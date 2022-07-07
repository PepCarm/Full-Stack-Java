package cuenta;

import cuenta.entidades.CuentaBancaria;
import cuenta.servicios.ServiciosCuenta;
import java.util.Scanner;

public class ClasePpal {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        ServiciosCuenta sc = new ServiciosCuenta();
        CuentaBancaria account = new CuentaBancaria();

        CuentaBancaria c1 = sc.crearCuenta();// Aca llamo para crear la cuenta
            
        System.out.println("\n");
            
        byte opcion = 0;
        do {
            System.out.println("MENU");
            System.out.println("1-Ingresar dinero");
            System.out.println("2-Retirar dinero");
            System.out.println("3.Extraccion Rapida");
            System.out.println("4-Consultar Saldo");
            System.out.println("5-Consultar Mis Datos");
            System.out.println("6-Salir");

            opcion = leer.nextByte();
            
            
            switch (opcion) {
                case 1:
                    System.out.println(c1.getSaldo());
                    System.out.print("Ingrese monto a ingresar: $");
                    double ingreso = leer.nextDouble();//Creo una variable que tome el valor  por teclado
                    sc.ingresar(c1, ingreso);//y luego se la paso a la cuenta
                    System.out.println(c1.getSaldo());
                    break;
                case 2:
                    System.out.print("Ingrese monto a retirar: $");
                    double retiro =leer.nextDouble();
                    sc.retiro(c1, retiro);
                    System.out.println(account.getSaldo());
                    break;
                case 3:
                    System.out.print("Ingrese monto a retirar: $");
                    double monto = leer.nextDouble();
                    sc.extraccionRapida(c1, monto);
                    System.out.println(account.getSaldo());
                    break;
                case 4:
                    System.out.println("Su sado actual es de: $");
                    System.out.println(account.getSaldo());
                    break;
                case 5:
                    System.out.println(account.mostrarDatos());
                    break;
                default:
            }
            System.out.println("\n");
        } while (opcion < 6);
 /*   System.out.print("\033[H\033[2J");

System.out.flush();*/
    }  
}
