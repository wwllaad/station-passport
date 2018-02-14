package com.sevgmo.stationpassport.serialize;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sevgmo.stationpassport.model.AbstractEntity;
import com.sevgmo.stationpassport.model.Section;

@JsonSerialize
public class SectionDTO extends AbstractEntity {

    private String name;
    private Section section;

    public SectionDTO(int id) {
        super(id);
    }

    public SectionDTO() {
    }

    public SectionDTO(Section section){
        this.id = section.getId();
        this.name = section.getName();
        this.section = section.getSection();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
}
