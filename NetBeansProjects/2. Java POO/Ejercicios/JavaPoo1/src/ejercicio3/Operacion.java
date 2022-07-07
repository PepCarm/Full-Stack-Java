package ejercicio3;

public class Operacion {

    private int numero1, numero2;

    public Operacion(int numero1, int numero2) {
        this.numero1 = numero1;
        this.numero2 = numero2;
    }

    public Operacion() {
    }

    public int getNumero1() {
        return numero1;
    }

    public void setNumero1(int numero1) {
        this.numero1 = numero1;
    }

    public int getNumero2() {
        return numero2;
    }

    public void setNumero2(int numero2) {
        this.numero2 = numero2;
    }

    public void crearOperacion(int numero1, int numero2) {
        this.numero1 = numero1;
        this.numero2 = numero2;
    }

    public int sumar() {
        int suma = this.numero1 + this.numero2;
        return suma;
    }

    public int resta() {
        int resta = numero1 - numero2;
        return resta;
    }

    public int multiplicar() {
        if (numero1 == 0 || numero2 == 0) {
            System.out.println("Ha ingresado un valor igual a 0");
        }
        int multiplicar = numero1 * numero2;
        return multiplicar;
    }

    public int division() {
        if (numero1 ==0 || numero2 ==0) {
            System.out.println("Ha ingresado un valor igual a 0");
            return 0;
        }
        int division = numero1/numero2;
        return division;
        }
}
