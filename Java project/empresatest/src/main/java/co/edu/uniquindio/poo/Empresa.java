/**
 * Clase empresa;
 * @author Área de programación UQ
 * @since 2023-08
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Optional;
import java.util.function.Predicate;

public class Empresa {
    private String nombre;
    private String nit;
    private final Collection<Empleado> empleados;
    private final Collection<Cliente> clientes;
    private final Collection<Prestamo> prestamos;
    private final Collection<Objeto> objetos;

    // Constructor
    public Empresa(String nombre, String nit) {
        assert nombre != null;
        assert nit != null;
        this.nombre = nombre;
        this.nit = nit;
        this.empleados = new LinkedList<>();
        this.clientes = new LinkedList<>();
        this.prestamos = new LinkedList<>();
        this.objetos = new LinkedList<>();
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getNit() {
        return nit;
    }

    public Collection<Empleado> getEmpleados() {
        return Collections.unmodifiableCollection(empleados);
    }

    public Collection<Cliente> getClientes() {
        return Collections.unmodifiableCollection(clientes);
    }

    public Collection<Prestamo> getPrestamos() {
        return Collections.unmodifiableCollection(prestamos);
    }

    public Collection<Objeto> getObjetos() {
        return Collections.unmodifiableCollection(objetos);
    }

    /**
     * Permite registrar un cliente a la listaClientes
     * 
     * @param cliente Cliente a ser registrado
     * @throws Se genera si el cliente ya se encuentra registrado
     */
    public void registrarCliente(Cliente cliente) {
        assert !validarClienteExiste(cliente) : "El cliente ya esta registrado";
        clientes.add(cliente);
    }

    /**
     * Permite eliminar un cliente de la listaClientes
     * 
     * @param cliente Clientre a ser eliminado
     * @throws Se genera si elo cliente no se encuentra registrado
     */
    public void eliminarCliente(Cliente cliente) {
        assert validarClienteExiste(cliente) : "El cliente no esta registrado";
        clientes.remove(cliente);
    }

    /**
     * Valida si el cliente ya se encuentra registrado
     * 
     * @param cliente
     * @return
     */
    private boolean validarClienteExiste(Cliente cliente) {
        boolean existeCliente = buscarClientePorDocumento(cliente.getDocumento()).isPresent();
        return existeCliente;
    }

    /**
     * Permite buscar un cliente por su documento entre los clientes registrados
     * 
     * @param documento
     * @return
     */
    public Optional<Cliente> buscarClientePorDocumento(String documento) {
        Predicate<Cliente> condicion = cliente -> cliente.getDocumento().equals(documento);
        return clientes.stream().filter(condicion).findAny();
    }

    /**
     * Permite registrar un empleado a la listaEmpleados
     * 
     * @param empleado Empleado a ser registrado
     * @throws Se genera si el empleado ya se encuentra registrado
     */
    public void registrarEmpleado(Empleado empleado) {
        assert !validarEmpleadoExiste(empleado) : "El empleado ya esta registrado";
        empleados.add(empleado);
    }

    /**
     * Permite eliminar un empleado de la listaEmpleados
     * 
     * @param empleado Empleado a ser eliminado
     * @throws Se genera si el empleado no se encuentra registrado
     */
    public void eliminarEmpleado(Empleado empleado) {
        assert validarEmpleadoExiste(empleado) : "El empleado no esta registrado";
        empleados.remove(empleado);
    }

    /**
     * Valida si el empleado ya se encuentra registrado
     * 
     * @param empleado
     * @return
     */
    private boolean validarEmpleadoExiste(Empleado empleado) {
        boolean existeEmpleado = buscarEmpleadoPorCodigo(empleado.getCodigo()).isPresent();
        return existeEmpleado;
    }

    /**
     * Permite buscar un empleado por su codigo entre los empleados registrados
     * 
     * @param codigo
     * @return
     */
    public Optional<Empleado> buscarEmpleadoPorCodigo(String codigo) {
        Predicate<Empleado> condicion = empleado -> empleado.getCodigo().equals(codigo);
        return empleados.stream().filter(condicion).findAny();
    }

    /**
     * Permite registrar un prestamo a la listaPrestamos
     * 
     * @param prestamo Prestamo a ser registrado
     * @throws Se genera si el prestamo ya se encuentra registrado
     */
    public void registrarPrestamo(Prestamo prestamo) {
        assert !validarPrestamoExiste(prestamo) : "El prestamo ya esta registrado";
        prestamos.add(prestamo);
    }

    /**
     * Permite eliminar un prestamo a la listaPrestamos
     * 
     * @param prestamo Prestamo a ser eliminado
     * @throws Se genera si el prestamo no esta registrado
     */
    public void eliminarPrestamo(Prestamo prestamo) {
        assert validarPrestamoExiste(prestamo) : "El prestamo no esta registrado";
        prestamo.devolucionPrestamo();
        prestamos.remove(prestamo);
    }

    /**
     * Valida si el prestamo ya se encuentra registrado
     * 
     * @param prestamo
     * @return
     */
    private boolean validarPrestamoExiste(Prestamo prestamo) {
        boolean existePrestamo = buscarPrestamoPorCodigo(prestamo.getCodigo()).isPresent();
        return existePrestamo;
    }

    /**
     * Permite buscar un prestamo por su codigo entre los prestamos registrados
     * 
     * @param documento
     * @return
     */
    public Optional<Prestamo> buscarPrestamoPorCodigo(String codigo) {
        Predicate<Prestamo> condicion = prestamo -> prestamo.getCodigo().equals(codigo);
        return prestamos.stream().filter(condicion).findAny();
    }

    /**
     * Permite registrar un objeto a la listaObjetos
     * 
     * @param objeto Objeto a ser registrado
     * @throws Se genera si el objeto ya se encuentra registrado
     */
    public void registrarObjeto(Objeto objeto) {//Se optimiza código agregando !
        assert !validarObjetoExiste(objeto)
                : "El objeto ya esta registrado, unicamente modifique las unidades disponibles";
        objetos.add(objeto);
    }

    /**
     * Permite eliminar un objeto de la listaObjetos
     * 
     * @param objeto
     */
    public void eliminarObjeto(Objeto objeto) {
        assert validarObjetoExiste(objeto) : "El objeto no esta registrado";
        objetos.remove(objeto);
    }

    /**
     * Valida si el objeto ya se encuentra registrado
     * 
     * @param objeto
     * @return
     */
    private boolean validarObjetoExiste(Objeto objeto) {
        boolean existeObjeto = buscarObjetoPorCodigo(objeto.getCodigo()).isPresent();
        return existeObjeto;
    }

    /**
     * Permite buscar un objeto por su codigo entre los objetos registrados
     * 
     * @param codigo
     * @return
     */
    public Optional<Objeto> buscarObjetoPorCodigo(String codigo) {
        Predicate<Objeto> condicion = objeto -> objeto.getCodigo().equals(codigo);
        return objetos.stream().filter(condicion).findAny();
    }

    /**
     * Permite filtrar la listaObjetos con un valor indicado
     * 
     * @param dinero Filtro
     * @return Una lista con los objetos cuyo valor sea mayor o igual al valor
     *         indicado
     
    public Collection<Objeto> filtroPorDinero(double dinero) {
        LinkedList<Objeto> lista = new LinkedList<>();
        for (Objeto objeto : objetos) {
            if (objeto.isPrestado() == true && objeto.getPrecioAlquiler() >= dinero) {
                lista.add(objeto);
            }
        }
        return lista;
    }
    */

    /**
     * Permite imprimir la listaPrestamos
     * 
     * @param prestamos
     */
    public void imprimirListaPrestamos(LinkedList<Prestamo> prestamos) {
        for (Prestamo prestamo : prestamos) {
            System.out.println("- " + prestamo);
        }
    }

    public Collection<Cliente> obtenerListaClientesMasculinos(LinkedList<Cliente> clientes) {
        LinkedList<Cliente> clientesMasculinos = new LinkedList<>();
        for (Cliente cliente : clientes) {
            if (cliente.getGenero().equals("Masculino")) {
                clientesMasculinos.add(cliente);
            }
        }
        return clientesMasculinos;
    }
    //Funcionalidad agregada por los testers
    public Collection<Objeto> obtenerListaObjetosPrestadosMayorA20k(LinkedList<Objeto> objetos) {
        LinkedList<Objeto> objetosPrestadosMayor20k = new LinkedList<>();
        for (Objeto objeto : objetos) {
            if (objeto.isPrestado() == true && objeto.getPrecioAlquiler() >= 20000) {
                objetosPrestadosMayor20k.add(objeto);
            }
        }
        return objetosPrestadosMayor20k;
    }
    //Funcionalidad extraida del otro grupo de developers
     /**
     * Metodo para obtener la cantidad de unidades prestadas de un objeto
     * @param codigoPrestamoBuscar 
     */
    public int obtenerCantidadUnidadesPrestadas(String codigoPrestamoBuscar){
        int unidadesPrestadas = 0; 
        for (Prestamo prestamo: prestamos) {
            if (prestamo.getCodigo().equals(codigoPrestamoBuscar)){
                Collection<DetallePrestamo> detallesDelPrestamo = new LinkedList<>(prestamo.getDetallePrestamo());
                for (DetallePrestamo detallePrestamo: detallesDelPrestamo){
                    unidadesPrestadas += detallePrestamo.getUnidadesPrestadas();
                }
            }
        }
        return unidadesPrestadas; 
    }

}
