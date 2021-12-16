package rosenfeld.boggle;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class DictionaryTest {
        @Test
        public void validCaps_checkForWord() throws IOException {
            Dictionary test = new Dictionary();
            boolean testWord = test.checkForWord("ARGUMENT");
            Assert.assertTrue(testWord);
        }

        @Test
        public void validLower_checkForWord() throws IOException {
            Dictionary test = new Dictionary();
            boolean testWord = test.checkForWord("argument");
            Assert.assertTrue(testWord);
        }

        @Test
        public void validMixedCase_checkForWord() throws IOException {
            Dictionary test = new Dictionary();
            boolean testWord = test.checkForWord("arGuMENT");
            Assert.assertTrue(testWord);
        }

        @Test
        public void invalid_checkForWord() throws IOException {
            Dictionary test = new Dictionary();
            boolean testWord = test.checkForWord("hadassah");
            Assert.assertFalse(testWord);
        }

        @Test
        public void validWhitespace_checkForWord() throws IOException {
            Dictionary test = new Dictionary();
            boolean testWord = test.checkForWord("   plagiarism   ");
            Assert.assertTrue(testWord);
        }
        @Test
        public void invalidEmptyInput_checkForWord() throws IOException {
            Dictionary test = new Dictionary();
            boolean testWord = test.checkForWord(" ");
            Assert.assertFalse(testWord);
        }

        @Test
        public void validFirstWord_checkForWord() throws IOException {
            Dictionary test = new Dictionary();
            boolean testWord = test.checkForWord("AA");
            Assert.assertTrue(testWord);
        }

        @Test
        public void validLastWord_checkForWord() throws IOException {
            Dictionary test = new Dictionary();
            boolean testWord = test.checkForWord("zoogeographical");
            Assert.assertTrue(testWord);
        }

        @Test
        public void hasDefinition() throws IOException {
            Dictionary test = new Dictionary();
            String testDef = test.getDefinition("ENJOY");
            Assert.assertEquals("to receive pleasure from [v -ED, -ING, -S]", testDef);
        }

        @Test
        public void doesNotHaveDefinition() throws IOException {
            Dictionary test = new Dictionary();
            String testDef = test.getDefinition("Hadassah");
            Assert.assertEquals("", testDef);
        }
    }
