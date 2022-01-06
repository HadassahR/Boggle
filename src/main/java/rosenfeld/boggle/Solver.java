package rosenfeld.boggle;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Solver {

    public void findWord(String[][] board, boolean[][] visited, int row, int col, String word, List<String> englishDic) {
        if (englishDic.contains(word)) {
            System.out.println(word);
        }
        if (word.length() == 16) {
            return;
        }
        for (int i = 0; i < pathRow.length; i++) {
            int rowNew = row + pathRow[i];
            int colNew = col + pathCol[i];
            if (validate(rowNew, colNew, visited)) {
                visited[rowNew][colNew] = true;
                findWord(board, visited, rowNew, colNew, word + board[rowNew][colNew], englishDic);
                visited[rowNew][colNew] = false;
            }
        }
    }

    private boolean validate(int rowNew, int colNew, boolean[][] visited) {
        if ((rowNew >= 0) && (colNew >= 0) && (rowNew < 3) && (colNew < 3) && (!visited[rowNew][colNew])) {
            return true;
        } else {
            return false;
        }
    }


    public static void main(String[] args) throws IOException {
        BoggleBoard boggleBoard = new BoggleBoard();
        Dictionary dictionary = new Dictionary();
        List<String> dictionaryWords = dictionary.getWordList().stream().filter(w -> w.length() > 3).collect(Collectors.toList());
        Solver solver = new Solver();
        String[][] boggleMatrix = new String[boggleBoard.getBoardSize()][boggleBoard.getBoardSize()];
        for (int row = 0; row < boggleMatrix.length; row++){
            for (int col = 0; col < boggleMatrix.length; col++){
                boggleMatrix[row][col] = boggleBoard.nextLetter();
            }
        }
        for (int i = 0; i < boggleMatrix.length; i++) {
            for (int j = 0; j < boggleMatrix.length; j++) {
                System.out.print(boggleMatrix[i][j] + " ");
            }
        }

        boolean[][] visited = new boolean[boggleBoard.getBoardSize()][boggleBoard.getBoardSize()];
        String word = "";

        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                visited[row][col] = true;
                solver.findWord(boggleMatrix, visited, 0, 0, word + boggleMatrix[row][col],dictionaryWords);
                visited[row][col] = false;
            }
        }
    }

    static int[] pathRow = {0, 0, 1, 1, -1, 1, -1, -1};
    static int[] pathCol = {1, -1, -1, 1, 1, 0, 0, -1};
}
