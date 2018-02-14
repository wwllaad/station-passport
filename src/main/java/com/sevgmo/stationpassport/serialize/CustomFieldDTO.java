package com.sevgmo.stationpassport.serialize;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sevgmo.stationpassport.model.AbstractEntity;
import com.sevgmo.stationpassport.model.CustomField;
import com.sevgmo.stationpassport.model.Section;

@JsonSerialize
public class CustomFieldDTO extends AbstractEntity {

    private Section section;
    private String name;
    private String type;
    private Integer order;

    public CustomFieldDTO(CustomField customField){
        this.id = customField.getId();
        this.name = customField.getName();
        this.type = customField.getType();
        this.order = customField.getOrder();
        this.section = new Section(customField.getSection().getId(),customField.getSection().getName(),customField.getSection().getSection());
    }

    public CustomFieldDTO(int id, Section section, String name, String type, Integer order) {
        super(id);
        this.section = section;
        this.name = name;
        this.type = type;
        this.order = order;
    }

    public CustomFieldDTO(Section section, String name, String type, Integer order) {
        this.section = section;
        this.name = name;
        this.type = type;
        this.order = order;
    }

    public CustomFieldDTO(int id) {
        super(id);
    }

    public CustomFieldDTO() {
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
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
