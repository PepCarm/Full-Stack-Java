package main;

import servicio.ServiciosBaraja;

public class Main {

    public static void main(String[] args) {
      
            ServiciosBaraja sb = new ServiciosBaraja();
            
            sb.barajar();
            sb.darCartas(5);
            sb.muestraBaraja();
            sb.ordenaBaraja();
            sb.siguienteCarta();
                  
        
    }
    
}
