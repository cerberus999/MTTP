/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registros;

import java.io.Serializable;

/**
 *
 * @author Lenovo
 */
public abstract class Registro implements Comparable<Registro>, Serializable{
    private String comparador;
    
    public abstract String toStringList();
    public abstract int compareTo(Registro r);
}
