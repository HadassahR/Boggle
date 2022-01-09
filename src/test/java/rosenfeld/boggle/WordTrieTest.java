package rosenfeld.boggle;
import org.junit.Assert;
import org.junit.Test;

public class WordTrieTest {

    private String[] sampleDictionary = new String [] { "LANGUAGE", "SYNTAX", "ENVIRONMENT", "COMPILER", "PROGRAMMING",
                                                        "DATA", "OBJECT", "class", "DEVELOPMENT", "DATABASE", "CONCATENATE",
                                                        "DEBUGGER", "DEVELOPER", "software", "JAVA"};

    @Test
    public void insert(){
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
    public void search() {
        // given
        WordTrie wordTrie = new WordTrie();
        for (String word : sampleDictionary) {
            wordTrie.insert(word);
        }

        // when
        boolean search1 = wordTrie.search("data"); // true
        boolean search2 = wordTrie.search("ENVIRON");  // false
        boolean search3 = wordTrie.search("PYTHON"); // false
        boolean search4 = wordTrie.search("CONCATENATE"); // true


        // then
        Assert.assertTrue(search1);
        Assert.assertFalse(search2);
        Assert.assertFalse(search3);
        Assert.assertTrue(search4);
    }

    @Test
    public void startsWith(){
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
