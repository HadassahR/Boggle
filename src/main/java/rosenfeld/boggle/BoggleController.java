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
    public Label [][] letterMatrix;
    @FXML
    public TextField playerWords;

    Game game;
    Stack <String> clickedLetters;
    List<String> words;
    boolean visited[][];

    public void initialize() throws IOException {
        clickedLetters = new Stack<>();
        words = new ArrayList<String>();
        game = new Game(new Dictionary());
        visited = new boolean[4][4];
        letterMatrix = new Label[4][4];
    }

    public void onLetterClicked(javafx.scene.input.MouseEvent mouseEvent) {
        Label label = (Label) mouseEvent.getSource();
        int row = 0;
        int col = 0;
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++){
                if (letterMatrix[r][c] == label) {
                    if (game.validateTile(r, c, visited)){
                        String letter = label.getText();
                        showCurrentWord();
                        visited[r][c] = true;
                    }
                }
            }
        }
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
        Arrays.fill(visited, false);
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
