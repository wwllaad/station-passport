package com.sevgmo.stationpassport.model;

public class StationMySQLForm extends AbstractEntity {

    private String station_name;
    private String section_name;
    private  int customfield_id;
    private int customfield_section_id;
    private String customfield_name;
    private String customfield_type;
    private String customfieldsvalue_text_value;
    private int customfieldsvalue_numeric_value;

    public String getStation_name() {
        return station_name;
    }

    public void setStation_name(String station_name) {
        this.station_name = station_name;
    }

    public String getSection_name() {
        return section_name;
    }

    public void setSection_name(String section_name) {
        this.section_name = section_name;
    }

    public int getCustomfield_id() {
        return customfield_id;
    }

    public void setCustomfield_id(int customfield_id) {
        this.customfield_id = customfield_id;
    }

    public int getCustomfield_section_id() {
        return customfield_section_id;
    }

    public void setCustomfield_section_id(int customfield_section_id) {
        this.customfield_section_id = customfield_section_id;
    }

    public String getCustomfield_name() {
        return customfield_name;
    }

    public void setCustomfield_name(String customfield_name) {
        this.customfield_name = customfield_name;
    }

    public String getCustomfield_type() {
        return customfield_type;
    }

    public void setCustomfield_type(String customfield_type) {
        this.customfield_type = customfield_type;
    }

    public String getCustomfieldsvalue_text_value() {
        return customfieldsvalue_text_value;
    }

    public void setCustomfieldsvalue_text_value(String customfieldsvalue_text_value) {
        this.customfieldsvalue_text_value = customfieldsvalue_text_value;
    }

    public int getCustomfieldsvalue_numeric_value() {
        return customfieldsvalue_numeric_value;
    }

    public void setCustomfieldsvalue_numeric_value(int customfieldsvalue_numeric_value) {
        this.customfieldsvalue_numeric_value = customfieldsvalue_numeric_value;
    }

    public StationMySQLForm(int id) {
        super(id);
    }

    public StationMySQLForm() {
    }

    public StationMySQLForm(int id, String station_name, String section_name, int customfield_id, int customfield_section_id, String customfield_name, String customfield_type, String customfieldsvalue_text_value, int customfieldsvalue_numeric_value) {
        super(id);
        this.station_name = station_name;
        this.section_name = section_name;
        this.customfield_id = customfield_id;
        this.customfield_section_id = customfield_section_id;
        this.customfield_name = customfield_name;
        this.customfield_type = customfield_type;
        this.customfieldsvalue_text_value = customfieldsvalue_text_value;
        this.customfieldsvalue_numeric_value = customfieldsvalue_numeric_value;
    }

    public StationMySQLForm(String station_name, String section_name, int customfield_id, int customfield_section_id, String customfield_name, String customfield_type, String customfieldsvalue_text_value, int customfieldsvalue_numeric_value) {
        this.station_name = station_name;
        this.section_name = section_name;
        this.customfield_id = customfield_id;
        this.customfield_section_id = customfield_section_id;
        this.customfield_name = customfield_name;
        this.customfield_type = customfield_type;
        this.customfieldsvalue_text_value = customfieldsvalue_text_value;
        this.customfieldsvalue_numeric_value = customfieldsvalue_numeric_value;
    }
}
