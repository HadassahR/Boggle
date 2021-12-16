package rosenfeld.boggle;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class GameTest {

    @Test
    public void tooShort_EnterWord () throws IOException {
        // given
        Game game = new Game();

        // when
        boolean valid = game.enterWord("it");

        // then
        Assert.assertEquals(false, valid);
    }

    @Test
    public void invalidWord_EnterWord () throws IOException {
        // given
        Game game = new Game();

        // when
        boolean valid = game.enterWord("Hadassah");

        // then
        Assert.assertEquals(false, valid);
    }

    @Test
    public void duplicate_EnterWord () throws IOException {
        // given
        Game game = new Game();

        // when
        game.enterWord("travel");
        boolean valid = game.enterWord("travel");

        // then
        Assert.assertEquals(false, valid);
    }

    @Test
    public void valid_EnterWord () throws IOException {
        // given
        Game game = new Game();

        // when
        boolean valid = game.enterWord("escape");

        // then
        Assert.assertEquals(true, valid);
    }

    @Test
    public void score () throws IOException {
        // given
        Game game = new Game();

        // when
        game.enterWord("cat"); // none
        game.enterWord("fish");
        game.enterWord("fish"); // none
        game.enterWord("worry");
        game.enterWord("Biden"); // none
        game.enterWord("octopus");

        // then
        Assert.assertEquals(8, game.calculateScore());
    }
}
