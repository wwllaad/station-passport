package com.sevgmo.stationpassport.service;

import com.sevgmo.stationpassport.model.Section;
import com.sevgmo.stationpassport.model.Station;
import com.sevgmo.stationpassport.model.StationMySQLForm;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class StationParser {

    private Station station;

    private List<Section> sections;

    private Section section;
    private List<Integer> customfield_section_id;
    private List<String> customfield_name;
    private List<String> customfield_type;
    private List<String> customfieldsvalue_text_value;
    private List<Integer> customfieldsvalue_numeric_value;

    public Station parse(List<StationMySQLForm> stationMySQLForms){

        int id = stationMySQLForms.get(0).getId();
        String stationName = stationMySQLForms.get(0).getStation_name();

        sectionFieldsInit();

        section = new Section();
        section.setSection_name(stationMySQLForms.get(0).getSection_name());
        section.setId(stationMySQLForms.get(0).getCustomfield_section_id());
        sections = new ArrayList<>();
        sections.add(section);
        int sectionCounter = 1;


        for (int i=0;i<stationMySQLForms.size();i++) {

            int sectionIdFromSQL = stationMySQLForms.get(i).getCustomfield_section_id();
            int sectionId = section.getId();

            if (sectionId != sectionIdFromSQL) {

                sectionCounter++;
                String sectionName = stationMySQLForms.get(i).getSection_name();
                sectionFieldsInit();

                section = new Section(sectionCounter,sectionName,customfield_section_id,customfield_name,customfield_type,customfieldsvalue_text_value,customfieldsvalue_numeric_value);

                sections.add(section);
            }


            customfield_section_id.add(stationMySQLForms.get(i).getCustomfield_section_id());
            customfield_name.add(stationMySQLForms.get(i).getCustomfield_name());
            customfield_type.add(stationMySQLForms.get(i).getCustomfield_type());
            customfieldsvalue_text_value.add(stationMySQLForms.get(i).getCustomfieldsvalue_text_value());
            customfieldsvalue_numeric_value.add(stationMySQLForms.get(i).getCustomfieldsvalue_numeric_value());

            section.setCustomfield_section_id(customfield_section_id);
            section.setCustomfield_name(customfield_name);
            section.setCustomfield_type(customfield_type);
            section.setCustomfieldsvalue_text_value(customfieldsvalue_text_value);
            section.setCustomfieldsvalue_numeric_value(customfieldsvalue_numeric_value);
        }


        station = new Station(id, stationName, sections);

        return station;

    }

    private void sectionFieldsInit(){
        customfield_name = new ArrayList<>();
        customfield_section_id = new ArrayList<>();
        customfield_type = new ArrayList<>();
        customfieldsvalue_text_value = new ArrayList<>();
        customfieldsvalue_numeric_value = new ArrayList<>();
    }

}