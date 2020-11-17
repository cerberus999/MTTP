package registros;

import java.io.Serializable;
import java.util.Date;

public class Transporte extends Servicio implements Serializable{
    private String destino;
    private Date fechaHoraSalida;
    private int asientosDisponibles;
    //ListaCDE<Venta> venta;
    
    public Transporte(String[] datos, String destino, String fecha, int asientosDisp){
        super(datos);
        this.destino = destino;
        fechaHoraSalida = new Date(fecha); //formato "mm/dd/aaaa hh:mm:ss";
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
        res += addTab(super.getUbicacion(), 2) ;
        res += addTab(destino, 2);
        res += addTab(fechaHoraSalida.toString(), 5);
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