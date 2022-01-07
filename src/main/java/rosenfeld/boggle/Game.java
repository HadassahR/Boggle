package rosenfeld.boggle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Game {
    Dictionary dictionary;
    private List<String> userWords;
    private final int MIN_LENGTH = 4;
    private int lastRowClicked;
    private int lastColClicked;

    public Game(Dictionary dictionary) {
        this.dictionary = dictionary;
        userWords = new ArrayList<>();
    }

    public boolean enterWord (String word) {
        boolean valid = isWord(word) && isValidLength(word) && notAlreadyUsed(word);
        if (valid) {
            userWords.add(word);
        }
        return valid;
    }

    private boolean isWord (String word) {
        return dictionary.checkForWord(word);
    }

    private boolean isValidLength (String word){
        return word.length() > MIN_LENGTH-1;
    }

    private boolean notAlreadyUsed (String word){
        return !userWords.contains(word);
    }

    public int calculateScore (){
        int score = 0;
        for (String word : userWords) {
            switch (word.length()){
                case 4:
                    score +=1;
                    break;
                case 5:
                    score +=2;
                    break;
                case 6:
                    score +=3;
                    break;
                case 7:
                    score +=5;
                    break;
                case 8: default:
                    score +=11;
                    break;
            }
        }
        return score;
    }

    public List<String> getPlayerWords (){
        return this.userWords;
    }

    public boolean validateTile(int lastRow, int lastCol, int currRow, int currCol, boolean [][] visited){
        return withinBoardAndUnvisited(currRow, currCol, visited) && connected(lastRow, lastCol, currRow, currCol, visited);
    }
    private boolean withinBoardAndUnvisited(int row, int col, boolean[][] visited) {
        return (row > -1) && (col > -1) && (row < 4) && (col < 4) && (!visited[row][col]);
    }

    private boolean connected (int lastRow, int lastCol, int currRow, int currCol, boolean [][] visited) {
        int[] rowPath = new int [] { 0, 0, 1, 1, -1, 1, -1, -1 };
        int[] colPath = new int [] { 1, -1, -1, 1, 1, 0, 0, -1 };

        for (int ix = 0; ix < rowPath.length; ix++) {
            if (withinBoardAndUnvisited(lastRow + rowPath[ix], lastCol + colPath[ix], visited)){
                if (currRow == lastRow + rowPath[ix] && currCol == lastCol + colPath[ix]){
                    visited[currRow][currCol] = true;
                    return true;
                }
            }
        }
        return false;
    }

    public int getLastRowClicked() {
        return this.lastRowClicked;
    }

    public int getLastColClicked() {
        return this.lastColClicked;
    }

    public void setLastRowClicked (int n) {
        lastRowClicked = n;
    }

    public void setLastColClicked (int n) {
        lastColClicked = n;
    }
}
