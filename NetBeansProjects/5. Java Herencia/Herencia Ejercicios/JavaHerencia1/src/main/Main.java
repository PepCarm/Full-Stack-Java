package main;

import entidad.Caballo;
import entidad.Gato;
import entidad.Perro;

public class Main {

    public static void main(String[] args) {

        Perro perro = new Perro("Ladrido", "Lupin", "Doggi", 3, "Ovejero ALeman");
        perro.alimento();

        Caballo caballo = new Caballo("Relincha", "Mendieta", "Balanceado", 7, "Tordillo");
        caballo.alimento();
        
        Gato gato = new Gato("maulla", "Merlin", "Catchaw", 6, "Persa");
        gato.alimento();
    }

}
