SET foreign_key_checks = 0;

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` INT (20) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `username` VARCHAR(32) DEFAULT NULL,
  `password` VARCHAR(32) DEFAULT NULL,
  `email` VARCHAR(32) DEFAULT NULL,
  `phone` VARCHAR (32) DEFAULT NULL,
  `role` VARCHAR(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `stations`;
CREATE TABLE `stations` (
  `stations_id` INT NOT NULL AUTO_INCREMENT,
  `stations_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`stations_id`),
  UNIQUE INDEX `stations_id_UNIQUE` (`stations_id` ASC))
  ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `sections`;
CREATE TABLE `sections` (
  `sections_id` INT NOT NULL AUTO_INCREMENT,
  `sections_name` VARCHAR(45) NOT NULL,
  `parent_section_id` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`sections_id`),
  UNIQUE INDEX `sections_id_UNIQUE` (`sections_id` ASC))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

DROP TABLE IF EXISTS `customfields`;
CREATE TABLE `customfields` (
  `customfields_id` INT NOT NULL AUTO_INCREMENT,
  `customfields_section_id` INT NOT NULL,
  `customfields_type` VARCHAR(45) NOT NULL,
  `customfields_name` VARCHAR(45) NOT NULL,
  `customfields_order` INT NOT NULL,
  UNIQUE INDEX `customfields_id_UNIQUE` (`customfields_id` ASC),
  PRIMARY KEY (`customfields_id`),
  INDEX `fk_section_id_idx` (`customfields_section_id` ASC),
  CONSTRAINT `fk_section_id`
  FOREIGN KEY (`customfields_section_id`)
  REFERENCES `sections` (`sections_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

DROP TABLE IF EXISTS `customfieldsvalues`;
CREATE TABLE `customfieldsvalues`(
  `customfieldsvalues_id` INT NOT NULL AUTO_INCREMENT,
  `customfieldsvalues_customfields_id` INT NOT NULL,
  `customfieldsvalues_station_id` INT NOT NULL,
  `customfieldsvalues_text_value` VARCHAR(256) NOT NULL,
  `customfieldsvalues_numeric_value` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`customfieldsvalues_id`),
  UNIQUE INDEX `customfieldsvalues_id_UNIQUE` (`customfieldsvalues_id` ASC),
  INDEX `fk_customfields_id_idx` (`customfieldsvalues_customfields_id` ASC),
  INDEX `fk_station_id_idx` (`customfieldsvalues_station_id` ASC),
  CONSTRAINT `fk_customfields_id`
  FOREIGN KEY (`customfieldsvalues_customfields_id`)
  REFERENCES `customfields` (`customfields_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_station_id`
  FOREIGN KEY (`customfieldsvalues_station_id`)
  REFERENCES `stations` (`stations_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

