SELECT
s.stations_id, s.stations_name, se.sections_name, cf.customfields_name,

CASE cf.customfields_type
WHEN 'TEXT' THEN cfv.customfieldsvalues_text_value
WHEN 'NUMERIC' THEN cfv.customfieldsvalues_numeric_value
END

FROM stations s
INNER JOIN customfieldsvalues cfv ON s.stations_id = cfv.customfieldsvalues_station_id
INNER JOIN customfields cf ON cfv.customfieldsvalues_customfields_id = cf.customfields_id
INNER JOIN sections se ON se.sections_id = cf.customfields_section_id