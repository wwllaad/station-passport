package com.sevgmo.stationpassport.controller;

import com.sevgmo.stationpassport.serialize.CustomFieldDTO;
import com.sevgmo.stationpassport.serialize.CustomFieldValueDTO;
import com.sevgmo.stationpassport.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/section")
public class SectionRestController {

    @Autowired
    private StationService stationService;

    @GetMapping("/customfield")
    private CustomFieldDTO getCustomFieldsDTOById(@RequestParam int id){
        return stationService.getCustomFieldDTOById(id);
    }

    @GetMapping("/customfieldvalue")
    private List<CustomFieldValueDTO> getCustomFieldValueDTOByStationId(@RequestParam int id){
        return stationService.getCustomFieldValueDTOByStationId(id);
    }
}
