
package test.epam.task1.reader;

import com.epam.task1.exception.EntityArrayException;
import com.epam.task1.reader.TxtFileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TxtFileReaderTest {
    
    public static final String TXT_FILE_GOOD_ROWS;
    public static final TxtFileReader TXT_FILE_READER = new TxtFileReader();
    static {
        ClassLoader loader = TxtFileReader.class.getClassLoader();
        URL currentURL = loader.getResource("testTxtFileGoodRows.txt");
        if (currentURL == null) {
            fail("Test file URL equals null");
        }
        TXT_FILE_GOOD_ROWS = currentURL.toString().substring(6);
    }
    
    @DataProvider(name = "good_data")
    public Object[][] createData() {
        List<String> rowsFromFileWithGoodRows = new ArrayList<>();
        rowsFromFileWithGoodRows.add("55; 66; 77; 99;");
        rowsFromFileWithGoodRows.add("65435");
        rowsFromFileWithGoodRows.add("");
        rowsFromFileWithGoodRows.add("");
        rowsFromFileWithGoodRows.add("987; 452    ; 1;         0");
        rowsFromFileWithGoodRows.add("- 5; -   7;  -10");
        List<String> linesFromFileOnlyWithOneCorrectLine = new ArrayList<>();
        linesFromFileOnlyWithOneCorrectLine.add("1 ; -5;    4; 6");
        List<String> linesFromFileWithLastCorrectLine = new ArrayList<>();
        linesFromFileWithLastCorrectLine.add("1; 2; 3; 4; 5");
        List<String> emptyList = new ArrayList<>();

        Object[][] data = new Object[1][2];
        data[0] = new Object[]{
                TXT_FILE_GOOD_ROWS,
                rowsFromFileWithGoodRows
        };
       
        return data;
    }
    
    @Test(dataProvider = "good_data")
    public void testReadAllRows(String fileName, List<String> expectedList) throws EntityArrayException {
        List<String> actualList = TXT_FILE_READER.getFileContents(fileName);
        assertEquals(actualList, expectedList);
    }
    
}
