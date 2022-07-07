package entidad;

import java.util.Scanner;

public class Televisor extends Electrodomestico {

    private int resolucionPulg;
    private boolean sintTDT;

    public Televisor() {
    super();
    }
    

    public Televisor(int resolucionPulg, boolean sintTDT, String color, char conEnerg, double peso) {
        super(color, conEnerg, peso);
        this.resolucionPulg = resolucionPulg;
        this.sintTDT = sintTDT;
    }

    public Televisor(int resolucionPulg, boolean sintTDT) {
        super.creaElectrodomestico();
        this.resolucionPulg = resolucionPulg;
        this.sintTDT = sintTDT;
    }

    
    public int getResolucionPulg() {
        return resolucionPulg;
    }

    public void setResolucionPulg(int resolucionPulg) {
        this.resolucionPulg = resolucionPulg;
    }

    public boolean isSintTDT() {
        return sintTDT;
    }

    public void setSintTDT(boolean sintTDT) {
        this.sintTDT = sintTDT;
    }

    public void crearTelevisor() {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("TELEVISOR: Cuantas Pulgadas?");
        this.resolucionPulg = leer.nextInt();
        System.out.println("Tiene Sintonizador TDT incorporado? S/N");
        char sele = leer.next().toLowerCase().charAt(0);

        switch (sele)
        {
            case 'S':
                this.sintTDT = true;
                break;
            case 'N':
                this.sintTDT = false;
            default:
                System.out.println("Opcion no valida, por defecto se crea sin sintonizador");
                this.sintTDT = false;
        }
        super.creaElectrodomestico();
        precioFinal();
    }

    @Override
    public void precioFinal() {
        double vPrecio = super.getPrecio();

        if (this.resolucionPulg > 40)
        {
            System.out.println("Precio segun pulgadas");
            super.setPrecio(vPrecio + vPrecio * 0.30);
        }

        if (this.sintTDT)
        {
            System.out.println("Precio segun sintonizador");
            super.setPrecio(super.getPrecio() + 500);
        }

    }

    public String toString() {
        String sintoniza = "NO posee";
        if (this.sintTDT)
        {
            sintoniza = "SI posee";
        }
        return "Televisor de " + resolucionPulg + " pulgadas, TDT: " + sintoniza + "\n"
                + super.toString();
    }
}
