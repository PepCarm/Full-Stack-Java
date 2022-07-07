package ejercicio2;

import java.util.Scanner;

public class ClasePpal {

    public static void main(String[] args) {

        Scanner dato = new Scanner(System.in).useDelimiter("\n");

        Circunferencia radio1 = new Circunferencia(0);

        System.out.println("Ingrese el valor del radio para calcular el area y el perimetro de una circunferencia");
        radio1.setRadio(dato.nextDouble()); // el obejeto.set(objetoScanner.next())

        //Calculo del area y del perimetro
        System.out.println("El area de la circunferencia es " + radio1.area());
        System.out.println("El perimetro de la circunferencia es " + radio1.perimetro());

    }
}
