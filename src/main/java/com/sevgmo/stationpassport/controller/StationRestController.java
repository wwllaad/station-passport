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

    @GetMapping("/customfield")
    private CustomFieldDTO getCustomFieldsDTOById(@RequestParam int id)
    {
        return stationService.getCustomFieldDTOById(id);
    }

    @GetMapping("/customfieldvalue")
    private List<CustomFieldValueDTO> getCustomFieldValueDTOByStationId(@RequestParam int id){
        return stationService.getCustomFieldValueDTOByStationId(id);
    }

    @GetMapping("/api")
    private StationApiFormDTO getStationApiDTOById(@RequestParam int id){
        return stationService.getStationApiDTOById(id);
    }

}


