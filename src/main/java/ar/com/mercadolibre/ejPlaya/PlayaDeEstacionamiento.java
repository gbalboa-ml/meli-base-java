package ar.com.mercadolibre.ejPlaya;

import java.util.ArrayList;
import java.util.List;

public class PlayaDeEstacionamiento {

    public final static Integer CAPACIDAD_DE_VEHICULOS = 100;
    private Integer cantidadDeVehiculos = 0;
    private List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

    private static PlayaDeEstacionamiento playaDeEstacionamiento = new PlayaDeEstacionamiento();
    private PlayaDeEstacionamiento() {}

    public static PlayaDeEstacionamiento getInstance(){
        return playaDeEstacionamiento;
    }

    public void estacionar(Vehiculo vehiculo) {
        if (!cantidadDeVehiculos.equals(CAPACIDAD_DE_VEHICULOS)) {
            vehiculos.add(vehiculo);
            cantidadDeVehiculos++;
        }
    }

    public void sacarVehiculo(Vehiculo vehiculo) {
        if(this.vehiculos.contains(vehiculo)) {
            this.vehiculos.remove(vehiculo);
            this.cantidadDeVehiculos--;
        }
    }

    public Integer getCantidadDeVehiculos() {
        return cantidadDeVehiculos;
    }
}
