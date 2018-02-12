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
        StationDTO stationDTO = new StationDTO(station);
        return stationDTO;
    }

    @JsonSerialize
    public CustomFieldDTO getCustomFieldDTOById(int id){
        CustomField customField = sqlSession.selectOne("getCustomFieldById", id);
        CustomFieldDTO customFieldDTO = new CustomFieldDTO(customField);
        return customFieldDTO;
    }

    @JsonSerialize
    public List<CustomFieldValueDTO> getCustomFieldValueDTOByStationId(int id){
        CustomFieldValueDTO customFieldValueDTO;
        List<CustomFieldValueDTO> customFieldValueDTOList = new ArrayList<>();
        List<CustomFieldValue> customFieldValueList = sqlSession.selectList(" getCustomFieldValueByStationId", id);
        for(CustomFieldValue customFieldValue: customFieldValueList){
            customFieldValueDTO = new CustomFieldValueDTO(customFieldValue);
            customFieldValueDTOList.add(customFieldValueDTO);
        }
        return customFieldValueDTOList;
    }

    @JsonSerialize
    public SectionDTO getSectionDTOById(int id){
        Section section = sqlSession.selectOne("getSectionById", id);
        SectionDTO sectionDTO = new SectionDTO(section);
        return sectionDTO;
    }

    @JsonSerialize
    public StationApiFormDTO getStationApiDTOById(int id) {

        //Loading StationDTO
        StationDTO stationDTO = this.getStationDTOById(id);

        String stationName = stationDTO.getName();

        int stationId = stationDTO.getId();

        //Loading CustomFieldValueDTO
        List<CustomFieldValueDTO> customFieldValueDTOList = this.getCustomFieldValueDTOByStationId(stationId);

        List<CustomFieldDTO> customFieldDTOList = new ArrayList<>();


        //Loading CustomFieldDTO
        for(CustomFieldValueDTO customFieldValueDTO : customFieldValueDTOList){
            int customFieldId = customFieldValueDTO.getCustomFieldId();
            customFieldDTOList.add(this.getCustomFieldDTOById(customFieldId));
        }

        List<SectionDTO> sectionDTOList = new ArrayList<>();

        //Loading SectionDTO
        int sectionIdCounter = 0;
        for(CustomFieldDTO customFieldDTO : customFieldDTOList){

            int sectionId = customFieldDTO.getSectionId();

            if (sectionId != sectionIdCounter) {
                sectionDTOList.add(this.getSectionDTOById(sectionId));
                sectionIdCounter = sectionId;
            }
        }

        //Transfer StationDTO, CustomFieldValueDTO, CustomFieldDTO, SectionDTO into common class SectionApiFormDTO

        SectionApiFormDTO sectionApiFormDTO;
        List<SectionApiFormDTO> sectionApiFormDTOList = new ArrayList<>();
        List<CustomFieldDTO> tempCustomFieldDTOList = new ArrayList<>();
        List<CustomFieldValueDTO> tempCustomFieldValueDTOList = new ArrayList<>();
        int sectionApiDTOIdCounter = sectionDTOList.get(0).getId();

        for(SectionDTO sectionDTO : sectionDTOList){


            int sectionId = sectionDTO.getId();

            //sectionId - unique
            if(sectionId != sectionApiDTOIdCounter){

             tempCustomFieldDTOList = new ArrayList<>();
             tempCustomFieldValueDTOList = new ArrayList<>();
            }

            for (CustomFieldDTO customFieldDTO : customFieldDTOList){
                if(sectionId == customFieldDTO.getSectionId()) {
                    tempCustomFieldDTOList.add(customFieldDTO);

                    int customFieldId = customFieldDTO.getId();
                    for(CustomFieldValueDTO customFieldValueDTO: customFieldValueDTOList){
                        if(customFieldId == customFieldValueDTO.getCustomFieldId()) {

                            tempCustomFieldValueDTOList.add(customFieldValueDTO);

                        }
                    }
                }
            }

            String name = sectionDTO.getName();
            int sectionApiFormDTOId = sectionDTO.getId();
            sectionApiFormDTO = new SectionApiFormDTO(sectionApiFormDTOId,name, tempCustomFieldDTOList, tempCustomFieldValueDTOList);
            sectionApiFormDTOList.add(sectionApiFormDTO);

        }

        return new StationApiFormDTO(stationName, sectionApiFormDTOList);

    }

}
