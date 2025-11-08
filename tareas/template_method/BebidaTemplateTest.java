package service;

import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

public class BebidaTemplateTest {

    private BebidaTemplate bebida;
    private ByteArrayOutputStream salida;
    private PrintStream salidaOriginal;

    private class BebidaTestConcreta extends BebidaTemplate {
        public BebidaTestConcreta() {
            super();
        }

        public BebidaTestConcreta(int agua, int temperatura) {
            super(agua, temperatura);
        }

        @Override
        protected void prepararIngrediente() {
            System.out.println("Preparando ingrediente de prueba");
        }

        @Override
        protected void agregarCondimentos() {
            System.out.println("Agregando condimentos de prueba");
        }
    }

    @Before
    public void setUp() {
        bebida = new BebidaTestConcreta();
        salida = new ByteArrayOutputStream();
        salidaOriginal = System.out;
        System.setOut(new PrintStream(salida));
    }

    @Test
    public void testConstructorPorDefecto() {
        int esperadoAgua = 250;
        int obtenidoAgua = bebida.getAgua();
        assertEquals(esperadoAgua, obtenidoAgua);

        int esperadoTemp = 100;
        int obtenidoTemp = bebida.getTemperatura();
        assertEquals(esperadoTemp, obtenidoTemp);
    }

    @Test
    public void testConstructorConParametros() {
        BebidaTemplate bebida2 = new BebidaTestConcreta(300, 80);
        int esperadoAgua = 300;
        int obtenidoAgua = bebida2.getAgua();
        assertEquals(esperadoAgua, obtenidoAgua);

        int esperadoTemp = 80;
        int obtenidoTemp = bebida2.getTemperatura();
        assertEquals(esperadoTemp, obtenidoTemp);
    }

    @Test
    public void testGetAgua() {
        int esperado = 250;
        int obtenido = bebida.getAgua();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testSetAgua() {
        bebida.setAgua(350);
        int esperado = 350;
        int obtenido = bebida.getAgua();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testSetAguaNegativa() {
        bebida.setAgua(-100);
        int esperado = 250;
        int obtenido = bebida.getAgua();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testGetTemperatura() {
        int esperado = 100;
        int obtenido = bebida.getTemperatura();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testSetTemperatura() {
        bebida.setTemperatura(90);
        int esperado = 90;
        int obtenido = bebida.getTemperatura();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testSetTemperaturaNegativa() {
        bebida.setTemperatura(-50);
        int esperado = 100;
        int obtenido = bebida.getTemperatura();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testSetTemperaturaMayorA100() {
        bebida.setTemperatura(150);
        int esperado = 100;
        int obtenido = bebida.getTemperatura();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testPrepararBebida() {
        bebida.prepararBebida();
        String resultado = salida.toString();

        assertTrue(resultado.contains("Hirviendo"));
        assertTrue(resultado.contains("Preparando ingrediente"));
        assertTrue(resultado.contains("Sirviendo en la taza"));
        assertTrue(resultado.contains("Agregando condimentos"));
    }

    @Test
    public void testHervirAgua() {
        bebida.hervirAgua();
        String resultado = salida.toString();
        assertTrue(resultado.contains("Hirviendo 250ml de agua a 100°C"));
    }

    @Test
    public void testServirEnTaza() {
        bebida.servirEnTaza();
        String resultado = salida.toString();
        assertTrue(resultado.contains("Sirviendo en la taza"));
    }

    @Test
    public void testToString() {
        String resultado = bebida.toString();
        assertNotNull(resultado);
        assertTrue(resultado.contains("agua=250"));
        assertTrue(resultado.contains("temperatura=100"));
    }
}