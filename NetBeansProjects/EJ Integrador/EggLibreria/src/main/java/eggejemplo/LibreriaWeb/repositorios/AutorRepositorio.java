package eggejemplo.LibreriaWeb.repositorios;

import eggejemplo.LibreriaWeb.entidades.Autor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
/*Entre los <> va 1ro el NOMBRE DE LA CLASE, y despues el TIPO DE DATO DEL ID DE LA ENTIDAD */
/*String -> pq la PK es un String.JpaRepository ya nos provee por defecto de ciertos metodos sin tener que hacer nada x ej Buscar x id*/
public interface AutorRepositorio extends JpaRepository<Autor, String> {

    /* Salvo el @Query, q es una anotación,los otros query puedo ponerles el nombre q quira*/
    @Query("SELECT a FROM Autor a WHERE a.nombre LIKE :query")
    List<Autor> buscarporId(@Param("query") String query);

    @Query("SELECT a FROM Autor a WHERE a.nombre LIKE :nombre")
    public Autor buscarAutorPorNombre(@Param("nombre") String nombre);

    @Query("SELECT a FROM Autor a WHERE a.alta LIKE true ORDER BY a.nombre ASC")
    public List<Autor> listarAutores();

}
