package ar.com.mercadolibre.ejTragamonedas;

import java.util.Random;

import static java.lang.Math.abs;

public class Tambor {

    private Integer numeroActual;

    public void girar() {
        Random r = new Random();

        numeroActual = (abs(r.nextInt())%8)+1;
    }


    public Integer obtenerPosicion() {
        return numeroActual;
    }

}
