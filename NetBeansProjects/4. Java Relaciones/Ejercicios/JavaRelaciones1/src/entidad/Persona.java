package entidad;

public class Persona {
    
    private String nombre, apellido, dni;
    private int edad;
    private Perro pet;
    
    
///* Se puede poner como atributo, una clase, como en este caso Perro*/     
//    
///*Atributos que originan relaciones, este metodo sirve para vincular una persona a 1, a varias o ninguna mascota,
//    esto es mejor que poner private Perro pet; que vincula a una persona con "UNA" mascota*/
//    private ArrayList<Perro> pet =new ArrayList();// Varios OBJETOS relacionados


    public Persona() {
    }

    public Persona(String nombre, String apellido, String dni, int edad, Perro pet) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
        this.pet = pet;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Perro getPet() {
        return pet;
    }

    public void setPet(Perro pet) {
        this.pet = pet;
    }

    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", edad=" + edad + ", pet=" + pet + '}';
    }
    
    
}
