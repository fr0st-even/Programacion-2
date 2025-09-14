package service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LugarTest {

    private Lugar lugar;

    @Before
    public void before() throws Exception {
        lugar = new Lugar();
    }

    @Test
    public void testGetNombre() {
        String esperado = "";
        String obtenido = lugar.getNombre();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testSetNombre() {
        lugar.setNombre("Antigua Guatemala");
        String esperado = "Antigua Guatemala";
        String obtenido = lugar.getNombre();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testGetDireccion() {
        String esperado = "";
        String obtenido = lugar.getDireccion();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testSetDireccion() {
        lugar.setDireccion("Sacatepequez");
        String esperado = "Sacatepequez";
        String obtenido = lugar.getDireccion();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testGetTelefono() {
        String esperado = "";
        String obtenido = lugar.getTelefono();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testSetTelefono() {
        lugar.setTelefono("78451234");
        String esperado = "78451234";
        String obtenido = lugar.getTelefono();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testToString() {
        String esperado = "lugar{nombre='', direccion='', telefono=''}";
        String obtenido = lugar.toString().toLowerCase();
        assertEquals(esperado, obtenido);
    }
}