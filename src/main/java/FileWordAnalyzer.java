import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileWordAnalyzer {
    List<String> stringList;
    FilePartReader filePartReader;
    String fileLines;

    FileWordAnalyzer(FilePartReader filePartReader){
        stringList = new ArrayList<>();
        this.filePartReader = filePartReader;
    }

    public List<String> getWordsOrderedAlphabetically (){
        addWordsToArray();
        return stringList.stream().sorted().collect(Collectors.toList());
    }

    public List<String> getWordsContainingSubstring (String subString ) {
        addWordsToArray();
        return stringList.stream().filter(s -> s.contains(subString)).collect(Collectors.toList());
    }

    public List<String> getStringsWhichPalindromes (){
        addWordsToArray();
        return stringList.stream().filter(this::checkIfIsPalindrome).collect(Collectors.toList());

    }


    public void addWordsToArray(){
        stringList.clear();
        fileLines = filePartReader.read();
        String[] strings = fileLines.split("\\W+");
        stringList = new ArrayList<>(Arrays.asList(strings));
    }

    private boolean checkIfIsPalindrome(String word){
        int remainder, temp, sum = 0;
        int wordLength = word.length();
        temp = wordLength;
        while(wordLength > 0){
            remainder = wordLength % 10;
            sum = (sum * 10) + remainder;
            wordLength /= 10;
        }
        return temp == sum;
    }

}
