package entidad;

public class Revolver {

    private Integer posicionActual;
    private Integer posicionAgua;

    public Revolver() {
    }

    public Revolver(Integer posicionActual, Integer posicionAgua) {
        this.posicionActual = posicionActual;
        this.posicionAgua = posicionAgua;
    }

    public Integer getPosicionActual() {
        return posicionActual;
    }

    public void setPosicionActual(Integer posicionActual) {
        this.posicionActual = posicionActual;
    }

    public Integer getPosicionAgua() {
        return posicionAgua;
    }

    public void setPosicionAgua(Integer posicionAgua) {
        this.posicionAgua = posicionAgua;
    }

    public String mostarRevolver() {
        return "Revolver{" + "posicionActual=" + posicionActual + ", posicionAgua=" + posicionAgua + '}';
    }

    public Revolver llenarRevolver() {
        posicionActual = (int) (Math.random() * 6 + 1);
        posicionAgua = (int) (Math.random() * 6 + 1);
        return new Revolver(posicionActual, posicionAgua);
    }

    public boolean mojar() {
        if (posicionActual == posicionAgua) {
            return true;
        }
        return false;
    }

    public void siguienteChorro() {
        if (this.posicionActual == 6) {
            this.posicionActual = 1;
        } else {
            this.posicionActual = posicionActual + 1;
        }
    }

}
