package servicio;

import entidad.Baraja;
import entidad.Carta;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ServiciosBaraja {

    private Baraja baraja;
    private ArrayList<Carta> mazo;

    public ServiciosBaraja() {
        this.baraja = new Baraja();
        this.mazo = new ArrayList(baraja.getBaraja());
    }

    public void muestraBaraja() {

        for (Carta aux : mazo) {
            System.out.println(aux);
        }
    }

    public void barajar() {
        System.out.println("**** BARAJA MEZCLADA ****");
        Collections.shuffle(mazo);
    }

    public Carta siguienteCarta() {
        Carta aux = mazo.get(0);
        mazo.remove(0);
        return aux;
    }

    public void darCartas(int cantidad) {
        ArrayList<Carta> mano = new ArrayList();

        for (int i = 0; i < cantidad; i++) {
            mano.add(mazo.get(i));

            mazo.remove(i);
        }

        System.out.println("**** LA MANO DADA ES: ****");
        for (Carta carta : mano) {
            System.out.println(carta);
        }
        System.out.println("Quedan " + mazo.size() + " cartas");
    }

    public static Comparator<Carta> porPalo = new Comparator<Carta>() {
        @Override
        public int compare(Carta c1, Carta c2) {
            return c1.getPalo().compareTo(c2.getPalo());
        }
    };

    public static Comparator<Carta> porNumero = new Comparator<Carta>() {
        @Override
        public int compare(Carta c1, Carta c2) {
            return c1.getNumero().compareTo(c2.getNumero());
        }
    };

    public void ordenaBaraja() {
        System.out.println("**** BARAJA ORDENADA ****");
        Collections.sort(mazo, porNumero);
        Collections.sort(mazo, porPalo);

        for (Carta carta : mazo) {
            System.out.println(carta);
        }
    }

}
