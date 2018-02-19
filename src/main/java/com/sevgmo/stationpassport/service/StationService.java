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
        Station station = sqlSession.selectOne("getStationNameById", id);
        return new StationDTO(station);
    }

    @JsonSerialize
    public CustomFieldDTO getCustomFieldDTOById(int id){
        CustomField customField = sqlSession.selectOne("getCustomFieldById", id);
        return new CustomFieldDTO(customField);
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
    public StationApiFormDTO getStationApiDTOById(int id) {

        List<CustomFieldValueDTO> customFieldValueDTOList = this.getCustomFieldValueDTOByStationId(id);

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
        String stationName = customFieldValueDTOList.get(0).getStationDTO().getName();
        return new StationApiFormDTO(stationName, tempSectionApiFormDTOList);
    }
}
