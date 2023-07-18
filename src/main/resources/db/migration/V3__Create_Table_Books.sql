﻿CREATE TABLE `book` (
  `id` bigint AUTO_INCREMENT PRIMARY KEY,
  `author` longtext,
  `launch_date` varchar(40) NOT NULL,
  `price` decimal(65,2) NOT NULL,
  `title` longtext
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
