package com.sevgmo.stationpassport.model;

public class CustomField extends AbstractEntity {

    private int sectionId;
    private String name;
    private String type;


    public CustomField(int id) {
        super(id);
    }

    public CustomField() {
    }



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

    public CustomField(int id, int sectionId, String name, String type) {
        super(id);
        this.sectionId = sectionId;
        this.name = name;
        this.type = type;
    }

    public CustomField(int sectionId, String name, String type) {
        this.sectionId = sectionId;
        this.name = name;
        this.type = type;
    }


}
