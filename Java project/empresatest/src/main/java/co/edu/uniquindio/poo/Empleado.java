package co.edu.uniquindio.poo;

public class Empleado {
    private String nombre;
    private String codigo;
    private String correo;
    private String aniosExperiancia;
    
    //Constructor 
    public Empleado(String nombre, String codigo, String correo, String aniosExperiencia){
        assert nombre != null;
        assert codigo != null;
        assert correo != null;
        assert aniosExperiencia != null;
        this.nombre = nombre;
        this.codigo = codigo;
        this.correo = correo;
        this.aniosExperiancia = aniosExperiencia;
    }

    //Getters
    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getCorreo() {
        return correo;
    }

    public String getAniosExperiancia() {
        return aniosExperiancia;
    }    
}

