package ejercicio2;

public class Circunferencia {

    private  double radio;
    private double area, perimetro;
  
    public Circunferencia(double radio) {
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public void crearCircunferencia(double radio) {
        this.radio = radio;
    }

    public double area(){
        area = (Math.PI *radio*radio);
        return area;
    }
    public double perimetro(){
        perimetro = (2*Math.PI*radio);
        return perimetro;
    }
}
