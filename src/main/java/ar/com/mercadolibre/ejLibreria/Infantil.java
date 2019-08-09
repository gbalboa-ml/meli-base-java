package ar.com.mercadolibre.ejLibreria;

public class Infantil extends Libro {

    private Integer edadDesde;
    private Integer edadHasta;

    public Infantil(Integer desde, Integer hasta, String editorial, String titulo) {
        super(titulo, editorial);
        this.edadDesde = desde;
        this.edadHasta = hasta;

    }
}
