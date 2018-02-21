package com.sevgmo.stationpassport.serialize;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sevgmo.stationpassport.model.AbstractEntity;

import java.util.ArrayList;
import java.util.List;

@JsonSerialize
public class ReactTreebeardDTO extends AbstractEntity {

    private String name;
    private List<ReactTreebeardDTO> children;
    private boolean toggled;
    private boolean active;
    private boolean loading;

    public ReactTreebeardDTO(StationApiFormDTO stationApiFormDTO){

        this.id = stationApiFormDTO.getId();
        this.name = stationApiFormDTO.getName();
        this.toggled = true;
        this.active = true;
        this.loading = false;

        List<ReactTreebeardDTO> children = new ArrayList<>();
        List<SectionApiFormDTO> sectionApiFormDTOList = stationApiFormDTO.getSections();

        for (SectionApiFormDTO sectionApiFormDTO: sectionApiFormDTOList){

            ReactTreebeardDTO reactTreebeardDTO = new ReactTreebeardDTO();
            reactTreebeardDTO.setId(sectionApiFormDTO.getId());
            reactTreebeardDTO.setName(sectionApiFormDTO.getName());
            reactTreebeardDTO.setChildren(null);
            reactTreebeardDTO.setToggled(false);
            reactTreebeardDTO.setActive(false);
            reactTreebeardDTO.setLoading(false);
            children.add(reactTreebeardDTO);
        }
        this.children = children;
    }

    public ReactTreebeardDTO(int id) {
        super(id);
    }

    public ReactTreebeardDTO() {
    }

    public ReactTreebeardDTO(int id, String name, List<ReactTreebeardDTO> children, boolean toggled, boolean active, boolean loading) {
        super(id);
        this.name = name;
        this.children = children;
        this.toggled = toggled;
        this.active = active;
        this.loading = loading;
    }

    public ReactTreebeardDTO(String name, List<ReactTreebeardDTO> children, boolean toggled, boolean active, boolean loading) {
        this.name = name;
        this.children = children;
        this.toggled = toggled;
        this.active = active;
        this.loading = loading;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ReactTreebeardDTO> getChildren() {
        return children;
    }

    public void setChildren(List<ReactTreebeardDTO> children) {
        this.children = children;
    }

    public boolean isToggled() {
        return toggled;
    }

    public void setToggled(boolean toggled) {
        this.toggled = toggled;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isLoading() {
        return loading;
    }

    public void setLoading(boolean loading) {
        this.loading = loading;
    }
}


