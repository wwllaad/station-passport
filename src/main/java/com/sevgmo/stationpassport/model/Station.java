package com.sevgmo.stationpassport.model;

public class Station extends AbstractEntity{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Station(int id) {
        super(id);
    }

    public Station() {
    }

    public Station(int id, String name) {
        super(id);
        this.name = name;
    }

    public Station(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Station{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
