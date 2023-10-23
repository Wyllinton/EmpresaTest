/**
 * Clase para probar el funcionamiento del código
 * @author Área de programación UQ
 * @since 2023-08
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedList;
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
    public void registroCliente(){
        LOG.info("Iniciando test de registrar cliente");
        Empresa empresa = new Empresa("Prestadora SAS", "34567");
        Cliente cliente = new Cliente("345678", "Mario", "Masculino", "Armenia", TipoDocumento.CEDULA);

        empresa.registrarCliente(cliente);

        assertTrue(empresa.getClientes().contains(cliente));
        assertEquals(1, empresa.getClientes().size());
        
        LOG.info("Finalizando test de registrar cliente");

    }
    
     @Test
    public void eliminarCliente(){
        LOG.info("Iniciando test de eliminar cliente");
        Empresa empresa = new Empresa("Prestadora SAS", "34567");
        Cliente cliente = new Cliente("345678", "Mario", "Masculino", "Armenia", TipoDocumento.CEDULA);

        empresa.registrarCliente(cliente);
        empresa.eliminarCliente(cliente);

        assertEquals(0, empresa.getClientes().size());
        
        LOG.info("Finalizando test de eliminar cliente");

    }
    @Test 
    public void buscarClientePorDocumento(){
        LOG.info("Iniciando test buscar cliente por documento");
        Empresa empresa = new Empresa("Prestadora SAS", "34567");
        Cliente cliente = new Cliente("104483382","Luis Jimenez","Masculino", "Armenia", TipoDocumento.PASAPORTE);
        Cliente cliente2 = new Cliente("109478","Elva Giron","Femenino", "Armenia", TipoDocumento.CEDULA);
        Cliente cliente3 = new Cliente("109487302","Luisa Maria","Femenino", "Armenia", TipoDocumento.CEDULA_EXTRANJERA);
        
        empresa.registrarCliente(cliente);
        empresa.registrarCliente(cliente2);
        empresa.registrarCliente(cliente3);
        assertEquals(cliente3, empresa.buscarClientePorDocumento("109487302").get());
        
        LOG.info("Finalizando test buscar cliente por documento");
    }  

    @Test 
    public void registrarListaPrestamos(){
        LOG.info("Iniciando test registrar lista de prestamos");

        Empresa empresa = new Empresa("Prestadora SAS", "34567");
        Objeto objeto = new Objeto("Retroexcavadora", "23456", 2, 50000);
        Objeto objeto2 = new Objeto("Balón", "256", 9, 500);
        Empleado empleado = new Empleado("Camila Sanchez", "41912026", "camila@gmail.com", "5");
        Cliente cliente = new Cliente("104483382","Luis Jimenez","Masculino", "Armenia", TipoDocumento.PASAPORTE);

        LinkedList<DetallePrestamo> detallesPrestamos1 = new LinkedList<>();
        detallesPrestamos1.add(new DetallePrestamo(2,3,objeto));
        Prestamo prestamo1 = new Prestamo("12345", 4, 78756, empleado, cliente, detallesPrestamos1);

        LinkedList<DetallePrestamo> detallesPrestamos2 = new LinkedList<>();
        detallesPrestamos2.add(new DetallePrestamo(2,4,objeto2) );
        Prestamo prestamo2 = new Prestamo("23456",6,40000,empleado,cliente,detallesPrestamos2);
        empresa.registrarPrestamo(prestamo1);
        empresa.registrarPrestamo(prestamo2);
        assertEquals(2, empresa.getPrestamos().size());

        LOG.info("Finalizando test registrar lista de prestamos");
    }
     @Test 
    public void eliminarPrestamos(){
        LOG.info("Iniciando test eliminar prestamo");

        Empresa empresa = new Empresa("Prestadora SAS", "34567");
        Objeto objeto = new Objeto("Retroexcavadora", "23456", 2, 50000);
        Objeto objeto2 = new Objeto("Balón", "256", 9, 500);
        Empleado empleado = new Empleado("Camila Sanchez", "41912026", "camila@gmail.com", "5");
        Cliente cliente = new Cliente("104483382","Luis Jimenez","Masculino", "Armenia", TipoDocumento.PASAPORTE);

        LinkedList<DetallePrestamo> detallesPrestamos1 = new LinkedList<>();
        detallesPrestamos1.add(new DetallePrestamo(2,3,objeto));
        Prestamo prestamo1 = new Prestamo("12345", 4, 78756, empleado, cliente, detallesPrestamos1);

        LinkedList<DetallePrestamo> detallesPrestamos2 = new LinkedList<>();
        detallesPrestamos2.add(new DetallePrestamo(2,4,objeto2) );
        Prestamo prestamo2 = new Prestamo("23456",6,40000,empleado,cliente,detallesPrestamos2);
        empresa.registrarPrestamo(prestamo1);
        empresa.registrarPrestamo(prestamo2);
        empresa.eliminarPrestamo(prestamo2);
        assertEquals(1, empresa.getPrestamos().size());
        assertFalse(empresa.getPrestamos().contains(prestamo2));

        LOG.info("Finalizando test eliminar prestamo");
    }
     @Test 
    public void buscarPrestamoCodigo(){
        LOG.info("Iniciando test buscar prestamo por código");

        Empresa empresa = new Empresa("Prestadora SAS", "34567");
        Objeto objeto = new Objeto("Retroexcavadora", "23456", 2, 50000);
        Objeto objeto2 = new Objeto("Balón", "256", 9, 500);
        Empleado empleado = new Empleado("Camila Sanchez", "41912026", "camila@gmail.com", "5");
        Cliente cliente = new Cliente("104483382","Luis Jimenez","Masculino", "Armenia", TipoDocumento.PASAPORTE);

        LinkedList<DetallePrestamo> detallesPrestamos1 = new LinkedList<>();
        detallesPrestamos1.add(new DetallePrestamo(2,3,objeto));
        Prestamo prestamo1 = new Prestamo("12345", 4, 78756, empleado, cliente, detallesPrestamos1);

        LinkedList<DetallePrestamo> detallesPrestamos2 = new LinkedList<>();
        detallesPrestamos2.add(new DetallePrestamo(2,4,objeto2) );
        Prestamo prestamo2 = new Prestamo("23456",6,40000,empleado,cliente,detallesPrestamos2);
        empresa.registrarPrestamo(prestamo1);
        empresa.registrarPrestamo(prestamo2);
    
        assertTrue(empresa.buscarPrestamoPorCodigo("12345").isPresent());

        LOG.info("Finalizando test buscar prestamo por código");
    }

    @Test 
    public void imprimirListaPrestamos(){
        LOG.info("Iniciando test imprimir lista de prestamos");

        Empresa empresa = new Empresa("Prestadora SAS", "34567");
        Objeto objeto = new Objeto("Retroexcavadora", "23456", 2, 50000);
        Empleado empleado = new Empleado("Camila Sanchez", "41912026", "camila@gmail.com", "5");
        Cliente cliente = new Cliente("104483382","Luis Jimenez","Masculino", "Armenia", TipoDocumento.PASAPORTE);
        
        LinkedList<DetallePrestamo> detallesPrestamo = new LinkedList<>();
        detallesPrestamo.add(new DetallePrestamo(2,3,objeto));
        Prestamo prestamo1 = new Prestamo("12345", 4, 78756, empleado, cliente, detallesPrestamo);
        LinkedList<DetallePrestamo> detallesPrestamo2 = new LinkedList<>();
        Prestamo prestamo2 = new Prestamo("23456",6,40000,empleado,cliente,detallesPrestamo2);
        empresa.registrarPrestamo(prestamo1);
        empresa.registrarPrestamo(prestamo2);
        LinkedList<Prestamo> prestamos = new LinkedList<>(empresa.getPrestamos());
        empresa.imprimirListaPrestamos(prestamos);
        //Un imprimir se prueba en la consola, observando si imprime, o no
        LOG.info("Finalizando test imprimir lista de prestamos");
    }
    
    @Test 
    public void registarEmpleados(){
        LOG.info("Iniciando test de registrar empleado");
        Empresa empresa = new Empresa("Prestadora SAS", "34567");
        Empleado empleado = new Empleado("Camila Sanchez", "41912026", "camila@gmail.com", "5");

        empresa.registrarEmpleado(empleado);
       
        assertTrue(empresa.getEmpleados().contains(empleado));
        assertEquals(1, empresa.getEmpleados().size());

        LOG.info("Finalizando test de registrar empleado");
    }

    @Test 
    public void eliminarEmpleados(){
        LOG.info("Iniciando test de eliminar empleado");

        Empleado empleado = new Empleado("Camila Sanchez", "41912026", "camila@gmail.com", "5");
        Empresa empresa = new Empresa("Prestadora SAS", "34567");
        empresa.registrarEmpleado(empleado);
        empresa.eliminarEmpleado(empleado);

        assertEquals(0, empresa.getClientes().size());

        LOG.info("Finalizando test de eliminar empleado");
    } 

    @Test
    public void buscarEmpleadoPorCodigo(){
        LOG.info("Iniciando test de buscar empleado por código");
        
        Empresa empresa = new Empresa("Prestadora SAS", "34567");
        Empleado empleado1 = new Empleado("Camila Sanchez", "41912026", "camila@gmail.com", "5");
        Empleado empleado2 = new Empleado("Paula Ramirez", "10923476", "Paula@gmail.com", "8");
        Empleado empleado3 = new Empleado("Roberto Rodrigueez", "39487236", "Roberto@gmail.com", "3");
        empresa.registrarEmpleado(empleado1);
        empresa.registrarEmpleado(empleado2);
        empresa.registrarEmpleado(empleado3);
        
        assertTrue(empresa.buscarEmpleadoPorCodigo("39487236").isPresent());
        
        LOG.info("Finalizando test de buscar empleado por código");

    }
    
    @Test
    public void obtenerListaClientesMasculinos(){
        LOG.info("Iniciando test obtener lista de clientes masculinos ");
        Empresa empresa = new Empresa("Prestadora SAS", "34567");
        Cliente cliente = new Cliente("104483382","Luis Jimenez","Masculino", "Armenia", TipoDocumento.PASAPORTE);
        Cliente cliente2 = new Cliente("109478","Elva Giron","Femenino", "Armenia", TipoDocumento.CEDULA);
        Cliente cliente3 = new Cliente("109487302","Luisa Maria","Femenino", "Armenia", TipoDocumento.CEDULA_EXTRANJERA);
        Cliente cliente4 = new Cliente("109787302","Carlos Alberto","Masculino", "Armenia", TipoDocumento.CEDULA_EXTRANJERA);
        empresa.registrarCliente(cliente);
        empresa.registrarCliente(cliente2);
        empresa.registrarCliente(cliente3);
        empresa.registrarCliente(cliente4);
        LinkedList<Cliente> clientes = new LinkedList<>(empresa.getClientes());
        assertEquals(2,empresa.obtenerListaClientesMasculinos(clientes).size());
        
        LOG.info("Finalizando test obtener lista de clientes masculinos");
    }
    @Test 
    public void objetosPrestadosMayorA20000(){
        LOG.info("Iniciando test objetos prestados mayor a 20000");

        Empresa empresa = new Empresa("Prestadora SAS", "34567");
        Objeto objeto = new Objeto("Retroexcavadora", "23476", 2, 50000);
        Objeto objeto1 = new Objeto("Cubo", "23156", 2, 5000);
        Objeto objeto2 = new Objeto("Libro", "22436", 2, 30000);
        Objeto objeto3 = new Objeto("Crotolamo", "2456", 2, 20000);
        empresa.registrarObjeto(objeto);
        empresa.registrarObjeto(objeto1);
        empresa.registrarObjeto(objeto2);
        empresa.registrarObjeto(objeto3);

        objeto.setPrestado(true);
        objeto1.setPrestado(true);
        objeto2.setPrestado(true);
        objeto3.setPrestado(true);

        LinkedList<Objeto> objetos = new LinkedList<>(empresa.getObjetos());

        assertEquals(2, empresa.obtenerListaObjetosPrestadosMayorA20k(objetos).size() );
        LOG.info("Finalizando test objetos prestados mayor a 20000");
    }
    @Test 
    public void registrarObjeto(){
        LOG.info("Iniciado test registrar objeto");
        
        Empresa empresa = new Empresa("Prestadora SAS", "34567");
        Objeto objeto = new Objeto("Retroexcavadora", "23456", 2, 50000);

        empresa.registrarObjeto(objeto);
        
        assertTrue(empresa.getObjetos().contains(objeto));
        assertEquals(1, empresa.getObjetos().size());


        LOG.info("Finalizando test registrar objeto");

    }
    @Test 
    public void eliminarObjeto(){
        LOG.info("Iniciado test eliminar objeto");
        
        Empresa empresa = new Empresa("Prestadora SAS", "34567");
        Objeto objeto = new Objeto("Retroexcavadora", "23456", 2, 50000);

        empresa.registrarObjeto(objeto);
        empresa.eliminarObjeto(objeto);
        
        assertFalse(empresa.getObjetos().contains(objeto));
        assertEquals(0, empresa.getObjetos().size());


        LOG.info("Finalizando test eliminar objeto");

    }
    @Test
    public void obtenerCantidadUnidadesPrestadas (){

        LOG.info("Iniciando test obtener cantidad unidades prestadas");
        Empresa empresa = new Empresa("Prestadora SAS", "34567");
        Objeto objeto = new Objeto("Retroexcavadora", "23456", 2, 50000);
        Objeto objeto2 = new Objeto("Balón", "256", 9, 500);
        Empleado empleado = new Empleado("Camila Sanchez", "41912026", "camila@gmail.com", "5");
        Cliente cliente = new Cliente("104483382","Luis Jimenez","Masculino", "Armenia", TipoDocumento.PASAPORTE);

        LinkedList<DetallePrestamo> detallesPrestamos1 = new LinkedList<>();
        detallesPrestamos1.add(new DetallePrestamo(2,3,objeto));
        Prestamo prestamo1 = new Prestamo("12345", 4, 78756, empleado, cliente, detallesPrestamos1);

        LinkedList<DetallePrestamo> detallesPrestamos2 = new LinkedList<>();
        detallesPrestamos2.add(new DetallePrestamo(2,4,objeto2) );
        Prestamo prestamo2 = new Prestamo("23456",6,40000,empleado,cliente,detallesPrestamos2);
        empresa.registrarPrestamo(prestamo1);
        empresa.registrarPrestamo(prestamo2);
        

        assertEquals(2, empresa.obtenerCantidadUnidadesPrestadas("12345"));
        
        LOG.info("Iniciando test obtener cantidad unidades prestadas");

    }
    @Test
    public void buscarObjetoCodigo(){
        LOG.info("Iniciado test buscar objeto por código");
        
        Empresa empresa = new Empresa("Prestadora SAS", "34567");
        Objeto objeto = new Objeto("Retroexcavadora", "23456", 2, 50000);
        Objeto objeto2 = new Objeto("Balón", "83528", 10, 700);

        empresa.registrarObjeto(objeto);
        empresa.registrarObjeto(objeto2);
        
        assertTrue(empresa.buscarObjetoPorCodigo("23456").isPresent());
        

        LOG.info("Finalizando test buscar objeto por código");
    }


}
