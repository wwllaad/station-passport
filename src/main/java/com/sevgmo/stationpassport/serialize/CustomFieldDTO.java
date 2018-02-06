package com.sevgmo.stationpassport.serialize;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sevgmo.stationpassport.model.AbstractEntity;
import com.sevgmo.stationpassport.model.CustomField;

@JsonSerialize
public class CustomFieldDTO extends AbstractEntity {

    private int sectionId;
    private String name;
    private String type;
    private Integer order;

    public CustomFieldDTO(CustomField customField){
        this.id = customField.getId();
        this.sectionId = customField.getSectionId();
        this.name = customField.getName();
        this.type = customField.getType();
        this.order = customField.getOrder();
    }

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }
}
