package com.sevgmo.stationpassport.serialize;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sevgmo.stationpassport.model.AbstractEntity;
import com.sevgmo.stationpassport.model.Section;

@JsonSerialize
public class SectionDTO extends AbstractEntity {

    private String name;
    private Integer parentSectionId;

    public SectionDTO(Section section){
        this.id = section.getId();
        this.name = section.getName();
        this.parentSectionId = section.getParentSectionId();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentSectionId() {
        return parentSectionId;
    }

    public void setParentSectionId(Integer parentSectionId) {
        this.parentSectionId = parentSectionId;
    }
}
