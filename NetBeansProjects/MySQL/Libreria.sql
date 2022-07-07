Create database Libreria;

use Libreria;

CREATE TABLE autor (
  ID int NOT NULL,
  ALTA tinyint,
  NOMBRE varchar(255) ,
  PRIMARY KEY (ID)
);

CREATE TABLE editorial (
  ID int,
  ALTA tinyint,
  NOMBRE varchar(255),
  PRIMARY KEY (ID)
);

CREATE TABLE libro (
  ISBN bigint(20),
  ALTA tinyint,
  ANIO int,
  EJEMPLARES int,
  EJEMPLARESPRESTADOS int,
  EJEMPLARESRESTANTES int,
  TITULO varchar(255),
  AUTOR_ID int,
  EDITORIAL_ID int,
  FOREIGN KEY (AUTOR_ID) REFERENCES autor (ID),
  FOREIGN KEY (EDITORIAL_ID) REFERENCES editorial (ID)
);