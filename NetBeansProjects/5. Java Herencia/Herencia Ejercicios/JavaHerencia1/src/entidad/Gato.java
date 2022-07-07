package entidad;

public class Gato extends Animal {

private String sonido;

    public Gato() {
    }

    public Gato(String sonido, String nombre, String alimento, Integer edad, String raza) {
        super(nombre, alimento, edad, raza);
        this.sonido = sonido;
    }

    public String getSonido() {
        return sonido;
    }

    public void setSonido(String sonido) {
        this.sonido = sonido;
    }

    public String mostrarGato() {
        return "Gato{" + "sonido=" + sonido + '}';
    }
    
    public void alimento(){
        super.alimento();
    }


   
}
