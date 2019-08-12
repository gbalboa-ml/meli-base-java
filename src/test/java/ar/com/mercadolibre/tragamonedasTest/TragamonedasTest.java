package ar.com.mercadolibre.tragamonedasTest;

import ar.com.mercadolibre.ejTragamonedas.Tambor;
import ar.com.mercadolibre.ejTragamonedas.Tragamonedas;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class TragamonedasTest{

    @Test
    public void creaBienVariosTambores() {
        Tambor tambor1 = new Tambor();
        Tambor tambor2 = new Tambor();
        Tambor tambor3 = new Tambor();

        tambor1.girar();
        Assertions.assertThat(tambor1).isNotNull();
        Assertions.assertThat(tambor1.obtenerPosicion()).isBetween(1,8);
        System.out.println(tambor1.obtenerPosicion());
        tambor2.girar();
        Assertions.assertThat(tambor2).isNotNull();
        Assertions.assertThat(tambor2.obtenerPosicion()).isBetween(1,8);
        System.out.println(tambor2.obtenerPosicion());
        tambor3.girar();
        Assertions.assertThat(tambor3).isNotNull();
        Assertions.assertThat(tambor3.obtenerPosicion()).isBetween(1,8);
        System.out.println(tambor3.obtenerPosicion());
    }
    @Test
    public void creaBienTragamonedasYGana() {
        TamborMock tambor1 = new TamborMock(1);
        TamborMock tambor2 = new TamborMock(1);
        TamborMock tambor3 = new TamborMock(1);

        Tragamonedas tragamonedas = new Tragamonedas(tambor1,tambor2,tambor3);

        Assertions.assertThat(tragamonedas).isNotNull();
        Assertions.assertThat(tragamonedas.entregaPremio()).isTrue();

    }

    @Test
    public void creaBienTragamonedasYPierde() {
        TamborMock tambor1 = new TamborMock(1);
        TamborMock tambor2 = new TamborMock(2);
        TamborMock tambor3 = new TamborMock(1);

        Tragamonedas tragamonedas = new Tragamonedas(tambor1,tambor2,tambor3);

        Assertions.assertThat(tragamonedas).isNotNull();
        Assertions.assertThat(tragamonedas.entregaPremio()).isFalse();

    }
}
