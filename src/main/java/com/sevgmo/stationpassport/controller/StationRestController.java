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
@RequestMapping("/st")
public class StationRestController {

    @Autowired
    private StationService stationService;


    @GetMapping("/getAllStations")
    private List<StationDTO> getAllStationsDTOFromDB()
    {
        return stationService.getAllStationsDTOFromDB();
    }

    @GetMapping("/name")
    private StationDTO getStationDTOFromDBById(@RequestParam int id)
    {
        return stationService.getStationDTOFromDBById(id);
    }

    @GetMapping("/sec")
    private CustomFieldDTO getCustomFieldsDTOFromDBById(@RequestParam int id)
    {
        return stationService.getCustomFieldDTOFromDBById(id);
    }

    @GetMapping("/cfv")
    private List<CustomFieldValueDTO> getCustomFieldValueDTOFromDBByStationId(@RequestParam int id)
    {
        return stationService.getCustomFieldValueDTOFromDBByStationId(id);
    }

    @GetMapping("/api")
    private StationApiFormDTO getStationApiFormDTO(@RequestParam int id){
        return stationService.getStationApiDTOById(id);
    }

}


