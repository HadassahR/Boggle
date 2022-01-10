package rosenfeld.boggle;

/*
    More about Trie data structure: https://www.geeksforgeeks.org/boggle-set-2-using-trie/?ref=lbp
    See ReadMe for additional resources.
 */
public class WordTrie {
    private Node root;
    private int wordCount = 0;

    public WordTrie(){
        root = new Node ('*');
    }

    public void insert (String word) {
        word = word.toUpperCase();
        Node curr = root;
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            int index = c - 'A';
            if (curr.children[index] == null){
                curr.children [index] = new Node (c);
            }
            curr = curr.children[index];
        }
        curr.isWord = true;
        wordCount ++;
    }

    public boolean isWord(String word){
        word = word.toUpperCase();
        Node node = getNode(word);
        return node != null && node.isWord;
    }

    public boolean startsWith (String prefix) {
        prefix = prefix.toUpperCase();
        return getNode(prefix) != null;
    }

    public int getWordCount() {
        return this.wordCount;
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
