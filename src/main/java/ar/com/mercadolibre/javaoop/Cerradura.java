package ar.com.mercadolibre.javaoop;

public class Cerradura {

    public Integer clave;

    private Boolean cerrada = true;

    public Cerradura(){}

    public Cerradura(Integer clave){
        this.clave = clave;
    }

    public boolean estaCerrada(){
        return this.cerrada;
    }

    public void abrir (Integer clave){
        if (clave.equals(this.clave)){
            this.cerrada = false;
        }
    }
}
