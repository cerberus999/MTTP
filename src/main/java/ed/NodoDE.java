package ed;

import java.io.Serializable;

public class NodoDE <T> implements Serializable{
    NodoDE<T> ant;
    T dato;
    NodoDE<T> sig;
    int index;
    
    public NodoDE(T dato){
        this.dato = dato;
        ant = null;
        sig = null;
    }
    
    public T getDato(){
        return dato;
    }
    
    public NodoDE<T> getAnt(){
        return ant;
    }
    
    public NodoDE<T> getSig(){
        return sig;
    }
    
    public void setAnt(NodoDE<T> n){
        ant = n;
    }
    
    public void setSig(NodoDE<T> n){
        sig = n;
    }
    
    public void setIndex(int n){
        index = n;
    }
    
    public int getIndex(){
        return index;   
    }
}
