package ar.com.mercadolibre;

import ar.com.mercadolibre.ejTragamonedas.Tambor;

import java.util.Random;

import static java.lang.Math.abs;

public class TamborMock extends Tambor {

    private Integer numeroActual;

    public TamborMock(Integer numero) {
        numeroActual = numero;
    }

    public void girar() {
   }

    public Integer obtenerPosicion() {
        return numeroActual;
    }
}
