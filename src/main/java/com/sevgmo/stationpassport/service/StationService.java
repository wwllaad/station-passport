package com.sevgmo.stationpassport.service;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sevgmo.stationpassport.model.CustomField;
import com.sevgmo.stationpassport.model.CustomFieldValue;
import com.sevgmo.stationpassport.model.Section;
import com.sevgmo.stationpassport.model.Station;
import com.sevgmo.stationpassport.serialize.*;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class StationService {

    private SqlSession sqlSession;

    public StationService(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @JsonSerialize
    public List<StationDTO> getAllStationsDTO(){
        List<Station> stations = sqlSession.selectList("getAllStations");
        List<StationDTO> stationDTOList = new ArrayList<>();
        for(Station station: stations ){
            StationDTO stationDTO = new StationDTO(station);
            stationDTOList.add(stationDTO);
        }
        return stationDTOList;
    }

    @JsonSerialize
    public StationDTO getStationDTOById(int id){
        Station station = sqlSession.selectOne("getStationById", id);
        return new StationDTO(station);
    }

    @JsonSerialize
    public List<CustomFieldDTO> getAllCustomFieldDTO(){
        List<CustomField> customFieldList = sqlSession.selectList("getAllCustomFields");
        List<CustomFieldDTO> customFieldDTOList = new ArrayList<>();
        for(CustomField customField: customFieldList){
            customFieldDTOList.add(new CustomFieldDTO(customField));
        }
        return customFieldDTOList;
    }


    @JsonSerialize
    public CustomFieldDTO getCustomFieldDTOById(int id){
        CustomField customField = sqlSession.selectOne("getCustomFieldById", id);
        return new CustomFieldDTO(customField);
    }

    @JsonSerialize
    public List<CustomFieldDTO> getCustomFieldDTOBySectionId(int id){
        List<CustomField> customFieldList = sqlSession.selectList("getCustomFieldBySectionId", id);
        List<CustomFieldDTO> customFieldDTOList = new ArrayList<>();
        for(CustomField customField: customFieldList){
            customFieldDTOList.add(new CustomFieldDTO(customField));
        }
        return customFieldDTOList;
    }

    @JsonSerialize
    public List<CustomFieldValueDTO> getCustomFieldValueDTOByStationId(int id){
         List<CustomFieldValue> customFieldValueList = sqlSession.selectList(" getCustomFieldValueByStationId", id);
         List<CustomFieldValueDTO> customFieldValueDTOList = new ArrayList<>();
         for(CustomFieldValue customFieldValue: customFieldValueList){
             customFieldValueDTOList.add(new CustomFieldValueDTO(customFieldValue));
         }
        return customFieldValueDTOList;
    }

    @JsonSerialize
    public SectionDTO getSectionDTOById(int id){
        Section section = sqlSession.selectOne("getSectionById", id);
        return new SectionDTO(section);
    }

    @JsonSerialize
    public ReactTreebeardDTO getTreeFormSectionListByStationId(int id){
        ReactTreebeardDTO reactTreebeardDTO = new ReactTreebeardDTO(this.getStationApiDTOById(id));
        return reactTreebeardDTO;
    }

    @JsonSerialize
    public StationApiFormDTO getStationApiDTOById(int id) {
        List<CustomFieldValueDTO> customFieldValueDTOList = getCustomFieldValueDTOByStationId(id);

        SectionApiFormDTO sectionApiFormDTO;
        List<SectionApiFormDTO> tempSectionApiFormDTOList = new ArrayList<>();
        List<CustomFieldDTO> tempCustomFieldDTOList = new ArrayList<>();
        List<CustomFieldValueDTO> tempCustomFieldValueDTOList = new ArrayList<>();

        String tempSectionName = customFieldValueDTOList.get(0).getCustomFieldDTO().getSection().getName();
        int tempSectionId = customFieldValueDTOList.get(0).getCustomFieldDTO().getSection().getId();
        sectionApiFormDTO = new SectionApiFormDTO(tempSectionId, tempSectionName, tempCustomFieldDTOList, tempCustomFieldValueDTOList);
        tempSectionApiFormDTOList.add(sectionApiFormDTO);

        List<Integer> customFieldIdBuffer = new ArrayList<>();

        for(CustomFieldValueDTO customFieldValueDTO: customFieldValueDTOList) {
            if (tempSectionId != customFieldValueDTO.getCustomFieldDTO().getSection().getId()) {
                tempSectionId = customFieldValueDTO.getCustomFieldDTO().getSection().getId();
                tempSectionName = customFieldValueDTO.getCustomFieldDTO().getSection().getName();
                tempCustomFieldDTOList = new ArrayList<>();
                tempCustomFieldValueDTOList = new ArrayList<>();
                sectionApiFormDTO = new SectionApiFormDTO(tempSectionId, tempSectionName, tempCustomFieldDTOList, tempCustomFieldValueDTOList);
                tempSectionApiFormDTOList.add(sectionApiFormDTO);
            }
                tempCustomFieldValueDTOList.add(customFieldValueDTO);
            //one section can contain multiple CustomFieldValues ​​but only one set of CustomField names
            if(!customFieldIdBuffer.contains(customFieldValueDTO.getCustomFieldDTO().getId())) {
                tempCustomFieldDTOList.add(customFieldValueDTO.getCustomFieldDTO());
                customFieldIdBuffer.add(customFieldValueDTO.getCustomFieldDTO().getId());
            }
        }
        tempSectionApiFormDTOList = sortSectionApiFormDTOByCustomFieldId(tempSectionApiFormDTOList);
        String stationName = customFieldValueDTOList.get(0).getStationDTO().getName();
        return new StationApiFormDTO(id, stationName, tempSectionApiFormDTOList);
    }

    private List<SectionApiFormDTO> sortSectionApiFormDTOByCustomFieldId(List<SectionApiFormDTO> sectionApiFormDTOList){
        List<SectionApiFormDTO> sectionApiFormDTOListUnsorted = sectionApiFormDTOList;
        Iterator<SectionApiFormDTO> i = sectionApiFormDTOListUnsorted.iterator();
        List<Integer> customFieldIdBuffer = new ArrayList<>();
        List<CustomFieldValueDTO> customFieldValueDTOList = new ArrayList<>();
        int sectionId = -1;
        while(i.hasNext()){
            SectionApiFormDTO sectionApiFormDTO = i.next();
            if (!customFieldIdBuffer.contains(sectionApiFormDTO.getId())){
                customFieldIdBuffer.add(sectionApiFormDTO.getId());
            } else {
                customFieldValueDTOList = sectionApiFormDTO.getCustomFieldValueDTOList();
                sectionId = sectionApiFormDTO.getId();
                i.remove();
            }
        }
        for (SectionApiFormDTO sectionApiFormDTO: sectionApiFormDTOListUnsorted){
            if(sectionId == sectionApiFormDTO.getId()){
                sectionApiFormDTO.getCustomFieldValueDTOList().addAll(customFieldValueDTOList);
            }
        }
        return sectionApiFormDTOListUnsorted;
    }

    public void updateTextFieldValue(CustomFieldValueDTO customFieldValueDTO) {
        sqlSession.update("updateFieldValue", customFieldValueDTO);
    }

    public void addBlankFieldsBySectionAndStationId(int stationId, int sectionId) {
        List<CustomFieldDTO> customFieldDTOList = getCustomFieldDTOBySectionId(sectionId);
        CustomFieldValueInsertDTO customFieldValueInsertDTO;
        String textValue;
        int intValue;
        for(CustomFieldDTO customFieldDTO: customFieldDTOList){
            if (customFieldDTO.getType().equals("TEXT")){
                textValue = " ";
                intValue = 0;
            } else {
                textValue = "NULL";
                intValue = 0;
            }
            customFieldValueInsertDTO = new CustomFieldValueInsertDTO(customFieldDTO.getId(), stationId, textValue, intValue);
            sqlSession.insert("insertBlankCustomFieldValue", customFieldValueInsertDTO);
        }
    }

    @JsonSerialize
    public StationDTO addNewStation(String name) {
        List<StationDTO> stationDTOList = getAllStationsDTO();
        for (StationDTO stationDTO: stationDTOList){
            if (stationDTO.getName().toLowerCase().equals(name.toUpperCase())){
                System.out.println("Error: same station name exist.");
                return null;
            }
        }
        sqlSession.insert("addNewStation", name);
        int stationId = sqlSession.selectOne("getStationIdByName", name);
        List<Integer> sectionIdList = sqlSession.selectList("getAllSectionsId");
        for (Integer sectionId: sectionIdList){
            addBlankFieldsBySectionAndStationId(stationId, sectionId);
        }

        return getStationDTOById(stationId);
    }

    public void deleteStationById(int id) {
        sqlSession.update("deleteStationById", id);
    }

}
