package com.sevgmo.stationpassport.model;

import java.util.List;

public class Section extends AbstractEntity{

    private String section_name;
    private List<Integer> customfield_section_id;
    private List<String> customfield_name;
    private List<String> customfield_type;
    private List<String> customfieldsvalue_text_value;
    private List<Integer> customfieldsvalue_numeric_value;

    public String getSection_name() {
        return section_name;
    }

    public void setSection_name(String section_name) {
        this.section_name = section_name;
    }

    public List<Integer> getCustomfield_section_id() {
        return customfield_section_id;
    }

    public void setCustomfield_section_id(List<Integer> customfield_section_id) {
        this.customfield_section_id = customfield_section_id;
    }

    public List<String> getCustomfield_name() {
        return customfield_name;
    }

    public void setCustomfield_name(List<String> customfield_name) {
        this.customfield_name = customfield_name;
    }

    public List<String> getCustomfield_type() {
        return customfield_type;
    }

    public void setCustomfield_type(List<String> customfield_type) {
        this.customfield_type = customfield_type;
    }

    public List<String> getCustomfieldsvalue_text_value() {
        return customfieldsvalue_text_value;
    }

    public void setCustomfieldsvalue_text_value(List<String> customfieldsvalue_text_value) {
        this.customfieldsvalue_text_value = customfieldsvalue_text_value;
    }

    public List<Integer> getCustomfieldsvalue_numeric_value() {
        return customfieldsvalue_numeric_value;
    }

    public void setCustomfieldsvalue_numeric_value(List<Integer> customfieldsvalue_numeric_value) {
        this.customfieldsvalue_numeric_value = customfieldsvalue_numeric_value;
    }

    public Section(int id) {
        super(id);
    }

    public Section() {
    }

    public Section(int id, String section_name, List<Integer> customfield_section_id, List<String> customfield_name, List<String> customfield_type, List<String> customfieldsvalue_text_value, List<Integer> customfieldsvalue_numeric_value) {
        super(id);
        this.section_name = section_name;
        this.customfield_section_id = customfield_section_id;
        this.customfield_name = customfield_name;
        this.customfield_type = customfield_type;
        this.customfieldsvalue_text_value = customfieldsvalue_text_value;
        this.customfieldsvalue_numeric_value = customfieldsvalue_numeric_value;
    }

    public Section(String section_name, List<Integer> customfield_section_id, List<String> customfield_name, List<String> customfield_type, List<String> customfieldsvalue_text_value, List<Integer> customfieldsvalue_numeric_value) {
        this.section_name = section_name;
        this.customfield_section_id = customfield_section_id;
        this.customfield_name = customfield_name;
        this.customfield_type = customfield_type;
        this.customfieldsvalue_text_value = customfieldsvalue_text_value;
        this.customfieldsvalue_numeric_value = customfieldsvalue_numeric_value;
    }

    @Override
    public String toString() {
        return "Section{" +
                "section_name='" + section_name + '\'' +
                ", customfield_section_id=" + customfield_section_id +
                ", customfield_name=" + customfield_name +
                ", customfield_type=" + customfield_type +
                ", customfieldsvalue_text_value=" + customfieldsvalue_text_value +
                ", customfieldsvalue_numeric_value=" + customfieldsvalue_numeric_value +
                ", id=" + id +
                '}';
    }
}
