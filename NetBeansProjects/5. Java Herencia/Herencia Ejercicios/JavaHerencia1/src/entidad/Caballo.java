package entidad;

public class Caballo extends Animal {

    private String sonido;

    public Caballo() {
    }

    public Caballo(String sonido, String nombre, String alimento, Integer edad, String raza) {
        super(nombre, alimento, edad, raza);
        this.sonido = sonido;
    }

    public String getSonido() {
        return sonido;
    }

    public void setSonido(String sonido) {
        this.sonido = sonido;
    }

    public String mostrarCaballo() {
        return "Caballo{" + "sonido=" + sonido + '}';
    }

    public void alimento() {
        super.alimento();
    }

}
