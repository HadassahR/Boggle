package rosenfeld.boggle;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BoggleDictionary {

    private List<String> wordList;

    public BoggleDictionary() throws IOException {
        InputStream in = getClass().getClassLoader().getResourceAsStream("dictionary.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        wordList = new ArrayList<>();
        String line;
        while (((line = reader.readLine()) != null)) {
            String [] wordDef = line.split(" ", 2);
            wordList.add(wordDef[0]);
        }
        wordList = wordList.stream().filter(w -> w.length() > 3).collect(Collectors.toList());
    }

    public boolean checkForWord(String word) {
        return wordList.contains(word.toUpperCase().trim());
    }

    public List<String> getWordList(){
        return this.wordList;
    }

    public int size() {
        return wordList.size();
    }
}
