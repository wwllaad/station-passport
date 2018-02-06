INSERT INTO users(username,password,email,phone,role) VALUES('Alexey','root','lao@gmail.com','102','ROLE_ADMIN');
INSERT INTO users(username,password,email,phone,role) VALUES('Vlad','root','bve@gmail.com','103','ROLE_USER');

INSERT INTO stations (station_name) VALUE ('Черноморское');
INSERT INTO stations (station_name) VALUE ('Мысовое');
INSERT INTO stations (station_name) VALUE ('Раздольное');
INSERT INTO stations (station_name) VALUE ('Опасное');


INSERT INTO sections (section_name, parent_section_id) VALUES ('Программа работы', 0 );
INSERT INTO sections (section_name, parent_section_id) VALUES ('Штат', 0 );
INSERT INTO sections (section_name, parent_section_id) VALUES ('Приборы', 0 );

INSERT INTO customfields (customfield_section_id, customfield_type, customfield_name, customfield_order) VALUES
  (1, 'TEXT', 'Наблюдение за высотой волны',1);
INSERT INTO customfields (customfield_section_id, customfield_type, customfield_name, customfield_order) VALUES
  (1, 'NUMERIC', 'Наблюдение за температурой воды',2);
INSERT INTO customfields (customfield_section_id, customfield_type, customfield_name, customfield_order) VALUES
  (1, 'NUMERIC', 'Наблюдение за температурой воздуха',3);

INSERT INTO customfields (customfield_section_id, customfield_type, customfield_name, customfield_order) VALUES
  (2, 'TEXT', 'ФИО',1);
INSERT INTO customfields (customfield_section_id, customfield_type, customfield_name, customfield_order) VALUES
  (2, 'TEXT', 'Дата рождения',2);
INSERT INTO customfields (customfield_section_id, customfield_type, customfield_name, customfield_order) VALUES
  (2, 'NUMERIC', 'Стаж',3);

INSERT INTO customfields (customfield_section_id, customfield_type, customfield_name, customfield_order) VALUES
  (3, 'TEXT', 'Название',1);
INSERT INTO customfields (customfield_section_id, customfield_type, customfield_name, customfield_order) VALUES
  (3, 'TEXT', 'Дата изготовления',2);

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

INSERT INTO customfieldsvalues (customfieldsvalue_customfield_id, customfieldsvalue_station_id, customfieldsvalue_text_value, customfieldsvalue_numeric_value) VALUES
  (4, 1, 'Иванов Иван', 0);
INSERT INTO customfieldsvalues (customfieldsvalue_customfield_id, customfieldsvalue_station_id, customfieldsvalue_text_value, customfieldsvalue_numeric_value) VALUES
  (5, 1, '1.11.1988', 0);
INSERT INTO customfieldsvalues (customfieldsvalue_customfield_id, customfieldsvalue_station_id, customfieldsvalue_text_value, customfieldsvalue_numeric_value) VALUES
  (6, 1, 'NULL', 5);

INSERT INTO customfieldsvalues (customfieldsvalue_customfield_id, customfieldsvalue_station_id, customfieldsvalue_text_value, customfieldsvalue_numeric_value) VALUES
  (4, 2, 'Петр Петров', 0);
INSERT INTO customfieldsvalues (customfieldsvalue_customfield_id, customfieldsvalue_station_id, customfieldsvalue_text_value, customfieldsvalue_numeric_value) VALUES
  (5, 2, '2.12.1978', 0);
INSERT INTO customfieldsvalues (customfieldsvalue_customfield_id, customfieldsvalue_station_id, customfieldsvalue_text_value, customfieldsvalue_numeric_value) VALUES
  (6, 2, 'NULL', 15);

INSERT INTO customfieldsvalues (customfieldsvalue_customfield_id, customfieldsvalue_station_id, customfieldsvalue_text_value, customfieldsvalue_numeric_value) VALUES
  (7, 1, 'Термометр', 0);
INSERT INTO customfieldsvalues (customfieldsvalue_customfield_id, customfieldsvalue_station_id, customfieldsvalue_text_value, customfieldsvalue_numeric_value) VALUES
  (8, 1, '1.01.1930', 0);


INSERT INTO customfieldsvalues (customfieldsvalue_customfield_id, customfieldsvalue_station_id, customfieldsvalue_text_value, customfieldsvalue_numeric_value) VALUES
  (7, 2, 'Бинокль', 0);
INSERT INTO customfieldsvalues (customfieldsvalue_customfield_id, customfieldsvalue_station_id, customfieldsvalue_text_value, customfieldsvalue_numeric_value) VALUES
  (8, 2, '2.10.1912', 0);
