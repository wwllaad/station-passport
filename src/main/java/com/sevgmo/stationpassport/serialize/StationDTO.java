package com.sevgmo.stationpassport.serialize;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sevgmo.stationpassport.model.Station;

@JsonSerialize
public class StationDTO {
    private Integer id;
    private String name;

    public StationDTO(Station station){
        this.id = station.getId();
        this.name = station.getName();
    }

    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}
