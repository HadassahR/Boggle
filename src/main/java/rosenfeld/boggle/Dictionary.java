package rosenfeld.boggle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dictionary {

    private final Map<String, String> wordsToDefinitions = new HashMap<>();
    private final List<String> wordList;

    public Dictionary () throws IOException {
        InputStream in = getClass().getClassLoader().getResourceAsStream("dictionary.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        wordList = new ArrayList<>();
        String line;
        while (((line = reader.readLine()) != null)) {
            String [] wordDef = line.split(" ", 2);
            String word = wordDef[0];
            String definition = wordDef.length == 1 ? "" : wordDef[1];
            wordsToDefinitions.put(word, definition);
            wordList.add(word);
        }
    }


    public boolean checkForWord(String word) {
        return wordsToDefinitions.containsKey(word.toUpperCase().trim());
    }

    public String getDefinition(String word) {
        String definition = wordsToDefinitions.get(word.toUpperCase().trim());
        return definition == null ? "" : definition;
    }

    public List<String> getWordList(){
        return this.wordList;
    }

    public Map<String, String> getWordsToDefinitions() {
        return wordsToDefinitions;
    }
    public int size() {
        return wordsToDefinitions.size();
    }
}
