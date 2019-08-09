package ar.com.mercadolibre.javaoop;

public class MotorACombustible extends Motor implements ModificarPotenciaInterface{

    public MotorACombustible(Double temperatura, Double potencia) {
        super(temperatura, potencia);
    }

    public void modificarPotencia (Double potencia) {
        this.potencia += potencia;

        this.modificarTemperatura(potencia);
    }

    public void modificarTemperatura(Double potencia) {
        setTemperatura(getTemperatura()+potencia*1.1);
    }
}
