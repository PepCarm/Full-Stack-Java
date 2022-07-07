package persona;

import persona.entidades.Persona;
import persona.servicios.PersonaServicios;

public class ClasePpal {

    public static void main(String[] args) {

        PersonaServicios ps = new PersonaServicios();

        /* Si dejamos esto asi, es para que el usuario los ingrese por teclado
         */
//      Persona p1 = ps.crearPersona();
//        Persona p2 = ps.crearPersona();
//        Persona p3 = ps.crearPersona();
//        Persona p4 = ps.crearPersona();
//        
        //Así lo ingresamos nosotros
        
        Persona p1 = new Persona();
        p1.setNombre("Agustin");
        p1.setEdad(25);
        p1.setSexo('H');
        p1.setPeso(75.4);
        p1.setAltura(1.98);

        Persona p2 = new Persona();
        p2.setNombre("Florencia");
        p2.setEdad(29);
        p2.setSexo('M');
        p2.setPeso(69.2);
        p2.setAltura(1.65);

        Persona p3 = new Persona();
        p3.setNombre("Raul");
        p3.setEdad(32);
        p3.setSexo('H');
        p3.setPeso(72.1);
        p3.setAltura(1.72);

        Persona p4 = new Persona();
        p4.setNombre("Melisa");
        p4.setEdad(22);
        p4.setSexo('M');
        p4.setPeso(61.06);
        p4.setAltura(1.62);

        //si la persona está en su peso ideal
        System.out.println(p1.mostrarDatos());
        ps.calcularIMC(p1);
        ps.esMayorDeEdad(p1);
        

        System.out.println(p2.mostrarDatos());
        ps.calcularIMC(p2);
        ps.esMayorDeEdad(p2);

        System.out.println(p3.mostrarDatos());
        ps.calcularIMC(p3);
        ps.esMayorDeEdad(p3);

        System.out.println(p4.mostrarDatos());
        ps.calcularIMC(p4);
        ps.esMayorDeEdad(p4);
        
        
    }

}
