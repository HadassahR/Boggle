package rosenfeld.boggle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Timer;

public class BoggleController {
    @FXML
    public Button start, submitWord;
    @FXML
    public Text currentWord, score, timer;
    @FXML
    public Label [][] letterMatrix;
    @FXML
    public TextField playerWords;

    Game game;
    Stack <String> clickedLetters;
    List<String> words;

    public void initialize() throws IOException {
        clickedLetters = new Stack<>();
        words = new ArrayList<String>();
        game = new Game(new Dictionary());
        letterMatrix = new Label[4][4];
    }

    public void onLetterClicked(javafx.scene.input.MouseEvent mouseEvent) {
        Label label = (Label) mouseEvent.getSource();
        String letter = label.getText();

        if (label.getStyle().equals("clicked")){
            label.getStyleClass().remove("clicked");
            clickedLetters.remove(letter);
        } else {
            label.getStyleClass().add("clicked");
            clickedLetters.add(letter);
        }
        showCurrentWord();
    }

    public void startGame() {
        BoggleBoard boggleBoard = new BoggleBoard();
        for (int r = 0; r < boggleBoard.getBoardSize(); r++) {
            for (int c = 0; c < boggleBoard.getBoardSize(); c++) {
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

    public void submitWord(){
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
