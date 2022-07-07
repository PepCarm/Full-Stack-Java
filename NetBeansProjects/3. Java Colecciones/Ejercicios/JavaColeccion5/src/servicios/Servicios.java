package servicios;

import entidad.Pais;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Servicios {

    Scanner dato = new Scanner(System.in).useDelimiter("\n");

    HashSet<Pais> country = new HashSet();

    private Pais crearPais() {
        System.out.println("Ingrese un pais");
        String pais = dato.next();

        return new Pais(pais);
    }

    public void agregarPais() {

        char respuesta;
        do {
            /*Otra forma de agregar objetos a la lista cdo tenemos muchos atributos*/
            country.add(crearPais());
            System.out.println("Quiere ingresar otro pais ?");
            respuesta = dato.next().toUpperCase().charAt(0);
        } while (respuesta != 'N');

        for (Pais mundo : country) {
            System.out.println(mundo.mostrarPaises());
        }
    }

    public void eliminarPais() {
        System.out.println("\nIngrese el nombre del pais a eliminar:");
        String eliminar = dato.next().toLowerCase();

        boolean d = true;
        /* con aux o it.next() obtengo el Objeto de la clase Pais de las iteraciones  
entonces con un condicional puedo preguntar si el el nombre del objeto
es igual al nombre buscado del pais,si el condicional es verdadero con it.remove(); elimino el objeto
         */
        Iterator<Pais> it = country.iterator();

        while (it.hasNext()) {
            Pais aux = it.next();
            if (aux.getPais().equals(eliminar)) {
                it.remove();
                d = true;
                break;
            } else {
                d = false;
            }
        }
        if (d) {
            System.out.println("Encontre el Pais " + eliminar + " y lo elimine del Conjunto");
        } else {
            System.out.println("No existe en este mundo el pais " + eliminar);
        }

        System.out.println("\nLista Actualizada");
        for (Pais pais : country) {
            System.out.println(pais.mostrarPaises());
        }
    }
}
