package cafetera;

import cafetera.entidades.Cafetera;
import cafetera.servicios.CafeteraServicios;
import java.util.Scanner;

public class ClasePpal {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        CafeteraServicios sc = new CafeteraServicios();

        Cafetera c1 = sc.crearCafetera();// Aca llamo para crear la cuenta

        System.out.println("\n");
        byte opcion = 0;
        do {
            System.out.println("\t");
            System.out.println("MENU");
            System.out.println("1-Llenar Cafetera");
            System.out.println("2-Servir Taza");
            System.out.println("3-Agregar Cafe");
            System.out.println("4-Vaciar cafetera");
            System.out.println("5-Salir");

            opcion = leer.nextByte();

            switch (opcion) {
                case 1:
                    System.out.println("La cafetera ha sido llenada");
                    sc.llenarCafetera(c1);
                    System.out.println(c1.getCantidadActual());
                    break;
                case 2:
                    sc.servirTaza(c1, opcion);
                    System.out.println("La taza ha sido servida");
                    System.out.println("La cafetera contiene " + c1.getCantidadActual() + " litros de cafe");
                    break;
                case 3:
                    sc.agregarCafe(c1, opcion);
                    System.out.println(c1.getCantidadActual());
                    break;
                case 4:
                    System.out.println("La cafetera ha sido vaciada");
                    sc.vaciarCafetera(c1);
                    System.out.println(c1.getCantidadActual());
                    break;
                case 5: 
                    break;
                default:
            }
        } while (opcion < 5);
    }
}
