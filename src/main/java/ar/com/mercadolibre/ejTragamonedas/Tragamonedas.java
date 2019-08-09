package ar.com.mercadolibre.ejTragamonedas;

import java.util.ArrayList;
import java.util.List;

public class Tragamonedas {

    List<Tambor> tambores;
    boolean hayGanador;

    public Tragamonedas() {
        tambores = new ArrayList<Tambor>();
        for(int i = 0; i < 3; i++) {
            Tambor actual = new Tambor();
            tambores.add(actual);
        }
    }

    public Tragamonedas(Tambor tambor1, Tambor tambor2, Tambor tambor3) {
        tambores = new ArrayList<Tambor>();
        tambores.add(tambor1);
        tambores.add(tambor2);
        tambores.add(tambor3);
    }

    private void activar() {
        tambores.forEach(tambor -> tambor.girar());
    }

    public boolean entregaPremio() {
        this.activar();
        boolean result = true;
        int numeroGanador = this.tambores.get(0).obtenerPosicion();
        for(Tambor tambor : this.tambores) {
            result = tambor.obtenerPosicion().equals(numeroGanador) && result;
            System.out.println(tambor.obtenerPosicion());
            System.out.println("cosas");
        }
        return result;
    }
}
