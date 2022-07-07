Create database jpaModeloBasico;

use jpaModeloBasico;

CREATE TABLE direccion (
  ID varchar(255),
  PAIS varchar(255),
  PROVINCIA varchar(255),
  PRIMARY KEY (ID)
  );
  
  CREATE TABLE mascota (
  ID varchar(255),
  APODO varchar(255),
  RAZA varchar(255),
  PRIMARY KEY (ID)
  );
  
  CREATE TABLE newentity (
  ID bigint(20),
  PRIMARY KEY (ID)
  );
  
  CREATE TABLE quieroquetellamesasi (
  ID varchar(255),
  CLAVE varchar(255),
  CORREOELECTRONICO varchar(255),
  DNI integer,
  NACIMIENTO date,
  ROL varchar(255),
  DIRECCION_ID varchar(255),
  MASCOTA_ID varchar(255),
  PRIMARY KEY (ID),
  FOREIGN KEY (DIRECCION_ID) REFERENCES direccion (ID),
  FOREIGN KEY (MASCOTA_ID) REFERENCES mascota (ID)
);

CREATE TABLE sequence (
  SEQ_NAME varchar(50),
  SEQ_COUNT decimal(38,0),
  PRIMARY KEY (SEQ_NAME)
);

