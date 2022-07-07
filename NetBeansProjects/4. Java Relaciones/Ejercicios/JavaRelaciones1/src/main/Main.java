package main;

import entidad.*; //Para traerse todas las clases de entidaddes
import java.util.Scanner;
import servicios.Servicio;

public class Main {

    public static void main(String[] args) {

        Scanner dato = new Scanner(System.in).useDelimiter("\n");
        Perro dog1 = new Perro();
        Perro dog2 = new Perro();

        Persona p1 = new Persona("Raul","Fernandez" , "20104906", 45, dog1);
        Persona p2 = new Persona("Laura", "Lopez", "25041879", 41, dog2);
        Servicio cane = new Servicio();
        
        cane.crearPerro(dog1);
        cane.crearPerro(dog2);
        System.out.println(p1.toString());
        System.out.println(p2.toString());


    }

}
