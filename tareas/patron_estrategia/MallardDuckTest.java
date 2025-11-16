package service;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;

public class MallardDuckTest {
    private Duck d1;//referenciacon
    private ByteArrayOutputStream coo;

    @Before
    public void before() throws Exception {
        d1 = new MallardDuck();//instanciacion
        coo = new ByteArrayOutputStream();
        System.setOut( new java.io.PrintStream(coo));
    }

    @Test
    public void testDisplay() {
        d1.display();
        assertTrue(coo.toString().toLowerCase().contains("quak"));
    }
    @Test
    public void testSwim() {
        d1.swim();
        assertTrue(coo.toString().toLowerCase().contains("nadar"));
    }
    @Test
    public void testFly() {
        d1.performfly();
        assertTrue(coo.toString().toLowerCase().contains("volar"));
    }
    @Test
    public void testQuack() {
        d1.Quack();
        assertTrue(coo.toString().contains("Quack"));
    }

    @Test
    public void testToString() {
        String esperado = "mallardduck()";
        String obtenido = d1.toString().toLowerCase();
        assertEquals(esperado, obtenido);
    }
    //prueba unitaria de la asignacion de comportamientos en tiempo de ejecucion//

    @Test
    public void testPerformNewFlyBehaviorInJIT(){
        d1.performfly();
        d1.setFlyBehavior(new FlyNoWay());
        d1.performfly();
        assertTrue(coo.toString().toLowerCase().contains("no puede volar"));
    }
    @Test
    public void testQuakNewSoundBehaviorInJIT(){
        d1.Quack();
        d1.setSoundBehavior(new muteSound());
        d1.Quack();
        assertTrue(coo.toString().toLowerCase().contains("... ..."));

    }
}