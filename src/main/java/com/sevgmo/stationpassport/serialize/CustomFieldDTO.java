package com.sevgmo.stationpassport.serialize;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sevgmo.stationpassport.model.CustomField;

@JsonSerialize
public class CustomFieldDTO {
    private Integer id;
    private String name;
    private Integer sectionId;

    public CustomFieldDTO(CustomField customField){
        this.id = customField.getId();
        this.name = customField.getName();
        this.sectionId = customField.getSectionId();
    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getSectionId() {
        return sectionId;
    }
}
