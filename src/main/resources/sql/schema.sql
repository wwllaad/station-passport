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
  `station_id` INT NOT NULL AUTO_INCREMENT,
  `station_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`station_id`),
  UNIQUE INDEX `station_id_UNIQUE` (`station_id` ASC))
  ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `sections`;
CREATE TABLE `sections` (
  `section_id` INT NOT NULL AUTO_INCREMENT,
  `section_name` VARCHAR(45) NOT NULL,
  `parent_section_id` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`section_id`),
  UNIQUE INDEX `section_id_UNIQUE` (`section_id` ASC))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

DROP TABLE IF EXISTS `customfields`;
CREATE TABLE `customfields` (
  `customfield_id` INT NOT NULL AUTO_INCREMENT,
  `customfield_section_id` INT NOT NULL,
  `customfield_type` VARCHAR(256) NOT NULL,
  `customfield_name` VARCHAR(256) NOT NULL,
  `customfield_order` INT NOT NULL,
  UNIQUE INDEX `customfield_id_UNIQUE` (`customfield_id` ASC),
  PRIMARY KEY (`customfield_id`),
  INDEX `fk_section_id_idx` (`customfield_section_id` ASC),
  CONSTRAINT `fk_section_id`
  FOREIGN KEY (`customfield_section_id`)
  REFERENCES `sections` (`section_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

DROP TABLE IF EXISTS `customfieldsvalues`;
CREATE TABLE `customfieldsvalues`(
  `customfieldsvalue_id` INT NOT NULL AUTO_INCREMENT,
  `customfieldsvalue_customfield_id` INT NOT NULL,
  `customfieldsvalue_station_id` INT NOT NULL,
  `customfieldsvalue_text_value` VARCHAR(256) NOT NULL,
  `customfieldsvalue_numeric_value` INT NOT NULL,
  PRIMARY KEY (`customfieldsvalue_id`),
  UNIQUE INDEX `customfieldsvalue_id_UNIQUE` (`customfieldsvalue_id` ASC),
  INDEX `fk_customfield_id_idx` (`customfieldsvalue_customfield_id` ASC),
  INDEX `fk_station_id_idx` (`customfieldsvalue_station_id` ASC),
  CONSTRAINT `fk_customfield_id`
  FOREIGN KEY (`customfieldsvalue_customfield_id`)
  REFERENCES `customfields` (`customfield_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_station_id`
  FOREIGN KEY (`customfieldsvalue_station_id`)
  REFERENCES `stations` (`station_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

