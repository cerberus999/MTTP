package registros;

import ed.ListaCDE;

import java.io.Serializable;


public class PaqueteTuristico extends Registro implements Serializable
{
    private String lugar;   //Departamento
    private int precio;
    private String nombre;
    private String descripcion;
    private Oferta oferta;
    private ListaCDE<Servicio> listaServicios;
    private ListaCDE<String> itinerario;

    public PaqueteTuristico(String lugar, int precio, String nombre, String descripcion,int porcentajeDescuento, String descripcionDesc){
        this. precio = precio;
        this.lugar = lugar;
        this.nombre = nombre;
        this.descripcion = descripcion;
        if(porcentajeDescuento == 0 && descripcionDesc.equals("")) oferta = null;
        else oferta = new Oferta(porcentajeDescuento, descripcionDesc);
        listaServicios = new ListaCDE<Servicio>();
        itinerario = new ListaCDE<String>();
    }

    public int getPrecio() {
        return precio;
    }

    public Oferta getOferta() {
        return oferta;
    }

    public String getLugar() {
        return lugar;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public ListaCDE<Servicio> getListaServicios() {
        return listaServicios;
    }

    public ListaCDE<String> getItinerario() {
        return itinerario;
    }
    
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setOferta(Oferta oferta) {
        this.oferta = oferta;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setListaServicios(ListaCDE<Servicio> listaServicios) {
        this.listaServicios = listaServicios;
    }

    public void setItinerario(ListaCDE<String> itinerario) {
        this.itinerario = itinerario;
    }
    
    @Override
    public String toStringList() {
        String res = "";
        res += addTab(lugar, 2);
        res += addTab("" + precio + " BS", 1);
        res += addTab(nombre, 3);
        if(oferta != null)
            res += "SI\n";
        else
            res += "NO\n";
        res += descripcion;
        return res;
    }

    @Override
    public int compareTo(Registro r) {
        PaqueteTuristico p = (PaqueteTuristico) r;
        return (lugar.compareTo(p.getLugar()) * 10000) + (p.getPrecio()-precio);
    }
}    