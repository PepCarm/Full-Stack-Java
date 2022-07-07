package cadena;

import cadena.entidades.Cadena;
import cadena.servicios.CadenaServicios;
import java.util.Scanner;

public class ClasePpal {
    
    public static void main(String[] args) {
        
        Scanner dato = new Scanner(System.in).useDelimiter("\n");
        CadenaServicios f = new CadenaServicios();
        Cadena p = new Cadena();
        
        System.out.println("Ingrese una frase cualquiera");
        p.setFrase(dato.next());

        f.mostrarVocales(p.getFrase());
        f.invertirFrse(p.getFrase());
          f.vecesRepetido(p.getFrase().toLowerCase());
        f.compararLongitud(p.getFrase());
        f.unirFrases(p.getFrase());
        f.reemplazar(p.getFrase());
        f.contiene(p.getFrase().toLowerCase());
    }
    
}
