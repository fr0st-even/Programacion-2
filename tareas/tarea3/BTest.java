package service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BTest {
    private B b;

    @Before
    public void setUp() throws Exception {
        b = new B();
    }
    @Test
    public void testToSting (){
        String esperado = "b{}";
        String obtenido = b.toString().toLowerCase();
        assertEquals(esperado,obtenido);
    }

}