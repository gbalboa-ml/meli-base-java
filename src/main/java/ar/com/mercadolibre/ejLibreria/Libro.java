package ar.com.mercadolibre.ejLibreria;

public abstract class Libro {

    public String titulo;
    public String editorial;

    public Libro(String titulo, String editorial) {
        this.titulo = titulo;
        this.editorial = editorial;
    }
}
