package persona.servicios;

import java.util.Scanner;
import persona.entidades.Persona;

public class PersonaServicios {

    Scanner dato = new Scanner(System.in).useDelimiter("\n");

    private final int IMC_BAJO = -1;
    private final int IMC = 0;
    private final int IMC_ALTO = 1;

    /*ES FINAL PQ SU VALOR SE MANTIENE INVARIABLE, y se escribe en MAYUSCULA, y se separa con guión bajo
    y se le asigna siempre un valor. */
    public Persona crearPersona() { // Este es el metodo "Crear Persona"
        System.out.println("Ingrese el nombre");
        String nombre = dato.next();
        System.out.println("Ingrese la edad");
        int edad = dato.nextInt();
        System.out.println("Ingrese el sexo - 'H' hombre, 'M' mujer, 'O' otro");
        char sexo = Character.toUpperCase(dato.next().charAt(0));

        while (sexo != 'M' && sexo != 'H' && sexo != 'O') {
            System.out.println("ERROR Ingresó una letra incorrecta");
            sexo = Character.toUpperCase(dato.next().charAt(0));
        }

        System.out.println("Ingrese el peso en kg");
        double peso = dato.nextDouble();

        while (peso <= 0) {
            System.out.println("Ingrese el peso en kg");
            peso = dato.nextDouble();
        }

        System.out.println("Ingrese la altura en metros");
        double altura = dato.nextDouble();

        while (altura <= 0) {
            System.out.println("Ingrese la altura en metros");
            altura = dato.nextDouble();
        }

        return new Persona(nombre, sexo, edad, peso, altura); // Aca se agrega el constructor con los parametros (Crl+ space)
    }

    /*En vez de crear arriba un a persona e ir seteandole los atributos lo que hemos echo es guardarlo en variable y pasarselo a mi objeto constructor
     */
    public int calcularIMC(Persona p) {
        double altura = p.getAltura();
        double peso = p.getPeso();

        double resultado = peso / (Math.pow(altura, 2));

        if (resultado < 20) {
            return IMC_BAJO;
        } else if (20 < resultado && resultado < 25) {
            return IMC;
        } else if (resultado > 25) {
            return IMC_ALTO;
        }
        return 0;
    }

    public boolean esMayorDeEdad(Persona p) {

        int edad = p.getEdad();
        boolean mayor = true;
        if (edad >= 18) {
            return mayor;
        } else {
            return false;
        }

        /*Tener en cuenta que hace y sobre que se calcula para hacer los ej y si devuelve o no un valor.
   Lo que se recibe por parametro en los parentesis(Persona), solo es para ese metodo, por eso usamos los get para traer el valor que se
     ingreso arriba*/
    }

    public Persona[] crearPersonas(int cant) {
        Persona[] personas = new Persona[cant];

        for (int i = 0; i < personas.length; i++) {
            personas[i] = crearPersona(); //Y que pida los datos de a 1 por vez.
        }
        return personas;
    }

    //Estructura para guardar los metodos y sacar un porcentaje
    public void porcentajes(Persona[] personas) {
        int contAlto = 0;
        int contBajo = 0;
        int contNulo = 0;
        int cantidadPersonas = personas.length;

        for (Persona persona : personas) {
            switch (calcularIMC(persona)) {
                case 1:
                    System.out.println(persona.getNombre() + " esta persona esta por encima de su peso ");
                    contAlto++;
                    break;
                case 0:
                    System.out.println(persona.getNombre() + " esta persona se encuntra en su peso ideal");
                    contNulo++;
                    break;
                case -1:
                    System.out.println(persona.getNombre() + " esta persona se encuentra por debajo de su peso normal");
                    break;
                default:

            }
            double resultado1 = (contAlto * 100) / cantidadPersonas;
            double resultado2 = (contBajo * 100) / cantidadPersonas;
            double resultado3 = (contNulo * 100) / cantidadPersonas;

            System.out.println("Hay " + resultado1 + " % por encima de su peso");
            System.out.println("Hay " + resultado2 + " % por debajo de su peso");
            System.out.println("Hay " + resultado3 + " % que se encuentra ensu peso ideal");
        }
    }

    public void porcentajeEdad(Persona[] personas) {
        int cantidadPersonas = personas.length;
        int contMayor =0;
        
        for (Persona persona : personas) {
            if (esMayorDeEdad(persona)) {
                contMayor++;
                System.out.println(persona.getNombre()+" es mayor de edad");
                
            }
            double result = (contMayor*100)/cantidadPersonas;
            System.out.println("Hay "+ result+ "% de personas que son mayores de edad");
        }
    }
}
