package ar.com.mercadolibre.javaoop;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class MotorTest {

    @Test
    public void crearMotor(){
        Motor motor = new Motor(100d,100d);
        Assertions.assertThat(motor).isNotNull();
    }

    @Test
    public void obtenerDatos(){
        Motor motor = new Motor(100d,100d);
        Assertions.assertThat(motor.getPotencia()).isEqualTo(100d);
        Assertions.assertThat(motor.getTemperatura()).isEqualTo(100d);
    }

    @Test
    public void modificaPotenciaACombustible(){
        MotorACombustible motor = new MotorACombustible(100d, 100d);
        motor.modificarPotencia(20d);
        Assertions.assertThat(motor.getPotencia()).isEqualTo(120d);
        Assertions.assertThat(motor.getTemperatura()).isEqualTo(122d);
    }

    @Test
    public void modificaPotenciaAEnergia(){
        MotorAEnergia motor = new MotorAEnergia(100d, 100d);
        motor.modificarPotencia(20d);
        Assertions.assertThat(motor.getPotencia()).isEqualTo(120d);
        Assertions.assertThat(motor.getTemperatura()).isEqualTo(118d);
    }

    @Test
    public void refrigerarMotor(){
        MotorAEnergia motor = new MotorAEnergia(100d, 100d);
        motor.refrigerar();
        Assertions.assertThat(motor.getTemperatura()).isEqualTo(80d);
    }
}
