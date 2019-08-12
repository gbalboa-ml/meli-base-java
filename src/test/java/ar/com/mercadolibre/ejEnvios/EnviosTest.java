package ar.com.mercadolibre.ejEnvios;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.mockito.Mockito.*;

import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EnviosTest {



    @Test
    public void meEligeCorrectamenteUnVehiculo() throws Exception {
        Assertions.assertThat(Despachador.SelectorDeVehiculo.seleccionarVehiculo(2)).isEqualTo(Transportes.Bicicleta);
        Assertions.assertThat(Despachador.SelectorDeVehiculo.seleccionarVehiculo(6)).isEqualTo(Transportes.Auto);
        Assertions.assertThat(Despachador.SelectorDeVehiculo.seleccionarVehiculo(51)).isEqualTo(Transportes.Camioneta);
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
    @Test
    public void exceptionTestSelectorDeVehiculo() throws  Exception {
        exceptionRule.expect(Exception.class);
        exceptionRule.expectMessage("El peso sobrepasa lo pedido");
        Despachador.SelectorDeVehiculo.seleccionarVehiculo(170);
    }

    @Test
    public void crearEnvioCorrectamente() {
        List<Integer> paquetes = new ArrayList<Integer>(Arrays.asList(5,8,19,32));
        Envio envio = new Envio(paquetes, Transportes.Bicicleta, "Calle Falsa 123", 50.0);
        Assertions.assertThat(envio).isNotNull();
    }

    @Test
    public void calcularCostosDeEnvioFunciona(){
        List<Integer> paquetes1 = new ArrayList<Integer>(Arrays.asList(5,10,19,20));
        List<Integer> paquetes2 = new ArrayList<Integer>(Arrays.asList(5,8,19,32,29));
        List<Integer> paquetes3 = new ArrayList<Integer>(Arrays.asList(5,8,19,32,12,12,13,14,15,17,53));
        List<Integer> paquetes4 = new ArrayList<Integer>(Arrays.asList(5,8,19,32,12,12,13,14,15,18,92,10));

        Assertions.assertThat(Despachador.CalculadorDeCostos.calcularCostoDeEnvio(paquetes1)).isEqualTo(50);
        Assertions.assertThat(Despachador.CalculadorDeCostos.calcularCostoDeEnvio(paquetes2)).isEqualTo(80);
        Assertions.assertThat(Despachador.CalculadorDeCostos.calcularCostoDeEnvio(paquetes3)).isEqualTo(95);
        Assertions.assertThat(Despachador.CalculadorDeCostos.calcularCostoDeEnvio(paquetes4)).isEqualTo(110);
    }

    @Test
    public void generarEnviosCorrectamente() throws Exception {
        List<Integer> paquetes1 = new ArrayList<Integer>(Arrays.asList(5,10,19,20));
        List<Integer> paquetes2 = new ArrayList<Integer>(Arrays.asList(5,8,19,32,29));
        List<Integer> paquetes3 = new ArrayList<Integer>(Arrays.asList(5,8,19,32,12,12,13,14,15,17,53));
        List<Integer> paquetes4 = new ArrayList<Integer>(Arrays.asList(5,8,19,32,12,12,13,14,15,18,92,10));

        Despachador.SelectorDeVehiculo selectorDeVehiculosMock = mock(Despachador.SelectorDeVehiculo.class);
        when(selectorDeVehiculosMock.seleccionarVehiculo(any(Integer.class))).thenReturn(Transportes.Auto);

        //Assertions.assertThat(selectorDeVehiculosMock.seleccionarVehiculo(50)).isEqualTo(Transportes.Auto);


    }
}
