package com.sevgmo.stationpassport.serialize;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sevgmo.stationpassport.model.Section;

@JsonSerialize
public class SectionDTO {
    private Integer id;
    private String name;

    public SectionDTO(Section section){
        this.id = section.getId();
        this.name = section.getName();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
