package service;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AsistenciaTest {

    private Asistencia asis;

    @Before
    public void before (){
        asis = new Asistencia();
    }

    @Test
    public void testAddEstudiante() {
        asis.addEstudiante(new Estudiante());
        String esperado = "asistencia(estudiantes=[estudiante{carnet=1000}])";
        String obtenido = asis.toString().toLowerCase();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testToStringLombok() {
        String esperado = "asistencia(estudiantes=[])";
        String obtenido = asis.toString().toLowerCase();
        assertEquals(esperado, obtenido);
    }

    @Ignore("testToStringIncrustado") //
    @Test
    public void testToStringIncrustado() {
        String esperado = "asistencia(estudiantes=[])";
        String obtenido = asis.toString().toLowerCase();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testGet() {
        // Al inicio debe estar vacía
        assertTrue(asis.getEstudiantes().isEmpty());

        // Agrego un estudiante (carnet por defecto = 1000)
        asis.addEstudiante(new Estudiante());

        int esperado = 1000;
        int obtenido = asis.getEstudiantes().get(0).getCarnet();

        assertEquals(esperado, obtenido);
    }

    @Test
    public void testSet() {
        // Creo una lista con un estudiante
        List<Estudiante> lista = new ArrayList<>();
        lista.add(new Estudiante(2000));

        // Uso el setter
        asis.setEstudiantes(lista);

        // Verifico con el getter
        assertEquals(1, asis.getEstudiantes().size());
        assertEquals(2000, asis.getEstudiantes().get(0).getCarnet());
    }

    @Test(expected = MyException.class)
    public void testAddEstudianteNoNulo() {
        asis.addEstudiante(null);
    }

    @Test
    public void testToStringNoEmpty() {
        asis.addEstudiante(new Estudiante());
        String esperado = "asistencia{estudiantes=[estudiante{carnet=1000}]}";
        String obtenido = asis.toString().toLowerCase();
        assertEquals(esperado, obtenido);
    }
}
