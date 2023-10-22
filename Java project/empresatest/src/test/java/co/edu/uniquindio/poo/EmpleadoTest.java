/**
 * Clase para probar el funcionamiento del código
 * @author Área de programación UQ
 * @since 2023-08
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class EmpleadoTest {
    private static final Logger LOG = Logger.getLogger(EmpleadoTest.class.getName());

    /**
     * Rigorous Test :-)
     */
    @Test
    public void datosNulosEmpleado() {
        LOG.info("Iniciado test de datos nulos de empleado");
        // Por medio de un assertThrows verificamos que los dato no sean nulos

        assertThrows(Throwable.class, () -> new Empleado(null, null, null, null));

        LOG.info("Finalizando test de datos nulos de empleado");
    }
    @Test 
    public void datosCompletosEmpleados(){
        LOG.info("Iniciando test de datos completos empleado");

        Empleado empleado = new Empleado("Camila Sanchez", "41912026", "camila@gmail.com", "5");

        assertEquals("camila@gmail.com", empleado.getCorreo());
        assertEquals("41912026", empleado.getCodigo());

        LOG.info("Finalizando test de datos completos empleado");
    }    
}

