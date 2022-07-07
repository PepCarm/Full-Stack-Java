package libreria.persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import libreria.entidades.Autor;

public class AutorDAO {
    
        //El parametro de este atributo, es COMO SE NOMBRA MI ARCHIVO PERSISTENCIA (persistence.xml, Persistencia Unit Name)
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaPU");
    private final EntityManager em = emf.createEntityManager();

    public void guardarAutor(Autor autor) throws Exception { // Este metodo es para ingresar 
        em.getTransaction().begin();
        em.persist(autor); // Para guardar - envio el objeto completo
        em.getTransaction().commit();       
    }
//
    public void modificarAutor(Autor autor) throws Exception { // Este metodo es para ingresar o modificar
        em.getTransaction().begin();
        em.merge(autor); // Para modificar un objeto - Sobreescribe los atributos
        em.getTransaction().commit();    
    }

    public void eliminarAutor(String nombre) throws Exception {
        Autor autor = buscarAutorPorNombre(nombre);
        em.getTransaction().begin(); //Inicio   
        em.remove(autor);
        em.getTransaction().commit(); //Fin (Si algo fallo ... vuelve pa atras)    
    }

    public Autor buscarAutorPorNombre(String nombre) throws Exception {
        Autor autor = (Autor) em.createQuery("SELECT a "
                + " FROM Autor a"
                + " WHERE a.nombre LIKE :nombre").
                setParameter("nombre", nombre).
                getSingleResult(); 
        return autor;
    }

    //CONSULTA SIN PARAMETROS
    public List<Autor> listarAutors() throws Exception {
        List<Autor> autors = em.createQuery("SELECT a FROM Autor a")
                .getResultList();
        return autors;
    }

    //CONSULTA CON PARAMETROS
    public List<Autor> listarAutorsNombre(String nombre) throws Exception {
        List<Autor> autorsFiltradas = em.createQuery("SELECT a "
                + " FROM Autor a"
                + " WHERE a.nombre = :nombre").
                setParameter("nombre", nombre)
                .getResultList();
        return autorsFiltradas;
    }
}
