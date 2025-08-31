package service;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
public class CarroTest {

    private Carro car;

    @Before
    public void before() throws Exception{
        car = new Carro();
    }

    @Test
    public void testCFLT(){
        Llanta esperado = new Llanta(20);

        Llanta[]lls = new Llanta[4];
        lls[0] = esperado;

        car.setLlantas(lls);

        Llanta obtenido = car.getLlantas()[0];

        assertEquals(esperado,obtenido);
    }

    @Test
    public void testGetRin(){

    }

    @Test
    public void testTestToString() {
        String esperado = "Carro{TAM=4, llantas=[Llanta{\n" +
                "\trin :10\n" +
                "}, Llanta{\n" +
                "\trin :10\n" +
                "}, Llanta{\n" +
                "\trin :10\n" +
                "}, Llanta{\n" +
                "\trin :10\n" +
                "}]}";
        String obtenido = car.toString();
        assertEquals(esperado, obtenido);
    }
}