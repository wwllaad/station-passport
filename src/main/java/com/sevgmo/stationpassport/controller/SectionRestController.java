package com.sevgmo.stationpassport.controller;

import com.sevgmo.stationpassport.serialize.CustomFieldDTO;
import com.sevgmo.stationpassport.serialize.CustomFieldValueDTO;
import com.sevgmo.stationpassport.serialize.ReactTreebeardDTO;
import com.sevgmo.stationpassport.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/treeformsections")
    private ReactTreebeardDTO getTreeFormSectionListByStationId(@RequestParam int id){
        return stationService.getTreeFormSectionListByStationId(id);
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/update")
    @ResponseBody
    private void updateFieldValue(@RequestBody List<CustomFieldValueDTO> customFieldValueDTOList){
       for(CustomFieldValueDTO customFieldValueDTO: customFieldValueDTOList){
              stationService.updateTextFieldValue(customFieldValueDTO);
        }
    }

    @GetMapping("/addsectionfields")
        private void addBlankFieldsBySectionAndStationId(@RequestParam int stationId, int sectionId){
        stationService.addBlankFieldsBySectionAndStationId(stationId, sectionId);
    }
}
