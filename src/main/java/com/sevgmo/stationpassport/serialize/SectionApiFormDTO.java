package com.sevgmo.stationpassport.serialize;

import com.sevgmo.stationpassport.model.AbstractEntity;

import java.util.List;

public class SectionApiFormDTO extends AbstractEntity {

    private String name;
    private List<CustomFieldDTO> customFieldDTOList;
    private List<CustomFieldValueDTO> customFieldValueDTOList;

    public SectionApiFormDTO(String name, List<CustomFieldDTO> customFields, List<CustomFieldValueDTO> customFieldValues){
        this.name = name;
        this.customFieldDTOList = customFields;
        this.customFieldValueDTOList = customFieldValues;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CustomFieldDTO> getCustomFieldDTOList() {
        return customFieldDTOList;
    }

    public void setCustomFieldDTOList(List<CustomFieldDTO> customFieldDTOList) {
        this.customFieldDTOList = customFieldDTOList;
    }

    public List<CustomFieldValueDTO> getCustomFieldValueDTOList() {
        return customFieldValueDTOList;
    }

    public void setCustomFieldValueDTOList(List<CustomFieldValueDTO> customFieldValueDTOList) {
        this.customFieldValueDTOList = customFieldValueDTOList;
    }
}
