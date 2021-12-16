package rosenfeld.boggle;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class LetterCubeSetTest {

    @Test
    public void fourByFour(){
        // given
        LetterCubeSet letterCubeSet = new LetterCubeSet(4);

        // when
        List<String> cubes = letterCubeSet.fourByFourCubes();

        // then
        Assert.assertEquals(16, cubes.size());
    }

    @Test
    public void fiveByFive(){
        // given
        LetterCubeSet letterCubeSet = new LetterCubeSet(5);

        // when
        List<String> cubes = letterCubeSet.fiveByFiveCubes();

        // then
        Assert.assertEquals(25, cubes.size());
    }

    @Test
    public void shuffleCubes(){
        // given
        LetterCubeSet letterCubeSet = new LetterCubeSet(5);

        // when
        List<String> cubes = letterCubeSet.shuffleCubes();

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
