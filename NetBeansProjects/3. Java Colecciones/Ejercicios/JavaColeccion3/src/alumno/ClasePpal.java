package alumno;

import alumno.entidad.Alumno;
import java.util.ArrayList;
import java.util.Scanner;

public class ClasePpal {

    public static void main(String[] args) {

        Scanner dato = new Scanner(System.in).useDelimiter("\n");
        ArrayList<Alumno> estudiante = new ArrayList(); // Creamos una lista de tipo Estudiante 
        Alumno s1 = new Alumno();

        char opcion;
        do {

            Alumno e1 = new Alumno(); // Creamos un objeto en cada vuelta para meterlo a nuestra lista

            System.out.println("Ingrese el nombre del estudiante");
            String nombre = dato.next();
            System.out.println("Ingrese las 3 notas");
            System.out.print("Ingrese la nota 1; ");
            int nota1 = dato.nextInt();

            System.out.print("Ingrese la nota 2; ");
            int nota2 = dato.nextInt();

            System.out.print("Ingrese la nota 3; ");
            int nota3 = dato.nextInt();

            e1.setNombreAlumno(nombre);
            e1.setNota1(nota1);
            e1.setNota2(nota2);
            e1.setNota3(nota3);

            estudiante.add(e1); // Agregamos el objeto llenado a la lista

            System.out.println("Desea agregar otro Alumno" + " 'S' para Continuar o 'N' para Salir");
            opcion = dato.next().toLowerCase().charAt(0);
        } while (opcion != 'n'); //Mientras sea distinto de "no" se repetira

        for (Alumno student : estudiante) { // Aca los mostramos en un for each

            System.out.println(student.mostrarDatos());
        }
        
        System.out.println("Ingrese el Nombre:");
        String nombreAlumno =dato.next();
        double promedio=0;
        for (Alumno aux : estudiante) {
            if(nombreAlumno.equalsIgnoreCase(aux.getNombreAlumno())){
                promedio = aux.notaFinal();
            }
        }
        System.out.println("Promedio:"+promedio);
    

    }
}
