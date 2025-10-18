package sevice;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import service.Shape;
import service.Point;

public class ShapeTest {
    private Shape shape;

    @Before
    public void setUp() {
        shape = new Point(0, 0);
    }

    @Test
    public void testShapeArea() {
        double esperado = 0.0;
        double obtenido = shape.area();
        assertEquals(esperado, obtenido, 0.01);
    }

    @Test
    public void testShapeVolume() {
        double esperado = 0.0;
        double obtenido = shape.volume();
        assertEquals(esperado, obtenido, 0.01);
    }

    @Test
    public void testShapeGetName() {
        String esperado = "punto";
        String obtenido = shape.getName();
        assertEquals(esperado, obtenido);
    }
}
