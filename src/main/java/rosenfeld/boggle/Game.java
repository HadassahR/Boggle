package rosenfeld.boggle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Game {
    Dictionary dictionary;
    private List<String> userWords;
    private final int MIN_LENGTH = 4;

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

    public boolean validateTile(int row, int col, boolean [][] visited){
        return withinBoardAndUnvisited(row, col, visited);
    }
    private boolean withinBoardAndUnvisited(int row, int col, boolean[][] visited) {
        return (row >= 0) && (col >= 0) && (row < 3) && (col < 3) && (!visited[row][col]);
    }
}
