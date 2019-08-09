package ar.com.mercadolibre.ejPlayaTest;

import ar.com.mercadolibre.ejPlaya.*;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.List;

public class CargasTest {

    @Test
    public void creaLaPlayaDeCarga() {
        PlayaDeCarga playa = PlayaDeCarga.getInstance();

        Assertions.assertThat(playa).isNotNull();
        Assertions.assertThat(playa.getCantidadDeVehiculos()).isEqualTo(0);
    }

    @Test
    public void agregaUnAutoALaPlayaDeCarga() {
        PlayaDeCarga playa = PlayaDeCarga.getInstance();
        Camion camion = new Camion("pepe", 500);
        Integer cantidadAnterior = playa.getCantidadDeVehiculos();

        playa.estacionarYCargar(camion);

        Assertions.assertThat(playa.getCantidadDeVehiculos()).isEqualTo(cantidadAnterior + 1);

        }
    @Test
    public void sacarUnVehiculoDeCargaDeLaPlayaDeCarga() {
        PlayaDeCarga playa = PlayaDeCarga.getInstance();
        Camion camion = new Camion("pepe", 500);

        playa.estacionarYCargar(camion);
        playa.sacarVehiculo(camion);

        Assertions.assertThat(camion.getCarga()).isEqualTo(playa.getCargasDespachadas().get(0));

    }
    @Test
    public void agregaMuchosAutosALaPlayaDeCarga() {
        PlayaDeCarga playaDeCarga = PlayaDeCarga.getInstance();
        Camioneta camioneta = new Camioneta("pepe", 600);
        Camion camion = new Camion("pepito",500);

        playaDeCarga.estacionarYCargar(camioneta);
        playaDeCarga.estacionarYCargar(camion);

        playaDeCarga.sacarVehiculo(camioneta);
        playaDeCarga.sacarVehiculo(camion);

        Assertions.assertThat(camioneta.getCarga()).isEqualTo(playaDeCarga.getCargasDespachadas().get(0));
        Assertions.assertThat(camion.getCarga()).isEqualTo(playaDeCarga.getCargasDespachadas().get(1));
        Assertions.assertThat(playaDeCarga.getCargasDespachadas().size()).isEqualTo(2);
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
