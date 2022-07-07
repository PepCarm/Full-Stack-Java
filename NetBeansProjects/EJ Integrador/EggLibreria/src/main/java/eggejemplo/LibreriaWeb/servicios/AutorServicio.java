package eggejemplo.LibreriaWeb.servicios;

import eggejemplo.LibreriaWeb.entidades.Autor;
import eggejemplo.LibreriaWeb.excepciones.ErrorServicio;
import eggejemplo.LibreriaWeb.repositorios.AutorRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AutorServicio {

 /*A todos les @Autowired de Servicios les pone "private ", pero puedo optar por omitirlo*/   
    @Autowired // creo un objeto de la clase AutorRepositorio y lo denomino autoRepo, sin necesidad de instanciarlo
    private AutorRepositorio autoRepo;

    @Transactional
    public void ingresarAutor(String nombre, Boolean alta) throws ErrorServicio {

/*creo un un objeto de tipo Autor y lo denomino "autor" y el ID se genera automaticamente*/
 
        Autor autor = new Autor();
        
/*con los parametros recibidos invoco al metodo validar (Evitar q sean Vacios)
en esta linea si el metodo validar no arroja excepcion continuo seteando los parametros al autor*/
        
        validarDatos(nombre, alta);
        
        autor.setNombre(nombre);
        autor.setAlta(alta);
        autoRepo.save(autor);//Mediante el Repositorio de autor utilizo el metodo save para persistir en la base
    }

    
    @Transactional
    public void modificarAutor(String id, String nombre, Boolean alta) throws ErrorServicio {

        validarDatos(nombre, alta);

        Autor autor = autoRepo.buscarAutorPorNombre(nombre);
        if (autor != null) {
            autor.setNombre(nombre);
            autor.setAlta(alta);

            autoRepo.save(autor);
        } else {
            throw new ErrorServicio("El nombre ingresado no corresponde a un autor registrado");
        }
    }
                        /*    BUSQUEDA x ID    */
    
    /*@Transactional
    public void modificarAutor(String id, String nombre, Boolean alta) throws ErrorServicio {

        validarDatos(nombre, alta);

        Optional<Autor> respuesta = autoRepo.findById(id);
        
/*Usamos el "Optinal" cdo el ID es incorrecto y ese Autor no existe. 
 Con este metodo puedo ver si existe un ID asociado a un autor(respuesta.isPresent()),
si la rta es afirmativa entro al if, y modifico al autor, si no voy al else.*/
        
    /*    if (respuesta.isPresent()) {
            Autor autor = respuesta.get();
            autor.setNombre(nombre);
            autor.setAlta(alta);

            autoRepo.save(autor);
        } else {
            throw new ErrorServicio("El id ingresado no corresponde a un autor registrado");
        }
    }*/
    
    @Transactional//Puse que se elimine por nombre para mostrar otrea variante.
    public void eliminarautor(String nombre) throws ErrorServicio {

        Autor respuesta = autoRepo.buscarAutorPorNombre(nombre);

        if (respuesta != null) {
            autoRepo.delete(respuesta);
        } else {
            throw new ErrorServicio("El nombre ingresado no corresponde a un autor registrado");
        }
    }
    
        @Transactional
    public void deshabilitarAutor(String id) throws ErrorServicio {

        Optional<Autor> respuesta = autoRepo.findById(id);

        if (respuesta.isPresent() || respuesta.get().getAlta() == Boolean.TRUE) {
            Autor autor = respuesta.get();
            autor.setAlta(Boolean.FALSE);
            autoRepo.save(autor);
        } else {
            throw new ErrorServicio("El id ingresado no corresponde a un autor registrado o el autor ya se encuentra deshabilitado");
        }
    }

    @Transactional
    public void habilitarAutor(String id) throws ErrorServicio {

        Optional<Autor> respuesta = autoRepo.findById(id);

        if (respuesta.isPresent() || respuesta.get().getAlta() == Boolean.FALSE) {
            Autor autor = respuesta.get();
            autor.setAlta(Boolean.TRUE);
            autoRepo.save(autor);
        } else {
            throw new ErrorServicio("El id ingresado no corresponde a un autor registrado o el autor no se encuentra habilitado");
        }
    }
    
                       /*    BUSQUEDA    */
    
    //buscar todos
    public List<Autor> listAll(){
        return  autoRepo.findAll();
    }
    
    //buscador general
    public List<Autor> listByQuery(String query) {
        return  autoRepo.buscarporId("%" + query + "%");
    }
    
    Optional<Autor> searchId(String id){
        return  autoRepo.findById(id);
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
