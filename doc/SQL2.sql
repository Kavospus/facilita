SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `facilita` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `facilita` ;

-- -----------------------------------------------------
-- Table `facilita`.`perfil`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `facilita`.`perfil` ;

CREATE TABLE IF NOT EXISTS `facilita`.`perfil` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `perfil` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `facilita`.`usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `facilita`.`usuario` ;

CREATE TABLE IF NOT EXISTS `facilita`.`usuario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(255) NOT NULL,
  `senha` VARCHAR(32) NOT NULL,
  `nome` VARCHAR(255) NOT NULL,
  `id_perfil` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_usuario_perfil_idx` (`id_perfil` ASC),
  CONSTRAINT `fk_usuario_perfil`
    FOREIGN KEY (`id_perfil`)
    REFERENCES `facilita`.`perfil` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `facilita`.`menu`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `facilita`.`menu` ;

CREATE TABLE IF NOT EXISTS `facilita`.`menu` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `menu` VARCHAR(255) NOT NULL,
  `link` VARCHAR(255) NOT NULL,
  `icone` VARCHAR(255) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `facilita`.`menu_perfil`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `facilita`.`menu_perfil` ;

CREATE TABLE IF NOT EXISTS `facilita`.`menu_perfil` (
  `id_perfil` INT NOT NULL,
  `id_menu` INT NOT NULL,
  PRIMARY KEY (`id_perfil`, `id_menu`),
  INDEX `fk_perfil_has_menu_menu1_idx` (`id_menu` ASC),
  INDEX `fk_perfil_has_menu_perfil1_idx` (`id_perfil` ASC),
  CONSTRAINT `fk_perfil_has_menu_perfil1`
    FOREIGN KEY (`id_perfil`)
    REFERENCES `facilita`.`perfil` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_perfil_has_menu_menu1`
    FOREIGN KEY (`id_menu`)
    REFERENCES `facilita`.`menu` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `facilita`.`calculo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `facilita`.`calculo` ;

CREATE TABLE IF NOT EXISTS `facilita`.`calculo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `operacao` VARCHAR(255) NOT NULL,
  `entrada` VARCHAR(1023) NOT NULL,
  `resultado` VARCHAR(1023) NOT NULL,
  `id_usuario` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_calculo_usuario1_idx` (`id_usuario` ASC),
  CONSTRAINT `fk_calculo_usuario1`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `facilita`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
