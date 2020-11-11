/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registros;

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
public class ClienteTest {
    
    public ClienteTest() {
    }

    @org.junit.BeforeClass
    public static void setUpClass() throws Exception {
    }

    @org.junit.AfterClass
    public static void tearDownClass() throws Exception {
    }

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void TestComparteTo01()
    {
        Cliente cliente1 = new Cliente(new String[] {"89572924","","","",""});
        Cliente cliente2 = new Cliente(new String[] {"404624","","","",""});
        assertEquals(200, cliente1.compareTo(cliente2));
    }
    
    @Test
    public void TestComparteTo0()
    {
        Cliente cliente1 = new Cliente(new String[] {"404624","","","",""});
        Cliente cliente2 = new Cliente(new String[] {"89572924","","","",""});
        assertEquals(-200, cliente1.compareTo(cliente2));
    }
    
    @Test
    public void TestComparteTo1()
    {
        Cliente cliente1 = new Cliente(new String[] {"12404624","","","",""});
        Cliente cliente2 = new Cliente(new String[] {"89572924","","","",""});
        assertEquals(-70, cliente1.compareTo(cliente2));
    }
    
    @Test
    public void TestComparteTo2()
    {
        Cliente cliente1 = new Cliente(new String[] {"19404624","","","",""});
        Cliente cliente2 = new Cliente(new String[] {"12572924","","","",""});
        assertEquals(71, cliente1.compareTo(cliente2));
    }
    
    @Test
    public void TestComparteTo3()
    {
        Cliente cliente1 = new Cliente(new String[] {"1940462C","","","",""});
        Cliente cliente2 = new Cliente(new String[] {"1940462A","","","",""});
        assertEquals(27, cliente1.compareTo(cliente2));
    }
    @Test
    public void TestComparteTo4()
    {
        Cliente cliente1 = new Cliente(new String[] {"1940462C","","","",""});
        Cliente cliente2 = new Cliente(new String[] {"1940462C","","","",""});
        assertEquals(0, cliente1.compareTo(cliente2));
    }
    
}
