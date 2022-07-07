package entidad;

import enumeradores.Color;
import enumeradores.Consumo;
import java.util.Scanner;

public class Televisor extends Electrodomestico {   
    
    private int resolucion;
    private boolean tdt;

    public Televisor() {
    }

    public Televisor(int resolucion, boolean tdt, double precio, Color color, double peso, Consumo conEnerg) {
        super(precio, color, peso, conEnerg);//llama al constructor de la clase padre
        this.resolucion = resolucion;
        this.tdt = tdt;
    }

    public int getResolucion() {
        return resolucion;
    }

    public void setResolucion(int resolucion) {
        this.resolucion = resolucion;
    }

    public boolean isTdt() {
        return tdt;
    }

    public void setTdt(boolean tdt) {
        this.tdt = tdt;
    }

    /**
     * Método crearTelevisor(): este método llama a crearElectrodomestico() de
     * la clase padre, lo utilizamos para llenar los atributos heredados del
     * padre y después llenamos los atributos del televisor.
     */
    public void crearTelevisor() {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        char op;
        System.out.println("***TELEVISOR**");
        super.crearElectrodomestico();
        System.out.println("De cuantas pulgadas es?");
        this.resolucion = leer.nextInt();
        System.out.println("Tienen Sintonizador TDT? S/N");
        op = leer.next().toUpperCase().charAt(0);
        
        //switch(op)
        
        do {
            if (op == 'S') {
                this.tdt = true;
            } else if (op == 'N') {
                this.tdt = false;
            } else {
                System.out.println("S ó N no es tan dificil");
                op = leer.next().toUpperCase().charAt(0);
            }

        } while (op != 'S' && op != 'N');
    }
    /**
     * Método precioFinal(): este método será heredado y se le sumará la 
     * siguiente funcionalidad. Si el televisor tiene una resolución mayor 
     * de 40 pulgadas, se incrementará el precio un 30% y si tiene un 
     * sintonizador TDT incorporado, aumentará $500. Recuerda que las 
     * condiciones que hemos visto en la clase Electrodomestico también 
     * deben afectar al precio.
     */

    public void precioFinal(){
        super.precioFinal();
        if(this.resolucion>40){
            System.out.println("Precio aumentado por Resolucion");
            super.setPrecio(super.getPrecio()*1.30);
        }
        
        if(this.tdt){
            //System.out.println("Precio aumentado por TDT");
            super.setPrecio(super.getPrecio()+500);
        }
    }

    public String toString() {
        String sintoniza = "NO posee";
        if (this.tdt){
                    sintoniza = "SI posee";
        }

        return "Televisor de " + resolucion + " pulgadas, TDT: " + sintoniza + "\n";
                //+ super.toString();
    }
}
