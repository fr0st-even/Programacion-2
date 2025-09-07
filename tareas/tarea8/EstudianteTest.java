package service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EstudianteTest {

    private Estudiante est;

    @Before
    public void before (){
        est = new Estudiante();

    }


    @Test
    public void setCarnetNegativo() {
    est.setCarnet(-1);
    int esperado = 1000;
    int obtenido = est.getCarnet();
    assertEquals(esperado,obtenido);
    }


        @Test
    public void testToString() {

        String esperado = "estudiante{carnet=1000}";
        String obtenido = est.toString().toLowerCase();
        assertEquals(esperado, obtenido);

    }
}
