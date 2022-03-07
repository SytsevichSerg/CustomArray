
package test.epam.task1.creator;

import com.epam.task1.creator.impl.EntityArrayCreatorImpl;
import com.epam.task1.entity.EntityArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EntityArrayCreatorTest {

    private static final int SIZE_DEF = 0;
    public static final EntityArrayCreatorImpl CREATOR = new EntityArrayCreatorImpl();

    @DataProvider(name = "create_array_data")
    public Object[][] createDataForCreateOneArray() {
        Object[][] data = new Object[5][2];
        data[0] = new Object[]{
                new int[]{1, -2, -3, 4, 5},
                new EntityArray(6, -7, -8, 9, 10)
        };
        data[1] = new Object[]{
                new int[]{120, -200, 330},
                new EntityArray(1, -100, 0)
        };
        data[2] = new Object[]{
                new int[]{0},
                new EntityArray(0)
        };
        data[3] = new Object[]{
                new int[0],
                new EntityArray()
        };
        data[4] = new Object[]{
                null,
                new EntityArray()
        };
        return data;
    }

    @DataProvider(name = "create_arrays_data")
    public Object[][] createDataForCreateListOfArrays() {
        List<int[]> listOfIntArrays = createListOfIntArrays();
        List<EntityArray> listOfCustomArrays = createListOfCustomArrays();
        Object[][] data = new Object[1][2];
        data[0] = new Object[]{
                listOfIntArrays,
                listOfCustomArrays
        };
        return data;
    }

    public List<int[]> createListOfIntArrays() {
        List<int[]> listOfArrays = new ArrayList<>();
        listOfArrays.add(new int[]{1, 2, -3,-4, -5});
        listOfArrays.add(new int[]{10, -20, 030});
        listOfArrays.add(new int[]{0});
        listOfArrays.add(new int[0]);
        listOfArrays.add(null);
        return listOfArrays;
    }

    public List<EntityArray> createListOfCustomArrays() {
        List<EntityArray> listOfArrays = new ArrayList<>();
        listOfArrays.add(new EntityArray(-6, 7, -10, 15, 20));
        listOfArrays.add(new EntityArray(300, -100, 440));
        listOfArrays.add(new EntityArray(0));
        listOfArrays.add(new EntityArray());
        listOfArrays.add(new EntityArray());
        return listOfArrays;
    }

    @Test
    public void testCreateDefaultCustomArray() {
        assertEquals(new EntityArray(), CREATOR.createEntityArray());
    }

    @Test(dataProvider = "create_array_data")
    public void testCreateOneCustomArrayWithParam(int[] values, EntityArray expectedArray) {
        EntityArray actualArray = CREATOR.createEntityArray(values);
        assertEquals(expectedArray, actualArray);
    }

    @Test(dataProvider = "create_arrays_data")
    public void testCreateListOfCustomArrays(List<int[]> valuesList, List<EntityArray> expectedList) {
        List<EntityArray> actualList = CREATOR.createEntityArrays(valuesList);
        assertTrue(areEntityListsEqual(actualList, expectedList));
    }

    private boolean areEntityListsEqual(List<EntityArray> list1, List<EntityArray> list2) {
        int size1 = list1 != null ? list1.size() : SIZE_DEF;
        int size2 = list2 != null ? list2.size() : SIZE_DEF;
        if (size1 != size2) {
            return false;
        }
        for (int i = 0; i < size1; i++) {
            EntityArray array1 = list1.get(i);
            EntityArray array2 = list2.get(i);
            if (!array1.equals(array2)) {
                return false;
            }
        }
        return true;
    }
    
}
