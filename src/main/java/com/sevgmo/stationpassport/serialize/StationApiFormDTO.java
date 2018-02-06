package com.sevgmo.stationpassport.serialize;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sevgmo.stationpassport.model.AbstractEntity;

import java.util.List;

@JsonSerialize
public class StationApiFormDTO extends AbstractEntity {

    private String name;
    private List<SectionApiFormDTO> sections;

    public StationApiFormDTO(String name, List<SectionApiFormDTO> sections){
        this.name = name;
        this.sections = sections;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SectionApiFormDTO> getSections() {
        return sections;
    }

    public void setSections(List<SectionApiFormDTO> sections) {
        this.sections = sections;
    }
}
