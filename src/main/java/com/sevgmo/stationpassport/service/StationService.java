package com.sevgmo.stationpassport.service;

import com.sevgmo.stationpassport.model.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StationService {

    @Autowired
    StationParser stationParser;

    @Autowired
    StationMySQLFormService stationMySQLFormService;

    public Station getStationByIdFromDB(int id){
        return stationParser.parse(stationMySQLFormService.getStationById(id));
    }




}
