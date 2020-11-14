package registros;

import java.io.Serializable;
import java.util.Date;



public class Transporte extends Registro implements Serializable{
    private String destino;
    private Date fechaHoraSalida;
    private int asientosDisponibles;
    //ListaCDE<Venta> venta;

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
        res += addTab(destino, 2);
        res += addTab(fechaHoraSalida.toString(), 2);
        res += asientosDisponibles;
        return res;
    }

    @Override
    public int compareTo(Registro r) {
        int res = 0;
        Transporte t = (Transporte) r;
        res = destino.compareTo(t.getDestino()) * 10;
        res += fechaHoraSalida.compareTo(t.getFechaHoraSalida());
        return res;
    }
}