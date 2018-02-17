package com.sevgmo.stationpassport.model;

public class Section extends AbstractEntity{

    private String name;
    private Section section;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Section getParent() {
        return section;
    }

    public void setParent(Section section) {
        this.section = section;
    }

    public Section(int id) {
        super(id);
    }

    public Section() {
    }

    public Section(int id, String name, Section section) {
        super(id);
        this.name = name;
        this.section = section;
    }

    public Section(String name, Section section) {
        this.name = name;
        this.section = section;
    }
}
