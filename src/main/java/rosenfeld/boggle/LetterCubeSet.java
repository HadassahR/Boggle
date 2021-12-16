package rosenfeld.boggle;

import java.lang.reflect.Array;
import java.util.*;

public class LetterCubeSet {

    private final int CUBE_SIDES = 6;
    private List<String> cubeSet;
    private Random random = new Random();

    public LetterCubeSet(int size) {
        if (size == 4) {
            cubeSet = fourByFourCubes();
        }
    }
    private List<String> fourByFourCubes () {
        return  Arrays.asList(
                "AAEGN", "ABBJOO", "ACHOPS", "AFFKPS",
                "AOOTTW", "CIMOTU", "DEILRX", "DELRVY",
                "DISTTY", "EEGHNW", "EEINSU", "EHRTVW",
                "EIOSST", "ELRTTY", "HIMNQU", "HLNNRZ");
    }

    public List<Character> shuffleCubes () throws InterruptedException {
        int[] indexes = new int [cubeSet.size()];
        List<Character> cubes = new ArrayList<>();
        for (int ix : indexes) {
            indexes[ix] = random.nextInt(CUBE_SIDES);
        }
        for (String cube : cubeSet) {
            int index = cubeSet.indexOf(cube);
            cubes.add(cube.charAt(indexes[index]));
        }
        Collections.shuffle(cubes);
        return cubes;
    }

    public static void main(String[] args) throws InterruptedException {
        LetterCubeSet lcs = new LetterCubeSet(4);
        List<Character> shuffled = lcs.shuffleCubes();
        for (char c : shuffled) {
            System.out.print(c + " ");
        }
        System.out.println();
       List<Character> shuffled2 = lcs.shuffleCubes();
        for (char c : shuffled2) {
            System.out.print(c + " ");
        }
    }
}
