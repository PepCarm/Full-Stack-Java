package servicio;

import entidad.Pelicula;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import utilidades.Comparadores;

public class Servicio {

    Scanner dato = new Scanner(System.in).useDelimiter("\n");

    ArrayList<Pelicula> peliculas = new ArrayList();

    public Pelicula crearPeliculas() {

        System.out.println("Ingrese el nombre del la pelicula");
        String titulo = dato.next();

        System.out.println("Ingrese el director de la pelicula");
        String director = dato.next();

        System.out.println("Ingrese la duracion de la pelicula");
        Integer duracion = dato.nextInt();

        return new Pelicula(titulo, director, duracion);
    }

    public void agregarPeliculas() {

        char respuesta;
        do {
            /*Otra forma de agregar objetos a la lista cdo tenemos muchos atributos*/
            peliculas.add(crearPeliculas());
            System.out.println("Quiere ingresar otro pelicula ?");
            respuesta = dato.next().toUpperCase().charAt(0);
        } while (respuesta != 'N');
        /*Esto es otra forma de hacerlo, pero por el main 
Pelicula movie = pelis.crearPeliculas();
 peliculas.add(movie);*/
    }

    public void mostrarPeliculas() {
        System.out.println("MOSTRAR PELICULAS");

        for (Pelicula pelicula : peliculas) {
            System.out.println(pelicula.mostaraPelicula());
        }
    }

    public void mostrarPeliculasMas60() {

        System.out.println("MOSTRAR PELICULAS MAYORES A 1HS");
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getDuracionHs() >= 60) {
                System.out.println(pelicula.mostaraPelicula());
            }
        }
    }

    public void mostrarPeliculasAsc() {
        System.out.println("PELICULAS DE ACUERDO A SU DURACION DE MAY A MENOR");
        Collections.sort(peliculas, Comparadores.poDuracionAsc);
        for (Pelicula pelicula : peliculas) {
            System.out.println(pelicula.mostaraPelicula());
        }
    }

    public void mostrarPeliculasDesc() {
        System.out.println("PELICULAS DE ACUERDO A SU DURACION DE MENOR A MAY");
        Collections.sort(peliculas, Comparadores.poDuracionDes);
        for (Pelicula pelicula : peliculas) {
            System.out.println(pelicula.mostaraPelicula());
        }
    }

    public void mostrarPorTitulo() {
        System.out.println("PELICULAS POR ORDEN ALFABETICO");
        Collections.sort(peliculas, Comparadores.porTitulo);
        for (Pelicula pelicula : peliculas) {
            System.out.println(pelicula.mostaraPelicula());
        }
    }

    public void mostrarPorDirector() {
        System.out.println("PELICULAS POR DIRECTOR");
        Collections.sort(peliculas, Comparadores.poDirector);
        for (Pelicula pelicula : peliculas) {
            System.out.println(pelicula.mostaraPelicula());
        }
    }
}
