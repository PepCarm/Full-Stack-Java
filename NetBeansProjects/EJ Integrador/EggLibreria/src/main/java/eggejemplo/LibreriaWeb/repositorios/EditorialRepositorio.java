package eggejemplo.LibreriaWeb.repositorios;

import eggejemplo.LibreriaWeb.entidades.Editorial;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorialRepositorio extends JpaRepository<Editorial, String> {

    @Query("SELECT e FROM Editorial e WHERE e.nombre LIKE :query")
    List<Editorial> busquedaporId(@Param("query") String query);
    
       @Query("SELECT e FROM Editorial e WHERE e.nombre LIKE :nombre")
    public Editorial buscarEditorialPorNombre(@Param("nombre") String nombre);

    @Query("SELECT e FROM Editorial e WHERE e.alta LIKE true ORDER BY e.nombre ASC")
    public List<Editorial> listarEditoriales();
}
