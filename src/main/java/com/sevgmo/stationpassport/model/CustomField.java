package com.sevgmo.stationpassport.model;

public class CustomField extends AbstractEntity {

    private int sectionId;
    private String name;
    private String type;
    private Integer order;

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
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

    public CustomField(int id, int sectionId, String name, String type, Integer order) {
        super(id);
        this.sectionId = sectionId;
        this.name = name;
        this.type = type;
        this.order = order;
    }

    public CustomField(int sectionId, String name, String type, Integer order) {
        this.sectionId = sectionId;
        this.name = name;
        this.type = type;
        this.order = order;
    }
}
