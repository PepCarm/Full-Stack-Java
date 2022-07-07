package alumno.entidad;

import java.util.ArrayList;
import java.util.Scanner;

public class Alumno {

    private String nombreAlumno;
    private Integer nota1, nota2, nota3;
    private ArrayList<Integer> notas;

    Scanner dato = new Scanner(System.in).useDelimiter("\n");

    public Alumno() {
    }

    public Alumno(String nombreAlumno, Integer nota1, Integer nota2, Integer nota3) {
        this.nombreAlumno = nombreAlumno;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public Integer getNota1() {
        return nota1;
    }

    public void setNota1(Integer nota1) {
        this.nota1 = nota1;
    }

    public Integer getNota2() {
        return nota2;
    }

    public void setNota2(Integer nota2) {
        this.nota2 = nota2;
    }

    public Integer getNota3() {
        return nota3;
    }

    public void setNota3(Integer nota3) {
        this.nota3 = nota3;
    }

    public Scanner getDato() {
        return dato;
    }

    public void setDato(Scanner dato) {
        this.dato = dato;
    }

    public String mostrarDatos() {
        return "Alumno{" + "nombreAlumno=" + nombreAlumno + ", nota1=" + nota1 + ", nota2=" + nota2 + ", nota3=" + nota3 + '}';
    }

    public Integer notaFinal() {

        Integer notaFinal;

        notaFinal = (nota1 + nota2 + nota3) / 3;

        return notaFinal;
    }

}
