package ar.com.mercadolibre.ejPlaya;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayaDeCarga {


    public final static Integer CAPACIDAD_DE_VEHICULOS = 100;
    private Integer cantidadDeVehiculos = 0;
    private List<Integer> cargasDespachadas = new ArrayList<Integer>();

    private List<VehiculoDeCarga> vehiculosDeCarga = new ArrayList<VehiculoDeCarga>();
    private List<Integer> cargas = new ArrayList<Integer>();

    private static PlayaDeCarga playaDeCarga = new PlayaDeCarga();

    private PlayaDeCarga(){

        Integer[] cargasIniciales = new Integer[]{100,200,300,120,240};
        this.cargas.addAll(Arrays.asList(cargasIniciales));

    }

    public static PlayaDeCarga getInstance(){
        return playaDeCarga;
    }

    public void guardarCargas(Integer carga) {
        this.cargas.add(carga);
    }

    public void estacionarYCargar(VehiculoDeCarga vehiculoDeCarga) {
        if (!cargas.isEmpty()) {
            if (cantidadDeVehiculos <= CAPACIDAD_DE_VEHICULOS) {
                vehiculosDeCarga.add(vehiculoDeCarga);
                cantidadDeVehiculos++;
                Integer carga = this.seleccionarCarga(vehiculoDeCarga);
                vehiculoDeCarga.cargar(carga);
                cargas.remove(carga);
            }
        }
    }

    public void sacarVehiculo(VehiculoDeCarga vehiculoDeCarga) {
        if(this.vehiculosDeCarga.contains(vehiculoDeCarga)) {
            this.vehiculosDeCarga.remove(vehiculoDeCarga);
            this.cantidadDeVehiculos--;
            this.cargasDespachadas.add(vehiculoDeCarga.getCarga());
        }
    }

    private Integer seleccionarCarga (VehiculoDeCarga vehiculoDeCarga){
        for (int i = 0; i <= cargas.size(); i++) {
            if (vehiculoDeCarga.getCapacidad() >= cargas.get(i)){
                return cargas.get(i);
            }
        }
        return -1;
    }

    public Integer getCantidadDeVehiculos() {
        return cantidadDeVehiculos;
    }

    public List<Integer> getCargasDespachadas() {
        return cargasDespachadas;
    }
}
