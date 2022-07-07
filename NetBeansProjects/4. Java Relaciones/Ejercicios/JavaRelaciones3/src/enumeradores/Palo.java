package enumeradores;

public enum Palo {

    ESPADA, BASTOS, ORO, COPAS;

    //asi hago un metodo para obtener un value Random
    public static Palo getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
