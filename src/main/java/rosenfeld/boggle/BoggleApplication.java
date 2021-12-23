package rosenfeld.boggle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BoggleApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        BoggleController boggleController = new BoggleController();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/boggle_application.fxml"));
        loader.setController(boggleController);

        Parent parent = loader.load();
        Scene scene = new Scene(parent, 600, 450);

        stage.setTitle("Boggle");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
