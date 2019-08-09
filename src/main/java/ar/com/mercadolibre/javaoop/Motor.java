package ar.com.mercadolibre.javaoop;

public class Motor {
    protected Double temperatura;
    public Double potencia;

    public Motor(Double temperatura, Double potencia) {
        this.temperatura = temperatura;
        this.potencia = potencia;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }


    public Double getTemperatura() {
        return temperatura;
    }

    public Double getPotencia() {
        return potencia;
    }
}
