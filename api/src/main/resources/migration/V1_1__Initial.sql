CREATE TABLE User(
  id INT AUTO_INCREMENT NOT NULL ,
  login VARCHAR(50) NOT NULL ,
  password VARCHAR(255) NOT NULL ,
  email VARCHAR(50),
  admin BOOL DEFAULT FALSE
);

CREATE TABLE Category(
  id INT AUTO_INCREMENT NOT NULL ,
  title VARCHAR(50) NOT NULL ,
  image VARCHAR(255) NOT NULL
);

CREATE TABLE Dish(
  id INT AUTO_INCREMENT NOT NULL ,
  title VARCHAR(50) NOT NULL ,
  description VARCHAR(255),
  image VARCHAR(255) NOT NULL ,
  category_id INT NOT NULL,
);

CREATE TABLE Table(
  id INT AUTO_INCREMENT NOT NULL,
  posx DOUBLE NOT NULL,
  posy DOUBLE NOT NULL
)