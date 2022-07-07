package entidad;

import java.util.Objects;

public class Pais implements Comparable<Pais> {
    
    private String pais;

    public Pais() {
    }

    public Pais(String pais) {
        this.pais = pais;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String mostrarPaises() {
        return "Pais{" + "pais=" + pais + '}';
    }

    public int asignarValores() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.pais);
        return hash;
    }

    public boolean compararPaises(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pais other = (Pais) obj;
        if (!Objects.equals(this.pais, other.pais)) {
            return false;
        }
        return true;
    }

    public int compareTo(Pais t) {
       return this.pais.compareTo(t.getPais());
    }
    
    
}
