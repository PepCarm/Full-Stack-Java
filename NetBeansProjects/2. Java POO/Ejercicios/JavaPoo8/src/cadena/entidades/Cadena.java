package cadena.entidades;

public class Cadena {
    
    private String frase;
    private int longuitud;

    public Cadena() {
    }

    public Cadena(String frase, int longuitud) {
        this.frase = frase;
        this.longuitud = longuitud;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }

    public int getLonguitud() {
        return longuitud;
    }

    public void setLonguitud(int longuitud) {
        this.longuitud = longuitud;
    }
    
    
    
}
