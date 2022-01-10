package rosenfeld.boggle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BoggleSolver {
    private BoggleBoard boggleBoard;
    private List<String> boggleDictionary;
    private WordTrie wordTrie;
    private List<String> possibleWords;

    public BoggleSolver(BoggleBoard boggleBoard, Game game, WordTrie wordTrie) {
        this.boggleBoard = boggleBoard;
        this.boggleDictionary = game.dictionary.getWordList().stream().filter(w -> w.length() > 3).collect(Collectors.toList());
        this.wordTrie = new WordTrie();
        createTrie();
        possibleWords = new ArrayList<>();
    }

    private void createTrie() {
        for (String word : boggleDictionary) {
            wordTrie.insert(word);
        }
    }

    private void findWords() {
        boolean[][] visited = new boolean[boggleBoard.getBoardSize()][boggleBoard.getBoardSize()];
        String[][] boggleMatrix = boggleBoard.getCubes();

        for (int row = 0; row < boggleMatrix.length; row++) {
            for (int col = 0; col < boggleMatrix.length; col++) {
                String currPrefix = boggleMatrix[row][col];
                visited[row][col] = true;
                List<Location> originCellNeighbors = getNeighbors(row, col, visited);
                boardSearch(originCellNeighbors, currPrefix, visited, boggleMatrix);
                // When finished
                Arrays.stream(visited).forEach(b -> Arrays.fill(b, false));
            }
        }
    }

    private void boardSearch(List<Location> neighbors, String currPrefix, boolean[][] visited, String[][] boggleMatrix) {
        for (Location neighbor : neighbors) {
            int neighborRow = neighbor.getRow();
            int neighborCol = neighbor.getCol();
            String currWord = currPrefix + boggleMatrix[neighborRow][neighborCol];
            if (wordTrie.startsWith(currWord)) {
                if (wordTrie.isWord(currWord)) {
                    possibleWords.add(currWord);
                }
                visited[neighborRow][neighborCol] = true;
                List<Location> newNeighbors = getNeighbors(neighborRow, neighborCol, visited);
                boardSearch(newNeighbors, currWord, visited, boggleMatrix);
            }
            visited[neighborRow][neighborCol] = false;
        }
    }

    private List<Location> getNeighbors(int row, int col, boolean[][] visited) {
        List<Location> neighbors = new ArrayList<>();
        int[] rowPath = new int[]{0, 0, 1, 1, -1, 1, -1, -1};
        int[] colPath = new int[]{1, -1, -1, 1, 1, 0, 0, -1};

        for (int ix = 0; ix < rowPath.length; ix++) {
            if (withinBoardAndUnvisited(row + rowPath[ix], col + colPath[ix], visited)) {
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
        possibleWords = possibleWords.stream().distinct().collect(Collectors.toList());
        return this.possibleWords;
    }
}