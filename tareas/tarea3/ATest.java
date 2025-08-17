package service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ATest {

    private A a;

    @Before
    public void before() throws Exception{
        a = new A();
    }

    @Test
    public void testGetB(){
        B esperado = new B();
        B obtenido = a.getB();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testSetB() {
        B b = new B();
        a.setB(b);
        B esperado = new B();
        B obtenido = a.getB();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testToString() {
        String esperado = "a{b=b{}}";
        String obtenido = a.toString().toLowerCase();
        assertEquals(esperado, obtenido);
    }

}