package libreria.persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import libreria.entidades.Libro;
import static libreria.entidades.Libro_.titulo;

public class LibroDAO {

    //El parametro de este atributo, es COMO SE NOMBRA MI ARCHIVO PERSISTENCIA (persistence.xml, Persistencia Unit Name)
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaPU");
    private final EntityManager em = emf.createEntityManager();

    public void guardarLibro(Libro libro) throws Exception { // Este metodo es para ingresar 
        em.getTransaction().begin();
        em.persist(libro); // Para guardar - envio el objeto completo
        em.getTransaction().commit();
    }
//

    public void modificarLibro(Libro libro) throws Exception { // Este metodo es para ingresar o modificar
        em.getTransaction().begin();
        em.merge(libro); // Para modificar un objeto - Sobreescribe los atributos
        em.getTransaction().commit();
    }

    public void eliminarLibro(String titulo) throws Exception {
        Libro libro = buscarLibroPorTitulo(titulo);
        em.getTransaction().begin(); //Inicio   
        em.remove(libro);
        em.getTransaction().commit(); //Fin (Si algo fallo ... vuelve pa atras)    
    }

    public Libro buscarLibroPorTitulo(String tiutlo) throws Exception {
        try {
            Libro libro = (Libro) em.createQuery("SELECT l "
                    + " FROM Libro l"
                    + " WHERE l.titulo LIKE : titulo")
                    .setParameter("titulo", titulo)
                    .getSingleResult();
            return libro;
        } catch (Exception e) {
            System.out.println("ERROR al buscar por titulo");
            return null;
        }

    }

    public Libro buscaPorISBN(Long isbn) throws Exception {
        try {
            Libro libro = (Libro) em.createQuery("SELECT l "
                    + " FROM Libro l"
                    + " WHERE l.isbn = :isbn").
                    setParameter("isbn", isbn).
                    getSingleResult();
            return libro;

        } catch (Exception e) {
            System.out.println("ERROR al buscar por ISBN");
            return null;
        }
    }

    public List<Libro> buscaPorAutor(String nombAut) throws Exception {
        try {
            List<Libro> libros = em.createQuery("SELECT l "
                    + " FROM Libro l"
                    + " WHERE l.autor.nombre LIKE CONCAT('%', :nombre, '%')", Libro.class)
                    .setParameter("nombre", nombAut)
                    .getResultList();
            return libros;
        } catch (Exception e) {
            System.out.println("ERROR al buscar por Autor");
            return null;
        }
    }
    
    public List<Libro> buscaPorEditorial(String nombEdit) throws Exception {
        try
        {
            List<Libro> libros = em.createQuery("SELECT l "
                    + " FROM Libro l"
                    + " WHERE l.editorial.nombre LIKE CONCAT('%', :nombre, '%')", Libro.class)
                    .setParameter("nombre", nombEdit)
                    .getResultList();
            return libros;
        } catch (Exception e)
        {
            System.out.println("ERROR al buscar por Autor");
            return null;
        }
    }

    //CONSULTA SIN PARAMETROS
    public List<Libro> listarLibros() throws Exception {
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l")
                .getResultList();
        return libros;
    }

    //CONSULTA CON PARAMETROS
    public List<Libro> listarLibrosNombre(String nombre) throws Exception {
        List<Libro> librosFiltradas = em.createQuery("SELECT l "
                + " FROM Libro l"
                + " WHERE l.titulo = :titulo").
                setParameter("titulo", titulo)
                .getResultList();
        return librosFiltradas;
    }

}
