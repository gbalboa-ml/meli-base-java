package ar.com.mercadolibre.javaoop;

public class MotorAEnergia extends Motor implements ModificarPotenciaInterface{


    public MotorAEnergia(Double temperatura, Double potencia) {
        super(temperatura, potencia);
    }

    public void modificarPotencia (Double potencia) {

        this.potencia += potencia;

        this.modificarTemperatura(potencia);
    }

    public void modificarTemperatura(Double potencia) {
        setTemperatura(getTemperatura()+potencia*0.9);
    }

    public void refrigerar(){
        this.setTemperatura(this.getTemperatura() * 0.8);
    }

}
