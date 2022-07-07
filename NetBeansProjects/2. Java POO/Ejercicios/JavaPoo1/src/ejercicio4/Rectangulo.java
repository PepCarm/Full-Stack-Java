package ejercicio4;

public class Rectangulo {
    
    private int base;
    private int altura;

    public Rectangulo(int base, int altura) {
        this.base = base;
        this.altura = altura;
    }

    public Rectangulo() {
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
    
    public int perimetro(){
        return altura*2 + base*2;
    }
    
    public int area(){
        return (base*altura);
    }
    public void dibujarRectangulo(){
        for (int i = 0; i < altura; i++) { // Filas
            for (int j = 0; j < base; j++) {//Columnas
                if (i>0 && i< altura-1 && j>0 && j<base-1) {
                    System.out.print(" ");
                }else{
                    System.out.print("*");
                }
            }
            System.out.println(" ");
        }
    }
}
