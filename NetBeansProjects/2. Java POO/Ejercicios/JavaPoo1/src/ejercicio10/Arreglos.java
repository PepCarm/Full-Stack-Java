package ejercicio10;

import java.util.Arrays;

public class Arreglos {

    public static void main(String[] args) {

        double[] A = new double[50];
        double[] B = new double[20];

        System.out.println("Array A");
        for (int i = 0; i < A.length; i++) {
            A[i] = (double) (Math.random() * 100);
            System.out.println(A[i]);
        }
        System.out.println("\n");
        System.out.println("ArrayA Ordenado");
        Arrays.sort(A, 0, 50);
        System.out.println(Arrays.toString(A));

        System.out.println("\n");
        System.out.println("Array B");

        B = Arrays.copyOf(A, 20);
        Arrays.fill(B, 10, 20, 0.5);
        System.out.println(Arrays.toString(B));

    }

}
