package rosenfeld.boggle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BoggleApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        BoggleBoard boggleBoard = new BoggleBoard();
        BoggleDictionary dictionary = new BoggleDictionary();
        Game game = new Game(dictionary);
        WordTrie wordTrie = new WordTrie(dictionary);
        BoggleSolver boggleSolver = new BoggleSolver(boggleBoard, game, wordTrie);

        BoggleController boggleController = new BoggleController(boggleBoard, dictionary, boggleSolver, game, wordTrie);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/boggle_application.fxml"));
        loader.setController(boggleController);

        Parent parent = loader.load();
        Scene scene = new Scene(parent, 600, 525);

        stage.setTitle("Boggle");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
