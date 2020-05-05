import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {


    @Test
    public void testIfSetupDoesNotThrowError(){
        FilePartReader filePartReader = new FilePartReader();
        assertDoesNotThrow( () -> filePartReader.setup("src/resources/", 1, 10));
    }

    @Test
    public void testIllegalArgumentExceptionThrownIfFomLineIsLowerThan1() {
        FilePartReader filePartReader = new FilePartReader();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                filePartReader.setup("src/resources/", 0, 100));
        assertEquals("IllegalArgumentException", exception.getMessage());
    }

    @Test
    public void testIllegalArgumentExceptionThrownIfToLineIsGreaterThanFromLine() {
        FilePartReader filePartReader = new FilePartReader();
        assertThrows(
                IllegalArgumentException.class,
                () -> filePartReader.setup("src/resources/", 5, 3)
        );
    }

    @Test()
    public void testIfPathIsWrongAndFileIsNotFound(){
        FilePartReader filePartReader = new FilePartReader();
        assertThrows(
                FileNotFoundException.class,
                () -> filePartReader.setup("/s", 1, 5)
        );
    }

    @Test
    public void testReadAllTextFromFile() throws FileNotFoundException {
        FilePartReader filePartReader = new FilePartReader();
        String expected = "dddddddddd\n" +
                "ba aa\n" +
                "ee\n" +
                "ii";
        filePartReader.setup("src/resources/", 1, 10);
        assertEquals(expected, filePartReader.read());
    }
}