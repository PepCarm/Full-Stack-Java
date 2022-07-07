package matematica;

import matematica.entidades.Matematica;
import matematica.servicios.MatematicaServicios;

public class ClasePpal {

    public static void main(String[] args) {

        Matematica num1 = new Matematica();
        Matematica num2 = new Matematica();
        MatematicaServicios ps = new MatematicaServicios();

        num1.setNum1((Math.random() * (100 - 1) + 1));
        num2.setNum2((Math.random() * (100 - 1) + 1));

        ps.devolverMayor(num1.getNum1(), num2.getNum1());
        ps.calcularPotencia(num1.getNum1(), num2.getNum2());
        ps.calculaRaiz(num1.getNum1(), num2.getNum2());
    }
}
