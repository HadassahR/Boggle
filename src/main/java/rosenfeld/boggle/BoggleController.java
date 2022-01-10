package rosenfeld.boggle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.util.*;

public class BoggleController {
    @FXML
    public Button start, submit, solve;
    @FXML
    public Label currentWord, score, timer;
    @FXML
    public ArrayList<Label> letterSet;
    @FXML
    public TextArea playerWords;

    Game game;
    boolean startWord = true;
    Stack <String> clickedLetters;
    List<String> words;
    Label [][] letterMatrix;
    private final int SIZE = 4;
    boolean visited[][];

    public void initialize() throws IOException {
        clickedLetters = new Stack<>();
        game = new Game(new BoggleDictionary());
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
                        label.getStyleClass().add("clicked");
                        String letter = label.getText();
                        clickedLetters.push(letter);
                        visited[r][c] = true;
                        startWord = false;
                    } else {

                        if (game.validateTile(game.getLastRowClicked(), game.getLastColClicked(), r, c, visited)) {
                            System.out.println("valid");
                            label.getStyleClass().add("clicked");
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
        start.setVisible(false);
        BoggleBoard boggleBoard = new BoggleBoard();
        int index = 0;
        for (int r = 0; r < boggleBoard.getBoardSize(); r++) {
            for (int c = 0; c < boggleBoard.getBoardSize(); c++) {
                letterMatrix[r][c] = letterSet.get(index);
                index++;
                letterMatrix[r][c].setText(boggleBoard.getCubes()[r][c]);
            }
        }
        submit.setVisible(true);
    }

    private void showCurrentWord(){
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
        for(Label[] letterSet : letterMatrix){
            for (Label letter : letterSet){
                if (letter.getStyleClass().contains("clicked")){
                    letter.getStyleClass().remove("clicked");
                }
            }
        }
    }

    public void initializeTimer() {
//        final int startTime = 180;
//        Timer timerObj = new Timer();
//        timer.setText()
    }

    public void endGame () {
        solve.setVisible(true);
    }
    public void showSolution () {

    }
// TODO Implement timer
// TODO Format toolbar
// TODO Controller Test
}