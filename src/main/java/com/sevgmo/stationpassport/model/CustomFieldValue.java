package com.sevgmo.stationpassport.model;

public class CustomFieldValue extends AbstractEntity {

    private String textValue;
    private Integer intValue;

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public CustomField getCustomField() {
        return customField;
    }

    public void setCustomField(CustomField customField) {
        this.customField = customField;
    }

    private Station station;
    private CustomField customField;

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

    public CustomFieldValue(int id, String textValue, Integer intValue) {
        super(id);
        this.textValue = textValue;
        this.intValue = intValue;
    }

    public CustomFieldValue(String textValue, Integer intValue) {
        this.textValue = textValue;
        this.intValue = intValue;
    }
}
