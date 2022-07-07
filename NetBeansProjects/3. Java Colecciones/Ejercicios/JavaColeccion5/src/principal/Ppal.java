package principal;

import servicios.Servicios;

public class Ppal {

    public static void main(String[] args) {
     
        
        Servicios nazione = new Servicios();
        
        nazione.agregarPais();
        nazione.eliminarPais();
    }
    
}
