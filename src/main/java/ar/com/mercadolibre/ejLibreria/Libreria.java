package ar.com.mercadolibre.ejLibreria;

import java.util.ArrayList;
import java.util.List;
import java.util.function.LongToIntFunction;
import java.util.function.Predicate;

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


        Alquiler result = buscarAlquiler(alquilable);

        return result != null;
    }

    private Alquiler buscarAlquiler(Alquilable alquilable)
    {

        Alquiler result = null;
        try {
            result = this.alquileres.stream()
                    .filter(getPredicate(alquilable)).findFirst().get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;

    }

    public Predicate<Alquiler> getPredicate (Alquilable alquilable)
    {
         return alquiler -> alquiler.getAlquilable().equals(alquilable) && alquiler.getFechaDevolucion() != null;
    }
}
