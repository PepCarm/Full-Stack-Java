package matematica.servicios;

import matematica.entidades.Matematica;

public class MatematicaServicios {
    
    public void devolverMayor(double num1, double num2){
        
        System.out.println("El numero mayor entre "+num1+" y "+num2+ " es "+Math.max(num2, num1)); 
    }
    /*
    Ojo con poner "public static " pq si no no puedo llamar al metodo desde
    otra clase, como la main x por ej.
    */

    public void calcularPotencia(double num1, double num2){
        
        int a = (int) Math.round(num1); //Parseo
        int b = (int) Math.round(num2);
        
        System.out.println(a);
        System.out.println(b);
        
        if (a>b) {
            int resultado = (int) Math.pow(num1, num2);
            System.out.println("El resultado de elevar "+num1+" al "+num2+" es = "+resultado);
        }else{
            int resultado = (int) Math.pow(num2, num1);
            System.out.println("El resultado de elevar "+num2+" al "+num1+" es = "+resultado);
        }
    
    }
    public void calculaRaiz(double num1, double num2){
        
       double a= Math.abs(num1);
       double b = Math.abs(num2);
        
        if (a<b) {
            double resultado = Math.sqrt(a);
            System.out.println("La raiz cuadrada de "+a+" es igual a "+resultado);
        }else{
            double resultado = Math.sqrt(b);
            System.out.println("La raiz cuadrada de "+b+" es igual a "+resultado);
        }
        
    }
}
