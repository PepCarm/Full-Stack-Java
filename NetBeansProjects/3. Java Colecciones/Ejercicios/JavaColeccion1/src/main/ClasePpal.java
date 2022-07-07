package main;

import main.entidad.Perro;
import main.servicios.ServiciosPerro;

public class ClasePpal {

    public static void main(String[] args) {

        Perro p1 = new Perro();
        ServiciosPerro can = new ServiciosPerro();

        can.agregarRazas();
        can.eliminarRaza();


    }

}
