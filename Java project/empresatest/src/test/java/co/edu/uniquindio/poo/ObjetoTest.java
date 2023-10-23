/**
 * Clase para probar el funcionamiento del codigo del objeto
 * @author Area de programacion UQ
 * @since 2023-08
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class ObjetoTest {
    private static final Logger LOG = Logger.getLogger(EmpresaTest.class.getName());
    /**
     * Rigorous Test :-)
     */

    @Test 
    public void objetoDatosCompletos(){
        LOG.info("Iniciando test objeto datos completos");
        
        Objeto objeto = new Objeto("Retroexcavadora", "23456", 2, 50000);
        
        assertEquals("Retroexcavadora", objeto.getNombre());
        assertEquals(2, objeto.getUnidadesDisponibles());

        LOG.info("Finalizando test objeto datos completos");

    }
    @Test
    public void objetoDatosNulos() {
        LOG.info("Iniciando test objeto datos nulos");

        assertThrows(Throwable.class, ()-> new Objeto(null,null,0,0));

        LOG.info("Finalizando test objeto datos nulos");
    }
    @Test
    public void objetoUnidadesDisponiblesNegativas() {
        LOG.info("Iniciando test objeto de unidades disponibles negativas");
        assertThrows(Throwable.class, ()-> new Objeto("Retroexcavadora","23456",-2,50000));
        LOG.info("Finalizando test objeto de unidades disponibles negativas");
    }
    @Test
    public void objetoPrecioAlquilerNegativo() {
        LOG.info("Iniciando test objeto con precio de alquiler negativo");
        assertThrows(Throwable.class, ()-> new Objeto("Retroexcavadora","23456",2,-50000));
        LOG.info("Finalizando test objeto con precio de alquiler negativo");
    }

    @Test
    public void modificarUnidadesDisponibles() {
        LOG.info("Iniciando test modificar unidades disponibles");
        Objeto objeto = new Objeto("Retroexcavadora", "23456", 2, 50000);
        objeto.modificarUnidades(6);
        assertEquals(8,objeto.getUnidadesDisponibles());
        LOG.info("Finalizando test modificar unidades disponibles");
    }
    @Test
    public void verificarEstado() {
        LOG.info("Iniciando test verificar estado");
        Objeto objeto = new Objeto("Retroexcavadora", "23456", 2, 50000);
        assertTrue(objeto.isEstado());
        LOG.info("Finalizando test verificar estado");
    }
    @Test
    public void verificarPrestado() {
        LOG.info("Iniciando test verificar prestado");
        Objeto objeto = new Objeto("Retroexcavadora", "23456", 2, 50000);
        objeto.setPrestado(true);
        assertTrue(objeto.isPrestado());
        LOG.info("Finalizando test verificar prestado");
    }
}
