package com.sevgmo.stationpassport.controller;

import com.sevgmo.stationpassport.model.Station;
import com.sevgmo.stationpassport.model.StationMySQLForm;
import com.sevgmo.stationpassport.service.StationMySQLFormService;
import com.sevgmo.stationpassport.service.StationParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/stations")
public class StationRestController {

    @Autowired
    StationMySQLFormService stationMySQLFormService;

    @Autowired
    StationParser stationParser;

    @GetMapping("/sql")
    private List<StationMySQLForm> getStationMySQLForm(@RequestParam int id){
        return stationMySQLFormService.getStationById(id);
    }

    @GetMapping("/api")
    private Station getStation(@RequestParam int id){
        return stationParser.parse(stationMySQLFormService.getStationById(id));
    }

}
