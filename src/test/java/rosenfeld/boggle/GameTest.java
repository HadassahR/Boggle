package rosenfeld.boggle;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class GameTest {

    @Test
    public void tooShort_EnterWord () throws IOException {
        // given
        Game game = new Game(new BoggleDictionary());

        // when
        boolean valid = game.enterWord("it");

        // then
        Assert.assertFalse(valid);
    }

    @Test
    public void invalidWord_EnterWord () throws IOException {
        // given
        Game game = new Game(new BoggleDictionary());

        // when
        boolean valid = game.enterWord("Hadassah");

        // then
        Assert.assertFalse(valid);
    }

    @Test
    public void duplicate_EnterWord () throws IOException {
        // given
        Game game = new Game(new BoggleDictionary());

        // when
        game.enterWord("travel");
        boolean valid = game.enterWord("travel");

        // then
        Assert.assertFalse(valid);
    }

    @Test
    public void valid_EnterWord () throws IOException {
        // given
        Game game = new Game(new BoggleDictionary());

        // when
        boolean valid = game.enterWord("escape");

        // then
        Assert.assertTrue(valid);
    }

    @Test
    public void score () throws IOException {
        // given
        Game game = new Game(new BoggleDictionary());

        // when
        game.enterWord("cat");
        game.enterWord("fish");
        game.enterWord("fish");
        game.enterWord("worry");
        game.enterWord("Biden");
        game.enterWord("octopus");

        // then
        Assert.assertEquals(8, game.calculateScore());
    }
}
