/**
 * Clase para probar el funcionamiento del codigo del objeto
 * @author Area de programacion UQ
 * @since 2023-08
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 * String codigo, int diasSolicitados, double valor, Empleado empleado, Cliente cliente, DetallePrestamo detallePrestamo
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
public class PrestamoTest {
    private static final Logger LOG = Logger.getLogger(EmpresaTest.class.getName());
    /**
     * Rigorous Test :-)
     */
    @Test
    public void prestamoDatosCompletos() {
        LOG.info("Iniciado test de prestamo datos completos");
        
        Empleado empleado = new Empleado("Camila Sanchez", "41912026", "camila@gmail.com", "5");
        Cliente cliente = new Cliente("104483382","Luis Jimenez","Masculino", "Armenia", TipoDocumento.PASAPORTE);
        Objeto objeto = new Objeto("Retroexcavadora", "23456", 2, 50000);
        DetallePrestamo detallePrestamo = new DetallePrestamo(2,3,objeto);
        Prestamo prestamo = new Prestamo("12345",4,50000,empleado,cliente,detallePrestamo);
        assertEquals(empleado,prestamo.getEmpleado());
        LOG.info("Finalizando test de prestamo datos completos");
    }

}
