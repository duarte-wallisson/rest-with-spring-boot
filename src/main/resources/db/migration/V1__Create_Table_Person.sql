CREATE TABLE IF NOT EXISTS `person`
(
    `id`         bigint      NOT NULL AUTO_INCREMENT,
    `first_name` varchar(40) NOT NULL,
    `last_name`  varchar(40) NOT NULL,
    `gender`     varchar(20)  DEFAULT NULL,
    `address`    varchar(100) DEFAULT NULL,
    PRIMARY KEY (`id`)
);