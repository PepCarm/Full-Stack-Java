package entidad;

public class Jugador {

    private Integer id;
    private String nombre;
    private boolean mojado;

    public Jugador() {
    }

    public Jugador(Integer id, String nombre, boolean mojado) {
        this.id = id;
        this.nombre = nombre;
        this.mojado = mojado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isMojado() {
        return mojado;
    }

    public void setMojado(boolean mojado) {
        this.mojado = mojado;
    }

    public String mostrarJugador() {
        return "Jugador{" + "id=" + id + ", nombre=" + nombre + ", mojado=" + mojado + '}';
    }

    public boolean disparo(Revolver r) {
        Boolean verificacion = r.mojar();
        if (verificacion) {
            mojado = true;
            verificacion = false;
            return mojado;
        } else {
            mojado = false;
            r.siguienteChorro();
            return mojado;
        }
    }

}
