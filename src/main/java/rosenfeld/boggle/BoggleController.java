package rosenfeld.boggle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class BoggleController {
    @FXML
    public Button start, submitWord;
    @FXML
    public Text currentWord, score, timer;
    @FXML
    public ArrayList<Label> letterSet;
    @FXML
    public TextField playerWords;

    Game game;
    boolean startWord = true;
    Stack <String> clickedLetters;
    List<String> words;
    Label [][] letterMatrix;
    private final int SIZE = 4;
    boolean visited[][];

    public void initialize() throws IOException {
        clickedLetters = new Stack<>();
        words = new ArrayList<String>();
        game = new Game(new Dictionary());
        visited = new boolean[SIZE][SIZE];
        letterMatrix = new Label[SIZE][SIZE];
    }

    public void onLetterClicked(javafx.scene.input.MouseEvent mouseEvent) {
        Label label = (Label) mouseEvent.getSource();
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (letterMatrix[r][c] == label) {
                    System.out.print (r + ", " + c + " "); // debug
                    if (startWord){
                        game.setLastColClicked(c);
                        game.setLastRowClicked(r);
                        String letter = label.getText();
                        clickedLetters.push(letter);
                        visited[r][c] = true;
                        startWord = false;
                    } else {
                        if (game.validateTile(game.getLastRowClicked(), game.getLastColClicked(), r, c, visited)) {
                            System.out.println("valid");
                            String letter = label.getText();
                            clickedLetters.push(letter);
                            visited[r][c] = true;
                            game.setLastColClicked(c);
                            game.setLastRowClicked(r);
                        }
                        else
                            {
                            System.out.println("invalid");
                        }
                    }
                }
            }
        }
        showCurrentWord();
    }


    public void startGame() {
        BoggleBoard boggleBoard = new BoggleBoard();
        int index = 0;
        for (int r = 0; r < boggleBoard.getBoardSize(); r++) {
            for (int c = 0; c < boggleBoard.getBoardSize(); c++) {
                letterMatrix[r][c] = letterSet.get(index);
                index++;
                letterMatrix[r][c].setText(boggleBoard.getCubes()[r][c]);
            }
        }
    }

    public void showCurrentWord(){
        String word =  clickedLetters.toString()
                .replaceAll("\\[", "")
                .replaceAll("]", "")
                .replaceAll(",", "")
                .replaceAll(" ", "");
        currentWord.setText(word);
    }

    public void submitWord() {
        String word =  clickedLetters.toString()
                .replaceAll("\\[", "")
                .replaceAll("]", "")
                .replaceAll(",", "")
                .replaceAll(" ", "");

        if (game.enterWord(word)){
            playerWords.setText(game.getPlayerWords().toString());
        }
        clickedLetters.clear();
        currentWord.setText("");
        score.setText(String.valueOf(game.calculateScore()));
        visited = new boolean [SIZE][SIZE];
        startWord = true;
    }

    public void initializeTimer() {
//        final int startTime = 180;
//        Timer timerObj = new Timer();
//        timer.setText()
    }
//TODO Implement timer
// TODO Format toolbar
// TODO Game logic
// TODO Add Qu condition before adding the letter cube
//TODO Controller Test
}
