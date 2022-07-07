package principal;

import entidadades.Circulo;
import entidadades.Rectangulo;

public class Main {

    public static void main(String[] args) {

        Circulo c1 = new Circulo(7d);
        c1.calculaArea();
        c1.calculaPerimetro();

        Rectangulo r1 = new Rectangulo(8, 4);
        r1.calculaArea();
        r1.calculaPerimetro();

    }

}
