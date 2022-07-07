package libreria.servicios;

import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;
import libreria.persistencia.LibroDAO;

public class LibroServicio {

    private final LibroDAO daoLibro;
    private final AutorServicio autorSer;
    private final EditorialServicio editorialSer;
      
    public LibroServicio() {
        this.daoLibro = new LibroDAO();//daoAutor = new AutorDAO();
        this.editorialSer = new EditorialServicio();
        this.autorSer = new AutorServicio();
    }

    public Libro creaLibro(String titulo, Integer anio, Autor autor, Editorial editorial) {

        Libro newLibro = new Libro();

        try {
            if (titulo == null || titulo.trim().isEmpty()) {
                throw new Exception("Debe indicar el titulo del libro");
            }
            newLibro.setTitulo(titulo);

            if (anio == null || anio < 0) {
                throw new Exception("Debe indicar el año");
            }
            newLibro.setAnio(anio);

            if (autor == null) {
                throw new Exception("Autor nulo");
            }
            newLibro.setAutor(autor);

            if (editorial == null) {
                throw new Exception("Editorial nulo");
            }

            newLibro.setEditorial(editorial);

            //Magia para obtener los ejemplares
            int ejemplares = (int) (Math.random() * 7 + 1);
            int prestados = ejemplares - (int) (Math.random() * 7 + 1);

            newLibro.setIsbn((long) (int) (Math.random() * 999999 + 1));

            newLibro.setEjemplares(ejemplares);

            newLibro.setEjemplaresPrestados(prestados);

            newLibro.setEjemplaresRestantes(ejemplares - prestados);

            newLibro.setAlta(Boolean.TRUE);

            daoLibro.guardarLibro(newLibro);

            return newLibro;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    public void modificarLibro(String titulo, String nuevoTitulo, Integer anio, Integer nuevoAnio) {

        Libro aux = null;

        try {
            if (titulo == null || titulo.trim().isEmpty()) {
                throw new Exception("Debe indicar el titulo");
            }
            if (nuevoTitulo == null || nuevoTitulo.trim().isEmpty()) {
                throw new Exception("Debe indicar el titulo nuevo");
            }
            if (anio == null || anio <=0) {
                throw new Exception("Debe indicar el anio");
            }
            if (nuevoAnio == null || nuevoAnio <=0) {
                throw new Exception("Debe indicar el anio nuevo");
            }
            
//            List<Autor> autores = autorSer.imprimirAutores();
            Autor autor = null;
//            aux = daoAutor.modificarAutor(autorNuevo);
//            aux.setNombre(nuevoNombre);
//            daoAutor.modificarAutor(aux);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void eliminarLibro(String titulo) {

        try {
            //Validamos 
            if (titulo == null || titulo.trim().isEmpty()) {
                throw new Exception("Debe indicar el titulo");
            }
            daoLibro.eliminarLibro(titulo);
            System.out.println("LIBRO ELIMINADO CON EXITO");
        } catch (Exception e) {
            System.out.println("No se encontro libro " + e.getMessage());
        }
    }

}
