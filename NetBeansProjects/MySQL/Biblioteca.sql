Create database Biblioteca;

use biblioteca;

CREATE TABLE autor (
  id varchar(255) NOT null auto_increment,
  nombre varchar(255),
  PRIMARY KEY (id)
  );
  
  CREATE TABLE cliente (
  documento bigint(20),
  apellido text,
  domicilio varchar(255),
  nombre text,
  telefono varchar(20),
  PRIMARY KEY (documento)
  );
  
  CREATE TABLE editorial (
  id int not null auto_increment,
  nombre text,
  PRIMARY KEY (id)
  );
  
  CREATE TABLE libro (
  isbn bigint(20),
  anio int,
  ejemplares int,
  prestados int,
  titulo varchar(255),
  autor_id varchar(255),
  editorial_id varchar(255),
  PRIMARY KEY (isbn),
  FOREIGN KEY (editorial_id) REFERENCES editorial (id),
  FOREIGN KEY (autor_id) REFERENCES autor (id)
  );
  
  CREATE TABLE personal (
  documento bigint(20),
  apellido text,
  cargo text,
  domicilio varchar(255),
  nombre text,
  telefono int,
  PRIMARY KEY (documento)
  );
  
  CREATE TABLE usuario (
  password varchar(255),
  user varchar(255),
  documento bigint(20),
  PRIMARY KEY (documento),
  FOREIGN KEY (documento) REFERENCES personal (documento)
);

CREATE TABLE prestamo (
  id varchar(255),
  devolucion date,
  fecha datetime,
  multa double,
  cliente_documento bigint(20),
  libro_isbn bigint(20),
  PRIMARY KEY (id),
  FOREIGN KEY (cliente_documento) REFERENCES cliente (documento),
  FOREIGN KEY (libro_isbn) REFERENCES libro (isbn)
  );

