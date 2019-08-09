package ar.com.mercadolibre.javaoop;

import ar.com.mercadolibre.javaoop.Cerradura;
import org.junit.Assert;
import org.junit.Test;
import org.assertj.core.api.Assertions;

public class CerraduraTest {

     @Test
    public void crearCerradura(){

         Cerradura cerradura = new Cerradura();
         Assertions.assertThat(cerradura).isNotNull();
     }

     @Test
    public void crearCerraduraConClaveNumerica(){

         Cerradura cerradura = new Cerradura(1234);
         Assertions.assertThat(cerradura).isNotNull();

     }

     @Test
    public void crearCerraduraConClaveNumericaYLaGuarde(){

         Cerradura cerradura = new Cerradura(1234);
         Assertions.assertThat(cerradura).isNotNull();
         Assertions.assertThat(cerradura.clave).isEqualTo(1234);
     }

    @Test
    public void crearCerraduraConOtraClaveNumericaYLaGuarde(){

        Cerradura cerradura = new Cerradura(1235);
        Assertions.assertThat(cerradura).isNotNull();
        Assertions.assertThat(cerradura.clave).isEqualTo(1235);
    }

    @Test
    public void unaCerraduraSeCreaCerrada(){
         Cerradura cerradura = new Cerradura();
         Assertions.assertThat(cerradura.estaCerrada()).isTrue();
    }

    @Test
    public void abrirCerraduraConClave(){

         // Crear una cerradura
        Cerradura cerradura = new Cerradura(1235);

        // Verifico que este cerrada
        Assertions.assertThat(cerradura.estaCerrada()).isTrue();

        // La intento abrir
        cerradura.abrir(1235);

        // Verifico que este abierta
        Assertions.assertThat(cerradura.estaCerrada()).isFalse();
    }
}
