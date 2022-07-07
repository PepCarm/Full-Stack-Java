package libreria;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import libreria.servicios.AutorServicio;
import libreria.servicios.EditorialServicio;

public class Principal {

    public static void main(String[] args) throws Exception {

        //SOLO PARA CREAR LAS TABLAS SIN NECESIDAD D CREAR UN OBJETO, despues se borran entity manager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaPU");
        EntityManager em = emf.createEntityManager();

        AutorServicio author = new AutorServicio();
//        author.crearAutor("Jorge Luis Borges");
//        author.crearAutor("Roberto Fontanarrosa");

//        author.eliminarAutor("Jorge Luis Borges");
//        author.eliminarAutor("Roberto Fontanarrosa");
//        author.modificarAutor("Jorge Luis Borges", "Pepito");
//        author.imprimirAutores();
        EditorialServicio publisher = new EditorialServicio();
//        publisher.crearEditorial("Planeta");
//        publisher.crearEditorial("Alfaguara");

//        publisher.imprimirEditoriales();
        publisher.eliminarEditorial("Planeta");
        publisher.eliminarEditorial("Alfaguara");

    }

}
