package javacoleccion6;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JavaColeccion6 {

    public static void main(String[] args) {

        // TODO en el main es que no hay manera, sino serian mapas de objetos
        int op;

        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        HashMap<String, Double> Javimar = new HashMap();

        Javimar.put("Leche", 80.9);
        Javimar.put("Fideos", 45.90);
        Javimar.put("Aceite", 150.75);
        Javimar.put("Pure", 48.90);
        Javimar.put("Arroz", 75.9);
        Javimar.put("Mayonesa", 98.50);
        Javimar.put("Harina", 40.90);

        do {
            System.out.println("************** MENU *****************");
            System.out.println("** 1.- Mostrar todos los Productos **");
            System.out.println("** 2.- Introducir un Producto      **");
            System.out.println("** 3.- Modificar Precio            **");
            System.out.println("** 4.- Borrar un Producto          **");
            System.out.println("** 5.- Salir                       **");
            System.out.println("*************************************");
            op = leer.nextInt();

            switch (op) {
                case 1:
                    muestraProducto(Javimar);
                    break;
                case 2:
                    Javimar = agrega(Javimar);
                    break;
                case 3:
                    Javimar = modifica(Javimar);
                    break;
                case 4:
                    Javimar = borra(Javimar);
                    break;
            }
        } while (op != 5);

    }

    private static void muestraProducto(HashMap<String, Double> tienda) {
        for (Map.Entry<String, Double> auxiliar : tienda.entrySet()) {
            Object key = auxiliar.getKey();
            Object val = auxiliar.getValue();
            System.out.println(key + "   - $" + val);
        }

    }

    private static HashMap agrega(HashMap<String, Double> tienda) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingresa el nombre del Producto");
        String nom = leer.next();
        System.out.println("Ingrese el precio");
        Double pre = leer.nextDouble();

        tienda.put(nom, pre);

        System.out.println("***Lista Actualizada***");
        for (Map.Entry<String, Double> entry : tienda.entrySet()) {
            String key = entry.getKey();
            Double value = entry.getValue();
            System.out.println(key + "   - $" + value);

        }
        return tienda;

    }

    private static HashMap modifica(HashMap<String, Double> tienda) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingresa el nombre del producto a modificar");
        String buscado = leer.next();

        if (tienda.containsKey(buscado)) {
            System.out.println("Ingrese el nuevo precio");
            tienda.put(buscado, leer.nextDouble());
        } else {
            System.out.println("No se encontro el producto");
        }

        return tienda;
    }

    private static HashMap borra(HashMap<String, Double> tienda) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingresa el nombre del producto a borrar");
        String buscado = leer.next().toLowerCase();

        if (tienda.containsKey(buscado)) {
            tienda.remove(buscado);
        } else {
            System.out.println("No se encontro el producto");
        }
        System.out.println("***Lista Actualizada***");
        for (Map.Entry<String, Double> entry : tienda.entrySet()) {
            String key = entry.getKey();
            Double value = entry.getValue();
            System.out.println(key + "   - $" + value);

        }

        return tienda;
    }

}
