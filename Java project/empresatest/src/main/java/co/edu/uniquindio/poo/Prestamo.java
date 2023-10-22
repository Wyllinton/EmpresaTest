package co.edu.uniquindio.poo;

public class Prestamo {
    private String codigo;
    private int diasSolicitados;
    private int diasTranscurridos;
    private double valor;
    private Empleado empleado;
    private Cliente cliente;
    private DetallePrestamo detallePrestamo;

    //Constructor
    public Prestamo(String codigo, int diasSolicitados, double valor, Empleado empleado, Cliente cliente, DetallePrestamo detallePrestamo){
        assert codigo != null;
        assert diasSolicitados >= 0;
        assert valor >= 0;
        assert empleado != null;
        assert cliente != null;
        assert detallePrestamo != null;
        this.codigo = codigo;
        this.diasSolicitados = diasSolicitados;
        this.diasTranscurridos = 0;
        this.valor = valor;
        this.empleado = empleado;
        this.cliente = cliente;
        this.detallePrestamo = detallePrestamo;
        detallePrestamo.getObjeto().setPrestado(true);
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

    public DetallePrestamo getDetallePrestamo() {
        return detallePrestamo;
    }

    public void devolucionPrestamo(){
        Objeto objeto = detallePrestamo.getObjeto();
        objeto.modificarUnidades(detallePrestamo.getUnidadesPrestadas());
        detallePrestamo.getObjeto().setPrestado(false);
    }

    @Override
    public String toString(){
        return "Codigo= " + codigo + " | Valor= " + valor + " | Dias Solicitados= "  + diasSolicitados + " | Empleado= " + empleado + " | Cliente= " + cliente;
    }
}
