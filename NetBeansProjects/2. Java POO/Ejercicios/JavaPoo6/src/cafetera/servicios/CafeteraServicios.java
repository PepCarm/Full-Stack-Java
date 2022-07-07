package cafetera.servicios;

import cafetera.entidades.Cafetera;
import java.util.Scanner;

public class CafeteraServicios {

    Scanner dato = new Scanner(System.in).useDelimiter("\n");

    public Cafetera crearCafetera() {
        System.out.println("Ingrese el tamaño de la cafetera, que estara expresada en litros");
        int capMax = dato.nextInt();
        System.out.println("Ingrese la cantidad de litros de cafe que posee la cafetera actualmente");
        int cantActual = dato.nextInt();
        System.out.println("Ingrese el tamaño de la taza expresada en litros");
        int taza = dato.nextInt();
        return new Cafetera(capMax, cantActual, taza);
    }

    public void llenarCafetera(Cafetera nespresso) {
        int llenar = nespresso.getCapMax();
        nespresso.setCantidadActual(llenar);
    }

    /*Es decir primero llama al get con la variable creada, y despues le modifca el valor con un set. Es como 
    decir que set. metodo es = al objeto creado 
     */
    public void vaciarCafetera(Cafetera nespresso) {
        nespresso.setCantidadActual(0);
    }

    public void servirTaza(Cafetera nespresso, int taza) {
        System.out.println("Ingrese el tamaño de la taza");
        taza = dato.nextInt();
        if (nespresso.getCantidadActual() >= taza) {
            int cantidad = (int) nespresso.getCantidadActual();
            cantidad = cantidad - taza;
            nespresso.setCantidadActual(cantidad);
        } else {
            int resto = (int) (taza - nespresso.getCantidadActual());
            nespresso.setCantidadActual(0);
            System.out.println("Se sirvio la taza con " + resto + " cm3 y la cafetera quedo vacia");
        }
    }

    public void agregarCafe(Cafetera nespresso, int cantCafe) {
        if (nespresso.getCapMax() > nespresso.getCantidadActual()) {
            cantCafe = (int) (nespresso.getCapMax() - nespresso.getCantidadActual());
            System.out.println("Se debe agregar " + cantCafe + " litros de cafe");
            nespresso.setCantidadActual((int) (cantCafe+nespresso.getCantidadActual()));
         
        }
    }
}
