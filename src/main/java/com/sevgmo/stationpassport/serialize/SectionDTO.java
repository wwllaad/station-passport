package com.sevgmo.stationpassport.serialize;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sevgmo.stationpassport.model.AbstractEntity;
import com.sevgmo.stationpassport.model.Section;

@JsonSerialize
public class SectionDTO extends AbstractEntity {

    private String name;
    private int parentSectionId;

    public SectionDTO(int id) {
        super(id);
    }

    public SectionDTO() {    }

    public SectionDTO(Section section){
        this.id = section.getId();
        this.name = section.getName();
        this.parentSectionId = section.getParent().getId();
    }

    public SectionDTO(int id, String name, int parentId){
        this.id = id;
        this.name = name;
        this.parentSectionId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParentId() {
        return parentSectionId;
    }

    public void setParentId(int parentSectionId) {
        this.parentSectionId = parentSectionId;
    }
}
