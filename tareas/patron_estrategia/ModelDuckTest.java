package service;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

public class ModelDuckTest {
    private Duck d1;
    private ByteArrayOutputStream coo;

    @Before
    public void before() throws Exception {
        d1 = new ModelDuck();
        coo = new ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(coo));
    }

    @Test
    public void testDisplay() {
        d1.display();
        assertTrue(coo.toString().toLowerCase().contains("... ..."));
    }

    @Test
    public void testPerformFly() {
        d1.performfly();
        assertTrue(coo.toString().toLowerCase().contains("volar cual cohete y atacar como bolido"));
    }

    @Test
    public void testMuteSound() {
        d1.Quack();
        assertTrue(coo.toString().contains("... ..."));
    }

    @Test
    public void testToString() {
        String esperado = "modelduck()";
        String obtenido = d1.toString().toLowerCase();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testQuakNewSoundBehaviorInJIT() {
        d1.Quack();
        d1.setSoundBehavior(new Squeak());
        d1.Quack();
        assertTrue(coo.toString().toLowerCase().contains("squeak"));
    }
    @Test
    public void testPerformNewFlyBehaviorInJIT() {
        d1.performfly();
        d1.setFlyBehavior(new FlyNoWay());
        d1.performfly();
        assertTrue(coo.toString().toLowerCase().contains("no puede volar"));
    }
}