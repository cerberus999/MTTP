package registros;

import java.io.Serializable;

//falta reg

public class Servicio extends Registro implements Serializable{
    private String ubicacion;
    private String nombreEmpresa;
    private String numeroTelefono;
    private int precio;
    Oferta oferta;

    public Servicio(String ubicacion, String nombreEmpresa, String numeroTelf, int precio, Oferta oferta){
        this.ubicacion = ubicacion;
        this.nombreEmpresa = nombreEmpresa;
        numeroTelefono = numeroTelf;
        this.precio = precio;
        this.oferta = oferta;
    }
    
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setOferta(Oferta oferta) {
        this.oferta = oferta;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public int getPrecio() {
        return precio;
    }

    public Oferta getOferta() {
        return oferta;
    }

    public String getNombreEmpresa(){
        return nombreEmpresa;
    }
    
    public void setNombreEmpresa(String nombreEmpresa){
        this.nombreEmpresa = nombreEmpresa;
    }
    
    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    @Override
    public String toStringList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int compareTo(Registro r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}