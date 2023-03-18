CREATE TABLE `cinema`.`film` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `duration` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
);

INSERT INTO `cinema`.`film` (`id`, `name`, `duration`) VALUES ('1', 'Кот в сапогах', '104');
INSERT INTO `cinema`.`film` (`id`, `name`, `duration`) VALUES ('2', 'Чебурашка', '113');
INSERT INTO `cinema`.`film` (`id`, `name`, `duration`) VALUES ('3', 'Человк-муравей и Оса', '125');


CREATE TABLE `cinema`.`schedule` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `film_id` INT NOT NULL,
  `date` DATE NOT NULL,
  `time` TIME NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_film_id_idx` (`film_id` ASC) VISIBLE,
  CONSTRAINT `fk_film_id`
    FOREIGN KEY (`film_id`)
    REFERENCES `cinema`.`film` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
INSERT INTO `cinema`.`schedule` (`id`, `film_id`, `date`, `time`) VALUES ('1', '1', '2023-03-16', '14:50');
INSERT INTO `cinema`.`schedule` (`id`, `film_id`, `date`, `time`) VALUES ('2', '1', '2023-03-16', '17:45');
INSERT INTO `cinema`.`schedule` (`id`, `film_id`, `date`, `time`) VALUES ('3', '2', '2023-03-16', '13:00');
INSERT INTO `cinema`.`schedule` (`id`, `film_id`, `date`, `time`) VALUES ('4', '2', '2023-03-17', '13:00');
INSERT INTO `cinema`.`schedule` (`id`, `film_id`, `date`, `time`) VALUES ('5', '2', '2023-03-17', '15:40');
INSERT INTO `cinema`.`schedule` (`id`, `film_id`, `date`, `time`) VALUES ('6', '3', '2023-03-16', '21:00');
INSERT INTO `cinema`.`schedule` (`id`, `film_id`, `date`, `time`) VALUES ('7', '3', '2023-03-17', '10:00');

    
CREATE TABLE `cinema`.`pricelist` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `schedule_id` INT NOT NULL,
  `price` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `schedule_id_UNIQUE` (`schedule_id` ASC) VISIBLE,
  CONSTRAINT `fk_schedule_id`
    FOREIGN KEY (`schedule_id`)
    REFERENCES `cinema`.`schedule` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
INSERT INTO `cinema`.`pricelist` (`id`, `schedule_id`, `price`) VALUES ('1', '1', '7');
INSERT INTO `cinema`.`pricelist` (`id`, `schedule_id`, `price`) VALUES ('2', '2', '8');
INSERT INTO `cinema`.`pricelist` (`id`, `schedule_id`, `price`) VALUES ('3', '4', '6');
INSERT INTO `cinema`.`pricelist` (`id`, `schedule_id`, `price`) VALUES ('4', '3', '6');
INSERT INTO `cinema`.`pricelist` (`id`, `schedule_id`, `price`) VALUES ('5', '7', '8');
INSERT INTO `cinema`.`pricelist` (`id`, `schedule_id`, `price`) VALUES ('6', '6', '9');
INSERT INTO `cinema`.`pricelist` (`id`, `schedule_id`, `price`) VALUES ('7', '5', '6');


CREATE TABLE `cinema`.`tickets_sales` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `schedule_id` INT NOT NULL,
  `place` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_schedule_id_idx` (`schedule_id` ASC) VISIBLE,
  CONSTRAINT `fk_schedule_sales`
    FOREIGN KEY (`schedule_id`)
    REFERENCES `cinema`.`schedule` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
INSERT INTO `cinema`.`tickets_sales` (`id`, `schedule_id`, `place`) VALUES ('1', '2', '3');
INSERT INTO `cinema`.`tickets_sales` (`id`, `schedule_id`, `place`) VALUES ('2', '2', '17');
INSERT INTO `cinema`.`tickets_sales` (`id`, `schedule_id`, `place`) VALUES ('3', '2', '18');
INSERT INTO `cinema`.`tickets_sales` (`id`, `schedule_id`, `place`) VALUES ('4', '2', '19');
INSERT INTO `cinema`.`tickets_sales` (`id`, `schedule_id`, `place`) VALUES ('5', '6', '27');
INSERT INTO `cinema`.`tickets_sales` (`id`, `schedule_id`, `place`) VALUES ('6', '6', '29');
INSERT INTO `cinema`.`tickets_sales` (`id`, `schedule_id`, `place`) VALUES ('7', '6', '28');
INSERT INTO `cinema`.`tickets_sales` (`id`, `schedule_id`, `place`) VALUES ('8', '2', '13');
INSERT INTO `cinema`.`tickets_sales` (`id`, `schedule_id`, `place`) VALUES ('9', '3', '11');
INSERT INTO `cinema`.`tickets_sales` (`id`, `schedule_id`, `place`) VALUES ('10', '1', '17');
INSERT INTO `cinema`.`tickets_sales` (`id`, `schedule_id`, `place`) VALUES ('11', '3', '33');
INSERT INTO `cinema`.`tickets_sales` (`id`, `schedule_id`, `place`) VALUES ('12', '4', '5');
INSERT INTO `cinema`.`tickets_sales` (`id`, `schedule_id`, `place`) VALUES ('13', '5', '5');
INSERT INTO `cinema`.`tickets_sales` (`id`, `schedule_id`, `place`) VALUES ('14', '5', '6');
INSERT INTO `cinema`.`tickets_sales` (`id`, `schedule_id`, `place`) VALUES ('15', '7', '27');
INSERT INTO `cinema`.`tickets_sales` (`id`, `schedule_id`, `place`) VALUES ('16', '7', '29');
INSERT INTO `cinema`.`tickets_sales` (`id`, `schedule_id`, `place`) VALUES ('17', '7', '28');
INSERT INTO `cinema`.`tickets_sales` (`id`, `schedule_id`, `place`) VALUES ('18', '2', '28');
INSERT INTO `cinema`.`tickets_sales` (`id`, `schedule_id`, `place`) VALUES ('19', '7', '11');
INSERT INTO `cinema`.`tickets_sales` (`id`, `schedule_id`, `place`) VALUES ('20', '7', '3');
