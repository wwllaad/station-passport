package com.sevgmo.stationpassport.model;

public class CustomFieldValue extends AbstractEntity {

    private CustomField customField;
    private Station station;
    private String textValue;
    private Integer intValue;

    public CustomFieldValue(int id) {
        super(id);
    }

    public CustomFieldValue() {
    }

    public CustomFieldValue(int id, CustomField customField, Station station, String textValue, Integer intValue) {
        super(id);
        this.customField = customField;
        this.station = station;
        this.textValue = textValue;
        this.intValue = intValue;
    }

    public CustomFieldValue(CustomField customField, Station station, String textValue, Integer intValue) {
        this.customField = customField;
        this.station = station;
        this.textValue = textValue;
        this.intValue = intValue;
    }

    public CustomField getCustomField() {
        return customField;
    }

    public void setCustomField(CustomField customField) {
        this.customField = customField;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
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
