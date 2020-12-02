/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registros;

import java.io.Serializable;

public class Restaurante extends Servicio implements Serializable{
 
    private int cantEstrellas;
    private String tipoDeComida;

    public Restaurante(String args[]){
        super(new String[] {args[0],args[1],args[2],args[3],args[4],args[5]});
        cantEstrellas = Integer.parseInt(args[6]);
        tipoDeComida = args[7];
    }
    
    public Restaurante(String args){
        super(args);
        String datos[] = args.split(",");
        cantEstrellas = (Integer.parseInt(datos[1]));
    }
    
    public int getCantEstrellas() {
        return cantEstrellas;
    }

    public String getTipoDeComida() {
        return tipoDeComida;
    }

    public void setCantEstrellas(int cantEstrellas) {
        this.cantEstrellas = cantEstrellas;
    }

    public void setTipoDeComida(String tipoDeComida) {
        this.tipoDeComida = tipoDeComida;
    }
}
