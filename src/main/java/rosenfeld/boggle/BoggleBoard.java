package rosenfeld.boggle;

import javax.print.DocFlavor;
import java.util.*;

public class BoggleBoard {

    private final int CUBE_SIDES = 6;
    private int boardSize = 4;
    private List<String> cubeSet;
    private Random random = new Random();
    private Stack<String> stack = new Stack<>();

    public BoggleBoard() {
        cubeSet = generateCubes();
        shuffleCubes();
    }

    public List<String> generateCubes() {
        return Arrays.asList(
                "AAEEGN", "ABBJOO", "ACHOPS", "AFFKPS",
                "AOOTTW", "CIMOTU", "DEILRX", "DELRVY",
                "DISTTY", "EEGHNW", "EEINSU", "EHRTVW",
                "EIOSST", "ELRTTY", "HIMNQU", "HLNNRZ");
    }


    public void shuffleCubes()  { // change test for shuffle cubes
        List<String> cubes = new ArrayList<>();
        for (String cube : cubeSet) {
            cubes.add(String.valueOf(cube.charAt(random.nextInt(CUBE_SIDES))));
        }
        if (cubes.contains("Q")){
            cubes.set(cubes.indexOf("Q"), "Qu");
        }
        Collections.shuffle(cubes);
        stack.addAll(cubes);
    }

    public String nextLetter () {
        return stack.pop();
    }

    public List<String> getCubes () {
        return this.cubeSet;
    }

    public int getBoardSize () {
        return this.boardSize; 
    }

}