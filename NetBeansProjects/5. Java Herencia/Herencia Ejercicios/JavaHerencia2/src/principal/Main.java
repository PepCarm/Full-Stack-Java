package principal;

import entidad.Lavarropa;
import entidad.Televisor;

public class Main {

    public static void main(String[] args) {

        Lavarropa lava = new Lavarropa();
        lava.crearLavarropa();
        Televisor t = new Televisor();
        t.crearTelevisor();
        System.out.println(lava);
        System.out.println(t);

    }

}
