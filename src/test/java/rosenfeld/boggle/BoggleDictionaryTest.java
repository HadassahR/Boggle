package rosenfeld.boggle;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class BoggleDictionaryTest {
        @Test
        public void validCaps_checkForWord() throws IOException {
            BoggleDictionary test = new BoggleDictionary();
            boolean testWord = test.checkForWord("ARGUMENT");
            Assert.assertTrue(testWord);
        }

        @Test
        public void validLower_checkForWord() throws IOException {
            BoggleDictionary test = new BoggleDictionary();
            boolean testWord = test.checkForWord("argument");
            Assert.assertTrue(testWord);
        }

        @Test
        public void validMixedCase_checkForWord() throws IOException {
            BoggleDictionary test = new BoggleDictionary();
            boolean testWord = test.checkForWord("arGuMENT");
            Assert.assertTrue(testWord);
        }

        @Test
        public void invalid_checkForWord() throws IOException {
            BoggleDictionary test = new BoggleDictionary();
            boolean testWord = test.checkForWord("hadassah");
            Assert.assertFalse(testWord);
        }

        @Test
        public void validWhitespace_checkForWord() throws IOException {
            BoggleDictionary test = new BoggleDictionary();
            boolean testWord = test.checkForWord("   plagiarism   ");
            Assert.assertTrue(testWord);
        }
        @Test
        public void invalidEmptyInput_checkForWord() throws IOException {
            BoggleDictionary test = new BoggleDictionary();
            boolean testWord = test.checkForWord(" ");
            Assert.assertFalse(testWord);
        }

        @Test
        public void validFirstWord_checkForWord() throws IOException {
            BoggleDictionary test = new BoggleDictionary();
            boolean testWord = test.checkForWord("AA");
            Assert.assertTrue(testWord);
        }

        @Test
        public void validLastWord_checkForWord() throws IOException {
            BoggleDictionary test = new BoggleDictionary();
            boolean testWord = test.checkForWord("zoogeographical");
            Assert.assertTrue(testWord);
        }

        @Test
        public void invalidThreeLetterWord() throws IOException {
            BoggleDictionary test = new BoggleDictionary();
            boolean testWord = test.checkForWord("EYE");
            Assert.assertFalse(testWord);
        }
    }
