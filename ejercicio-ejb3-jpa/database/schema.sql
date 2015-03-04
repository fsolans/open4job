CREATE DATABASE `jpda`;

USE `jpda`;

CREATE TABLE `jpda`.`project` (
  `pname` VARCHAR(255) NULL,
  `pnumber` INT(11) NOT NULL AUTO_INCREMENT,
  `plocation` VARCHAR(255) NULL,
  `dept_no` VARCHAR(45) NULL,
  PRIMARY KEY (`pnumber`));
