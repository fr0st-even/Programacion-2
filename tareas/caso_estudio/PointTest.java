package service;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import service.Point;

public class PointTest {
    private Point point;

    @Before
    public void setUp() {
        point = new Point(1, 1);
    }

    @Test
    public void testPointSetPoint() {
        point.setPoint(4, 5);
        double esperadoX = 4;
        double obtenidoX = point.getX();
        assertEquals(esperadoX, obtenidoX, 0.01);
        double esperadoY = 5;
        double obtenidoY = point.getY();
        assertEquals(esperadoY, obtenidoY, 0.01);
    }

    @Test
    public void testPointGetX() {
        double esperado = 1;
        double obtenido = point.getX();
        assertEquals(esperado, obtenido, 0.01);
    }

    @Test
    public void testPointGetY() {
        double esperado = 1;
        double obtenido = point.getY();
        assertEquals(esperado, obtenido, 0.01);
    }

    @Test
    public void testPointGetName() {
        String esperado = "punto";
        String obtenido = point.getName();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testPointToString() {
        String esperado = "[1.0, 1.0]";
        String obtenido = point.toString();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testPointConstructor() {
        Point p = new Point(2, 3);
        double esperadoX = 2;
        double obtenidoX = p.getX();
        assertEquals(esperadoX, obtenidoX, 0.01);
        double esperadoY = 3;
        double obtenidoY = p.getY();
        assertEquals(esperadoY, obtenidoY, 0.01);
    }
}
