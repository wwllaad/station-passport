package com.sevgmo.stationpassport.controller;

import com.sevgmo.stationpassport.model.Station;
import com.sevgmo.stationpassport.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/st")
public class StationRestController {

    @Autowired
    StationService stationService;

    @GetMapping("/api")
    private Station getStation(@RequestParam int id)
    {
        return stationService.getStationByIdFromDB(id);
    }
}


