package registros;

import ed.ListaCDE;

import java.io.Serializable;


//falta reg

public class PaqueteTuristico implements Serializable
{
    private int precio;
    private Oferta oferta;
    private String lugar;   //Departamento
    private String nombre;
    private String descripcion;
    private ListaCDE<Servicio> listaServicios;
    private ListaCDE<String> itinerario;
    
    public PaqueteTuristico(int precio, String lugar, String nombre, String descripcion,int porcentajeDescuento, String descripcionDesc){
        this. precio = precio;
        this.lugar = lugar;
        this.nombre = nombre;
        this.descripcion = descripcion;
        oferta = new Oferta(porcentajeDescuento, descripcionDesc);
        listaServicios = null;
        itinerario = null;
    }
    public PaqueteTuristico(int precio, String lugar, String nombre, String descripcion,int porcentajeDescuento, String descripcionDesc, Servicio servicio, String itinerario){
        this. precio = precio;
        this.lugar = lugar;
        this.nombre = nombre;
        this.descripcion = descripcion;
        oferta = new Oferta(porcentajeDescuento, descripcionDesc);
        listaServicios.add(servicio);
        this.itinerario.add(itinerario);
    }
    
    public String printltinerario(int x){
        return itinerario.getPosition(x);
    }
    public String mostrarPrecios(){
        String monto;
        if(oferta == null){
            monto = "" + precio;
        }else{
            monto = "" + (precio - (precio * (oferta.getPorcentajeDesc())));
        }
        return monto;
    }
 
    public void getPrecio(int pre){
        precio = pre;
    }
    public int setPrecio(){
        int monto;
        if(oferta == null){
            monto = precio;
        }else{
            monto = precio - (precio * (oferta.getPorcentajeDesc()));
        }
        return monto;
    }
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
    public String getLugar() {
        return lugar;
    }
    public void getNombre(String nom){
        nombre = nom;
    }
    public String setNombre(){
        return nombre;
    }
    public void getDescripcion(String des){
        descripcion = des;
    }
    public String setDescripcion(){
        return descripcion;
    }
    public Oferta setOferta(){
        return oferta;
    }
    public void añadirServicio(Servicio x){
        listaServicios.add(x);
    }
    public Servicio setServicios(int x){
        return listaServicios.getPosition(x);
    }
    public void eliminarServicio(int x){
        listaServicios.remove(x);
    }
    public void añadirItinerario(String x){
        itinerario.add(x);
    }
    public String setItinerario(int x){
        return itinerario.getPosition(x);
    }
    public void eliminarItinerario(int x){
        itinerario.remove(x);
    }
}    