package com.sevgmo.stationpassport.model;

public class CustomFieldValue extends AbstractEntity {

    private Integer customFieldId;
    private Integer stationId;
    private String textValue;
    private Integer intValue;

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

    public CustomFieldValue(int id) {
        super(id);
    }

    public CustomFieldValue() {
    }

    public CustomFieldValue(int id, Integer customFieldId, Integer stationId, String textValue, Integer intValue) {
        super(id);
        this.customFieldId = customFieldId;
        this.stationId = stationId;
        this.textValue = textValue;
        this.intValue = intValue;
    }

    public CustomFieldValue(Integer customFieldId, Integer stationId, String textValue, Integer intValue) {
        this.customFieldId = customFieldId;
        this.stationId = stationId;
        this.textValue = textValue;
        this.intValue = intValue;
    }
}
