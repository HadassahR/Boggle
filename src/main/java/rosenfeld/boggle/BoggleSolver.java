package rosenfeld.boggle;
import java.io.IOException;
import java.util.ArrayList;
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

    public void createTrie(){
        boggleTrie = new WordTrie();
        for (String word : boggleDictionary){
            boggleTrie.insert(word);
        }
    }

    public void findWords() {
        boolean[][] visited = new boolean [boggleBoard.getBoardSize()][boggleBoard.getBoardSize()];
        String[][] boggleMatrix = boggleBoard.getCubes();

        for (int row = 0; row < boggleMatrix.length; row++) {
            for (int col = 0; col < boggleMatrix.length; col++) {
                String currPrefix = boggleMatrix[row][col];
                List<Location> neighbors = getNeighbors(row, col, visited);
                for (Location location : neighbors) {
                   boardSearch(neighbors, currPrefix, visited, boggleMatrix);
                }
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

    private void boardSearch (List<Location> neighbors, String currPrefix, boolean [][] visited, String[][] boggleMatrix) {
        for (Location location : neighbors) {
            String currWord = currPrefix + boggleMatrix[location.getRow()][location.getCol()];
            if (boggleTrie.startsWith(currWord)) {
                if (boggleTrie.search(currWord)) {
                    possibleWords.add(currWord);
                }
                visited[location.getRow()][location.getCol()] = true;
                List<Location> newNeighbors = getNeighbors(location.getRow(), location.getCol(), visited);
                boardSearch(newNeighbors, currWord, visited, boggleMatrix);
            } else {
                visited[location.getRow()][location.getCol()] = true;
                neighbors.remove(location);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BoggleSolver boggleSolver = new BoggleSolver(new BoggleBoard(), new Game(new Dictionary()));
        boggleSolver.findWords();
        System.out.println(boggleSolver.possibleWords.size());
    }

}








