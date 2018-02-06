package com.sevgmo.stationpassport.serialize;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sevgmo.stationpassport.model.AbstractEntity;
import com.sevgmo.stationpassport.model.Station;

@JsonSerialize
public class StationDTO extends AbstractEntity {

    private String name;

   public StationDTO(Station station){
       this.id = station.getId();
       this.name = station.getName();
   }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
