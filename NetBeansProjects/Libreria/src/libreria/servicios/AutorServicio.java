package libreria.servicios;

import java.util.Collection;
import java.util.UUID;
import libreria.entidades.Autor;
import libreria.persistencia.AutorDAO;

public class AutorServicio {
    
    private final AutorDAO daoAutor;
    
    public AutorServicio() {
        this.daoAutor = new AutorDAO();//daoAutor = new AutorDAO();
    }
    
    public Autor crearAutor(String nombre) {
        
        Autor nuevoAutor = new Autor();
        
        try {
            //Validamos
            if (nombre == null || nombre.trim().isEmpty()) {//Trim sirve por si tiene espacio al principio y al final
                throw new Exception("Debe indicar el nombre del autor");
            }

            //Creamos el usuario
            nuevoAutor.setNombre(nombre);
            nuevoAutor.setId(UUID.randomUUID().hashCode());// hashcode reemplaza a toString, devuelve un entero +o-.
            nuevoAutor.setAlta(Boolean.TRUE);
            
            daoAutor.guardarAutor(nuevoAutor);//ACa lo guardo
            
            return nuevoAutor;
            
        } catch (Exception e) {
            System.out.println("No se creo el autor " + e.getMessage());
            return null;
        }
    }
    
    public void eliminarAutor(String nombre) {
        
        try {
            //Validamos 
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre");
            }
            daoAutor.eliminarAutor(nombre);
            System.out.println("AUTOR ELIMINADO CON EXITO");
        } catch (Exception e) {
            System.out.println("No se elimino el autor " + e.getMessage());
        }
    }
    
    public void modificarAutor(String nombre, String nuevoNombre) {
        
        Autor aux = null;
        
        try {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre");
            }
            if (nuevoNombre == null || nuevoNombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre nuevo");
            }
            aux = daoAutor.buscarAutorPorNombre(nombre);
            aux.setNombre(nuevoNombre);
            daoAutor.modificarAutor(aux);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
        public Collection<Autor> listaAutores() throws Exception {

        try {
            Collection<Autor> autores = daoAutor.listarAutors();
            return autores;
        } catch (Exception e) {
            throw e;
        }
    }
        public void imprimirAutores() throws Exception {
        try {
            //Listamos los usuarios
            Collection<Autor> autores = listaAutores();

            //Imprimimos los usuarios - Solo algunos atributos....
            if (autores.isEmpty()) {
                throw new Exception("No existen autores para imprimir");
            } else {
                for (Autor aux : autores) {
                    System.out.println("*****************************************");
                    System.out.println(" Id :" + aux.getId()+
                                   "\n Nombre :" + aux.getNombre());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
        }
}
