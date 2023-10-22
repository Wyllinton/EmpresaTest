package co.edu.uniquindio.poo;

public class DetallePrestamo {
    private int unidadesPrestadas;
    private double subTotal;
    private Objeto objeto;
    
    //Constructor 
    public DetallePrestamo(int unidadesPrestadas, double subTotal, Objeto objeto){
        assert objeto.isEstado();
        assert unidadesPrestadas <= objeto.getUnidadesDisponibles(): "Las unidades prestadas supera a las unidades disponibles";
        assert unidadesPrestadas > 0: "Las unidades prestadas deben ser mayores que cero";
        assert subTotal > 0;
        assert objeto != null;
        this.unidadesPrestadas = unidadesPrestadas;
        this.subTotal = subTotal;
        this.objeto = objeto;
        objeto.modificarUnidades(-unidadesPrestadas);
    }

    //Getters
    public int getUnidadesPrestadas() {
        return unidadesPrestadas;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public Objeto getObjeto() {
        return objeto;
    }
}
