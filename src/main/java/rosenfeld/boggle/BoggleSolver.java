package rosenfeld.boggle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BoggleSolver {
    BoggleBoard board;
    List<String> words;
    Game game;
    String[][] boggleMatrix;
    final int ALPHABET_SIZE = 26;

    public BoggleSolver (BoggleBoard boggleBoard, Game currentGame) throws IOException {
        board = boggleBoard;
        words = new ArrayList<>();
        game = currentGame;
        boggleMatrix = new String [board.getBoardSize()][board.getBoardSize()];
        for (int row = 0; row < boggleMatrix.length; row++){
            for (int col = 0; col < boggleMatrix.length; col++){
                boggleMatrix[row][col] = board.nextLetter();
            }
        }
    }


    public void findAllWords() {

    }

}
