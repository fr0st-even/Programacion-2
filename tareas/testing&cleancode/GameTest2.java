package Game;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GameTest {
    @InjectMocks
    private Game game;
    @Mock
    Scanner service;
    @Mock
    Random random;

    @Test
    public void gameTest() {
        Mockito.when(this.service.nextLine()).thenReturn("Piedra").thenReturn("Salir");
        Mockito.when(this.random.nextInt(3)).thenReturn(1);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        this.game.play();
        Assert.assertEquals("Hola....", outContent.toString());
    }
}
