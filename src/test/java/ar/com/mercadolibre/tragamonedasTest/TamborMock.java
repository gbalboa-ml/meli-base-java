package ar.com.mercadolibre.tragamonedasTest;

import ar.com.mercadolibre.ejTragamonedas.Tambor;

import java.util.Random;

import static java.lang.Math.abs;

public class TamborMock extends Tambor {

    public TamborMock(Integer numero) {
        numeroActual = numero;
    }

    public void girar() {
   }
}
