package rosenfeld.boggle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BoggleSolver {
    BoggleBoard board;
    List<String> words;
    Game game;

    public BoggleSolver (BoggleBoard boggleBoard, Game currentGame) throws IOException {
        board = boggleBoard;
        words = new ArrayList<>();
        game = currentGame;
    }

    public void findAllWords() {

    }

}
