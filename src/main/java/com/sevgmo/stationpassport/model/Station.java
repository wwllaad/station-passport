package com.sevgmo.stationpassport.model;

import java.util.List;

public class Station extends AbstractEntity{

    private String name;
    private List<Section> section;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Section> getSection() {
        return section;
    }

    public void setSection(List<Section> section) {
        this.section = section;
    }

    public Station(int id) {
        super(id);
    }

    public Station() {
    }

    public Station(int id, String name, List<Section> section) {
        super(id);
        this.name = name;
        this.section = section;
    }

    public Station(String name, List<Section> section) {
        this.name = name;
        this.section = section;
    }

    @Override
    public String toString() {
        return "Station{" +
                "name='" + name + '\'' +
                ", section=" + section +
                ", id=" + id +
                '}';
    }
}
