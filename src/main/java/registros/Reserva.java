package registros;

//faltaReg

import ed.*;
import java.io.Serializable;

public class Reserva extends Registro implements Serializable {
    private int codigoVuelo;
    private ListaCDE<String> asientos;
    private Cliente cliente;

    public Reserva(int codigoVuelo, ListaCDE<String> asientos,Cliente cliente){
        this.codigoVuelo=codigoVuelo;
        this.asientos=asientos;
        this.cliente=cliente;
    }

    public int getCodigoVuelo(){
        return codigoVuelo;
    }

    public ListaCDE<String> getAsientos(){
        return asientos;
    }
    //cambiar a cliente
    public Cliente getCliente(){
        return cliente;
    }

    public void setCodigoVuelo(int codigo){
        codigoVuelo=codigo;
    }

    public void setAsientos(ListaCDE<String> asientos){
        this.asientos=asientos;
    }
    //cambiar Cliente
    public void setCliente(Cliente cliente){
        this.cliente=cliente;
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
