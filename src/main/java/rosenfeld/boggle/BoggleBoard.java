package rosenfeld.boggle;

import java.util.*;

public class BoggleBoard {

    private final int CUBE_SIDES = 6;
    private int boardSize;
    private List<String> cubeSet;
    private Random random = new Random();
    private Stack<String> stack = new Stack<>();

    public BoggleBoard(int size) {
        cubeSet = fourByFourCubes();
        shuffleCubes();
    }

    public List<String> fourByFourCubes() {
        return Arrays.asList(
                "AAEGN", "ABBJOO", "ACHOPS", "AFFKPS",
                "AOOTTW", "CIMOTU", "DEILRX", "DELRVY",
                "DISTTY", "EEGHNW", "EEINSU", "EHRTVW",
                "EIOSST", "ELRTTY", "HIMNQU", "HLNNRZ");
    }

    public List<String> fiveByFiveCubes() {
        return Arrays.asList(
                "CCNSTW", "EMOTTT", "AEEEM", "BJKQXZ", "DDLNOR",
                "CEILPT", "AEGMNN", "DHLNOR", "CEIILT", "ENSSSU",
                "AFIRSY", "AAFIRS", "AAEEEE", "AEEGMU", "NOOTUW",
                "OOOTTU", "ADENNN", "FIPRSY", "DHHNOT", "CEIPST",
                "AAAFRS", "GORRVW", "HIPRRY", "EIIITT", "DHHLOR"
        );
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

    public int getBoardSize () {
        return this.boardSize; 
    }

}