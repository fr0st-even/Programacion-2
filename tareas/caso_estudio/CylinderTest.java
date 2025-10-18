package service;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import service.Cylinder;

public class CylinderTest {
    private Cylinder cylinder;

    @Before
    public void setUp() {
        cylinder = new Cylinder(10, 5, 2, 3);
    }

    @Test
    public void testCylinderConstructor() {
        double esperado = 10;
        double obtenido = cylinder.getHeight();
        assertEquals(esperado, obtenido, 0.01);
        double esperadoRadio = 5;
        double obtenidoRadio = cylinder.getRadius();
        assertEquals(esperadoRadio, obtenidoRadio, 0.01);
    }

    @Test
    public void testCylinderSetHeight() {
        cylinder.setHeight(15);
        double esperado = 15;
        double obtenido = cylinder.getHeight();
        assertEquals(esperado, obtenido, 0.01);
    }

    @Test
    public void testCylinderSetHeightNegative() {
        cylinder.setHeight(-10);
        double esperado = 0;
        double obtenido = cylinder.getHeight();
        assertEquals(esperado, obtenido, 0.01);
    }

    @Test
    public void testCylinderArea() {
        double esperado = 471.2385;
        double obtenido = cylinder.area();
        assertEquals(esperado, obtenido, 0.01);
    }

    @Test
    public void testCylinderVolume() {
        double esperado = 785.795;
        double obtenido = cylinder.volume();
        assertEquals(esperado, obtenido, 0.01);
    }

    @Test
    public void testCylinderGetName() {
        String esperado = "cilindro";
        String obtenido = cylinder.getName();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testCylinderToString() {
        String esperado = "Círculo = {Centro = [2.0, 3.0]; Radio = 5.0}; Altura = 10.0";
        String obtenido = cylinder.toString();
        assertEquals(esperado, obtenido);
    }
}
