package entidad;

import java.util.ArrayList;

public class Juego {

    private ArrayList<Jugador> jugadores;
    private Revolver revolver;

    public Juego() {
    }

    public Juego(ArrayList<Jugador> jugadores, Revolver revolver) {
        this.jugadores = jugadores;
        this.revolver = revolver;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public Revolver getRevolver() {
        return revolver;
    }

    public void setRevolver(Revolver revolver) {
        this.revolver = revolver;
    }

    public String mostrarJuego() {
        return "Juego{" + "jugadores=" + jugadores + ", revolver=" + revolver + '}';
    }

    public void llenarJuego(ArrayList<Jugador> jg, Revolver r) {
        jugadores = jg;
        revolver = r;
    }

    public void ronda(Revolver r) {
        int cont = 0;
        for (Jugador aux : jugadores) {
            System.out.print("[Posicion_actual: " + r.getPosicionActual() + "]");
            System.out.print("El " + aux.getNombre() + " " + aux.getId() + " se apunta y dispara");
            if (aux.disparo(revolver) == true) {
                System.out.print(" ...Mojado\n");
                break;
            } else {
                System.out.print(" ...se Salvo\n");
                cont++;
            }
        }
        if (cont == jugadores.size()) {
            ronda(r);
        }
    }

}
