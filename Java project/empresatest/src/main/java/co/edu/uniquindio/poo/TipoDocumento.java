package co.edu.uniquindio.poo;

public enum TipoDocumento {
    CEDULA(0), PASAPORTE(1), CEDULA_EXTRANJERA(2);

    private TipoDocumento(int num){
        this.num = num;
    }

    public int getNum(){
        return num;
    }
    
    private Integer num;
}
