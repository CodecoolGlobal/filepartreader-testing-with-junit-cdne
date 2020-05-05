
import java.io.*;
import java.util.stream.Collectors;
import java.io.BufferedReader;

public class FilePartReader {
    private FileReader fileReader;
    private BufferedReader bufferedReader;
    private File file;
    private Integer fromLine;
    private Integer toLine;
    private String result;

    FilePartReader(){
        result = "";
        file = new File("file.txt");
        fileReader = null;

    }

    public void setup(String filePath, Integer fromLine, Integer toLine) throws FileNotFoundException {
        fileReader = new FileReader(filePath + file);
        bufferedReader = new BufferedReader(fileReader);
        this.fromLine = fromLine;
        this.toLine = toLine;
        if(toLine < fromLine || fromLine < 1){
            throw new IllegalArgumentException();
        }
    }

    public String read() {
        result = "";
        result = bufferedReader.lines().collect(Collectors.joining(System.lineSeparator()));
        return result;
    }

    public String readLines() throws IOException {
        int lineCount = 0;
        result = "";
        while(true){
            String line = bufferedReader.readLine();

            if(line == null){
                break;
            }
            lineCount++;
            if( fromLine <= lineCount && toLine > lineCount){
                result += line + "\n";
            }
        }
        bufferedReader.close();
        return result.substring(0, result.length() -1);
    }
}
