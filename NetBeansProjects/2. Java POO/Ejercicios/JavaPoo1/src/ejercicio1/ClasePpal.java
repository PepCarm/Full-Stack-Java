package ejercicio1;

import java.util.Scanner;

public class ClasePpal {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        Libro l1 = new Libro(); //apretar CRTL + espacio

        System.out.println("Ingrese el título del libro");
        String tituloLibro = leer.next();
        l1.setTituloLibro(tituloLibro); //Aca se almacena el valor del libro

        System.out.println("Ingrese el ISBN del libro");
        l1.setIsbn(leer.nextLong()); // Otra forma de hacerlo, mas corta.

        System.out.println("Ingrese el nombre del autor del libro");
        l1.setAutorLibro(leer.next());

        System.out.println("Ingrese el numero de paginas del libro");
        l1.setNumPaginas(leer.nextInt());

        System.out.println(l1.datosLibro());
    }
}
