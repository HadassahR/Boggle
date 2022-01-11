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
    private BoggleBoard boggleBoard;
    private BoggleDictionary boggleDictionary;
    private BoggleSolver boggleSolver;
    private Game game;
    private GameTimer timer;
    private WordTrie trie;
    private Location location;
    private Stack <String> clickedLetters;
    private int SIZE = 4;

    @BeforeClass
    public static void beforeClass() {
        com.sun.javafx.application.PlatformImpl.startup(() -> {
        });
    }

    private void givenBoggleController () throws IOException {
        boggleController = new BoggleController();
        boggleBoard = mock(BoggleBoard.class);
        boggleDictionary = mock(BoggleDictionary.class);
        boggleSolver = mock(BoggleSolver.class);
        game = mock(Game.class);
        timer = mock(GameTimer.class);
        trie = mock(WordTrie.class);
        location = mock(Location.class);
        clickedLetters = mock(Stack.class);
        boggleController.start = mock(Button.class);
        boggleController.submit = mock(Button.class);
        boggleController.solve = mock(Button.class);
        boggleController.currentWord = mock(Label.class);
        boggleController.playerWords = mock(TextArea.class);
        boggleController.letterSet = new ArrayList<>();
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
    public void initialize() {
    }

    @Test
    public void onLetterClicked() {

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
    public void showCurrentWord () throws IOException {

    }

    @Test
    public void submitWord () throws IOException {
        // given
        givenBoggleController();

////        doReturn("GAME").when(clickedLetters).toString()
////                .replaceAll("\\[", "")
////                .replaceAll("]", "")
////                .replaceAll(",", "")
////                .replaceAll(" ", "");
//        doReturn("Player Words: (1)\n GAME").when(boggleController.playerWords).getText();
//
//        // when
//        boggleController.submitWord();
//
//        // then
//        verify(boggleController.playerWords).setText("Player Words: (1)\n GAME");

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

}