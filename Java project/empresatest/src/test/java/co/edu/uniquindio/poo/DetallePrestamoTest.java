/**
 * Clase para probar el funcionamiento del codigo del cliente
 * @author Area de programacion UQ
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
public class DetallePrestamoTest {
    private static final Logger LOG = Logger.getLogger(EmpresaTest.class.getName());
    /**
     * Rigorous Test :-)
     */


    @Test
    public void DetallePrestamoDatosCompletos() {
        LOG.info("Iniciado test de detalle prestamo datos completos");
        Objeto objeto = new Objeto("Retroexcavadora", "23456", 2, 50000);
        DetallePrestamo detallePrestamo = new DetallePrestamo(2,3,objeto);
        assertEquals(2, detallePrestamo.getUnidadesPrestadas());
        LOG.info("Finalizando test de de detalle prestamo datos completos");
    }
    @Test
    public void DetallePrestamoUnidadesPrestadasMayorUnidadesDisponibles() {
        LOG.info("Iniciado test unidades prestadas mayor que unidades disponibles");
        Objeto objeto = new Objeto("Retroexcavadora", "23456", 5, 50000);
        assertThrows(Throwable.class, () -> new DetallePrestamo(7,3,objeto));
        LOG.info("Finalizando test unidades prestadas mayor que unidades disponibles");
    }
    @Test
    public void DetallePrestamoUnidadesPrestadasNegativas() {
        LOG.info("Iniciado test detalle prestamo con unidades prestadas negativas");
        Objeto objeto = new Objeto("Retroexcavadora", "23456", 5, 50000);
        assertThrows(Throwable.class, () -> new DetallePrestamo(-4,3,objeto));
        LOG.info("Finalizando test detalle prestamo con unidades prestadas negativas");
    }
    @Test
    public void DetallePrestamoSubTotalNegativo() {
        LOG.info("Iniciado test detalle prestamo con subtotal negativo");
        Objeto objeto = new Objeto("Retroexcavadora", "23456", 5, 50000);
        assertThrows(Throwable.class, () -> new DetallePrestamo(4,-2,objeto));
        LOG.info("Finalizando test detalle prestamo con subtotal negativo");
    }
    @Test
    public void DetallePrestamoDatosNulos() {
        LOG.info("Iniciado test de detalle prestamo datos nulos");
        Objeto objeto = null;
        assertThrows(Throwable.class, () -> new DetallePrestamo(0,0,objeto));
        LOG.info("Finalizando test de detalle prestamo datos nulos");
}
}
