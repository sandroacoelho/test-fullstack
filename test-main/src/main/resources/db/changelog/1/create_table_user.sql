--liquibase formatted sql

--changeset test-fullstack:v1
CREATE SCHEMA IF NOT EXISTS `test-fullstack` DEFAULT CHARACTER SET utf8;

--rollback drop schema `test-fullstack`;


--changeset test-fullstack:v2
CREATE TABLE IF NOT EXISTS `test-fullstack`.`USER` (
  `id` INT NOT NULL,
  `name` TEXT NOT NULL,
  `email` TEXT NOT NULL,
  `phone` VARCHAR(25) NOT NULL,
  `sex` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

--rollback drop table `test-fullstack`;
