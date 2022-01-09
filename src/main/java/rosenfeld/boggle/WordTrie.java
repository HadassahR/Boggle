package rosenfeld.boggle;

import java.io.IOException;

public class WordTrie {
    private Node root;

    public WordTrie(){
        root = new Node ('*');
    }

    public void insert (String word) {
        word = word.toUpperCase();
        Node curr = root;
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if (curr.children[c - 'A'] == null){
                curr.children [c - 'A'] = new Node (c);
            }
            curr = curr.children[c - 'A'];
        }
        curr.isWord = true;
    }

    public boolean search (String word){
        Node node = getNode(word);
        return node != null && node.isWord;
    }

    private Node getNode (String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if (curr.children[c - 'A'] == null) {
                return null;
            }
            curr = curr.children[c - 'A'];
        }
        return curr;
    }

    public boolean startsWith (String prefix) {
        return getNode(prefix) != null;
    }

    class Node {
        public char character;
        public boolean isWord;
        public Node[] children;

        public Node (char c) {
            character = c;
            isWord = false;
            children = new Node[26];
        }
    }
}
