//package rosenfeld.boggle;
//
//import javafx.scene.control.Button;
//import javafx.scene.control.TextField;
//import javafx.scene.text.Text;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//import java.io.IOException;
//
//import static org.mockito.Mockito.mock;
//
//public class BoggleControllerTest {
//
//    private BoggleBoard boggleBoard;
//    private BoggleController boggleController;
////    private BoggleSolver boggleSolver;
//    private Dictionary dictionary;
//    private Game game;
//
//    @BeforeClass
//    public static void beforeClass() {
//        com.sun.javafx.application.PlatformImpl.startup(() -> {
//        });
//    }
//
//    private void givenBogglecontroller () throws IOException {
//        boggleController = new BoggleController();
//        boggleBoard = mock(BoggleBoard.class);
//        dictionary = new Dictionary();
//        game = new Game(dictionary);
//        boggleController.currentWord = mock(Text.class);
//        boggleController.playerWords = mock(TextField.class);
////        boggleController.game = mock(Game.class);
//        boggleController.score = mock(Text.class);
//        boggleController.start = mock(Button.class);
//        boggleController.submitWord = mock(Button.class);
//
//    }
//
//    @Test
//    public void initialize() {
//
//    }
//
//    @Test
//    public void onLetterClicked() {
//
//    }
//
//    @Test
//    public void startGame() {
//
//    }
//
//    @Test
//    public void showCurrentWord () {
//
//    }
//
//    @Test
//    public void submitWord () {
//
//    }
//
//}
