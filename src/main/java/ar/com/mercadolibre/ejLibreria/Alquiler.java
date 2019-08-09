package ar.com.mercadolibre.ejLibreria;


import java.time.LocalDateTime;

public class Alquiler {
    private Alquilable alquilable;
    private LocalDateTime fechaAlquiler;
    private LocalDateTime fechaDevolucion;

    public Alquiler(Alquilable alquilable) {
        this.fechaAlquiler = LocalDateTime.now();
        this.alquilable = alquilable;
    }

    public Alquilable getAlquilable() {
        return alquilable;
    }

    public LocalDateTime getFechaDevolucion() {
        return fechaDevolucion;
    }
}
