package com.sevgmo.stationpassport.controller;

import com.sevgmo.stationpassport.model.Station;
import com.sevgmo.stationpassport.service.StationService;
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
    StationService stationService;

    @GetMapping("/station")
    private List<Station> getStationById(@RequestParam int id){
        return stationService.getStationById(id);
    }

    @GetMapping("/all")
    private List<Station> getAllStations(){
        return stationService.getAllStations();
}
}
