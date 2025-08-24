package service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InventarioTest {

    private Inventario inventario;
    private Producto producto1;
    private Producto producto2;

    @Before
    public void setUp(){
        inventario = new Inventario();
        producto1 = new Producto("000K27");
        producto2 = new Producto("000k35");
    }

    @Test
    public void testAgregarProducto() {
        inventario.agrgarProducto(producto1);
        String resultado = inventario.toString();
        assertNotNull(resultado);
    }

    @Test
    public void testAgregarDosProductos(){
        inventario.agrgarProducto(producto1);
        inventario.agrgarProducto(producto2);
        String resultado = inventario.toString();
        assertNotNull(resultado);
    }

    @Test
    public void testB_InventarioVacio(){
        String resultado = inventario.toString();
        assertEquals("Inventario:\n", resultado);
    }

    @Test
    public void testToString() {
        inventario.agrgarProducto(producto1);
        String resultado = inventario.toString();
        assertNotNull(resultado);

    }

}