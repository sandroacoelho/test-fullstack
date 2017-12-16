--liquibase formatted sql

--changeset test-fullstack:v1
CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` TEXT NOT NULL,
  `email` TEXT NOT NULL,
  `phone` VARCHAR(25) NOT NULL,
  `sex` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`id`));

--rollback drop table `test-fullstack`;
