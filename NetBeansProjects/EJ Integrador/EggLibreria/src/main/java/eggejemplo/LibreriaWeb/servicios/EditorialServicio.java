package eggejemplo.LibreriaWeb.servicios;

import eggejemplo.LibreriaWeb.entidades.Editorial;
import eggejemplo.LibreriaWeb.excepciones.ErrorServicio;
import eggejemplo.LibreriaWeb.repositorios.EditorialRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EditorialServicio {
    
    @Autowired
    private EditorialRepositorio editRepo;
    
    @Transactional
    public void ingresarEditorial(String nombre, Boolean alta) throws ErrorServicio {

        validarDatos(nombre, alta);

        Editorial editorial = new Editorial();
        editorial.setNombre(nombre);
        editorial.setAlta(alta);
        editRepo.save(editorial);
    }
    
    @Transactional
    public void modificarEditorial(String id, String nombre, Boolean alta) throws ErrorServicio {

        validarDatos(nombre, alta);

        Editorial editorial = editRepo.buscarEditorialPorNombre(nombre);
        if (editorial != null) {
            
            editorial.setNombre(nombre);
            editorial.setAlta(alta);

            editRepo.save(editorial);
        } else {
            throw new ErrorServicio("El nombre ingresado no corresponde a una editorial registrada");
        }
    }
    
    @Transactional
    public void eliminarEditorial(String nombre) throws ErrorServicio {

        Editorial respuesta = editRepo.buscarEditorialPorNombre(nombre);

        if (respuesta != null) {
            editRepo.delete(respuesta);
        } else {
            throw new ErrorServicio("El nombre ingresado no corresponde a una editorial registrada");
        }
    }
    
        @Transactional
    public void deshabilitarEditorial(String id) throws ErrorServicio {

        Optional<Editorial> respuesta = editRepo.findById(id);

        if (respuesta.isPresent() || respuesta.get().getAlta() == Boolean.TRUE) {
            Editorial editorial = respuesta.get();
            editorial.setAlta(Boolean.FALSE);
            editRepo.save(editorial);
        } else {
            throw new ErrorServicio("El id ingresado no corresponde a una editorial registrada o la editorial ya se encuentra dehabilitada");
        }
    }

    @Transactional
    public void habilitarAutor(String id) throws ErrorServicio {

        Optional<Editorial> respuesta = editRepo.findById(id);

        if (respuesta.isPresent() || respuesta.get().getAlta() == Boolean.FALSE) {
            Editorial editorial = respuesta.get();
            editorial.setAlta(Boolean.TRUE);
            editRepo.save(editorial);
        } else {
            throw new ErrorServicio("El id ingresado no corresponde a una editorial registrada o la editorial ya se encuentra habilitada");
        }
    }
    
                 /*    BUSQUEDA    */
    
    //buscar todos
    @Transactional(readOnly = true)
    public List<Editorial> listAll(){
        return editRepo.findAll();
    }
    
    //buscador general
    @Transactional(readOnly = true)
    public List<Editorial> listByQuery(String query) {
        return editRepo.busquedaporId("%" + query + "%");
    }
    @Transactional(readOnly = true)
    Optional<Editorial> searchId(String id){
        return editRepo.findById(id);
    }
    
    public void validarDatos(String nombre, Boolean alta) throws ErrorServicio {

        if (nombre == null || nombre.trim().isEmpty()) {
            throw new ErrorServicio("El nombre no puede ser nulo");
        }

        if (alta == null) {
            throw new ErrorServicio("El valor de alta no puede ser nulo");
        }
    }
}
