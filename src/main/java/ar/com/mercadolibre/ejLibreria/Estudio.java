package ar.com.mercadolibre.ejLibreria;

public class Estudio extends Libro implements Alquilable {

    private String tema;
    private boolean alquilado = false;

    public Estudio(String tema, String editorial, String titulo) {
        super(titulo, editorial);
        this.tema = tema;
    }

    public void alquilar(){
        this.alquilado = true;
    }

    public void devoler() {
        this.alquilado = false;
    }
}
