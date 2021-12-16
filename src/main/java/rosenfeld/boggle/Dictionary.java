package rosenfeld.boggle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Dictionary {

    private final Map<String, String> wordsToDefinitions = new HashMap<>();

    public Dictionary () throws IOException {
        InputStream in = getClass().getClassLoader().getResourceAsStream("dictionary.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line;
        while (((line = reader.readLine()) != null)) {
            String [] wordDef = line.split(" ", 2);
            String word = wordDef[0];
            String definition = wordDef.length == 1 ? "" : wordDef[1];
            wordsToDefinitions.put(word, definition);
        }
    }


    public boolean checkForWord(String word) {
        return wordsToDefinitions.containsKey(word.toUpperCase().trim());
    }

    public String getDefinition(String word) {
        String definition = wordsToDefinitions.get(word.toUpperCase().trim());
        return definition == null ? "" : definition;
    }

    public Map<String, String> getWordsToDefinitions() {
        return wordsToDefinitions;
    }
    public int size() {
        return wordsToDefinitions.size();
    }
}
