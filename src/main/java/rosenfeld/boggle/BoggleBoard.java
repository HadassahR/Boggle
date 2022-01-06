package rosenfeld.boggle;
import java.util.*;

public class BoggleBoard {

    private final int BOARD_SIZE = 4;
    private final List<String> fourByFourLetterSet;
    private String[][] boggleMatrix;
    private Stack<String> boggleStack = new Stack<>();
    private Random random = new Random();

    public BoggleBoard() {
        fourByFourLetterSet = getCubeSet();
        configureCubes();
    }

    public List<String> getCubeSet() {
        return Arrays.asList(
                "AAEEGN", "ABBJOO", "ACHOPS", "AFFKPS",
                "AOOTTW", "CIMOTU", "DEILRX", "DELRVY",
                "DISTTY", "EEGHNW", "EEINSU", "EHRTVW",
                "EIOSST", "ELRTTY", "HIMNQU", "HLNNRZ");
    }

    public void configureCubes()  {
        List<String> shuffledCubes = new ArrayList<>();
        int CUBE_SIDES = 6;
        for (String cube : fourByFourLetterSet) {
            shuffledCubes.add(String.valueOf(cube.charAt(random.nextInt(CUBE_SIDES))));
            if (shuffledCubes.contains("Q")){
                shuffledCubes.set(shuffledCubes.indexOf("Q"), "Qu");
            }
        }

        Collections.shuffle(shuffledCubes);
        boggleStack.addAll(shuffledCubes);
        Stack<String> stackCopy =  boggleStack;
        boggleMatrix = new String[BOARD_SIZE][BOARD_SIZE];

        for (int r = 0; r < BOARD_SIZE; r++) {
            for (int c = 0; c < BOARD_SIZE; c++) {
                boggleMatrix[r][c] = stackCopy.pop();
            }
        }
    }

    public String nextLetter () {
        return boggleStack.pop();
    }

    public String[][] getCubes () {
        return this.boggleMatrix;
    }

    public int getBoardSize() {
        return this.BOARD_SIZE;
    }

}