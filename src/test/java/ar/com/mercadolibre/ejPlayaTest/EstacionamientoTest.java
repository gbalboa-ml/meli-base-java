package ar.com.mercadolibre.ejPlayaTest;

import ar.com.mercadolibre.ejPlaya.Auto;
import ar.com.mercadolibre.ejPlaya.Camion;
import ar.com.mercadolibre.ejPlaya.PlayaDeEstacionamiento;
import ar.com.mercadolibre.ejPlaya.Utilitario;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class EstacionamientoTest {

    @Test
    public void creaLaPlayaDeEstacionamiento() {
        PlayaDeEstacionamiento playa = PlayaDeEstacionamiento.getInstance();

        Assertions.assertThat(playa).isNotNull();
        Assertions.assertThat(playa.getCantidadDeVehiculos()).isEqualTo(0);
    }

    @Test
    public void agregaUnAutoALaPlaya() {
        PlayaDeEstacionamiento playa = PlayaDeEstacionamiento.getInstance();
        Auto auto = new Auto("pepe");
        Integer cantidadAnterior = playa.getCantidadDeVehiculos();

        playa.estacionar(auto);

        Assertions.assertThat(playa.getCantidadDeVehiculos()).isEqualTo(cantidadAnterior + 1);
    }

    @Test
    public void agregaMuchosAutosALaPlaya() {
        PlayaDeEstacionamiento playa = PlayaDeEstacionamiento.getInstance();
        Auto auto = new Auto("pepe");
        Camion camion = new Camion("pepito",500);
        Utilitario utilitario = new Utilitario("pepon");
        Integer cantidadAnterior = playa.getCantidadDeVehiculos();

        playa.estacionar(auto);
        playa.estacionar(camion);
        playa.estacionar(utilitario);

        Assertions.assertThat(playa.getCantidadDeVehiculos()).isEqualTo(cantidadAnterior + 3);
    }

    @Test
    public void quitarUnVehiculoDeLaPlaya() {
        PlayaDeEstacionamiento playa = PlayaDeEstacionamiento.getInstance();
        Auto auto = new Auto("pepe");
        playa.estacionar(auto);
        Integer cantidadVehiculoEstacionado = playa.getCantidadDeVehiculos();
        playa.sacarVehiculo(auto);

        Assertions.assertThat(playa.getCantidadDeVehiculos()).isEqualTo(cantidadVehiculoEstacionado - 1);
    }

}
