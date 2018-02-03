package com.sevgmo.stationpassport.serialize;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sevgmo.stationpassport.model.CustomFieldValue;

@JsonSerialize
public class CustomFieldValueDTO {
    private Integer id;
    private String value;
    private Integer customFieldId;
    private Integer sectionId;
    private Integer stationId;

    public CustomFieldValueDTO(CustomFieldValue value){
        this.id = value.getId();
        this.value = value.getTextValue();
        this.stationId = value.getStation().getId();
        this.customFieldId = value.getCustomField().getId();
        this.sectionId = value.getCustomField().getSectionId();
    }

    public Integer getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public Integer getCustomFieldId() {
        return customFieldId;
    }

    public Integer getStationId() {
        return stationId;
    }
}
