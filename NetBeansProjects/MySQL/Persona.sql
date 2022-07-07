CREATE TABLE ciudad (
    id VARCHAR(255),
    nombre VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE persona (
  id varchar(255),
  apellido varchar(255),
  edad int,
  nombre varchar(255),,
  ciudad_id varchar(255),
  PRIMARY KEY (id),
  FOREIGN KEY (ciudad_id) REFERENCES ciudad (id)
);