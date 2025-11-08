package service;

import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

public class TeTest {

    private Te te;
    private ByteArrayOutputStream salida;

    @Before
    public void setUp() {
        te = new Te();
        salida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(salida));
    }

    @Test
    public void testConstructorPorDefecto() {
        String esperado = "Verde";
        String obtenido = te.getTipoHoja();
        assertEquals(esperado, obtenido);

        int esperadoAgua = 250;
        int obtenidoAgua = te.getAgua();
        assertEquals(esperadoAgua, obtenidoAgua);

        int esperadoTemp = 90;
        int obtenidoTemp = te.getTemperatura();
        assertEquals(esperadoTemp, obtenidoTemp);
    }

    @Test
    public void testConstructorConTipoHoja() {
        Te te2 = new Te("Negro");
        String esperado = "Negro";
        String obtenido = te2.getTipoHoja();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testConstructorCompleto() {
        Te te3 = new Te(300, 85, "Blanco");
        String esperado = "Blanco";
        String obtenido = te3.getTipoHoja();
        assertEquals(esperado, obtenido);

        int esperadoAgua = 300;
        int obtenidoAgua = te3.getAgua();
        assertEquals(esperadoAgua, obtenidoAgua);
    }

    @Test
    public void testGetTipoHoja() {
        String esperado = "Verde";
        String obtenido = te.getTipoHoja();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testSetTipoHoja() {
        te.setTipoHoja("Oolong");
        String esperado = "Oolong";
        String obtenido = te.getTipoHoja();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testSetTipoHojaNull() {
        te.setTipoHoja(null);
        String esperado = "Verde";
        String obtenido = te.getTipoHoja();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testSetTipoHojaVacio() {
        te.setTipoHoja("");
        String esperado = "Verde";
        String obtenido = te.getTipoHoja();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testPrepararIngrediente() {
        te.prepararIngrediente();
        String resultado = salida.toString();
        assertTrue(resultado.contains("Remojando hojas de té"));
        assertTrue(resultado.contains("Dejando reposar"));
    }

    @Test
    public void testAgregarCondimentos() {
        te.agregarCondimentos();
        String resultado = salida.toString();
        assertTrue(resultado.contains("Agregando limón y miel"));
    }

    @Test
    public void testPrepararBebidaCompleto() {
        te.prepararBebida();
        String resultado = salida.toString();

        assertTrue(resultado.contains("Hirviendo"));
        assertTrue(resultado.contains("Remojando hojas"));
        assertTrue(resultado.contains("Sirviendo en la taza"));
        assertTrue(resultado.contains("limón y miel"));
    }

    @Test
    public void testToString() {
        String resultado = te.toString();
        assertNotNull(resultado);
        assertTrue(resultado.contains("Te"));
        assertTrue(resultado.contains("tipoHoja='Verde'"));
    }
}