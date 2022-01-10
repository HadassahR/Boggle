package rosenfeld.boggle;
import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;

public class WordTrieTest {

    private String[] sampleDictionary = new String [] { "LANGUAGE", "SYNTAX", "ENVIRONMENT", "COMPILER", "PROGRAMMING",
                                                        "DATA", "OBJECT", "class", "DEVELOPMENT", "DATABASE", "CONCATENATE",
                                                        "DEBUGGER", "DEVELOPER", "software", "JAVA"};

    @Test
    public void dictionary() throws IOException {
        // given
        WordTrie wordTrie = new WordTrie(new BoggleDictionary());

        // when
        int dictionaryCount = wordTrie.getWordCount();

        // then
        Assert.assertEquals(166896, dictionaryCount);
    }

    @Test
    public void insert() {
        // given
        WordTrie wordTrie = new WordTrie();

        // when
        for (String word : sampleDictionary) {
            wordTrie.insert(word);
        }

        // then
        Assert.assertEquals(15, wordTrie.getWordCount());
    }

    @Test
    public void isWord() {
        // given
        WordTrie wordTrie = new WordTrie();
        for (String word : sampleDictionary) {
            wordTrie.insert(word);
        }

        // when
        boolean search1 = wordTrie.isWord("data"); // true
        boolean search2 = wordTrie.isWord("ENVIRON");  // false
        boolean search3 = wordTrie.isWord("PYTHON"); // false
        boolean search4 = wordTrie.isWord("CONCATENATE"); // true


        // then
        Assert.assertTrue(search1);
        Assert.assertFalse(search2);
        Assert.assertFalse(search3);
        Assert.assertTrue(search4);
    }

    @Test
    public void startsWith() {
        // given
        WordTrie wordTrie = new WordTrie();
        for (String word : sampleDictionary) {
            wordTrie.insert(word);
        }

        // when
        boolean search1 = wordTrie.startsWith("class"); // true
        boolean search2 = wordTrie.startsWith("ENVIRON");  // true
        boolean search3 = wordTrie.startsWith("PYTHON"); // false
        boolean search4 = wordTrie.startsWith("CONCAT"); // true
        boolean search5 = wordTrie.startsWith("DATA");// true


        // then
        Assert.assertTrue(search1);
        Assert.assertTrue(search2);
        Assert.assertFalse(search3);
        Assert.assertTrue(search4);
        Assert.assertTrue(search5);
    }

}
