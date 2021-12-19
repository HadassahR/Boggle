package rosenfeld.boggle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Game {
    Dictionary dictionary = new Dictionary();
    private List<String> userWords = new ArrayList<>();

    public Game() throws IOException {
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
        return word.length() > 2;
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
    // Controller will determine if letter combination is valid

    public List<String> getPlayerWords (){
        return this.userWords;
    }
}
