package rosenfeld.boggle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BoggleSolver {

    public BoggleSolver(){

    }

    public void createTrie() throws IOException {
        Dictionary dictionary = new Dictionary();
        List<String> words = dictionary.getWordList();
        MyTrie trie = new MyTrie();
        for (String word : dictionary.getWordList()){
            trie.insert(word);
        }
        System.out.println("done");
    }

    public static void main(String[] args) throws IOException {
        BoggleSolver solver = new BoggleSolver();
        solver.createTrie();
    }
}







