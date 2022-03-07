
package test.epam.task1.service.impl;

import com.epam.task1.entity.EntityArray;
import com.epam.task1.exception.EntityArrayException;
import com.epam.task1.service.impl.ArrayReplaceServiceImpl;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class ArrayReplaceServiceImplTest {
    public static final ArrayReplaceServiceImpl REPLACE_SERVICE = new ArrayReplaceServiceImpl();
    
    @DataProvider(name = "data_replaceAllValues")
    public Object[][] dataForReplaceAllValues() {
        Object[][] data = new Object[2][2];
        data[0] = new Object[]{
                new EntityArray(-1, 2, -3, 4),
                5, 
                55,
                new EntityArray(6, -7, 88, 9999)
        };

        data[1] = new Object[]{
                new EntityArray(4, 3, -2, 1),
                88,
                987,
                new EntityArray(9, 8, 7, 6)
        };
        return data;
    }
    
    @Test(dataProvider = "data_replaceAllValues")
    public void testReplaceAllValues(EntityArray actualArray, int value, int replacement, EntityArray expecteArrayd) throws EntityArrayException{
        REPLACE_SERVICE.replaceAllValues(actualArray, value, replacement);
        assertEquals(actualArray, expecteArrayd);
    }
}
