package principal;

import entidad.Electrodomestico;
import entidad.Lavarropa;
import entidad.Televisor;
import enumeradores.Color;
import enumeradores.Consumo;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        double acuTotal = 0, acuLava = 0, acuTv = 0;
        ArrayList<Electrodomestico> comercio = new ArrayList();

        Lavarropa l1 = new Lavarropa(15, 48000d, Color.BLANCO, 60d, Consumo.A);
        comercio.add(l1);
        Lavarropa l2 = new Lavarropa(55, 78000d, Color.BLANCO, 68d, Consumo.A);
        comercio.add(l2);
        Televisor t1 = new Televisor(32, true, 25000d, Color.NEGRO, 8d, Consumo.D);
        comercio.add(t1);
        Televisor t2 = new Televisor(55, true, 150000d, Color.NEGRO, 12d, Consumo.D);
        comercio.add(t2);

        for (Electrodomestico aux : comercio) {
            aux.precioFinal();
            System.out.println(aux);
            acuTotal += aux.getPrecio();
            if (aux instanceof Lavarropa) {
                acuLava += aux.getPrecio();
            } else if (aux instanceof Televisor) {
                acuTv += aux.getPrecio();
            }

        }

        System.out.println("El precio de todos los Lavarropas es: " + acuLava);
        System.out.println("El precio de todos los Televisores es: " + acuTv);
        System.out.println("El precio total de todos los electrodomesticos es: " + acuTotal);
    }

}


