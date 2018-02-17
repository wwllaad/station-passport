package com.sevgmo.stationpassport.serialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sevgmo.stationpassport.model.AbstractEntity;
import com.sevgmo.stationpassport.model.CustomField;

@JsonSerialize
public class CustomFieldDTO extends AbstractEntity {
    private SectionDTO section;
    private String name;
    private String type;
    private Integer order;

    public CustomFieldDTO(CustomField customField){
        this.id = customField.getId();
        this.name = customField.getName();
        this.type = customField.getType();
        this.order = customField.getOrder();
        int sectionId = customField.getSection().getId();
        String sectionName = customField.getSection().getName();
        int parentSectionId = 0;
        if(customField.getSection().getParent() != null){
            parentSectionId = customField.getSection().getParent().getId();
        }
        this.section = new SectionDTO(sectionId,sectionName,parentSectionId);
    }

    public CustomFieldDTO(int id, int sectionId, String sectionName, int parentSectionId, String name, String type, int order){
        this.id = id;
        this.name = name;
        this.type = type;
        this.order = order;
        this.section = new SectionDTO(sectionId,sectionName,parentSectionId);
    }

    public CustomFieldDTO(int id) {
        super(id);
    }

    public CustomFieldDTO() {
    }

    public SectionDTO getSection() {
        return section;
    }

    public void setSection(SectionDTO section) {
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
}
