/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lenovo
 */
public class ListaCDETest {
    
    public ListaCDETest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of isEmpty method, of class ListaCDE.
     */
     NodoDE<Integer> aux = null;

    @Test
    public void addIndex()
    {
        ListaCDE<Integer> listaDE1 = new ListaCDE<Integer>();
        assertEquals(false, listaDE1.add(2, 90));
        assertEquals(0, listaDE1.size());        
        assertEquals(true, listaDE1.add(0, 800));
        assertEquals(1, listaDE1.size());
        aux = null;
        for(int i=0;i<listaDE1.size();i++){
            aux = listaDE1.getNodo(i,aux);
            assertEquals(aux.getIndex(), i);
        }
        assertEquals(true, listaDE1.add(1, 500));
        assertEquals(2, listaDE1.size());
        aux = null;
        for(int i=0;i<listaDE1.size();i++){
            aux = listaDE1.getNodo(i,aux);
            assertEquals(aux.getIndex(), i);
        }
        assertEquals(true, listaDE1.add(1, 90));
        assertEquals(3, listaDE1.size());
        aux = null;
        for(int i=0;i<listaDE1.size();i++){
            aux = listaDE1.getNodo(i,aux);
            assertEquals(aux.getIndex(), i);
        }
        assertEquals(new Integer(800), listaDE1.getPosition(0));
        assertEquals(new Integer(90), listaDE1.getPosition(1));
        assertEquals(new Integer(500), listaDE1.getPosition(2));
        assertEquals(true, listaDE1.add(0, 100));
        assertEquals(4, listaDE1.size());
        aux = null;
        for(int i=0;i<listaDE1.size();i++){
            aux = listaDE1.getNodo(i,aux);
            assertEquals(aux.getIndex(), i);
        }
        assertEquals(new Integer(100), listaDE1.getPosition(0));
        assertEquals(new Integer(800), listaDE1.getPosition(1));
        assertEquals(true, listaDE1.add(4, 40));
        assertEquals(5, listaDE1.size());
        aux = null;
        for(int i=0;i<listaDE1.size();i++){
            aux = listaDE1.getNodo(i,aux);
            assertEquals(aux.getIndex(), i);
        }
        assertEquals(new Integer(500), listaDE1.getPosition(3));
    }

    @Test
    public void removeTest1(){
        ListaCDE<Integer> listaDE1 = new ListaCDE<Integer>();
        assertEquals(true, listaDE1.add(800));
        assertEquals(true, listaDE1.add(500));
        assertEquals(true, listaDE1.add(90));
        assertEquals(true, listaDE1.add(100));
        assertEquals(true, listaDE1.add(40));
        assertEquals(new Integer(800), listaDE1.remove(0));
        assertEquals(4, listaDE1.size());
        aux = null;
        for(int i=0;i<listaDE1.size();i++){
            aux = listaDE1.getNodo(i,aux);
            assertEquals(aux.getIndex(), i);
        }
        assertEquals(new Integer(500), listaDE1.getPosition(0));
    }

    @Test
    public void removeTest2()    {
        ListaCDE<Integer> listaDE1 = new ListaCDE<Integer>();
        assertEquals(true, listaDE1.add(800));
        assertEquals(true, listaDE1.add(500));
        assertEquals(true, listaDE1.add(90));
        assertEquals(true, listaDE1.add(100));
        assertEquals(true, listaDE1.add(40));    
        assertEquals(new Integer(90), listaDE1.remove(2));
        assertEquals(4, listaDE1.size());
        aux = null;
        for(int i=0;i<listaDE1.size();i++){
            aux = listaDE1.getNodo(i,aux);
            assertEquals(aux.getIndex(), i);
        }
        assertEquals(new Integer(100), listaDE1.getPosition(2));
    }

    @Test
    public void removeTest3(){
        ListaCDE<Integer> listaDE1 = new ListaCDE<Integer>();
        assertEquals(true, listaDE1.add(800));
        assertEquals(true, listaDE1.add(500));

        assertEquals(new Integer(500), listaDE1.remove(1));
        assertEquals(1, listaDE1.size());
        aux = null;
        for(int i=0;i<listaDE1.size();i++){
            aux = listaDE1.getNodo(i,aux);
            assertEquals(aux.getIndex(), i);
        }
        assertEquals(new Integer(800), listaDE1.getPosition(0));

        listaDE1.remove(0);
        assertEquals(0, listaDE1.size());
        aux = null;
        for(int i=0;i<listaDE1.size();i++){
            aux = listaDE1.getNodo(i,aux);
            assertEquals(aux.getIndex(), i);
        }
        assertEquals(true, listaDE1.isEmpty());

        assertEquals(null, listaDE1.remove(5));
        assertEquals(0, listaDE1.size());
        aux = null;
        for(int i=0;i<listaDE1.size();i++){
            aux = listaDE1.getNodo(i,aux);
            assertEquals(aux.getIndex(), i);
        }
    }
}
