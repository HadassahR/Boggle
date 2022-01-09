package rosenfeld.boggle;
import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;
import java.util.List;

public class BoggleSolverTest {

    @Test
    public void createWordTrie() throws IOException {
        // given
        BoggleBoard boggleBoard = new BoggleBoard();
        Game game = new Game(new Dictionary());
        BoggleSolver boggleSolver = new BoggleSolver(boggleBoard, game);

        // when
        List<String> words = boggleSolver.getPossibleWords();

        // then
        Assert.assertNotNull(words);
    }
}
