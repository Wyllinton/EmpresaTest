package co.edu.uniquindio.poo;

public class Cliente {
    private String documento;
    private String nombre;
    private String genero;
    private String ciudadResidencia;
    private TipoDocumento tipoDocumento;
    
    //Constructor
    public Cliente(String documento, String nombre, String genero, String ciudadResidencia, TipoDocumento tipoDocumento){
        assert documento != null;
        assert nombre != null;
        assert genero != null;
        assert ciudadResidencia != null;
        assert tipoDocumento != null;
        this.documento = documento;
        this.nombre = nombre;
        this.genero = genero;
        this.ciudadResidencia = ciudadResidencia;
        this.tipoDocumento = tipoDocumento;
    }

    //Getters
    public String getDocumento() {
        return documento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getGenero() {
        return genero;
    }

    public String getCiudadResidencia() {
        return ciudadResidencia;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    //Setters
    public void setCiudadResidencia(String ciudadResidencia) {
        assert ciudadResidencia != null;
        this.ciudadResidencia = ciudadResidencia;
    }
    //Se agregó un assert en setCiudadResidencia para poder hacer la prueba de datos nulos
}

