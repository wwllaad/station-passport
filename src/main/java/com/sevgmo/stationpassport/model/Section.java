package com.sevgmo.stationpassport.model;

import java.util.List;

public class Section extends AbstractEntity{

    private String name;
    private Integer parentSectionId;

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

    public Section(int id) {
        super(id);
    }

    public Section() {
    }

    public Section(int id, String name, Integer parentSectionId) {
        super(id);
        this.name = name;
        this.parentSectionId = parentSectionId;
    }

    public Section(String name, Integer parentSectionId) {
        this.name = name;
        this.parentSectionId = parentSectionId;
    }
}
