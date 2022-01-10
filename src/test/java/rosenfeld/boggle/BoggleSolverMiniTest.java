package rosenfeld.boggle;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class BoggleSolverMiniTest {
    @Test
    public void createWordTrie() throws IOException {
        // given
        BoggleBoard boggleBoard = new BoggleBoard();
        Game game = new Game(new Dictionary());
        BoggleSolverMini boggleSolverMini = new BoggleSolverMini(boggleBoard, game);

        // when
        List<String> words = boggleSolverMini.getPossibleWords();

        // then
        Assert.assertNotNull(words);
    }
}
