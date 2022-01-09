package rosenfeld.boggle;
import org.graalvm.compiler.asm.amd64.AMD64Assembler;

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

                while (neighbors.size() > 0) {
                    for (Location location : neighbors) {
                        String currWord = currPrefix + boggleMatrix[location.getRow()][location.getCol()];
                        if (boggleTrie.startsWith(currWord)) {
                            if (boggleTrie.search(currWord)) {
                                possibleWords.add(currWord);//**
                            }
                            // Continue searching locations
                        } else {
                            neighbors.remove(location);
                        }
                    }
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

    private void searchWords (List<Location> neighbors, String currLet, String[][] boggleMatrix) {
        for (Location location : neighbors) {
            String currWord = currLet + boggleMatrix[location.getRow()][location.getCol()];
            if (boggleTrie.startsWith(currWord)) {
                if (boggleTrie.search(currWord)) {
                    possibleWords.add(currWord);//**
                }
//                searchWords(neighbors,
            } else {
                neighbors.remove(location);
            }
        }
    }

}








