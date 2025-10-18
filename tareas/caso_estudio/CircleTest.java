package service;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import service.Circle;

public class CircleTest {
    private Circle circle;

    @Before
    public void setUp() {
        circle = new Circle(5, 2, 3);
    }

    @Test
    public void testCircleConstructor() {
        double esperadoRadio = 5;
        double obtenidoRadio = circle.getRadius();
        assertEquals(esperadoRadio, obtenidoRadio, 0.01);
        double esperadoX = 2;
        double obtenidoX = circle.getX();
        assertEquals(esperadoX, obtenidoX, 0.01);
        double esperadoY = 3;
        double obtenidoY = circle.getY();
        assertEquals(esperadoY, obtenidoY, 0.01);
    }

    @Test
    public void testCircleSetRadius() {
        circle.setRadius(8);
        double esperado = 8;
        double obtenido = circle.getRadius();
        assertEquals(esperado, obtenido, 0.01);
    }

    @Test
    public void testCircleSetRadiusNegative() {
        circle.setRadius(-5);
        double esperado = 0;
        double obtenido = circle.getRadius();
        assertEquals(esperado, obtenido, 0.01);
    }

    @Test
    public void testCircleArea() {
        double esperado = 78.53975;
        double obtenido = circle.area();
        assertEquals(esperado, obtenido, 0.01);
    }

    @Test
    public void testCircleGetName() {
        String esperado = "círculo";
        String obtenido = circle.getName();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testCircleToString() {
        String esperado = "Centro = [2.0, 3.0]; Radio = 5.0";
        String obtenido = circle.toString();
        assertEquals(esperado, obtenido);
    }
}
