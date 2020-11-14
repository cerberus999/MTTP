package registros;

import java.io.Serializable;



public class Transporte implements Serializable{
    private int codigo;
    private String nombreEmpresa;
    private int nit;
    private int telefono;
    private String email;
    private String fechaHoraSalida;
    private String origen;
    private String destino;
    private int asientoDisponibles;
    int precio;

    /**
     * Constructor for objects of class Flota
     */
    
     public Transporte(int codigo, String nombreEmpresa, int nit, int telefono,String email,String fechaHoraSalida,String origen,String destino,int asientoDisponibles,int precio){
        setCodigo(codigo);
        setNombreEmpresa(nombreEmpresa);
        setNit(nit);
        setEmail(email);
        setFechaHoraSalida(fechaHoraSalida);
        setOrigen(origen);
        setDestino(destino);
        setAsientoDisponibles(asientoDisponibles);
        setPrecio(precio);
    }
    public Transporte()
    {
        // initialise instance variables
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public String nombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }
    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getFechaHoraSalida() {
        return email;
    }

    public void setFechaHoraSalida(String fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
    }
    
    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

     public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
    
    public int asientoDisponibles() {
        return asientoDisponibles;
    }

    public void setAsientoDisponibles(int asientoDisponibles) {
        this.asientoDisponibles = asientoDisponibles;
    }
    
    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int Precio) {
        this.precio = precio;
    }
}
