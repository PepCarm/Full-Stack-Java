package ejercicio4;

import java.util.Scanner;

public class ClasePpal {

    public static void main(String[] args) {

        Scanner dato = new Scanner(System.in).useDelimiter("\n");
        Rectangulo rc = new Rectangulo();

        System.out.println("Ingrese un valor para la base");
        rc.setBase(dato.nextInt());

        System.out.println("Ingrese un valor para la altura");
        rc.setAltura(dato.nextInt());

        System.out.println("El Perimetro del rectangulo es " + rc.perimetro());
        System.out.println("El Area del rectangulo es " + rc.area());
        System.out.println("\t");
        System.out.println("Dibujo del rectangulo");
        System.out.println("\t");
        rc.dibujarRectangulo();
    }

}
