package cadena.servicios;

import cadena.entidades.Cadena;
import java.util.Scanner;

public class CadenaServicios {

    Scanner dato = new Scanner(System.in).useDelimiter("\n");
    Cadena sc = new Cadena();

    public void mostrarVocales(String frase) {

        String fraseIngMin = frase.toLowerCase();
        char arrayVocales[] = {'a', 'e', 'i', 'o', 'u'};
        char caracterLeido;
        int cantVocales = 0;

        for (int i = 0; i < frase.length(); i++) {
            caracterLeido = fraseIngMin.charAt(i);
            for (int j = 0; j < arrayVocales.length; j++) {
                if (arrayVocales[j] == caracterLeido) {
                    cantVocales++;
                    j = arrayVocales.length;
                }
            }
        }
        System.out.println("La frase ingresada cuenta con " + cantVocales + " vocales");
    }

    public void invertirFrse(String frase) {
        //String Builder me permite acceder a funciones como reversa 
        StringBuilder sb = new StringBuilder(frase);
        System.out.println(sb.reverse());
    }

    public void vecesRepetido(String frase) {

        System.out.println("Ingrese un caracter cualquiera");
        char letra = dato.next().toLowerCase().charAt(0);

        //Aca es donde paso una frase a un array de char
        char[] cuenta = frase.toCharArray();//metodo toCharArray
        int contador = 0;
        for (int i = 0; i < cuenta.length; i++) {
            if (cuenta[i] == letra) {
                contador++;
            }
        }
        if (contador != 0) {
            System.out.println(letra + " Se repite " + contador + " veces en la palabra y/o frase " + frase);
        } else {
            System.out.println(letra + " NO se repite en la palabra y/o frase " + frase);
        }
    }

    public void compararLongitud(String frase) {

        System.out.println("Ingrese una nueva frase para comparar con la anterior");
        String cadena = dato.nextLine();

        System.out.println(cadena.compareToIgnoreCase(frase));
    }

    public void unirFrases(String frase) {

        System.out.println("Ingrese una nueva frase para unirla con la anterior");
        String cadena = dato.nextLine();

        System.out.println(frase.concat(cadena));
    }

    public void reemplazar(String frase) {
       
        System.out.println("Ingrese el caracter por cual desea reeplazar todas las 'a' de la frase");
        char letra = dato.next().charAt(0);
        
        char[] cadena = frase.toCharArray();
        for (int i = 0; i < frase.length(); i++) {
            if (cadena[i] == 'a') {
                cadena [i]= letra;
            }
        }
        System.out.println(cadena);
    }
    public boolean contiene(String frase){
        
        System.out.println("Ingrese una letra para comprobar si dicho caracter, se encuntra en la frase");
        char letra = dato.next().toLowerCase().charAt(0);
        
         char[] cadena = frase.toCharArray();
         
         for (int i = 0; i < frase.length(); i++) {
             if (cadena[i] == letra) {
                 return true;
             }
        } return false;
    }
}
