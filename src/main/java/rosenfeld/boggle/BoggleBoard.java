package rosenfeld.boggle;

import java.lang.reflect.Array;
import java.util.*;

public class BoggleBoard {

    private final int CUBE_SIDES = 6;
    private int boardSize;
    private List<String> cubeSet;
    private Random random = new Random();

    public BoggleBoard(int size) {
        boardSize = size;
        if (size == 4) {
            cubeSet = fourByFourCubes();
        } else if (size == 5) {
            cubeSet = fiveByFiveCubes();
        }
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

    public List<String> shuffleCubes()  {
        List<String> cubes = new ArrayList<>();
        for (String cube : cubeSet) {
            cubes.add(String.valueOf(cube.charAt(random.nextInt(CUBE_SIDES))));
        }
        if (cubes.contains("Q")){
            cubes.set(cubes.indexOf("Q"), "Qu");
        }
        Collections.shuffle(cubes);
        return cubes;
    }

    public int getBoardSize () {
        return this.boardSize; 
    }

}