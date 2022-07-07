package libreria.persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import libreria.entidades.Editorial;

public class EditorialDAO {
     
     //El parametro de este atributo, es COMO SE NOMBRA MI ARCHIVO PERSISTENCIA (persistence.xml, Persistencia Unit Name)
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaPU");
    private final EntityManager em = emf.createEntityManager();

    public void guardarEditorial(Editorial editorial) throws Exception { // Este metodo es para ingresar 
        em.getTransaction().begin();
        em.persist(editorial); // Para guardar - envio el objeto completo
        em.getTransaction().commit();       
    }
//
    public void modificarEditorial(Editorial editorial) throws Exception { // Este metodo es para ingresar o modificar
        em.getTransaction().begin();
        em.merge(editorial); // Para modificar un objeto - Sobreescribe los atributos
        em.getTransaction().commit();    
    }

    public void eliminarEditorial(String nombre) throws Exception {
        Editorial editorial = buscarEditorialPorNombre(nombre);
        em.getTransaction().begin(); //Inicio   
        em.remove(editorial);
        em.getTransaction().commit(); //Fin (Si algo fallo ... vuelve pa atras)    
    }

    public Editorial buscarEditorialPorNombre(String nombre) throws Exception {
       Editorial editorial = (Editorial) em.createQuery("SELECT e "
                + " FROM Editorial e"
                + " WHERE e.nombre LIKE :nombre").
                setParameter("nombre", nombre).
                getSingleResult(); 
        
        return editorial;
    }

    //CONSULTA SIN PARAMETROS
    public List<Editorial> listarEditorials() throws Exception {
        List<Editorial> editorials = em.createQuery("SELECT e FROM Editorial e")
                .getResultList();
        return editorials;
    }

    //CONSULTA CON PARAMETROS
    public List<Editorial> listarEditorialsNombre(String nombre) throws Exception {
        List<Editorial> editorialsFiltradas = em.createQuery("SELECT e "
                + " FROM Editorial e"
                + " WHERE e.nombre = :nombre").
                setParameter("nombre", nombre)
                .getResultList();
        return editorialsFiltradas;
    }
}
