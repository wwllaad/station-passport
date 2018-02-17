package com.sevgmo.stationpassport.model;

public class CustomField extends AbstractEntity {

    private Section section;
    private String name;
    private String type;
    private Integer order;

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

    public CustomField(int id) {
        super(id);
    }

    public CustomField() {
    }

    public CustomField(int id, Section section, String name, String type, Integer order) {
        super(id);
        this.section = section;
        this.name = name;
        this.type = type;
        this.order = order;
    }

    public CustomField(Section section, String name, String type, Integer order) {
        this.section = section;
        this.name = name;
        this.type = type;
        this.order = order;
    }

}
