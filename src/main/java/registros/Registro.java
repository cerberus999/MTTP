/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registros;

import java.io.Serializable;

public abstract class Registro implements Comparable<Registro>, Serializable{
    
    public abstract String toStringList();
    public abstract int compareTo(Registro r);
    
    protected String addTab(String string,int tabs){
        int aux = string.length();
        tabs = tabs - (aux / 8);
        while(tabs > 0){
            string = string + "\t";
            tabs--;
        }
        return string;
    }
}
