package rosenfeld.boggle;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class BoggleBoardTest {

    @Test
    public void fourByFour(){
        // given
        BoggleBoard boggleBoard = new BoggleBoard();

        // when
        List<String> cubes = boggleBoard.getCubeSet();

        // then
        Assert.assertEquals(16, cubes.size());
    }

    @Test
    public void getNextLetter(){
        // given
        BoggleBoard boggleBoard = new BoggleBoard();

        // when
        boggleBoard.configureCubes();
        String[][] cubes = boggleBoard.getCubes();

        // then
        for (String [] cubeSet : cubes) {
            for (String cube : cubeSet) {
                if (cube.equals("Qu"))
                    Assert.assertEquals(2, cube.length());
                 else
                    Assert.assertEquals(1, cube.length());
            }
        }
    }
}
