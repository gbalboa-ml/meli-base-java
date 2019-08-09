package ar.com.mercadolibre.ejPlaya;

public class VehiculoDeCarga extends Vehiculo {

    private Integer capacidad;
    private Integer carga = 0;

    public VehiculoDeCarga(String nombre, Integer capacidad) {
        super(nombre);
        this.capacidad = capacidad;
    }

    public void cargar(Integer carga) {
        if(this.carga.equals(0)) {
            this.carga = carga;
        }
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public Integer getCarga() {
        return carga;
    }
}
