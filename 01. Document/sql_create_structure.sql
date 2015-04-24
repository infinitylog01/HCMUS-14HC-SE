-- MySQL Script generated by MySQL Workbench
-- 04/25/15 00:09:39
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema airplaneticket_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema airplaneticket_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `airplaneticket_db` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `airplaneticket_db` ;

-- -----------------------------------------------------
-- Table `airplaneticket_db`.`Airport`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `airplaneticket_db`.`Airport` (
  `id` INT UNSIGNED NOT NULL,
  `airport_name` VARCHAR(50) NOT NULL,
  `latitude` DECIMAL(6,6) NOT NULL,
  `longitude` DECIMAL(6,6) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `airplaneticket_db`.`Configuration`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `airplaneticket_db`.`Configuration` (
  `min_fly_time` SMALLINT UNSIGNED NOT NULL,
  `max_intermediate_airport` TINYINT(2) UNSIGNED NOT NULL,
  `min_stop_time` SMALLINT UNSIGNED NOT NULL,
  `max_stop_time` SMALLINT UNSIGNED NOT NULL,
  `limit_time_book_ticket` MEDIUMINT UNSIGNED NOT NULL,
  `limit_time_abort_ticket` MEDIUMINT UNSIGNED NOT NULL)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `airplaneticket_db`.`Flight`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `airplaneticket_db`.`Flight` (
  `flight_code` CHAR(10) NOT NULL,
  `depart_time` INT UNSIGNED NULL,
  `duration` MEDIUMINT UNSIGNED NULL,
  `business_class_tickets` SMALLINT(3) NULL,
  `ecomomy_class_tickets` SMALLINT(3) NULL,
  `route_id` VARCHAR(45) NULL,
  `flight_route(json)` TEXT NULL,
  UNIQUE INDEX `flight_code_UNIQUE` (`flight_code` ASC),
  PRIMARY KEY (`flight_code`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `airplaneticket_db`.`FlightRoute`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `airplaneticket_db`.`FlightRoute` (
  `route_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `start_airport_id` INT NULL,
  `des_airport_id` INT NULL,
  `first_med_airport` INT NULL,
  `second_med_airport` INT NULL,
  `can replace by json` VARCHAR(45) NULL,
  PRIMARY KEY (`route_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `airplaneticket_db`.`TicketClass`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `airplaneticket_db`.`TicketClass` (
  `id` CHAR(5) NOT NULL,
  `ticket_name` VARCHAR(45) NOT NULL,
  `price` DECIMAL(5,2) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `airplaneticket_db`.`Ticket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `airplaneticket_db`.`Ticket` (
  `ticket_code` CHAR(10) NOT NULL,
  `passenger_id` CHAR(10) NOT NULL,
  `passenger_name` VARCHAR(45) NOT NULL,
  `passenger_phone_number` CHAR(11) NOT NULL,
  `Flight_flight_code` CHAR(10) NOT NULL,
  `TicketClass_id` CHAR(5) NOT NULL,
  PRIMARY KEY (`ticket_code`, `Flight_flight_code`, `TicketClass_id`),
  INDEX `fk_Ticket_Flight1_idx` (`Flight_flight_code` ASC),
  INDEX `fk_Ticket_TicketClass1_idx` (`TicketClass_id` ASC),
  CONSTRAINT `fk_Ticket_Flight1`
    FOREIGN KEY (`Flight_flight_code`)
    REFERENCES `airplaneticket_db`.`Flight` (`flight_code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Ticket_TicketClass1`
    FOREIGN KEY (`TicketClass_id`)
    REFERENCES `airplaneticket_db`.`TicketClass` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `airplaneticket_db`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `airplaneticket_db`.`User` (
  `uid` CHAR(6) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(32) NOT NULL,
  `role` TINYINT(2) NULL,
  PRIMARY KEY (`uid`));


-- -----------------------------------------------------
-- Table `airplaneticket_db`.`UserRole`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `airplaneticket_db`.`UserRole` (
  `id` TINYINT(2) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;