package com.sevgmo.stationpassport.serialize;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sevgmo.stationpassport.model.*;

@JsonSerialize
public class CustomFieldValueDTO extends AbstractEntity {

    private CustomFieldDTO customFieldDTO;
    private StationDTO stationDTO;
    private String textValue;
    private Integer intValue;

    public CustomFieldValueDTO(CustomFieldValue customFieldValue){

        this.id = customFieldValue.getId();
        this.customFieldDTO = new CustomFieldDTO(customFieldValue.getCustomField());
        this.stationDTO = new StationDTO(customFieldValue.getStation());
        this.textValue = customFieldValue.getTextValue();
        this.intValue = customFieldValue.getIntValue();
    }

    public CustomFieldValueDTO(CustomFieldDTO customFieldDTO, StationDTO stationDTO, String textValue, Integer intValue){
        this.customFieldDTO = customFieldDTO;
        this.stationDTO = stationDTO;
        this.textValue = textValue;
        this.intValue = intValue;
    }

    public CustomFieldValueDTO(int id) {
        super(id);
    }

    public CustomFieldValueDTO() {    }

    public CustomFieldDTO getCustomFieldDTO() {
        return customFieldDTO;
    }

    public void setCustomFieldDTO(CustomFieldDTO customFieldDTO) {
        this.customFieldDTO = customFieldDTO;
    }

    public StationDTO getStationDTO() {
        return stationDTO;
    }

    public void setStationDTO(StationDTO stationDTO) {
        this.stationDTO = stationDTO;
    }

    public String getTextValue() {
        return textValue;
    }

    public void setTextValue(String textValue) {
        this.textValue = textValue;
    }

    public Integer getIntValue() {
        return intValue;
    }

    public void setIntValue(Integer intValue) {
        this.intValue = intValue;
    }
}
