package registros;

import java.io.Serializable;

public class Servicio extends Registro implements Serializable{
    private String ubicacion;
    private String nombreEmpresa;
    private String numeroTelefono;
    private int precio;
    Oferta oferta;

    public Servicio(String[] datos){
        ubicacion = datos[0];
        nombreEmpresa = datos[1];
        numeroTelefono = datos[2];
        precio = Integer.parseInt(datos[3]);
        oferta = new Oferta(Integer.parseInt(datos[4]),datos[5]);
    }
    
    public Servicio(String args){
        String datos[] = args.split(",");
        ubicacion = datos[0];
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
        String res = "";
        res += addTab(ubicacion, 2);
        res += addTab(nombreEmpresa, 3);
        res += addTab(numeroTelefono, 3);
        res += addTab("" + precio, 2);
        res += oferta == null? "0":"" + oferta.getPorcentajeDesc();
        return res;
    }

    @Override
    public int compareTo(Registro r) {
        Servicio s = (Servicio) r;
        int res = ubicacion.compareTo(s.getUbicacion());
        return res;
    }
}