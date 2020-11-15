package registros;

import java.io.Serializable;

/**
 * Write a description of class servicios here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Servicio implements Serializable{
    private String nombreEmpresa;
    private String rubro;
    private String numeroTelefono;
    private String eMail;
    private String ciudad;
    private String direccion;
    
    public Servicio(String nombreEmpresa, String rubro, String numeroTelefono,String eMail,String ciudad,String direccion){
        setNombreEmpresa(nombreEmpresa);
        setRubro(rubro);
        setNumeroTelefono(numeroTelefono);
        setEmail(eMail);
        setCiudad(ciudad);
        setDireccion(direccion);
    }
    
    public String getNombreEmpresa(){
        return nombreEmpresa;
    }
    
    public void setNombreEmpresa(String nombreEmpresa){
        this.nombreEmpresa = nombreEmpresa;
    }
    
    public String getRubro(){
        return rubro;
    }
    
    public void setRubro(String rubro){
        this.rubro = rubro;
    }
    
    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getEmail() {
        return eMail;
    }

    public void setEmail(String eMail) {
        this.eMail = eMail;
    }
    
    public String getCiudad(){
        return ciudad;
    }
    
    public void setCiudad(String ciudad){
        this.ciudad = ciudad;
    }
    
    public String getDireccion(){
        return direccion;
    }
    
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
}