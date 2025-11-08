package service;

import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

public class CafeTest {

    private Cafe cafe;
    private ByteArrayOutputStream salida;

    @Before
    public void setUp() {
        cafe = new Cafe();
        salida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(salida));
    }

    @Test
    public void testConstructorPorDefecto() {
        String esperado = "Arábica";
        String obtenido = cafe.getTipoGrano();
        assertEquals(esperado, obtenido);

        int esperadoAgua = 250;
        int obtenidoAgua = cafe.getAgua();
        assertEquals(esperadoAgua, obtenidoAgua);

        int esperadoTemp = 95;
        int obtenidoTemp = cafe.getTemperatura();
        assertEquals(esperadoTemp, obtenidoTemp);
    }

    @Test
    public void testConstructorConTipoGrano() {
        Cafe cafe2 = new Cafe("Colombiano");
        String esperado = "Colombiano";
        String obtenido = cafe2.getTipoGrano();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testConstructorCompleto() {
        Cafe cafe3 = new Cafe(300, 90, "Robusta");
        String esperado = "Robusta";
        String obtenido = cafe3.getTipoGrano();
        assertEquals(esperado, obtenido);

        int esperadoAgua = 300;
        int obtenidoAgua = cafe3.getAgua();
        assertEquals(esperadoAgua, obtenidoAgua);
    }

    @Test
    public void testGetTipoGrano() {
        String esperado = "Arábica";
        String obtenido = cafe.getTipoGrano();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testSetTipoGrano() {
        cafe.setTipoGrano("Etíope");
        String esperado = "Etíope";
        String obtenido = cafe.getTipoGrano();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testSetTipoGranoNull() {
        cafe.setTipoGrano(null);
        String esperado = "Arábica";
        String obtenido = cafe.getTipoGrano();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testSetTipoGranoVacio() {
        cafe.setTipoGrano("");
        String esperado = "Arábica";
        String obtenido = cafe.getTipoGrano();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testPrepararIngrediente() {
        cafe.prepararIngrediente();
        String resultado = salida.toString();
        assertTrue(resultado.contains("Moliendo granos de café"));
        assertTrue(resultado.contains("Filtrando café"));
    }

    @Test
    public void testAgregarCondimentos() {
        cafe.agregarCondimentos();
        String resultado = salida.toString();
        assertTrue(resultado.contains("Agregando azúcar y leche"));
    }

    @Test
    public void testPrepararBebidaCompleto() {
        cafe.prepararBebida();
        String resultado = salida.toString();

        assertTrue(resultado.contains("Hirviendo"));
        assertTrue(resultado.contains("Moliendo granos"));
        assertTrue(resultado.contains("Sirviendo en la taza"));
        assertTrue(resultado.contains("Agregando azúcar"));
    }

    @Test
    public void testToString() {
        String resultado = cafe.toString();
        assertNotNull(resultado);
        assertTrue(resultado.contains("Cafe"));
        assertTrue(resultado.contains("tipoGrano='Arábica'"));
    }
}
