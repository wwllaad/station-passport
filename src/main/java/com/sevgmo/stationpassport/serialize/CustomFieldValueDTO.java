package com.sevgmo.stationpassport.serialize;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sevgmo.stationpassport.model.*;

@JsonSerialize
public class CustomFieldValueDTO extends AbstractEntity {

    private CustomField customField;
    private Station station;
    private String textValue;
    private Integer intValue;

    public CustomFieldValueDTO(CustomFieldValue customFieldValue){

        this.id = customFieldValue.getId();

        Section section = new Section(customFieldValue.getCustomField().getSection().getId(),
                                        customFieldValue.getCustomField().getSection().getName(),
                                            customFieldValue.getCustomField().getSection().getSection());

        this.customField = new CustomField(customFieldValue.getCustomField().getId(),
                                            section,
                                            customFieldValue.getCustomField().getName(),
                                            customFieldValue.getCustomField().getType(),
                                            customFieldValue.getCustomField().getOrder());
        this.station = new Station(customFieldValue.getStation().getId(), customFieldValue.getStation().getName());
        this.textValue = customFieldValue.getTextValue();
        this.intValue = customFieldValue.getIntValue();

    }

    public CustomFieldValueDTO(int id) {
        super(id);
    }

    public CustomFieldValueDTO() {
    }

    public CustomFieldValueDTO(int id, CustomField customField, Station station, String textValue, Integer intValue) {
        super(id);
        this.customField = customField;
        this.station = station;
        this.textValue = textValue;
        this.intValue = intValue;
    }

    public CustomFieldValueDTO(CustomField customField, Station station, String textValue, Integer intValue) {
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
