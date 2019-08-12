package ar.com.mercadolibre.ejEnvios;

import java.util.List;

public class Envio {

    private List<Integer> paquetes;
    private Double costo;
    private String direccion;
    private Transportes transporte;

    public Envio(List<Integer> paquetes, Transportes transporte, String direccion, Double costo) {

        this.paquetes = paquetes;
        this.transporte = transporte;
        this.direccion = direccion;
        this.costo = costo;
    }

    public Double getCosto() {
        return costo;
    }

    public String getDireccion() {
        return direccion;
    }

    public Transportes getTransporte() {
        return transporte;
    }
}
