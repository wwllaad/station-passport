INSERT INTO users(username,password,email,phone,role) VALUES('Alexey','root','lao@gmail.com','102','ROLE_ADMIN');
INSERT INTO users(username,password,email,phone,role) VALUES('Vlad','root','bve@gmail.com','103','ROLE_USER');

INSERT INTO stations (station_name) VALUE ('Черноморское');
INSERT INTO stations (station_name) VALUE ('Мысовое');

INSERT INTO sections (section_name, parent_section_id) VALUES ('Программа работы', 'NULL' );

INSERT INTO customfields (customfield_section_id, customfield_type, customfield_name, customfield_order) VALUES
  (1, 'TEXT', 'Наблюдение за высотой волны',1);
INSERT INTO customfields (customfield_section_id, customfield_type, customfield_name, customfield_order) VALUES
  (1, 'NUMERIC', 'Наблюдение за температурой воды',2);
INSERT INTO customfields (customfield_section_id, customfield_type, customfield_name, customfield_order) VALUES
  (1, 'NUMERIC', 'Наблюдение за температурой воздуха',3);

INSERT INTO customfieldsvalues (customfieldsvalue_customfield_id, customfieldsvalue_station_id, customfieldsvalue_text_value, customfieldsvalue_numeric_value) VALUES
  (1, 1, '3 метра', 0);
INSERT INTO customfieldsvalues (customfieldsvalue_customfield_id, customfieldsvalue_station_id, customfieldsvalue_text_value, customfieldsvalue_numeric_value) VALUES
  (2, 1, 'NULL', 15);
INSERT INTO customfieldsvalues (customfieldsvalue_customfield_id, customfieldsvalue_station_id, customfieldsvalue_text_value, customfieldsvalue_numeric_value) VALUES
  (3, 1, 'NULL', 20);

INSERT INTO customfieldsvalues (customfieldsvalue_customfield_id, customfieldsvalue_station_id, customfieldsvalue_text_value, customfieldsvalue_numeric_value) VALUES
  (1, 2, '10 метров', 0);
INSERT INTO customfieldsvalues (customfieldsvalue_customfield_id, customfieldsvalue_station_id, customfieldsvalue_text_value, customfieldsvalue_numeric_value) VALUES
  (2, 2, 'NULL', 13);
INSERT INTO customfieldsvalues (customfieldsvalue_customfield_id, customfieldsvalue_station_id, customfieldsvalue_text_value, customfieldsvalue_numeric_value) VALUES
  (3, 2, 'NULL', 19);
