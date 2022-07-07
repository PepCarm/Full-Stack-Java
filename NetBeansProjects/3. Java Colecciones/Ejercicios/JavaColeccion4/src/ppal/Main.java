package ppal;

import entidad.Pelicula;
import java.util.ArrayList;
import java.util.Scanner;
import servicio.Servicio;

public class Main {

    public static void main(String[] args) {

        Scanner dato = new Scanner(System.in).useDelimiter("\n");

        ArrayList<Pelicula> peliculas = new ArrayList();
        Servicio pelis = new Servicio();  
        
        pelis.agregarPeliculas();
       pelis.mostrarPeliculas();
        pelis.mostrarPeliculasMas60();
        pelis.mostrarPeliculasAsc();
        pelis.mostrarPeliculasDesc();
        pelis.mostrarPorTitulo();
        pelis.mostrarPorDirector();
        }
    }


