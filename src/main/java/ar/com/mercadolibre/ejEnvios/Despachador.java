package ar.com.mercadolibre.ejEnvios;

import java.util.List;

public class Despachador {

    private Integer contadorEnvios = 0;

    public static class SelectorDeVehiculo{

        public static Transportes seleccionarVehiculo(Integer peso) throws Exception {

            if (peso < 5) return Transportes.Bicicleta;
            if (peso < 50) return Transportes.Auto;
            if (peso < 150) return Transportes.Camioneta;

            throw new Exception("El peso sobrepasa lo pedido");
        }
    }

    public static class CalculadorDeCostos {
        public static Double calcularCostoDeEnvio(List<Integer> paquetes) {
            if (paquetes.size() < 5) return 50d;
            if (paquetes.size() < 10) return 80d;
            else return 80d + (paquetes.size() - 10) * 15;
        }
    }

    public Envio generarEnvio (List<Integer> paquetes, String direccion) throws Exception {

        Integer peso = 0;
        Double costo = CalculadorDeCostos.calcularCostoDeEnvio(paquetes);
        if (contadorEnvios >= 10) costo *= 1.1;
        for(Integer paquete : paquetes) {
            peso += paquete;
        }
        Transportes transporte = SelectorDeVehiculo.seleccionarVehiculo(peso);
        return new Envio(paquetes, transporte, direccion, costo);
    }


}
