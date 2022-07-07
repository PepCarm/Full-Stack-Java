Create database EGG;

use EGG;

CREATE TABLE usuario (
  correo varchar(45),
  nombre varchar(45),
  apellido varchar(45),
  PRIMARY KEY (correo)
  );
  
  INSERT INTO usuario VALUES 
  ('julieta@egg.com','Julieta','Villarruel'),
  ('pepin@egg.com','Juancito','Sanchez');
