package cafetera.entidades;

public class Cafetera {

    private int capMax;
    private int cantidadActual;
    private int taza;

    public Cafetera() {
    }

    public Cafetera(int capMax, int cantidadActual, int taza) {
        this.capMax = capMax;
        this.cantidadActual = cantidadActual;
        this.taza = taza;
    }

    public int getCapMax() {
        return capMax;
    }

    public void setCapMax(int capMax) {
        this.capMax = capMax;
    }

    public double getCantidadActual() {
        return cantidadActual;
    }

    public void setCantidadActual(int cantidadActual) {
        this.cantidadActual = cantidadActual;
    }

    public void llenarCafetera(int cantidadActual) {
        this.cantidadActual = capMax;
    }

    public double getTaza() {
        return taza;
    }

    public void setTaza(int taza) {
        this.taza = taza;
    }

}
