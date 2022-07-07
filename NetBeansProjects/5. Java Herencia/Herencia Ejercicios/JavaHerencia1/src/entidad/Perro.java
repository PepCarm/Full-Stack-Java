
package entidad;

public class Perro extends Animal{
    
/*Poniendo extends le estoy avisando a java que esta clase hereda de la clase animal*/

    private String sonido;

    public Perro() {
    }

/* Cuando hago el constructor selecciono el constructor parametrizado, y el constructor de la clase propiamente dicho*/ 
    public Perro(String sonido, String nombre, String alimento, int edad, String raza) {
        super(nombre, alimento, edad, raza);
        this.sonido = sonido;
    }

    public String getSonido() {
        return sonido;
    }

    public void setSonido(String sonido) {
        this.sonido = sonido;
    }
    
    public String mostrarPerro() {
        return "Perro{" + "sonido=" + sonido + '}';
    }

    public void alimento(){
        super.alimento();
    }
    
    
}
