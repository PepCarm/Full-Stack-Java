package servicios;

import entidad.Perro;
import enumeraciones.Raza;
import java.util.Scanner;

public class Servicio {

    Scanner dato = new Scanner(System.in).useDelimiter("\n");

    Perro cane = new Perro();

    public Perro crearPerro(Perro raza) {

        System.out.println("Ingrese el nombre del perro");
        String nombre = dato.next();
        cane.setNombre(nombre);

        System.out.println("");//solo para un salto de linea
        System.out.println("Elija una raza dentro de las disponibles");
        // Muestro la raza y le pido al usuario que elija una
        for (Raza aux : Raza.values()) {
            System.out.println(aux);
        }
        System.out.println("");
        System.out.println("Ingrese la raza del perro");
        /*Con el for each recorre la clase enum, para buscar la raza que yo quiero*/
        String buscar = dato.next().toLowerCase();
        for (Raza cachorro : Raza.values()) {
            /*Para buscar dentro del for each tengo tengo que convertir variable cachorroen String, para poder comparar "buscar" con cachorro*/
            if (cachorro.toString().equalsIgnoreCase(buscar)) {
                cane.setRaza(cachorro);
            }
        }

        System.out.println("Ingrese el tamanio del perro");
        String tamanio = dato.next();
        cane.setTamanio(tamanio);

        System.out.println("Ingrese la edad del perro");
        int edad = dato.nextInt();
        cane.setEdad(edad);

        System.out.println(cane.mostrarPerro());
       
        return new Perro();
       
    }
    
    

}
