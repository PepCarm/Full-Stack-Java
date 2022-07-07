package entidad;

import java.util.Scanner;

public class Lavarropa extends Electrodomestico {

      private int carga;

    public Lavarropa() {
        super();
    }

    public Lavarropa(int carga, String color, char conEnerg, double peso) {
        super(color, conEnerg, peso);
        this.carga = carga;
    }

    public Lavarropa(int carga) {
        super.creaElectrodomestico();
        this.carga = carga;
    }
    
    public int getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }
   
    public void crearLavarropa() {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("LAVARROPA: Cuantos Kilos de ropa carga?");
        this.carga = leer.nextInt();
        super.creaElectrodomestico();
        precioFinal();
    }   
    
    @Override
    public void precioFinal(){
        super.precioFinal();
        double vPrecio = super.getPrecio();
        if(this.carga>30){
            System.out.println("Precio segun carga");
            super.setPrecio(vPrecio+500);
        }
    }
    
    @Override
    public String toString() {
        return "Lavarropa de " + carga + " kilos de carga\n"
                + super.toString();
    }
    
}
