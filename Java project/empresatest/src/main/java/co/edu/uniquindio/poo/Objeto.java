package co.edu.uniquindio.poo;

public class Objeto {
    private String nombre;
    private String codigo;
    private int unidadesDisponibles;
    private boolean estado;
    private boolean prestado;
    private double precioAlquiler;
    
    //Constructor
    public Objeto(String nombre, String codigo, int unidadesDisponibles, double precioAlquiler){
        assert nombre != null;
        assert codigo != null;
        assert unidadesDisponibles > 0;
        assert precioAlquiler > 0;
        this.estado = true;
        this.prestado = false;
        this.nombre = nombre;
        this.codigo = codigo;
        this.unidadesDisponibles = unidadesDisponibles;
        this.precioAlquiler = precioAlquiler;
    }

    //Getters
    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getUnidadesDisponibles() {
        return unidadesDisponibles;
    }

    public boolean isEstado() {
        return estado;
    }

    public double getPrecioAlquiler() {
        return precioAlquiler;
    }

    public boolean isPrestado(){
        return prestado;
    }

    //Setters
    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    /**
     * Permite modificar las unidades disponibles de un objeto
     * @param unidadesNew
     */
    public void modificarUnidades(int unidadesNew){
        this.unidadesDisponibles = getUnidadesDisponibles() + unidadesNew;
        if (getUnidadesDisponibles()>0){
            this.estado = true;
        }
        if (getUnidadesDisponibles()==0){
            this.estado = false;
        }
    }
}

