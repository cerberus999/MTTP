package registros;

//faltaReg

import ed.*;
import java.io.Serializable;

public class Reserva extends Registro implements Serializable {
    private int codReserva;
    private int nroDePersonas;
    private Cliente cliente;

    public Reserva(String arg1,String arg2 ,Cliente cliente){
        Integer i = 0;
        i.parseInt(arg1);
        this.codReserva = i.intValue();
        i.parseInt(arg2);
        this.nroDePersonas = i.intValue();
        this.cliente = cliente;
    }
    
    public void setCodReserva(int codReserva) {
        this.codReserva = codReserva;
    }

    public void setNroDePersonas(int nroDePersonas) {
        this.nroDePersonas = nroDePersonas;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getCodReserva() {
        return codReserva;
    }

    public int getNroDePersonas() {
        return nroDePersonas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public String toStringList() {
        String res = "";
        res = addTab("" + codReserva, 2) + addTab("" + nroDePersonas, 1) + "Reserva a nombre de:/n";
        res = cliente.toStringList();
        return res;
    }

    @Override
    public int compareTo(Registro r) {
        Reserva re = (Reserva) r;
        int res = re.getCodReserva() - codReserva;
        return res;
    }
}
