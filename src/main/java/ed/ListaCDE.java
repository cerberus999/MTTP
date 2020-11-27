package ed;

import java.io.Serializable;

public class ListaCDE<T> implements Serializable{
    private NodoDE<T> inicio;
    private int size = 0;

    public ListaCDE(){ 
        inicio = null;
    }

    public boolean isEmpty(){
        boolean res = false;
        if(inicio == null)
            res = true;
        return res;
    }

    public int size(){
        return size;
    }

    public boolean add(T dato){
        NodoDE<T> nuevo = new NodoDE<T>(dato);
        if(isEmpty()){
            inicio = nuevo;
            nuevo.setSig(inicio);
            nuevo.setAnt(inicio);
            nuevo.setIndex(0);
        }
        else{
            nuevo.setAnt(inicio.getAnt());
            inicio.getAnt().setSig(nuevo);
            inicio.setAnt(nuevo);
            nuevo.setSig(inicio);
        }
        size++;
        refresh(nuevo);
        return true;
    }

    public boolean add(int index, T dato){
        boolean res = false;
        NodoDE<T> nuevo = new NodoDE<T>(dato);
        if(isEmpty()){
            if(index == 0){
                res = true;
                inicio = nuevo;
                nuevo.setSig(inicio);
                nuevo.setAnt(inicio);
                size++;
                nuevo.setIndex(0);
            }
        }else if(!isEmpty()){
            if(index == 0){
                res = true;
                inicio.getAnt().setSig(nuevo);
                nuevo.setAnt(inicio.getAnt());
                inicio.setAnt(nuevo);
                nuevo.setSig(inicio);
                inicio = nuevo;
                size++;
                nuevo.setIndex(0);
                refresh(nuevo);
            }else{ 
                res = add(index-1, nuevo, inicio);
            }
        }
        return res;
    }

    private boolean add(int index, NodoDE<T> nuevo, NodoDE<T> nodoAnt){
        boolean res = false;
        if(index == 0){
            res = true;
            addNodo(nodoAnt, nuevo);
            size++;
            refresh(nuevo);
        }
        else if(index > 0){
            res = add(index-1,nuevo,nodoAnt.getSig());
        }
        return res;
    }

    public T getPosition(int pos){
        T res = null;
        int ind = 1;
        if(pos == 0)
            res = inicio.getDato();
        else{
            if(inicio.getSig() != null){
                res = getPosition(inicio.getSig(), pos ,ind);
            }
        }
        return res;
    }

    private T getPosition(NodoDE<T> nodoAct, int pos, int ind){
        T res = null;
        if(pos == ind)
            res = nodoAct.getDato();
        else if(nodoAct.getSig() != null)
            res = getPosition(nodoAct.getSig(), pos, ind+1);
        return res;
    }

    public T remove(int index){
        T res = null;
        if(!isEmpty()){
            if(index == 0){
                size--;
                res = inicio.getDato();
                if(!inicio.getSig().equals(inicio)){
                    inicio.getSig().setAnt(inicio.getAnt());
                    inicio.getAnt().setSig(inicio.getSig());
                    inicio = inicio.getSig();
                    refresh(inicio);
                }else{
                    inicio = null;
                }
            }else{ 
                if(!inicio.getSig().equals(inicio))
                    res = remove(index-1,inicio);
            }
        }
        return res;
    }

    private T remove(int index, NodoDE<T> nodoAnt){
        T res = null;
        if(index == 0){
            res = nodoAnt.getSig().getDato();
            nodoAnt.getSig().setAnt(nodoAnt);
            nodoAnt.setSig(nodoAnt.getSig().getSig());
            size--;
            refresh(nodoAnt);
        }
        else if(!nodoAnt.getSig().equals(inicio))
            res = remove(index-1, nodoAnt.getSig());
        return res;
    }

    public void clear(){
        inicio = null;
    }

    //Actualiza los indices los elementos de la ListaCDE
    private void refresh(NodoDE<T> nodo){
        if(!nodo.getAnt().equals(inicio.getAnt()))
            nodo.setIndex(nodo.getAnt().getIndex() + 1);
        else 
            nodo.setIndex(0);
        if(!nodo.getSig().equals(inicio))
            refresh(nodo.getSig());
        else
            nodo.setIndex(size-1);
    }

    //Retorna un nodo en la posicion indexDest teniendo de punto de partida nodoAct
    public NodoDE getNodo(int indexDest, NodoDE<T> nodoAct){
        NodoDE<T> res = null;
        if(!isEmpty()){
            if(indexDest == 0)  
                res = inicio;
            else if(nodoAct == null){
                res = getNodo(indexDest,inicio);
            }else{
                int indAct = nodoAct.getIndex();
                if(indAct == indexDest)
                    res = nodoAct;    
                else if(indAct < indexDest && !nodoAct.getSig().equals(inicio))
                    res = getNodo(indexDest,nodoAct.getSig());
                else if(indAct > indexDest && !nodoAct.getAnt().equals(inicio))
                    res = getNodo(indexDest,nodoAct.getAnt());
            }
        }
        return res;
    }

    public String toString(){
        String res = "";
        NodoDE<T> x = null;
        for(int i=0;i<size;i++){
            x = getNodo(i, x);
            res += x.getDato().toString();
        }
        return res;
     }

    //Introduce un nuevo nodo "nuevo" despues de nodoAnt y actualiza los indices siguientes al nodo
    public boolean addNodo(NodoDE<T> nodoAnt, NodoDE<T> nuevo){
        if(isEmpty()){
            inicio = nuevo;
            inicio.setSig(nuevo);
            inicio.setAnt(nuevo);
        }else{
            nodoAnt.getSig().setAnt(nuevo);
            nuevo.setSig(nodoAnt.getSig());
            nodoAnt.setSig(nuevo);
            nuevo.setAnt(nodoAnt);
        }refresh(nuevo);
        return true;
    }
    
}