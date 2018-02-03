package com.sevgmo.stationpassport.service;

import com.sevgmo.stationpassport.model.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class StationParser {

    private Station station;
    private List<Section> sections;
    private Section section;

    private CustomField customField;
    private List<CustomField> customFieldList;
    private CustomFieldValue customFieldValue;
    private List<CustomFieldValue> customFieldValueList;


    public Station parse(List<StationMySQLForm> stationMySQLForms){

        int id = stationMySQLForms.get(0).getId();
        String stationName = stationMySQLForms.get(0).getStation_name();

        customFieldsInit();

        customField.setId(stationMySQLForms.get(0).getCustomfield_id());
        customField.setName(stationMySQLForms.get(0).getCustomfield_name());
        customField.setType(stationMySQLForms.get(0).getCustomfield_type());

        customFieldValue.setId(1);
        customFieldValue.setTextValue(stationMySQLForms.get(0).getCustomfieldsvalue_text_value());
        customFieldValue.setIntValue(stationMySQLForms.get(0).getCustomfieldsvalue_numeric_value());

        int customFieldCounter = 1;

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
                customFieldsInit();

                section = new Section(sectionCounter,sectionName,customFieldList, customFieldValueList);

                sections.add(section);
            }

            int customFieldIdFromSQL = stationMySQLForms.get(i).getCustomfield_id();
            int customFieldId = customField.getId();

            if (customFieldId != customFieldIdFromSQL){

                customFieldCounter++;

                int customField_Id = stationMySQLForms.get(i).getCustomfield_id();
                int customFieldSectionId = stationMySQLForms.get(i).getCustomfield_section_id();
                String customFieldName = stationMySQLForms.get(i).getCustomfield_name();
                String customFieldType = stationMySQLForms.get(i).getCustomfield_type();

                customField = new CustomField(customField_Id,customFieldSectionId,customFieldName,customFieldType);

                String customFieldTextData = stationMySQLForms.get(i).getCustomfieldsvalue_text_value();
                int customFieldNumericData = stationMySQLForms.get(i).getCustomfieldsvalue_numeric_value();

                customFieldValue = new CustomFieldValue(customField_Id,customFieldTextData,customFieldNumericData);
            }


            customField.setSectionId(stationMySQLForms.get(i).getCustomfield_section_id());
            customField.setName(stationMySQLForms.get(i).getCustomfield_name());
            customField.setType(stationMySQLForms.get(i).getCustomfield_type());
            customFieldList.add(customField);
            customFieldValue.setTextValue(stationMySQLForms.get(i).getCustomfieldsvalue_text_value());
            customFieldValue.setIntValue(stationMySQLForms.get(i).getCustomfieldsvalue_numeric_value());
            customFieldValueList.add(customFieldValue);

            section.setCustomFields(customFieldList);
            section.setCustomFieldValues(customFieldValueList);

        }


        station = new Station(id, stationName, sections);

        return station;

    }

    private void customFieldsInit(){

        customField = new CustomField();
        customFieldValue = new CustomFieldValue();
        customFieldList = new ArrayList<>();
        customFieldValueList = new ArrayList<>();

    }

}