package ejercicio3;

import java.util.Scanner;

public class ClasePPal {

    public static void main(String[] args) {

        Scanner dato = new Scanner(System.in).useDelimiter("\n");
        Operacion aritmetica = new Operacion();

        System.out.println("Ingrese 2 numeros enteros cualquiera");

        aritmetica.setNumero1(dato.nextInt());
        aritmetica.setNumero2(dato.nextInt());

        System.out.println("La suma de " + aritmetica.getNumero1() + " y " + aritmetica.getNumero2() + " es " + aritmetica.sumar());
        System.out.println("La resta de " + aritmetica.getNumero1() + " y " + aritmetica.getNumero2() + " es " + aritmetica.resta());
        System.out.println("La multiplicacion de " + aritmetica.getNumero1() + " y " + aritmetica.getNumero2() + " es " + aritmetica.multiplicar());
        System.out.println("La divison de " + aritmetica.getNumero1() + " y " + aritmetica.getNumero2() + " es " + aritmetica.division());

    }
}
