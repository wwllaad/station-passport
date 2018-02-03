package com.sevgmo.stationpassport.model;

import java.util.List;

public class Section extends AbstractEntity{

    private String section_name;
    private List<CustomField> customFields;
    private List<CustomFieldValue> customFieldValues;

    public String getName() {
        return section_name;
    }

    public void setSection_name(String section_name) {
        this.section_name = section_name;
    }

    public List<CustomField> getCustomFields() {
        return customFields;
    }

    public void setCustomFields(List<CustomField> customFields) {
        this.customFields = customFields;
    }

    public List<CustomFieldValue> getCustomFieldValues() {
        return customFieldValues;
    }

    public void setCustomFieldValues(List<CustomFieldValue> customFieldValues) {
        this.customFieldValues = customFieldValues;
    }

    public Section(int id) {
        super(id);
    }

    public Section() {
    }

    public Section(int id, String section_name, List<CustomField> customFields, List<CustomFieldValue> customFieldValues) {
        super(id);
        this.section_name = section_name;
        this.customFields = customFields;
        this.customFieldValues = customFieldValues;
    }

    public Section(String section_name, List<CustomField> customFields, List<CustomFieldValue> customFieldValues) {
        this.section_name = section_name;
        this.customFields = customFields;
        this.customFieldValues = customFieldValues;
    }
}
