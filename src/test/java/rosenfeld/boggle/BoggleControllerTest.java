package rosenfeld.boggle;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class BoggleControllerTest {

    private BoggleController controller;
    private Game game;
    private BoggleDictionary boggleDictionary;
    private Stack<String> clickedLetters;
    private List<String> words;
    private BoggleBoard boggleBoard;
    private final int SIZE = 4;
    private Label [][] letterMatrix;
    private boolean[][] visited;

    @BeforeClass
    public static void beforeClass() {
        com.sun.javafx.application.PlatformImpl.startup(() -> {
        });
    }

    private void givenBoggleController () throws IOException {
        controller = new BoggleController();

        controller.start = mock(Button.class);
        controller.submitWord = mock(Button.class);
        controller.currentWord = mock(Label.class);
        controller.score = mock(Label.class);
        controller.timer = mock(Label.class);

        boggleBoard = mock(BoggleBoard.class);
        boggleDictionary = mock(BoggleDictionary.class);
        game = mock(Game.class);

        clickedLetters = mock(Stack.class);
        words = mock(ArrayList.class);

        controller.letterSet = Arrays.asList(
                mock(Label.class), mock(Label.class), mock(Label.class), mock(Label.class),
                mock(Label.class), mock(Label.class), mock(Label.class), mock(Label.class),
                mock(Label.class), mock(Label.class),  mock(Label.class), mock(Label.class),
                mock(Label.class), mock(Label.class),  mock(Label.class), mock(Label.class)
        );

        letterMatrix = new Label [SIZE][SIZE];
        for (Label[] labelRow : letterMatrix) {
            for (Label label : labelRow) {
                label = mock(Label.class);
            }
        }
//        letterMatrix = mock(Label[][].class);
//        visited = mock(boolean[][].class);
    }

    @Test
    public void startGame() throws IOException {
        // given
        givenBoggleController();
        doReturn("E").when(controller.letterSet.get(0)).getText();
        doReturn("A").when(controller.letterSet.get(1)).getText();
        doReturn("D").when(controller.letterSet.get(2)).getText();
        doReturn("S").when(controller.letterSet.get(3)).getText();

        doReturn("F").when(controller.letterSet.get(4)).getText();
        doReturn("V").when(controller.letterSet.get(5)).getText();
        doReturn("O").when(controller.letterSet.get(6)).getText();
        doReturn("I").when(controller.letterSet.get(7)).getText();

        doReturn("R").when(controller.letterSet.get(8)).getText();
        doReturn("E").when(controller.letterSet.get(9)).getText();
        doReturn("P").when(controller.letterSet.get(10)).getText();
        doReturn("M").when(controller.letterSet.get(11)).getText();

        doReturn("V").when(controller.letterSet.get(12)).getText();
        doReturn("M").when(controller.letterSet.get(13)).getText();
        doReturn("E").when(controller.letterSet.get(14)).getText();
        doReturn("L").when(controller.letterSet.get(15)).getText();

        for (Label [] label : letterMatrix) {
            for (Label lbl : label) {
                doReturn(lbl).when(lbl.getLabelFor());
            }
        }

        // when
        controller.startGame();

        // then
        Mockito.verify(controller.letterSet.get(0)).setText("E");
        Mockito.verify(controller.letterSet.get(0)).setText("A");
        Mockito.verify(controller.letterSet.get(0)).setText("D");
        Mockito.verify(controller.letterSet.get(0)).setText("S");
    }

    @Test
    public void onLetterClicked() throws IOException {
        // given
        givenBoggleController();

        // when
    }


    @Test
    public void submitWord () {

    }

}
