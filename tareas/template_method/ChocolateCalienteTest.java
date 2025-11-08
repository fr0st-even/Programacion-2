package service;

import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

public class ChocolateCalienteTest {

    private ChocolateCaliente chocolate;
    private ByteArrayOutputStream salida;

    @Before
    public void setUp() {
        chocolate = new ChocolateCaliente();
        salida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(salida));
    }

    @Test
    public void testConstructorPorDefecto() {
        double esperado = 70.0;
        double obtenido = chocolate.getPorcentajeCacao();
        assertEquals(esperado, obtenido, 0.01);

        int esperadoAgua = 300;
        int obtenidoAgua = chocolate.getAgua();
        assertEquals(esperadoAgua, obtenidoAgua);

        int esperadoTemp = 85;
        int obtenidoTemp = chocolate.getTemperatura();
        assertEquals(esperadoTemp, obtenidoTemp);
    }

    @Test
    public void testConstructorConPorcentaje() {
        ChocolateCaliente chocolate2 = new ChocolateCaliente(85.0);
        double esperado = 85.0;
        double obtenido = chocolate2.getPorcentajeCacao();
        assertEquals(esperado, obtenido, 0.01);
    }

    @Test
    public void testConstructorCompleto() {
        ChocolateCaliente chocolate3 = new ChocolateCaliente(350, 80, 90.0);
        double esperado = 90.0;
        double obtenido = chocolate3.getPorcentajeCacao();
        assertEquals(esperado, obtenido, 0.01);

        int esperadoAgua = 350;
        int obtenidoAgua = chocolate3.getAgua();
        assertEquals(esperadoAgua, obtenidoAgua);
    }

    @Test
    public void testGetPorcentajeCacao() {
        double esperado = 70.0;
        double obtenido = chocolate.getPorcentajeCacao();
        assertEquals(esperado, obtenido, 0.01);
    }

    @Test
    public void testSetPorcentajeCacao() {
        chocolate.setPorcentajeCacao(85.5);
        double esperado = 85.5;
        double obtenido = chocolate.getPorcentajeCacao();
        assertEquals(esperado, obtenido, 0.01);
    }

    @Test
    public void testSetPorcentajeCacaoNegativo() {
        chocolate.setPorcentajeCacao(-10.0);
        double esperado = 70.0;
        double obtenido = chocolate.getPorcentajeCacao();
        assertEquals(esperado, obtenido, 0.01);
    }

    @Test
    public void testSetPorcentajeCacaoMayorA100() {
        chocolate.setPorcentajeCacao(150.0);
        double esperado = 70.0;
        double obtenido = chocolate.getPorcentajeCacao();
        assertEquals(esperado, obtenido, 0.01);
    }

    @Test
    public void testPrepararIngrediente() {
        chocolate.prepararIngrediente();
        String resultado = salida.toString();
        assertTrue(resultado.contains("Derritiendo chocolate"));
        assertTrue(resultado.contains("70.0% de cacao"));
        assertTrue(resultado.contains("Mezclando con agua"));
    }

    @Test
    public void testAgregarCondimentos() {
        chocolate.agregarCondimentos();
        String resultado = salida.toString();
        assertTrue(resultado.contains("Agregando crema batida"));
    }

    @Test
    public void testHook() {
        chocolate.hook();
        String resultado = salida.toString();
        assertTrue(resultado.contains("Espolvoreando canela"));
        assertTrue(resultado.contains("Agregando malvaviscos"));
    }

    @Test
    public void testPrepararBebidaCompletoConHook() {
        chocolate.prepararBebida();
        String resultado = salida.toString();

        assertTrue(resultado.contains("Hirviendo"));
        assertTrue(resultado.contains("Derritiendo chocolate"));
        assertTrue(resultado.contains("Sirviendo en la taza"));
        assertTrue(resultado.contains("crema batida"));
        assertTrue(resultado.contains("canela"));
        assertTrue(resultado.contains("malvaviscos"));
    }

    @Test
    public void testToString() {
        String resultado = chocolate.toString();
        assertNotNull(resultado);
        assertTrue(resultado.contains("ChocolateCaliente"));
        assertTrue(resultado.contains("porcentajeCacao=70.0"));
    }
}