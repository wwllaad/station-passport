package com.sevgmo.stationpassport.serialize;

import com.sevgmo.stationpassport.model.AbstractEntity;

public class CustomFieldValueInsertDTO extends AbstractEntity {
    private Integer customFieldId;
    private Integer stationId;
    private String textValue;
    private Integer intValue;

    public CustomFieldValueInsertDTO(int customFieldId, int stationId, String textValue, int intValue) {
        this.customFieldId = customFieldId;
        this.stationId = stationId;
        this.textValue = textValue;
        this.intValue = intValue;
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

    public CustomFieldValueInsertDTO(int id) {
        super(id);
    }

    public CustomFieldValueInsertDTO() {
    }

    public CustomFieldValueInsertDTO(int id, Integer customFieldId, Integer stationId, String textValue, Integer intValue) {
        super(id);
        this.customFieldId = customFieldId;
        this.stationId = stationId;
        this.textValue = textValue;
        this.intValue = intValue;
    }

    public CustomFieldValueInsertDTO(Integer customFieldId, Integer stationId, String textValue, Integer intValue) {
        this.customFieldId = customFieldId;
        this.stationId = stationId;
        this.textValue = textValue;
        this.intValue = intValue;
    }
}

