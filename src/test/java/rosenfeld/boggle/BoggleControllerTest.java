package rosenfeld.boggle;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
    private final int SIZE = 4;

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
        boggleController.start = mock(Button.class);
        boggleController.submit = mock(Button.class);
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
    public void showCurrentWord () {

    }

    @Test
    public void submitWord () {

    }

}