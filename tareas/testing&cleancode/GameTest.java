package Cocumber;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GameTest {

    public static final int OPCION_PIEDRA = 0;
    public static final int OPCION_PAPEL = 1;
    public static final int OPCION_TIJERAS = 2;

    @InjectMocks
    private Game juego; 

    @Mock
    Scanner scanner;

    @Mock
    Random random;

    private ByteArrayOutputStream salida;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        salida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(salida));
    }

    @Test
    public void cuando_escribeSALIR_entonces_saleDelJuego() {
        when(scanner.nextLine()).thenReturn("SALIR");
        juego.jugar(); 

        Assert.assertTrue(salida.toString().contains("¡Juguemos Piedra"));
    }

    @Test
    public void cuando_eligePIEDRA_entonces_ganaATIJERAS() {
        when(scanner.nextLine()).thenReturn("PIEDRA").thenReturn("SALIR");
        when(random.nextInt(3)).thenReturn(OPCION_TIJERAS);

        juego.jugar();

        Assert.assertTrue(salida.toString().contains("La computadora eligió tijeras"));
        Assert.assertTrue(salida.toString().contains("ganadas:1"));
    }

    @Test
    public void cuando_eligeTIJERAS_entonces_ganaAPAPEL() {
        when(scanner.nextLine()).thenReturn("TIJERAS").thenReturn("SALIR");
        when(random.nextInt(3)).thenReturn(OPCION_PAPEL);

        juego.jugar();

        Assert.assertTrue(salida.toString().contains("La computadora eligió papel"));
        Assert.assertTrue(salida.toString().contains("ganadas:1"));
    }

    @Test
    public void cuando_eligePAPEL_entonces_ganaAPIEDRA() {
        when(scanner.nextLine()).thenReturn("PAPEL").thenReturn("SALIR");
        when(random.nextInt(3)).thenReturn(OPCION_PIEDRA);

        juego.jugar();

        Assert.assertTrue(salida.toString().contains("La computadora eligió piedra"));
        Assert.assertTrue(salida.toString().contains("ganadas:1"));
    }

    @Test
    public void cuando_ambosEligenPIEDRA_entonces_empate() {
        when(scanner.nextLine()).thenReturn("PIEDRA").thenReturn("SALIR");
        when(random.nextInt(3)).thenReturn(OPCION_PIEDRA);

        juego.jugar();

        Assert.assertTrue(salida.toString().contains("La computadora eligió piedra"));
        Assert.assertTrue(salida.toString().contains("empates:1"));
    }

    @Test
    public void cuando_eligePIEDRAyComputadoraPAPEL_entonces_pierde() {
        when(scanner.nextLine()).thenReturn("PIEDRA").thenReturn("SALIR");
        when(random.nextInt(3)).thenReturn(OPCION_PAPEL);

        juego.jugar();

        Assert.assertTrue(salida.toString().contains("La computadora eligió papel"));
        Assert.assertTrue(salida.toString().contains("perdidas:1"));
    }

}
