
package test.epam.task1.validator;

import com.epam.task1.validator.SourceRowValidator;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class SourceRowValidatorTest {
    public static final SourceRowValidator VALIDATOR = SourceRowValidator.getInstance();
    
    @DataProvider(name = "good_data")
    public Object[][] createGoodData() {
        Object[][] data = new Object[3][1];
        data[0] = new String[]{"1; -2; 3"};
        data[1] = new String[]{"4  ;-  5;   6; -9"};
        data[2] = new String[]{"       "};

        return data;
    }
    
    @Test(dataProvider = "good_data")
    public void testGoodRowForGoodData(String row) {
        assertTrue(VALIDATOR.iSRowValid(row));
    }
    
   @DataProvider(name = "poor_data")
    public Object[][] createPoorData() {
        Object[][] data = new String[5][1];
        data[0] = new String[]{"xx"};
        data[1] = new String[]{"12, 124tt5; 12"};
        data[2] = new String[]{"Igor-;  99"};
        data[3] = new String[]{"3; .14 *; 15465434"};
        data[4] = new String[]{"4, 5; 7"};
     
        return data;
    }
    
    @Test(dataProvider = "poor_data")
    public void testPoorRowForPoorData(String row) {
        assertFalse(VALIDATOR.iSRowValid(row));
    }
}
