INSERT INTO users(username,password,email,phone,role) VALUES('Alexey','root','lao@gmail.com','102','ROLE_ADMIN');
INSERT INTO users(username,password,email,phone,role) VALUES('Vlad','root','bve@gmail.com','103','ROLE_USER');

INSERT INTO stations (stations_name) VALUE ('Черноморское');
INSERT INTO stations (stations_name) VALUE ('Мысовое');

INSERT INTO sections (sections_name, parent_section_id) VALUES ('Программа работы', 'NULL' );

INSERT INTO customfields (customfields_section_id, customfields_type, customfields_name, customfields_order) VALUES
  (1, 'TEXT', 'Наблюдение за высотой волны',1);
INSERT INTO customfields (customfields_section_id, customfields_type, customfields_name, customfields_order) VALUES
  (1, 'NUMERIC', 'Наблюдение за температурой воды',2);
INSERT INTO customfields (customfields_section_id, customfields_type, customfields_name, customfields_order) VALUES
  (1, 'NUMERIC', 'Наблюдение за температурой воздуха',3);

INSERT INTO customfieldsvalues (customfieldsvalues_customfields_id, customfieldsvalues_station_id, customfieldsvalues_text_value, customfieldsvalues_numeric_value) VALUES
  (1, 1, '3 метра', 'NULL');
INSERT INTO customfieldsvalues (customfieldsvalues_customfields_id, customfieldsvalues_station_id, customfieldsvalues_text_value, customfieldsvalues_numeric_value) VALUES
  (2, 1, 'NULL', 15);
INSERT INTO customfieldsvalues (customfieldsvalues_customfields_id, customfieldsvalues_station_id, customfieldsvalues_text_value, customfieldsvalues_numeric_value) VALUES
(3, 1, 'NULL', 20);
