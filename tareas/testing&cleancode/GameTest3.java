package Game2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GameTest {

    public static final int OPTION_Piedra = 0;
    public static final int OPTION_Papel = 1;
    public static final int OPTION_Tijera = 2;

    @InjectMocks
    private Game game;

    @Mock
    Scanner scanner;

    @Mock
    Random random;

    private ByteArrayOutputStream out;

    @Before
    public void setup() {
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @Test
    public void when_writeQuit_then_exitGame() {
        when(scanner.nextLine()).thenReturn("Salir");
        game.play();

        Assert.assertTrue(out.toString().contains("Vamos a jugar Piedra"));
    }

    @Test
    public void when_chooseRock_then_beatsScissors() {
        when(scanner.nextLine()).thenReturn("Piedra").thenReturn("Salir");
        when(random.nextInt(3)).thenReturn(OPTION_Tijera);

        game.play();

        Assert.assertTrue(out.toString().contains("La computadora eligió tijeras"));
        Assert.assertTrue(out.toString().contains("victorias:1"));
    }

    @Test
    public void when_chooseScissors_then_beatsPaper() {
        when(scanner.nextLine()).thenReturn("Tijera").thenReturn("Salir");
        when(random.nextInt(3)).thenReturn(OPTION_Papel);

        game.play();

        Assert.assertTrue(out.toString().contains("La computadora eligió papel"));
        Assert.assertTrue(out.toString().contains("victorias:1"));
    }

    @Test
    public void when_choosePaper_then_beatsRock() {
        when(scanner.nextLine()).thenReturn("Paper").thenReturn("Salir");
        when(random.nextInt(3)).thenReturn(OPTION_Piedra);

        game.play();

        Assert.assertTrue(out.toString().contains("La computadora eligió piedra"));
        Assert.assertTrue(out.toString().contains("victorias:1"));
    }

    @Test
    public void when_bothChooseRock_then_tie() {
        when(scanner.nextLine()).thenReturn("Piedra").thenReturn("Salir");
        when(random.nextInt(3)).thenReturn(OPTION_Piedra);

        game.play();

        Assert.assertTrue(out.toString().contains("La computadora eligió piedra"));
        Assert.assertTrue(out.toString().contains("empates:1"));
    }

    @Test
    public void when_chooseRockAndComputerChoosePaper_then_loose() {
        when(scanner.nextLine()).thenReturn("Piedra").thenReturn("Salir");
        when(random.nextInt(3)).thenReturn(OPTION_Papel);

        game.play();

        Assert.assertTrue(out.toString().contains("La computadora eligió papel"));
        Assert.assertTrue(out.toString().contains("derrotas:1"));
    }
}
