/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registros;

import java.io.Serializable;

public class Oferta implements Serializable{

    private String descripcion;
    private int porcentajeDescuento;
    
    public Oferta(int porcentDesc, String descripDesc) {
        descripcion = descripDesc;
        porcentajeDescuento = porcentDesc;
    }

    public int getPorcentajeDesc() {
        return porcentajeDescuento;
    }
}
