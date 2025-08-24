package service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductoTest {

    private Producto product;

    @Before
    public void setUp(){
        product = new Producto("Producto0001");
    }

    @Test
    public void testGetSku() {
        String esperado = "Producto0001";
        String obtenido = product.getSku();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testSetSku() {
        product.setSku("Producto000");
        String esperado = "Producto000";
        String obtenido = product.getSku();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testToString() {
        String esperado = "Producto: Producto001";
        String obtenido = product.toString();
        assertEquals(esperado, obtenido);
    }

}