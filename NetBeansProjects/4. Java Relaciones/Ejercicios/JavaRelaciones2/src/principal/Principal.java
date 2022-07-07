package principal;

import entidad.Juego;
import entidad.Jugador;
import entidad.Revolver;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        Revolver datos_1 = new Revolver();

        Integer cantidad_jugador = 0;
        do {
            System.out.println("Ingrese la cantidad de jugador (1 a 6):");
            cantidad_jugador = leer.nextInt();
        } while (cantidad_jugador < 1 || cantidad_jugador > 6);

        Revolver Usar_Jugador = datos_1.llenarRevolver();
        System.out.println(Usar_Jugador.mostarRevolver());

        System.out.println("");

        ArrayList<Jugador> Pasar = new ArrayList();
        for (int i = 0; i < cantidad_jugador; i++) {
            Jugador datos_2 = new Jugador();
            datos_2.setNombre("Jugador");
            datos_2.setId(i + 1);
            Pasar.add(datos_2);
        }

        Juego datos_3 = new Juego();
        datos_3.llenarJuego(Pasar, Usar_Jugador);
        System.out.println("\t\t<<<<< COMIENZA EL JUEGO >>>>>");
        datos_3.ronda(Usar_Jugador);
    }

}


