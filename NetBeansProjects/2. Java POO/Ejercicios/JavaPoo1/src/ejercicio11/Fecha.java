package ejercicio11;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Fecha {

    public static void main(String[] args) {

        Scanner dato = new Scanner(System.in).useDelimiter("\n");

        System.out.println("dia");
        int dia = dato.nextInt();
        System.out.println("mes");
        int mes = dato.nextInt();
        System.out.println("anio");
        int anio = dato.nextInt();

        LocalDate fecha = LocalDate.of(anio, mes, dia);
        System.out.println(fecha.toString());


        LocalDate fechaHoy = LocalDate.now();
        Period lapso = Period.between(fecha, fechaHoy);
        System.out.println("El tiempo transcurrido entre una fecha ingresada y la fecha actual es de "+lapso.getYears()+" años "+lapso.getMonths()+" meses y "+lapso.getDays()+ " dias.");
        

    }
}
