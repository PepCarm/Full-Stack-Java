package entidadades;

import interfaces.Area;

public class Circulo implements Area {
    
     private double radio;

    public Circulo() {
    }

    public Circulo(double radio) {
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

   //Estos se generan de manera automatica y los puedo modificar a mi antojo
    public void calculaArea() {
        System.out.printf("\nEl Area del Circulo es %.2f", Area.pi * (this.radio * this.radio));
    }

    public void calculaPerimetro() {
        System.out.printf("\nEl Perimetro del Circulo es %.2f", Area.pi * (2 * this.radio));
    }
    
}
