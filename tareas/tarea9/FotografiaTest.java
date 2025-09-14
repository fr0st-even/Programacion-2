package service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FotografiaTest {

    private Fotografia fotografia;

    @Before
    public void before() throws Exception {
        fotografia = new Fotografia();
    }

    @Test
    public void testGetTipoArchivo() {
        String esperado = "jpg";
        String obtenido = fotografia.getTipoArchivo();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testSetTipoArchivo() {
        fotografia.setTipoArchivo("png");
        String esperado = "png";
        String obtenido = fotografia.getTipoArchivo();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testGetPathArchivo() {
        String esperado = "";
        String obtenido = fotografia.getPathArchivo();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testSetPathArchivo() {
        String path = "/fotos/vacaciones.jpg";
        fotografia.setPathArchivo(path);
        String esperado = "/fotos/vacaciones.jpg";
        String obtenido = fotografia.getPathArchivo();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testGetTamanoKbytes() {
        double esperado = 10.0;
        double obtenido = fotografia.getTamanoKbytes();
        assertEquals(esperado, obtenido, 0.001);
    }

    @Test
    public void testSetTamanoKbytes() {
        fotografia.setTamanoKbytes(50.5);
        double esperado = 50.5;
        double obtenido = fotografia.getTamanoKbytes();
        assertEquals(esperado, obtenido, 0.001);
    }

    @Test
    public void testSetTamanoKbytesInvalido() {
        fotografia.setTamanoKbytes(-5.0);
        double esperado = 10.0;
        double obtenido = fotografia.getTamanoKbytes();
        assertEquals(esperado, obtenido, 0.001);
    }

    @Test
    public void testToString() {
        String esperado = "fotografia{tipoarchivo='jpg', patharchivo='', tamanokbytes=10.0}";
        String obtenido = fotografia.toString().toLowerCase();
        assertEquals(esperado, obtenido);
    }
}