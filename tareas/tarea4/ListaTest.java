package service.edd;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ListaTest {
    private Lista lista;

    @Before
    public void before() throws Exception {
        lista = new Lista();
    }

    @Test
    public void testGetNombre() {
        String esperado = "";
        String obtenido = lista.getNombre();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testSetNombre() {
        String nombre = "MiLista";
        lista.setNombre(nombre);
        String esperado = "MiLista";
        String obtenido = lista.getNombre();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testGetIni() {
        Nodo esperado = null;
        Nodo obtenido = lista.getIni();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testSetIni() {
        Nodo nodo = new Nodo("Inicial");
        lista.setIni(nodo);
        Nodo esperado = nodo;
        Nodo obtenido = lista.getIni();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testGetFin() {
        Nodo esperado = null;
        Nodo obtenido = lista.getFin();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testSetFin() {
        Nodo nodo = new Nodo("Final");
        lista.setFin(nodo);
        Nodo esperado = nodo;
        Nodo obtenido = lista.getFin();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testEstaVacia() {
        boolean esperado = true;
        boolean obtenido = lista.estaVacia();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testEstaVaciaConElemento() {
        lista.insertarAlFrente("Elemento");
        boolean esperado = false;
        boolean obtenido = lista.estaVacia();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testInsertarAlFrente() {
        lista.insertarAlFrente("Primer elemento");
        boolean esperado = false;
        boolean obtenido = lista.estaVacia();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testToString() {
        String esperado = "lista{nombre='', ini=null, fin=null}";
        String obtenido = lista.toString().toLowerCase();
        assertEquals(esperado, obtenido);
    }

}