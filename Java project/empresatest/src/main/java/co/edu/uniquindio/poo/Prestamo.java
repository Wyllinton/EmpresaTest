package co.edu.uniquindio.poo;

import java.util.Collection;

public class Prestamo {
    private String codigo;
    private int diasSolicitados;
    private int diasTranscurridos;
    private double valor;
    private Empleado empleado;
    private Cliente cliente;
    private Collection<DetallePrestamo> detallesPrestamos;


    //Constructor
    public Prestamo(String codigo, int diasSolicitados, double valor, Empleado empleado, Cliente cliente, Collection<DetallePrestamo> detallesPrestamos){
        assert codigo != null;
        assert diasSolicitados >= 0;
        assert valor >= 0;
        assert empleado != null;
        assert cliente != null;
        this.codigo = codigo;
        this.diasSolicitados = diasSolicitados;
        this.diasTranscurridos = 0;
        this.valor = valor;
        this.empleado = empleado;
        this.cliente = cliente;
        this.detallesPrestamos = detallesPrestamos;
        detallesPrestamos.forEach(detalle -> detalle.getObjeto().setPrestado(true));
    }

    //Getters
    public String getCodigo() {
        return codigo;
    }

    public int getDiasSolicitados() {
        return diasSolicitados;
    }

    public int getDiasTranscurridos() {
        return diasTranscurridos;
    }

    public double getValor() {
        return valor;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Collection<DetallePrestamo> getDetallePrestamo() {
        return detallesPrestamos;
    }

    public void devolucionPrestamo(){

        detallesPrestamos.forEach(prestamo -> {
            Objeto objeto = prestamo.getObjeto();
            objeto.modificarUnidades(prestamo.getUnidadesPrestadas());
            prestamo.getObjeto().setPrestado(false);
        }); 
    }

    @Override
    public String toString(){
        return "Codigo= " + codigo + " | Valor= " + valor + " | Dias Solicitados= "  + diasSolicitados + " | Empleado= " + empleado + " | Cliente= " + cliente;
    }
}
