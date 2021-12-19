package rosenfeld.boggle;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class BoggleBoardTest {

    @Test
    public void fourByFour(){
        // given
        BoggleBoard boggleBoard = new BoggleBoard(4);

        // when
        List<String> cubes = boggleBoard.fourByFourCubes();

        // then
        Assert.assertEquals(16, cubes.size());
    }

    @Test
    public void fiveByFive(){
        // given
        BoggleBoard boggleBoard = new BoggleBoard(5);

        // when
        List<String> cubes = boggleBoard.fiveByFiveCubes();

        // then
        Assert.assertEquals(25, cubes.size());
    }

    @Test
    public void shuffleCubes(){
        // given
        BoggleBoard boggleBoard = new BoggleBoard(5);

        // when
        List<String> cubes = boggleBoard.shuffleCubes();

        // then
        for (String cube : cubes) {
            if (cube.equals("Qu")){
                Assert.assertEquals(2, cube.length());
            } else {
                Assert.assertEquals(1, cube.length());
            }
        }
    }
}