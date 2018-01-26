DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` INT (20) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `username` VARCHAR(32) DEFAULT NULL,
  `password` VARCHAR(32) DEFAULT NULL,
  `email` VARCHAR(32) DEFAULT NULL,
  `phone` VARCHAR (32) DEFAULT NULL,
  `role` VARCHAR(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO users(username,password,email,phone,role) VALUES('Alexey','root','lao@gmail.com','102','ROLE_ADMIN');
INSERT INTO users(username,password,email,phone,role) VALUES('Vlad','root','bve@gmail.com','103','ROLE_USER');
