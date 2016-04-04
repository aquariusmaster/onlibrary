-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema onlibrary
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `onlibrary` ;

-- -----------------------------------------------------
-- Schema onlibrary
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `onlibrary` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `onlibrary` ;

-- -----------------------------------------------------
-- Table `onlibrary`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `onlibrary`.`users` ;

CREATE TABLE IF NOT EXISTS `onlibrary`.`users` (
  `username` VARCHAR(30) NOT NULL COMMENT '',
  `password` VARCHAR(255) NOT NULL COMMENT '',
  `email` VARCHAR(100) NULL COMMENT '',
  `name` VARCHAR(45) NOT NULL COMMENT '',
  `enabled` TINYINT(1) NOT NULL COMMENT '',
  `authority` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`username`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `onlibrary`.`books`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `onlibrary`.`books` ;

CREATE TABLE IF NOT EXISTS `onlibrary`.`books` (
  `id` INT NULL AUTO_INCREMENT COMMENT '',
  `title` VARCHAR(255) NOT NULL COMMENT '',
  `author` VARCHAR(255) NOT NULL COMMENT '',
  `genre` VARCHAR(255) NOT NULL COMMENT '',
  `description` VARCHAR(255) NOT NULL COMMENT '',
  `filename` VARCHAR(255) NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `onlibrary`.`users_books`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `onlibrary`.`users_books` ;

CREATE TABLE IF NOT EXISTS `onlibrary`.`users_books` (
  `username` VARCHAR(30) NOT NULL COMMENT '',
  `book_id` INT NOT NULL COMMENT '',
  PRIMARY KEY (`username`, `book_id`)  COMMENT '',
  INDEX `fk_users_books_books1_idx` (`book_id` ASC)  COMMENT '',
  CONSTRAINT `fk_users_books_users`
    FOREIGN KEY (`username`)
    REFERENCES `onlibrary`.`users` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_users_books_books1`
    FOREIGN KEY (`book_id`)
    REFERENCES `onlibrary`.`books` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
