package service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PerfilTest {

    private Perfil perfil;

    @Before
    public void before() throws Exception {
        perfil = new Perfil();
    }

    @Test
    public void testGetTipoPerfil() {
        String esperado = "";
        String obtenido = perfil.getTipoPerfil();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testSetTipoPerfil() {
        perfil.setTipoPerfil("Aventurero");
        String esperado = "Aventurero";
        String obtenido = perfil.getTipoPerfil();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testGetDescripcion() {
        String esperado = "";
        String obtenido = perfil.getDescripcion();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testSetDescripcion() {
        perfil.setDescripcion("Le gusta explorar");
        String esperado = "Le gusta explorar";
        String obtenido = perfil.getDescripcion();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testToString() {
        String esperado = "perfil{tipoperfil='', descripcion=''}";
        String obtenido = perfil.toString().toLowerCase();
        assertEquals(esperado, obtenido);
    }
}