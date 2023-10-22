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
public class ClienteTest {
    private static final Logger LOG = Logger.getLogger(EmpresaTest.class.getName());
    /**
     * Rigorous Test :-)
     */
    @Test
    public void modificarCiudadResidencia() {
        LOG.info("Iniciado test modificar ciudad de residencia del cliente");
        // Por medio de un assertThrows verificamos que los dato no sean nulos

        Cliente cliente = new Cliente("4857305", "Carlos", "Masculino", "Armenia",TipoDocumento.CEDULA);

        cliente.setCiudadResidencia("Ibague");

        assertEquals("Ibague", cliente.getCiudadResidencia());

        LOG.info("Finalizando test modificar ciudad de residencia del cliente");
    }

    @Test 
    public void modificarCiudadResidenciaNulo(){
        LOG.info("Iniciado test modificar ciudad de residencia del cliente");
        
        Cliente cliente = new Cliente("4857305", "Carlos", "Masculino", "Armenia",TipoDocumento.CEDULA);
        
        assertThrows(Throwable.class, ()-> cliente.setCiudadResidencia(null));

        LOG.info("Finalizando test modificar ciudad de residencia del cliente");

    }
    @Test
    public void clienteDatosCompletos(){
        LOG.info("Iniciado test cliente con datos completos");
        Cliente cliente = new Cliente("104483382","Luis Jimenez","Masculino", "Armenia", TipoDocumento.PASAPORTE);
        assertEquals("104483382", cliente.getDocumento());
        LOG.info("Finalizando test cliente con datos completos");
    }

    @Test
    public void clienteDatosNulos(){
        LOG.info("Iniciado test cliente con datos nulos");
        assertThrows(Throwable.class, ()-> new Cliente(null,null,null,null,TipoDocumento.PASAPORTE));
        LOG.info("Finalizando test cliente con datos nulos");
    }
}

