package persona.servicios;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;
import persona.entidad.Persona;

public class PersonaServicios {

    Scanner dato = new Scanner(System.in).useDelimiter("\n");

    public Persona crearPersona() {
        System.out.println("\n *** NOMBRE ***");
        System.out.println("Ingrese el nombre de la persona");
        String nombre = dato.next();
        System.out.println("\n *** FECHA DE NACIMIENTO ***");
        System.out.println("Ingrese el año de nacimiento");
        int anio = dato.nextInt();
        System.out.println("Ingrese el mes de nacimiento");
        int mes = dato.nextInt();
        System.out.println("Ingrese el dia de nacimiento");
        int dia = dato.nextInt();

        Date fecha = new Date(anio - 1900, mes - 1, dia);
        return new Persona(nombre, fecha);
    }

    public void calcularEdad(Persona fecha) {
       Date fechaActual = new Date();
       int edad = fechaActual.getYear()- fecha.getFechaNac().getYear();
        System.out.println("edad "+edad);
    }
    
    public boolean menorQue(Persona fecha){
        
        boolean menor = true;
        System.out.println("Ingrese una nueva edad para comparar");
        int edad= dato.nextInt();
        Date nuevaEdad = new Date (edad-1900);
        
        if (nuevaEdad.getYear()>fecha.getFechaNac().getYear()) {
            System.out.println("Es menor");
            return true;
        }else{
            System.out.println("Es mayor");
            return false;
        }
    }
    
    public void mostrarPersona(Persona nombre, Persona fecha){
        System.out.println("Nombre de la persona; "+ nombre.getNombre());
        System.out.println("Edad; "+fecha.getNombre());
    }
}
