
package test.epam.task1.creator;

import com.epam.task1.creator.impl.EntityArrayCreatorImpl;
import com.epam.task1.entity.EntityArray;
import java.util.ArrayList;
import java.util.List;
import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EntityArrayCreatorTest {
    
    public EntityArrayCreatorTest() {
    }

    EntityArrayCreatorImpl creator = new EntityArrayCreatorImpl();

    @DataProvider(name = "create_array_data")
    public Object[][] createDataForCreateOneArray() {
        Object[][] data = new Object[5][2];
        data[0] = new Object[]{
                new int[]{4, -5, -3, 14, 4},
                new EntityArray(4, -5, -3, 14, 4)
        };
        data[1] = new Object[]{
                new int[]{14, -100, 0},
                new EntityArray(14, -100, 0)
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
        listOfArrays.add(new int[]{4, -5, -3, 14, 4});
        listOfArrays.add(new int[]{14, -100, 0});
        listOfArrays.add(new int[]{0});
        listOfArrays.add(new int[0]);
        listOfArrays.add(null);
        return listOfArrays;
    }

    public List<EntityArray> createListOfCustomArrays() {
        List<EntityArray> listOfArrays = new ArrayList<>();
        listOfArrays.add(new EntityArray(4, -5, -3, 14, 4));
        listOfArrays.add(new EntityArray(14, -100, 0));
        listOfArrays.add(new EntityArray(0));
        listOfArrays.add(new EntityArray());
        listOfArrays.add(new EntityArray());
        return listOfArrays;
    }

    @Test
    public void testCreateDefaultCustomArray() {
        assertEquals(new EntityArray(), creator.createEntityArray());
    }

    @Test(dataProvider = "create_array_data")
    public void testCreateOneCustomArrayWithParam(int[] elements, EntityArray expected) {
        EntityArray actual = creator.createEntityArray(elements);
        assertEquals(expected, actual);
    }

    @Test(dataProvider = "create_arrays_data")
    public void testCreateListOfCustomArrays(List<int[]> elementsList, List<EntityArray> expected) {
        List<EntityArray> actual = creator.createEntityArray(elementsList);
        ListComparator comparator = new ListComparator();
        assertTrue(comparator.areEqualsListsOfCustomArrays(expected, actual));
    }
}
