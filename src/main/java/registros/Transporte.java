package registros;

import java.io.Serializable;
import java.util.Date;

public class Transporte extends Servicio implements Serializable{
    private String destino;
    private Date fechaHoraSalida;
    private int asientosDisponibles;
    //ListaCDE<Venta> venta;
    
    public Transporte(String[] datos, int precio, Date fecha, int asientosDisp, Oferta oferta){
        super(datos[0],datos[1],datos[2],precio,oferta);
        destino = datos[3];
        fechaHoraSalida = fecha;
        asientosDisponibles = asientosDisp;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setFechaHoraSalida(Date fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
    }

    public void setAsientosDisponibles(int asientosDisponibles) {
        this.asientosDisponibles = asientosDisponibles;
    }

    public String getDestino() {
        return destino;
    }

    public Date getFechaHoraSalida() {
        return fechaHoraSalida;
    }

    public int getAsientosDisponibles() {
        return asientosDisponibles;
    }

    @Override
    public String toStringList() {
        String res = "";
        res += super.getUbicacion();
        res += addTab(destino, 2);
        res += addTab(fechaHoraSalida.toString(), 2);
        res += addTab("" + asientosDisponibles, 1);
        res += addTab(super.getNombreEmpresa(), 2);
        return res;
    }

    @Override
    public int compareTo(Registro r) {
        int res;
        Transporte t = (Transporte) r;
        res = super.compareTo(r) * 100;
        res += destino.compareTo(t.getDestino()) * 10;
        res += fechaHoraSalida.compareTo(t.getFechaHoraSalida());
        return res;
    }
}