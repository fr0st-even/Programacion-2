package service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonaTest {

    private Persona persona;

    @Before
    public void before() throws Exception {
        persona = new Persona();
    }

    @Test
    public void testGetNombre() {
        String esperado = "";
        String obtenido = persona.getNombre();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testSetNombre() {
        persona.setNombre("Juan");
        String esperado = "Juan";
        String obtenido = persona.getNombre();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testGetApellidos() {
        String esperado = "";
        String obtenido = persona.getApellidos();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testSetApellidos() {
        persona.setApellidos("Pérez López");
        String esperado = "Pérez López";
        String obtenido = persona.getApellidos();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testGetLugaresVisitados() {
        assertNotNull(persona.getLugaresVisitados());
        int esperado = 0;
        int obtenido = persona.getLugaresVisitados().size();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testAgregarLugar() {
        Lugar lugar = new Lugar("Tikal", "Petén", "12345678");
        persona.agregarLugar(lugar);
        int esperado = 1;
        int obtenido = persona.getLugaresVisitados().size();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testGetFotografia() {
        assertNotNull(persona.getFotografia());
    }

    @Test
    public void testSetFotografia() {
        Fotografia foto = new Fotografia("png", "/nueva.png", 25.5);
        persona.setFotografia(foto);
        Fotografia esperada = foto;
        Fotografia obtenida = persona.getFotografia();
        assertEquals(esperada, obtenida);
    }

    @Test
    public void testGetPerfil() {
        assertNotNull(persona.getPerfil());
    }

    @Test
    public void testSetPerfil() {
        Perfil perfil = new Perfil("Cultural", "Interesado en historia");
        persona.setPerfil(perfil);
        Perfil esperado = perfil;
        Perfil obtenido = persona.getPerfil();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testToString() {
        String obtenido = persona.toString().toLowerCase();
        assertNotNull(obtenido);
        assertTrue(obtenido.contains("persona"));
    }
}