package ar.com.mercadolibre.ejLibreria;

import java.util.ArrayList;
import java.util.List;
import java.util.function.LongToIntFunction;

public class Libreria {

    public List<Alquiler> alquileres = new ArrayList<Alquiler>();
    public List<Libro> libros = new ArrayList<Libro>();

    private static Libreria libreria = new Libreria();

    private Libreria() {
    }

    public static Libreria getInstance() {
        return libreria;
    }

    public void alquilar(Alquilable alquilable) {
        if (!this.libroEstaAlquilado(alquilable)) {
            Alquiler alquiler = new Alquiler(alquilable);
            this.alquileres.add(alquiler);
            alquilable.alquilar();
        }
    }

    



    private boolean libroEstaAlquilado(Alquilable alquilable) {


        Alquiler result = this.alquileres.stream()
                .filter(alquiler -> alquiler.getAlquilable().equals(alquilable))
                .filter(alquiler -> alquiler.getFechaDevolucion() != null).findFirst().orElse(null);

        return result != null;
    }

   /* private Alquiler buscarAlquiler(Libro libro) {


    }*/
}
