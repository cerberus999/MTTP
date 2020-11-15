package ed;



public class ListaDE<T>{
    private NodoDE<T> inicio;
    private int size = 0;

    public ListaDE(){
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
            size++;
            nuevo.setIndex(0);
            refresh(nuevo);
        }
        else
            add(nuevo,inicio);
        return true;
    }

    private boolean add(NodoDE<T> nuevo, NodoDE<T> nodoAnt){
        if(nodoAnt.getSig() == null){
            nodoAnt.setSig(nuevo);
            nuevo.setAnt(nodoAnt);
            size++;
            nuevo.setIndex(0);
            refresh(nuevo);
        }
        else
            add(nuevo,nodoAnt.getSig());
        return true;
    }

    public boolean add(int index, T dato){
        boolean res = false;
        NodoDE<T> nuevo = new NodoDE<T>(dato);
        if(isEmpty()){
            if(index == 0){
                res = true;
                inicio = nuevo;
                size++;
                nuevo.setIndex(0);
            }
        }else if(!isEmpty()){
            if(index == 0){
                res = true;
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
        if(nodoAnt.getSig() == null){
            if(index == 0){
                res = true;
                nodoAnt.setSig(nuevo);
                nuevo.setAnt(nodoAnt);
                size++;
                refresh(nuevo);
            }
        }else{
            if(index == 0){
                res = true;
                nuevo.setSig(nodoAnt.getSig());
                nuevo.setAnt(nodoAnt);
                nodoAnt.setSig(nuevo);
                size++;
                refresh(nuevo);
            }else if(index > 0){
                res = add(index-1,nuevo,nodoAnt.getSig());
            }
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
                if(inicio.getSig() != null){
                    inicio = inicio.getSig();
                    inicio.setAnt(null);
                    refresh(inicio);
                }else{
                    inicio = null;
                }
            }else{ 
                if(inicio.getSig() != null)
                    res = remove(index-1,inicio);
            }
        }
        return res;
    }

    private T remove(int index, NodoDE<T> nodoAnt){
        T res = null;
        if(index == 0){
            if(nodoAnt.getSig() != null){
                res = nodoAnt.getSig().getDato();
                nodoAnt.setSig(nodoAnt.getSig().getSig());
                if(nodoAnt.getSig() != null)
                    nodoAnt.getSig().setAnt(nodoAnt);
            }
            size--;
            refresh(nodoAnt);
        }else{
            if(nodoAnt.getSig() != null)
                res = remove(index-1, nodoAnt.getSig());
        }
        return res;
    }

    public void clear(){
        inicio = null;
    }

    private void refresh(NodoDE<T> nodo){
        if(nodo.getAnt() != null)
            nodo.setIndex(nodo.getAnt().getIndex() + 1);
        else 
            nodo.setIndex(0);
        if(nodo.getSig() != null)
            refresh(nodo.getSig());
        else
            nodo.setIndex(size-1);
    }

    public NodoDE getNodo(int indexDest, NodoDE<T> nodoAct){
        NodoDE<T> res = null;
        if(!isEmpty()){
            if(indexDest == 0)  
                res = inicio;
            else{
                int indAct = nodoAct.getIndex();
                if(indAct == indexDest)
                    res = nodoAct;    
                else if(indAct < indexDest && nodoAct.getSig() != null)
                    res = getNodo(indexDest,nodoAct.getSig());
                else if(indAct > indexDest && nodoAct.getAnt() != null)
                    res = getNodo(indexDest,nodoAct.getAnt());
            }
        }
        return res;
    }
    
}