package entidad;

import enumeraciones.Raza;

public class Perro {
    
    private String nombre, tamanio;
    private Raza raza;
    private int edad;

    public Perro() {
    }

    public Perro(String nombre, String tamanio, Raza raza, int edad) {
        this.nombre = nombre;
        this.tamanio = tamanio;
        this.raza = raza;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public Raza getRaza() {
        return raza;
    }

    public void setRaza(Raza raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String mostrarPerro() {
        return "Perro{" + "nombre=" + nombre + ", tamanio=" + tamanio + ", raza=" + raza + ", edad=" + edad + '}';
    }

    
    
       
    
}
