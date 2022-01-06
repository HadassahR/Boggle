package rosenfeld.boggle;

public class MyTrie {
    private Node root;

    public MyTrie(){
        root = new Node ('*');
    }

    public void insert (String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null){
                curr.children [c - 'a'] = new Node (c);
            }
            curr = curr.children[c - 'a'];
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
            if (curr.children[c - 'a'] == null) {
                return null;
            }
            curr = curr.children[c - 'a'];
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
