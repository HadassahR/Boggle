package rosenfeld.boggle;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

import static org.mockito.Mockito.*;

public class BoggleControllerTest {

    private BoggleController boggleController;

    @BeforeClass
    public static void beforeClass() {
        com.sun.javafx.application.PlatformImpl.startup(() -> {
        });
    }

    private void givenBoggleController () throws IOException {
        boggleController = new BoggleController();
        BoggleBoard boggleBoard = mock(BoggleBoard.class);
        BoggleDictionary boggleDictionary = mock(BoggleDictionary.class);
        BoggleSolver boggleSolver = mock(BoggleSolver.class);
        Game game = mock(Game.class);
        GameTimer timer = mock(GameTimer.class);
        WordTrie trie = mock(WordTrie.class);
        Location location = mock(Location.class);
        Stack<String> clickedLetters = mock(Stack.class);
        boggleController.start = mock(Button.class);
        boggleController.submit = mock(Button.class);
        boggleController.solve = mock(Button.class);
        boggleController.currentWord = mock(Label.class);
        boggleController.playerWords = mock(TextArea.class);
        boggleController.solvedWords = mock(TextArea.class);
        boggleController.letterSet = new ArrayList<>();
        int SIZE = 4;
        for (int ix = 0; ix < SIZE * SIZE; ix++){
            boggleController.letterSet.add(mock(Label.class));
        }

        boggleController.letterMatrix = new Label[SIZE][SIZE];
        for (int r = 0; r < SIZE; r++){
            for (int c = 0; c < SIZE; c++){
                boggleController.letterMatrix[r][c] = mock(Label.class);
            }
        }
    }

    @Test
    public void startGame() throws IOException {
        // given
        givenBoggleController();
        doReturn(false).when(boggleController.start).isVisible();
        doReturn(true).when(boggleController.submit).isVisible();

        // when
        boggleController.startGame();

        // then
        verify(boggleController.start).setVisible(false);
        verify(boggleController.submit).setVisible(true);
    }

    @Test
    public void onLetterClicked() {

    }

    @Test
    public void submitWord () throws IOException {


    }

    @Test
    public void endGame() throws IOException {
        // given
        givenBoggleController();
        doReturn(false).when(boggleController.submit).isVisible();
        doReturn(true).when(boggleController.solve).isVisible();
        doReturn(false).when(boggleController.currentWord).isVisible();

        // when
        boggleController.endGame();

        // then
        verify(boggleController.submit).setVisible(false);
        verify(boggleController.solve).setVisible(true);
        verify(boggleController.currentWord).setVisible(false);
    }

    @Test
    public void showSolution() {

    }

}