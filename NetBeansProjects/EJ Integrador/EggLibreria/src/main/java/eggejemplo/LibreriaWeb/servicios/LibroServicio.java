package eggejemplo.LibreriaWeb.servicios;

import eggejemplo.LibreriaWeb.entidades.Autor;
import eggejemplo.LibreriaWeb.entidades.Editorial;
import eggejemplo.LibreriaWeb.entidades.Libro;
import eggejemplo.LibreriaWeb.excepciones.ErrorServicio;
import eggejemplo.LibreriaWeb.repositorios.AutorRepositorio;
import eggejemplo.LibreriaWeb.repositorios.EditorialRepositorio;
import eggejemplo.LibreriaWeb.repositorios.LibroRepositorio;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LibroServicio {
   
    @Autowired
    private LibroRepositorio rLibro;

    @Autowired
    private AutorRepositorio repositorioAutor;

    @Autowired
    private EditorialRepositorio repositorioEditorial;
    
    @Transactional
    public void ingresarLibro(Long isbn, String titulo, Integer anio, Integer ejemplares, Integer ejemplaresPrestados,
            Boolean alta, String idAutor, String idEditorial) throws ErrorServicio {

        validarDatos(isbn, titulo, anio, ejemplares, ejemplaresPrestados, alta, idAutor, idEditorial);
/*creo un un objeto de tipo Libro y el ID se genera automaticamente        */
        
        Libro libro = new Libro();
        libro.setIsbn(isbn);
        libro.setTitulo(titulo);
        libro.setAnio(anio);
        libro.setEjemplares(ejemplares);
        libro.setEjemplaresPrestados(ejemplaresPrestados);
        libro.setEjemplaresRestantes(ejemplares - ejemplaresPrestados);
        libro.setAlta(alta);
        libro.setAutor(repositorioAutor.findById(idAutor).get());
        libro.setEditorial(repositorioEditorial.findById(idEditorial).get());

        rLibro.save(libro);

    }

    @Transactional
    public void modificarLibro(String id, Long isbn, String titulo, Integer anio, Integer ejemplares, Integer ejemplaresPrestados,
            Boolean alta, String idAutor, String idEditorial) throws ErrorServicio {

        validarDatos(isbn, titulo, anio, ejemplares, ejemplaresPrestados, alta, idAutor, idEditorial);

        Libro libro = rLibro.findByTitulo(titulo);

        if (libro != null) {
            
            libro.setIsbn(isbn);
            libro.setTitulo(idAutor);
            libro.setAnio(anio);
            libro.setEjemplares(ejemplares);
            libro.setEjemplaresPrestados(ejemplaresPrestados);
            libro.setEjemplaresRestantes(ejemplares - ejemplaresPrestados);
            libro.setAlta(alta);
            libro.setAutor(repositorioAutor.findById(idAutor).get());
            libro.setEditorial(repositorioEditorial.findById(idEditorial).get());
            
            rLibro.save(libro);
        } else {
            throw new ErrorServicio("El id ingresado no corresponde a un libro registrado");
        }
    }
    
    @Transactional
    public void eliminarLibro(String titulo) throws ErrorServicio {

        Libro respuesta = rLibro.findByTitulo(titulo);

        if (respuesta != null) {
            rLibro.delete(respuesta);
        } else {
            throw new ErrorServicio("El id ingresado no corresponde a un libro registrado");
        }
    }
    
        @Transactional
    public void deshabilitarLibro(String id) throws ErrorServicio {

        Optional<Libro> respuesta = rLibro.findById(id);

        if (respuesta.isPresent() || respuesta.get().getAlta() == Boolean.TRUE) {
            Libro libro = respuesta.get();
            libro.setAlta(Boolean.FALSE);
            rLibro.save(libro);
        } else {
            throw new ErrorServicio("El id ingresado no corresponde a un libro registrado o el libro ya se encuentra deshabilitado");
        }
    }

    @Transactional
    public void habilitarLibro(String id) throws ErrorServicio {

        Optional<Libro> respuesta = rLibro.findById(id);

        if (respuesta.isPresent() || respuesta.get().getAlta() == Boolean.FALSE) {
            Libro libro = respuesta.get();
            libro.setAlta(Boolean.TRUE);
            rLibro.save(libro);
        } else {
            throw new ErrorServicio("El id ingresado no corresponde a un libro registrado o el libro no se encuentra deshabilitado");
        }
    }
    
                    /*BUSQUEDA*/
    public List<Libro> listAllByAutor(String nombre){
        return rLibro.findAllByAutor(nombre);
    }
    
    public List<Libro> listAllByEditorial(String nombre){
        return rLibro.findAllByEditorial(nombre);
    }
    
    public Libro listAllByTitulo(String nombre){
        return rLibro.findByTitulo(nombre);
    }
    
    private void validarDatos(Long isbn, String titulo, Integer anio, Integer ejemplares, Integer ejemplaresPrestados,
            Boolean alta, String idAutor, String idEditorial) throws ErrorServicio {

        if (isbn == null || isbn.toString().length() < 13) {
            throw new ErrorServicio("El ISBN debe tener 13 caracteres");
        }

        if (titulo == null || titulo.trim().isEmpty()) {
            throw new ErrorServicio("El título del libro no puede ser nulo");
        }

        if (anio > LocalDate.now().getYear() || anio == null) {
            throw new ErrorServicio("El año del libro no puede ser nulo ni mayor al actual");
        }

        if (ejemplares == null || ejemplares < 0) {
            throw new ErrorServicio("El numero de ejemplares no puede ser menor a cero");
        }

        if (ejemplaresPrestados == null || ejemplaresPrestados > ejemplares) {
            throw new ErrorServicio("El numero de ejemplares prestados no puede ser mayor al existente");
        }

        if (alta == null) {
            throw new ErrorServicio("El valor de alta no puede ser nulo");
        }

        Optional<Autor> respuestaAutor = repositorioAutor.findById(idAutor);
        if (!respuestaAutor.isPresent()) {
            throw new ErrorServicio("El autor no puede ser nulo");
        }

        Optional<Editorial> respuestaEditorial = repositorioEditorial.findById(idEditorial);
        if (!respuestaEditorial.isPresent()) {
            throw new ErrorServicio("La editorial no puede ser nula");
        }

    }
    
}
