package service;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LlantaTest {

    private Llanta llanta;

    @Before
    public void before() throws Exception {
        llanta = new Llanta();
    }

    @Test
    public void testSetRin() {
        llanta.setRin(18);
        assertEquals(18, llanta.getRin());
    }

    @Test
    public void testGetRIn(){
        int esperado = 10;
        int obtenido = llanta.getRin();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testToString() {
        String esperado = "llanta{\n" +
                "\trin :10\n" +
                "}";
        String obtenido = llanta.toString().toLowerCase();
        assertEquals(esperado,obtenido);
    }

}


