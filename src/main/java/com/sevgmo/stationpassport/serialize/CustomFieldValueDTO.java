package com.sevgmo.stationpassport.serialize;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sevgmo.stationpassport.model.AbstractEntity;
import com.sevgmo.stationpassport.model.CustomFieldValue;

@JsonSerialize
public class CustomFieldValueDTO extends AbstractEntity {

    private Integer customFieldId;
    private Integer stationId;
    private String textValue;
    private Integer intValue;

    public CustomFieldValueDTO(CustomFieldValue customFieldValue){
        this.id = customFieldValue.getId();
        this.customFieldId = customFieldValue.getCustomFieldId();
        this.stationId = customFieldValue.getStationId();
        this.textValue = customFieldValue.getTextValue();
        this.intValue = customFieldValue.getIntValue();
    }

    public Integer getCustomFieldId() {
        return customFieldId;
    }

    public void setCustomFieldId(Integer customFieldId) {
        this.customFieldId = customFieldId;
    }

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
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
