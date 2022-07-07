package entidad;

public class Pelicula {
    
    private String titulo;
    private String director;
    private Integer duracionHs;

    public Pelicula() {
    }

    public Pelicula(String titulo, String director, Integer duracionHs) {
        this.titulo = titulo;
        this.director = director;
        this.duracionHs = duracionHs;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Integer getDuracionHs() {
        return duracionHs;
    }

    public void setDuracionHs(Integer duracionHs) {
        this.duracionHs = duracionHs;
    }

    public String mostaraPelicula() {
        return "Pelicula{" + titulo + ", director=" + director + ", duracionHs=" + duracionHs + '}';
    }
    
    
}
