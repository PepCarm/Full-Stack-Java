package entidadades;

import interfaces.Area;

public class Rectangulo implements Area {
      
    private int base, altura;

    public Rectangulo() {
    }

    public Rectangulo(int base, int altura) {
        this.base = base;
        this.altura = altura;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    @Override
    public void calculaArea() {
        System.out.println("\nEl Area del Rectangulo es "+ this.base*this.altura);
    }

    @Override
    public void calculaPerimetro() {
        System.out.println("El Perimetro del Rectangulo es "+ this.base+this.altura*2);
    }  

    
}
