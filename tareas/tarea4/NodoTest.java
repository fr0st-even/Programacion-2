package service.edd;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NodoTest {
    private Nodo nodo;

    @Before
    public void before() throws Exception {
        nodo = new Nodo();
    }

    @Test
    public void testGetDato() {
        Object esperado = null;
        Object obtenido = nodo.getDato();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testSetDato() {
        Object dato = "Prueba";
        nodo.setDato(dato);
        Object esperado = "Prueba";
        Object obtenido = nodo.getDato();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testGetSig() {
        Nodo esperado = null;
        Nodo obtenido = nodo.getSig();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testSetSig() {
        Nodo nuevoNodo = new Nodo("Siguiente");
        nodo.setSig(nuevoNodo);
        Nodo esperado = nuevoNodo;
        Nodo obtenido = nodo.getSig();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testToString() {
        String esperado = "nodo{dato=null, sig=null}";
        String obtenido = nodo.toString().toLowerCase();
        assertEquals(esperado, obtenido);
    }

}