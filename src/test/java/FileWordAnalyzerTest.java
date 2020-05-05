import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest {
    FilePartReader filePartReader = new FilePartReader();

    @Test
    public void testGetWordsOrderedAlphabetically() throws IOException {
        filePartReader.setup("src/resources/",1, 100);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
        assertEquals(new ArrayList<>(Arrays.asList("aa", "ba", "dddddddddd", "ee", "ii")),
                fileWordAnalyzer.getWordsOrderedAlphabetically());
    }

    @Test
    public void testGetWordsContainingSubstring() throws IOException {
        filePartReader.setup("src/resources/",1, 100);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
        assertEquals(new ArrayList<>(Arrays.asList("ba","aa")),
                fileWordAnalyzer.getWordsContainingSubstring("a"));
    }

    @Test
    public void testGetStringsWhichPalindromes() throws IOException {
        filePartReader.setup("src/resources/", 1, 100);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
        assertEquals(new ArrayList<>(Arrays.asList("ba", "aa", "ee", "ii")),
                fileWordAnalyzer.getStringsWhichPalindromes());
    }

    @Test
    public void testGetAllWordsFromSentence() throws FileNotFoundException {
        filePartReader.setup("src/resources/", 1, 100);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
        fileWordAnalyzer.addWordsToArray();
        assertEquals(new ArrayList<>(Arrays.asList("dddddddddd","ba", "aa", "ee", "ii")),
                fileWordAnalyzer.stringList);
    }
}