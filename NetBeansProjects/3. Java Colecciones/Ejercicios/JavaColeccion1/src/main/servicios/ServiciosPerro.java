package main.servicios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import main.entidad.Perro;

public class ServiciosPerro {

    Scanner dato = new Scanner(System.in).useDelimiter("\n");

    private ArrayList<String> perro = new ArrayList<String>();

    public Perro crearRaza() {
        System.out.println("Ingrese la raza del perro");
        String raza = dato.next();
        perro.add(raza);
        return new Perro(raza);
    }

    public void mostrarRaza(String raza) {
        for (String String : perro) {
            System.out.println(raza.toString());
        }
    }

    public void agregarRazas() {

        String respuesta;
        do {
            crearRaza();
            System.out.println("¿Desea agregar otra raza de perro? S/N");
            respuesta = dato.next().toUpperCase();
        } while (respuesta.equalsIgnoreCase("s"));

        System.out.println("La lista tiene como razas a " + perro.toString());
    }

    public void eliminarRaza() {
        /*
        pido que ingrese la raza eliminar y si coincide que lo elimine
         */
        boolean valor = false;
        Iterator<String> mascota = perro.iterator();
        System.out.println("Ingrese el tipo de raza a eliminar");
        String chau = dato.next();

        while (mascota.hasNext()) {
            String aux = mascota.next();

            if (aux.equals(chau)) {
                mascota.remove();
                valor = true;
            }
        }
        if (valor) {
            Collections.sort(perro);
            System.out.println(perro.toString());
        } else {
            System.out.println("\nNo se encontro el nombre de la raza de perro");
            Collections.sort(perro);
            System.out.println(perro.toString());
        }

    }

    public void imprimirLista() {
        System.out.println("Lista Actualizada \n");
        for (String aux : perro) {
            System.out.println(aux);
        }
    }
}
