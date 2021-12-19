package rosenfeld.boggle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.util.List;
import java.util.Stack;

public class BoggleController {
    @FXML
    Button start;
    @FXML
    Text currentWord;
    @FXML
    private List<Label> letterTiles;

    private Stack <String> clickedLetters;

    public void initialize(){
        clickedLetters = new Stack<>();
    }

    public void onLetterClicked(javafx.scene.input.MouseEvent mouseEvent) {
        Label label = (Label) mouseEvent.getSource();
        String letter = label.getText();
        clickedLetters.add(letter);
        updateStack();
    }

    public void startGame() {
        BoggleBoard boggleBoard = new BoggleBoard(4);
        for (Label label : letterTiles) {
            if (label.getText().isEmpty() || label.getText().equals("")) {
                label.setText(boggleBoard.nextLetter());
            }
        }
    }

    public void updateStack(){
        currentWord.setText(clickedLetters.toString().replaceAll("\\[", "").replaceAll("]", ""));
    }

}
