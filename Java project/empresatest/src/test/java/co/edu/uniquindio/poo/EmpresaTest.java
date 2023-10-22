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

import java.util.Collection;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class EmpresaTest {
    private static final Logger LOG = Logger.getLogger(EmpresaTest.class.getName());

    /**
     * Rigorous Test :-)
     */
    @Test
    public void datosNulos() {
        LOG.info("Iniciado test de datos nulos");
        // Por medio de un assertThrows verificamos que los dato no sean nulos

        assertThrows(Throwable.class, () -> new Empresa(null, null));

        LOG.info("Finalizando test de datos nulos");
    }

    @Test 
    public void datosCompletos() {
        LOG.info("Iniciado test de datos completos");
        // Almacenar los datos Prestadora SAS|34567

        Empresa empresa = new Empresa("Prestadora SAS", "34567");

        // Recuperación y verificación de datos

        assertEquals("Prestadora SAS", empresa.getNombre());
        assertEquals("34567", empresa.getNit());

        LOG.info("Finalizando test de datos completos");
    }

    @Test 
    public void imprimirListaPrestamos(){
        LOG.info("Iniciando test imprimir lista de prestamos");

        Empresa empresa = new Empresa(null, null);
        Objeto objeto = new Objeto(null, null, 0, 0);
        Empleado empleado = new Empleado(null, null, null, null);
        Cliente cliente = new Cliente(null, null, null, null, null);
        Prestamo prestamo = new Prestamo(null, 0, 0, null, null, null);
        DetallePrestamoTest detallePrestamo = new DetallePrestamoTest(0, 0, null);

        empresa.registrarCliente(cliente);
        empresa.registrarEmpleado(empleado);
        empresa.registrarObjeto(objeto);
        


        LOG.info("Finalizando test imprimir lista de prestamos");
    }
}
