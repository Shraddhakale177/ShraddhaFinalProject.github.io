-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema moviecruiser
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema moviecruiser
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `moviecruiser` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `moviecruiser` ;

-- -----------------------------------------------------
-- Table `moviecruiser`.`movie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `moviecruiser`.`movie` (
  `mo_id` INT(11) NOT NULL AUTO_INCREMENT,
  `mo_title` VARCHAR(100) NULL DEFAULT NULL,
  `mo_boxoffice` BIGINT(20) NULL DEFAULT NULL,
  `mo_active` VARCHAR(3) NULL DEFAULT NULL,
  `mo_date_of_launch` DATE NULL DEFAULT NULL,
  `mo_genre` VARCHAR(45) NULL DEFAULT NULL,
  `mo_has_teaser` VARCHAR(3) NULL DEFAULT NULL,
  PRIMARY KEY (`mo_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `moviecruiser`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `moviecruiser`.`user` (
  `us_id` INT(11) NOT NULL AUTO_INCREMENT,
  `us_name` VARCHAR(60) NULL DEFAULT NULL,
  PRIMARY KEY (`us_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `moviecruiser`.`favorites`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `moviecruiser`.`favorites` (
  `fav_id` INT(11) NOT NULL AUTO_INCREMENT,
  `fav_us_id` INT(11) NULL DEFAULT NULL,
  `fav_mo_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`fav_id`),
  INDEX `fav_us_id_idx` (`fav_us_id` ASC),
  INDEX `fav_mo_id_idx` (`fav_mo_id` ASC),
  CONSTRAINT `fav_mo_id`
    FOREIGN KEY (`fav_mo_id`)
    REFERENCES `moviecruiser`.`movie` (`mo_id`),
  CONSTRAINT `fav_us_id`
    FOREIGN KEY (`fav_us_id`)
    REFERENCES `moviecruiser`.`user` (`us_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
