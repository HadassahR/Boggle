package rosenfeld.boggle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class BoggleSolver {
    private BoggleBoard board;
    private List<String> words;
    private List<String> dictionary;
    private Game game;
    private String[][] boggleMatrix;
    private boolean[][] visited;
    private final int ALPHABET_SIZE = 26;
    int[] rowPath = new int [] { 0, 0, 1, 1, -1, 1, -1, -1 };
    int[] colPath = new int [] { 1, -1, -1, 1, 1, 0, 0, -1 };

    public BoggleSolver (BoggleBoard boggleBoard, Game currentGame) throws IOException {
        board = boggleBoard;
        words = new ArrayList<>();
        game = currentGame;
        dictionary = game.dictionary.getWordList().stream()
                .filter(w -> w.length() > 3)
                .collect(Collectors.toList());
        boggleMatrix = new String [board.getBoardSize()][board.getBoardSize()];
        for (int row = 0; row < boggleMatrix.length; row++){
            for (int col = 0; col < boggleMatrix.length; col++){
                boggleMatrix[row][col] = board.nextLetter();
            }
        }
        visited = new boolean [board.getBoardSize()][board.getBoardSize()];
    }

/* USES:
    board
    visited
    row
    col
    word
    dictionary
 */


    public void findWord(boolean[][] visited, int row, int col, String word) {
        if (dictionary.contains(word)){
            words.add(word);
        }
        if(boggleMatrix.length == word.length()){
            return;
        }
        for (int ix = 0; ix < rowPath.length; ix++) {
            int newRow = row + rowPath[ix];
            int newCol = row + colPath[ix];
            if (validate(newRow, newCol, visited)){
                visited[newRow][newCol] = true;
                findWord(visited, newRow, newCol, word+boggleMatrix[newRow][newCol]);
                visited[newRow][newCol] = false;
            }
        }
    }

    private boolean validate (int newRow, int newCol, boolean[][] visited) {
        if ((newRow >= 0) && (newCol >=0) && (newCol < 3) && (!visited[newRow][newCol])){
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) throws IOException {
        BoggleSolver boggleSolver = new BoggleSolver(new BoggleBoard(), new Game(new Dictionary()));
        String word = "";
        for (int row = 0; row < 4; row ++){
            for (int col = 0; col < 4; col ++){
                boggleSolver.visited[row][col] = true;
                boggleSolver.findWord(boggleSolver.visited, row, col, word+boggleSolver.boggleMatrix[row][col] );
                boggleSolver.visited[row][col] = false;
            }
        }
    }
}
