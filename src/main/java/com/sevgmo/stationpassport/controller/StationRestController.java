package com.sevgmo.stationpassport.controller;

import com.sevgmo.stationpassport.serialize.*;
import com.sevgmo.stationpassport.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/station")
public class StationRestController {

    @Autowired
    private StationService stationService;

    @GetMapping("/all")
    private List<StationDTO> getAllStationsDTO(){
        return stationService.getAllStationsDTO();
    }

    @GetMapping("/byid")
    private StationDTO getStationDTOById(@RequestParam int id){
        return stationService.getStationDTOById(id);
    }

    @GetMapping("/api")
    private StationApiFormDTO getStationApiDTOById(@RequestParam int id){
        return stationService.getStationApiDTOById(id);
    }

    @GetMapping("/add")
    private StationDTO addNewStation(@RequestParam String name){
        return stationService.addNewStation(name);
    }

    @GetMapping("/delete")
    private void deleteStationById(@RequestParam int id){
        stationService.deleteStationById(id);
    }
}


