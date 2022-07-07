package persona;

import java.util.Scanner;
import persona.entidad.Persona;
import persona.servicios.PersonaServicios;

public class ClasePpal {

    public static void main(String[] args) {

        Scanner dato = new Scanner(System.in).useDelimiter("\n");

        PersonaServicios ps = new PersonaServicios();
        Persona p1 = ps.crearPersona();
        ps.calcularEdad(p1);
        ps.menorQue(p1);
        ps.mostrarPersona(p1, p1);
       
       
    }

}
