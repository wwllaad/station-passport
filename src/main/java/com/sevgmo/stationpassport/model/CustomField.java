package com.sevgmo.stationpassport.model;

public class CustomField extends AbstractEntity {

    private int section_id;
    private String name;
    private String type;


    public CustomField(int id) {
        super(id);
    }

    public CustomField() {
    }



    public int getSection_id() {
        return section_id;
    }

    public void setSection_id(int section_id) {
        this.section_id = section_id;
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

    public CustomField(int id, int section_id, String name, String type) {
        super(id);
        this.section_id = section_id;
        this.name = name;
        this.type = type;
    }

    public CustomField(int section_id, String name, String type) {
        this.section_id = section_id;
        this.name = name;
        this.type = type;
    }


}
