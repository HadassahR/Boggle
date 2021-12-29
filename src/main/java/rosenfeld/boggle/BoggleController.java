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

public class BoggleController {
    @FXML
    Button start, submitWord;
    @FXML
    Text currentWord, score;
    @FXML
    private List<Label> letterTiles;
    @FXML
    TextField playerWords;
    Game game;

    private Stack <String> clickedLetters;
    private List<String> words;

    public void initialize() throws IOException {
        clickedLetters = new Stack<>();
        words = new ArrayList<String>();
        game = new Game(new Dictionary());
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
        for (Label label : letterTiles) {
            if (label.getText().isEmpty()) {
                label.setText(boggleBoard.nextLetter()); // will need to reverse load them because of stack
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
//TODO Implement timer
// TODO Format toolbar
// TODO Game logic
// TODO Add Qu condition before adding the letter cube
//TODO Controller Test
}
