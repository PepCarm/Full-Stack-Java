package cuenta.servicios;

import cuenta.entidades.CuentaBancaria;
import java.util.Scanner;

public class ServiciosCuenta {

    Scanner dato = new Scanner(System.in).useDelimiter("\n");

    //Esto se hace para cargar los datos
    public CuentaBancaria crearCuenta() {//public - Nombre de la Clase Entidad- Objeto a crear de la clase Servicios
        CuentaBancaria c = new CuentaBancaria();

        System.out.println("Ingrese el Nro de la Cuenta");
        int numeroCuenta = dato.nextInt();
        c.setnCuenta(numeroCuenta);// Lo que ingreso el usuario por teclado, lo guardamos en esta variable.

        System.out.println("Ingrese el DNI del titular de la Cuenta");
        long dni = dato.nextLong();
        c.setDni(dni);

        System.out.println("Ingrese el Saldo");
        c.setSaldo(dni);
        double saldo = dato.nextDouble();

        return c;

    }
    //Esa cuenta bancaria "d", es distinta de la cuenta c , se pudo así a proposito.Para inferir q c y d pueden no ser iguales.

    public void ingresar(CuentaBancaria d, double ingreso) {
        d.setSaldo(ingreso + d.getSaldo());
    }

    /* Seria que al ingreso actual, por eso uso get,le sumo el ingreso y como tengo que usarlo tengo que setearlo.
  Yo  antes usaba this, pq esta dentro de la misma clase*/

    public void retiro(CuentaBancaria d, double retiro) {
        
        if (d.getSaldo() > retiro) {

            d.setSaldo(d.getSaldo() - retiro);
        } else {
            d.setSaldo(0);
        }
    }

    public void extraccionRapida(CuentaBancaria d, double monto) {
        double saldo = d.getSaldo();
        double retiroMax = saldo * .20;
        if (monto > retiroMax) {
            System.out.println("Maximo permitido excedido");
            return;
        } else {
            d.setSaldo(saldo - monto);
            System.out.println("Monto a retirar $ " + monto);
        }
    }
    
}
