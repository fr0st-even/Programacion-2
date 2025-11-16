package service;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

public class FlyLikeRocketTest {
    private FlyBehavior fr;
    private ByteArrayOutputStream out;

    @Before
    public void before() throws Exception {
        fr = new FlyLikeRocket();
        out = new ByteArrayOutputStream();
        System.setOut( new java.io.PrintStream( out ));
    }

    @Test
    public void fly() {
        fr.fly();
        assertTrue(out.toString().toLowerCase().contains("volar cual cohete y atacar como bolido"));
    }

    @Test
    public void testToString() {
        String esperado = "flylikerocket()";
        String obtenido = fr.toString().toLowerCase();
        assertEquals(esperado, obtenido);
    }
}