package entidad;

import java.util.Scanner;

public class Electrodomestico {
    private double precio;
    private String color;
    private char conEnerg;
    private double peso;

    //Constructores
    public Electrodomestico() {
    }

    public Electrodomestico(String color, char conEnerg, double peso) {
        this.precio = 1000;
        this.color = compruebaColor(color);
        this.conEnerg = compruebaConsumo(conEnerg);
        this.peso = peso;
    }

    //Metodos
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public char getConEnerg() {
        return conEnerg;
    }

    public void setConEnerg(char conEnerg) {
        this.conEnerg = conEnerg;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void precioFinal() {
               
        switch (this.conEnerg) {
            case 'A':
                this.precio += 1000; //Esto es lo mismo que tener  this.precio= 1000 + this.precio;
                break;
            case 'B':
                this.precio += 800;
                break;
            case 'C':
                this.precio += 600;
                break;
            case 'D':
                this.precio += 500;
                break;
            case 'E':
               this.precio += 300;
                break;
            case 'F':
                this.precio += 100;
                break;
            default:
                this.precio = 1000;
        }

        if (this.peso > 80) {
            this.precio += 1000;
        } else if (this.peso >= 50) {
            this.precio += 800;
        } else if (this.peso >= 20) {
            this.precio += 500;
        } else {
            this.precio += 100;
        }
                
    }

    private char compruebaConsumo(char consumo) {
        switch (consumo) {
            case 'A':
                break;
            case 'B':
                break;
            case 'C':
                break;
            case 'D':
                break;
            case 'E':
                break;
            case 'F':
                break;
            default:
                consumo = 'A';
        }
        return consumo;
    }

    private String compruebaColor(String color) {
        switch (color) {
            case "BLANCO":
                color = "Blanco";
                break;
            case "NEGRO":
                color = "Negro";
                break;
            case "GRIS":
                color = "Gris";
                break;
            case "AZUL":
                color = "Azul";
                break;
            case "ROJO":
                color = "Rojo";
                break;
            default:
                color = "Blanco";
        }
        return color;
    }

    public void creaElectrodomestico() {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingrese el Color");
        String vColor = leer.next().toUpperCase();
        this.color = compruebaColor(vColor);
        System.out.println("Ingrese el Consumo (A,B,C,D o F)");
        char consumo = leer.next().toUpperCase().charAt(0);
        this.conEnerg = compruebaConsumo(consumo);
        System.out.println("Cuanto Pesa?");
        this.peso = leer.nextDouble();
        precioFinal();
   
    }

    @Override
    public String toString() {
        return "Precio: $" + precio + "000" + "\nColor: " + color + "\nConsumo Energetico: " + conEnerg + "\nPeso de embalaje: " + peso + " Kg.";
    }
}
