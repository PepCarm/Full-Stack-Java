package eggejemplo.LibreriaWeb.repositorios;

import eggejemplo.LibreriaWeb.entidades.Libro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepositorio extends JpaRepository<Libro, String> {

    //creo la query de busqueda de libro
    @Query("SELECT l FROM Libro l WHERE l.titulo LIKE :query")
    public Libro findByTitulo(@Param("query") String query);
    
  /* @Query("SELECT l FROM Libro l WHERE l.titulo LIKE :query or "
            + "l.anio LIKE :query or "
            + "l.autor.nombre LIKE :query or "
            + "l.editorial.nombre LIKE :query or "
            + "l.isbn = :queryIsbn")
    List<Libro> findByQuery(@Param("query") String query, @Param("queryIsbn") Long queryIsbn);

    /* Tengo que aplicar este metodo pq, arriba estoy buscando por Editorial y Autor que son las otras clases*/
    @Query("SELECT l from Libro l where l.autor.nombre LIKE :query")
    List<Libro> findAllByAutor(@Param("q") String query);

    @Query("SELECT l from Libro l where l.editorial.nombre LIKE :query")
    List<Libro> findAllByEditorial(@Param("q") String query);
    
}
