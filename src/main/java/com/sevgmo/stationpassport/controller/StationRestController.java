package com.sevgmo.stationpassport.controller;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sevgmo.stationpassport.serialize.CustomFieldValueDTO;
import com.sevgmo.stationpassport.serialize.StationDTO;
import com.sevgmo.stationpassport.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/st")
public class StationRestController {

    @Autowired
    private StationService stationService;

    @GetMapping("/api")
    private StationDataDTO getStation(@RequestParam int id)
    {
        return stationService.getStationByIdFromDB(id);
    }

    @JsonSerialize
    public static class StationDataDTO{
        private StationDTO stationDTO;
        private List<CustomFieldValueDTO> customFieldValues;

    }

}


