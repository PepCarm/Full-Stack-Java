package utilidades;

import entidad.Pelicula;
import java.util.Comparator;

public class Comparadores {

//Comparator con su declaracion estandar
    //Compara las películas por titulo, alfabéticamente.
    public static Comparator<Pelicula> porTitulo = new Comparator<Pelicula>() {

        public int compare(Pelicula p1, Pelicula p2) {
            return p1.getTitulo().compareTo(p2.getTitulo());
        }
    };

//    //Compara las películas de acuerdo a su duración de mayor a menor.     
    public static Comparator<Pelicula> poDuracionAsc = new Comparator<Pelicula>() {

        public int compare(Pelicula p1, Pelicula p2) {
            return p2.getDuracionHs().compareTo(p1.getDuracionHs());
        }
    };

//    //Compara las películas de acuerdo a su duración de menor a mayor.
    public static Comparator<Pelicula> poDuracionDes = new Comparator<Pelicula>() {

        public int compare(Pelicula p1, Pelicula p2) {
            return p1.getDuracionHs().compareTo(p2.getDuracionHs());
        }
    };

//    //Compara Peliculas por el Director, alfabeticamente.
        public static Comparator<Pelicula> poDirector = new Comparator<Pelicula>() {

        public int compare(Pelicula p1, Pelicula p2) {
            return p1.getDirector().compareTo(p2.getDirector());
        }
    };
}
