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
    public TextArea playerWords, solvedWords;

    private Game game;
    private BoggleBoard boggleBoard;
    private Stack <String> clickedLetters;

    private boolean startWord = true;
    private List<String> words;
    private Label [][] letterMatrix;
    private final int SIZE = 4;
    private boolean[][] visited;

    public void initialize() throws IOException {
        clickedLetters = new Stack<>();
        game = new Game(new BoggleDictionary());
        visited = new boolean[SIZE][SIZE];
        letterMatrix = new Label[SIZE][SIZE];
    }

    public void onLetterClicked(javafx.scene.input.MouseEvent mouseEvent) {
        Label label = (Label) mouseEvent.getSource();
        for (int row = 0; row < boggleBoard.getBoardSize(); row++) {
            for (int col = 0; col < boggleBoard.getBoardSize(); col++) {
                if (letterMatrix[row][col] == label){
                    if (startWord){
                        onStartWord(row, col);
                    } else {
                        onAnyLetter(row, col);
                    }
                }
            }
        }
        showCurrentWord();
    }

    public void startGame() {
        boggleBoard = new BoggleBoard();
        int index = 0;
        for (int r = 0; r < boggleBoard.getBoardSize(); r++) {
            for (int c = 0; c < boggleBoard.getBoardSize(); c++) {
                letterMatrix[r][c] = letterSet.get(index);
                index++;
                letterMatrix[r][c].setText(boggleBoard.getCubes()[r][c]);
            }
        }
        start.setVisible(false);
        submit.setVisible(true);
        initializeTimer();
    }

    public void initializeTimer() {
        BoggleController controller = this;
        new Thread(new Runnable() {
            @Override public void run() {
                new GameTimer(20, game, controller);
                }

        }).start();
    }

    private void onStartWord(int r, int c) {
        visited[r][c] = true;
        game.setLastRowClicked(r);
        game.setLastColClicked(c);

        String letter = letterMatrix[r][c].getText();
        clickedLetters.push(letter);
        letterMatrix[r][c].getStyleClass().add("clicked");

        startWord = false;
    }

    private void onAnyLetter (int r, int c){
        if (game.validateTile(game.getLastRowClicked(), game.getLastColClicked(), r, c, visited)) {
            visited[r][c] = true;
            game.setLastRowClicked(r);
            game.setLastColClicked(c);

            String letter =  letterMatrix[r][c].getText();
            clickedLetters.push(letter);
            letterMatrix[r][c].getStyleClass().add("clicked");
        }
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
        String word = clickedLetters.toString()
                .replaceAll("\\[", "")
                .replaceAll("]", "")
                .replaceAll(",", "")
                .replaceAll(" ", "");

        if (game.enterWord(word)){
            playerWords.setText("Player Words: (" + game.getPlayerWords().size() + ")\n" +game.getPlayerWords().toString().replace("[", "").replace("]", ""));
        }
        afterSubmission();
    }

    private void afterSubmission () {
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

    public void endGame () {
        submit.setVisible(false);
        solve.setVisible(true);
    }
    public void showSolution () throws IOException {
        solvedWords.setVisible(true);
        BoggleSolver boggleSolver = new BoggleSolver(boggleBoard, game, new WordTrie());
        List<String> possibleWords = boggleSolver.getPossibleWords();
        solvedWords.setText("Possible Boggle Words: (" + possibleWords.size() + ")\n" + possibleWords.toString().replace("[", "").replace("]", ""));
    }

}