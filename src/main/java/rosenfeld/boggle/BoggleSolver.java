package rosenfeld.boggle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BoggleSolver {
    private BoggleBoard boggleBoard;
    private List<String> boggleDictionary;
    private WordTrie boggleTrie;
    private List<String> possibleWords;

    public BoggleSolver(BoggleBoard board, Game game){
        boggleBoard = board;
        boggleDictionary = game.dictionary.getWordList().stream().filter(w -> w.length() > 3).collect(Collectors.toList());
        boggleTrie = new WordTrie();
        possibleWords = new ArrayList<>();
        createTrie();
    }

    private void createTrie(){
        boggleTrie = new WordTrie();
        for (String word : boggleDictionary){
            boggleTrie.insert(word);
        }
    }

    private void findWords() {
        boolean[][] visited = new boolean [boggleBoard.getBoardSize()][boggleBoard.getBoardSize()];
        String[][] boggleMatrix = boggleBoard.getCubes();

        for (int row = 0; row < boggleMatrix.length; row++) {
            for (int col = 0; col < boggleMatrix.length; col++) {
                String currPrefix = boggleMatrix[row][col];
                List<Location> originCellNeighbors = getNeighbors(row, col, visited);
                boardSearch(originCellNeighbors, currPrefix, visited, boggleMatrix);
                for (boolean[] b : visited){
                    Arrays.fill(b, false);
                }            }
        }
    }

    private void boardSearch (List<Location> neighbors, String currPrefix, boolean [][] visited, String[][] boggleMatrix) {
        for (Location neighbor : neighbors) {
            String currWord = currPrefix + boggleMatrix[neighbor.getRow()][neighbor.getCol()];
            if (boggleTrie.startsWith(currWord)) {
                if (boggleTrie.isWord(currWord)) {
                    possibleWords.add(currWord);
                }
                visited[neighbor.getRow()][neighbor.getCol()] = true;
                List<Location> newNeighbors = getNeighbors(neighbor.getRow(), neighbor.getCol(), visited);
                boardSearch(newNeighbors, currWord, visited, boggleMatrix);
            } else {
                break;
            }
            for (boolean[] b : visited){
                Arrays.fill(b, false);
            }
        }
    }

    private List<Location> getNeighbors(int row, int col, boolean [][] visited) {
        List<Location> neighbors = new ArrayList<>();
        int[] rowPath = new int [] { 0, 0, 1, 1, -1, 1, -1, -1 };
        int[] colPath = new int [] { 1, -1, -1, 1, 1, 0, 0, -1 };

        for (int ix = 0; ix < rowPath.length; ix++) {
            if (withinBoardAndUnvisited(row + rowPath[ix], col + colPath[ix], visited)){
                neighbors.add(new Location(row + rowPath[ix], col + colPath[ix]));
            }
        }
        return neighbors;
    }

    private boolean withinBoardAndUnvisited(int row, int col, boolean[][] visited) {
        return (row > -1) && (col > -1) && (row < 4) && (col < 4) && (!visited[row][col]);
    }

    public List<String> getPossibleWords() {
        findWords();
        return this.possibleWords;
    }

}








