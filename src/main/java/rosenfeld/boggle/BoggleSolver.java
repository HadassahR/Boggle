package rosenfeld.boggle;
import java.util.List;
import java.util.stream.Collectors;

public class BoggleSolver {
    private BoggleBoard boggleBoard;
    private List<String> boggleDictionary;
    private WordTrie boggleTrie;

    public BoggleSolver(BoggleBoard board, Game game){
        boggleBoard = board;
        boggleDictionary = game.dictionary.getWordList().stream().filter(w -> w.length() > 3).collect(Collectors.toList());
        boggleTrie = new WordTrie();
        createTrie();
    }

    public void createTrie(){
        boggleTrie = new WordTrie();
        for (String word : boggleDictionary){
            boggleTrie.insert(word);
        }
    }

}







