package libreria.servicios;

import java.util.Collection;
import java.util.UUID;
import libreria.entidades.Editorial;
import libreria.persistencia.EditorialDAO;

public class EditorialServicio {

    private final EditorialDAO daoEditorial;

    public EditorialServicio() {
        this.daoEditorial = new EditorialDAO();//daoEditorial = new EditorialDAO();
    }

    public Editorial crearEditorial(String nombre) {

        Editorial nuevoEditorial = new Editorial();

        try {
            //Validamos
            if (nombre == null || nombre.trim().isEmpty()) {//Trim sirve por si tiene espacio al principio y al final
                throw new Exception("Debe indicar el nombre del autor");
            }

            //Creamos el usuario
            nuevoEditorial.setNombre(nombre);
            // nuevoEditorial.setId(Math.abs(UUID.randomUUID().hashCode())); Me deberia devolver un valor positivo
            nuevoEditorial.setId(UUID.randomUUID().hashCode());// hashcode reemplaza a toString, devuelve un entero +o-.
            nuevoEditorial.setAlta(Boolean.TRUE);

            daoEditorial.guardarEditorial(nuevoEditorial);//ACa lo guardo

            return nuevoEditorial;

        } catch (Exception e) {
            System.out.println("No se creo la editorial " + e.getMessage());
            return null;
        }
    }

    public void eliminarEditorial(String nombre) {

        try {
            //Validamos 
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre");
            }
            daoEditorial.eliminarEditorial(nombre);
            System.out.println("EDITORIAL ELIMINADA CON EXITO");
        } catch (Exception e) {
            System.out.println("No se elimino la editorial " + e.getMessage());
        }
    }

    public void modificarEditorial(String nombre, String nuevoNombre) {

        Editorial aux = null;

        try {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre");
            }
            if (nuevoNombre == null || nuevoNombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre nuevo");
            }
            aux = daoEditorial.buscarEditorialPorNombre(nombre);
            aux.setNombre(nuevoNombre);
            daoEditorial.modificarEditorial(aux);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Collection<Editorial> listaEditoriales() throws Exception {

        try {
            Collection<Editorial> editoriales = daoEditorial.listarEditorials();
            return editoriales;
        } catch (Exception e) {
            throw e;
        }
    }

    public void imprimirEditoriales() throws Exception {
        try {
            //Listamos los usuarios
            Collection<Editorial> editoriales = listaEditoriales();

            //Imprimimos los usuarios - Solo algunos atributos....
            if (editoriales.isEmpty()) {
                throw new Exception("No existen editoriales para imprimir");
            } else {
                for (Editorial aux : editoriales) {
                    System.out.println("*****************************************");
                    System.out.println(" Id :" + aux.getId()
                            + "\n Nombre :" + aux.getNombre());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
    }

}
