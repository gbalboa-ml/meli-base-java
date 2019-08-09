package ar.com.mercadolibre.ejLibreria;

public class Novela extends  Libro implements Alquilable{

    private boolean alquilado = false;
    private String autor;
    private String edicion;

    public Novela(String autor, String edicion, String editorial, String titulo) {
        super(titulo, editorial);
        this.autor = autor;
        this.edicion = edicion;
    }

    public void alquilar(){
        this.alquilado = true;
    }

    public void devoler() {
        this.alquilado = false;
    }

}
