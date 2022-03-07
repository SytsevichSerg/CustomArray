
package com.epam.task1.creator;

import com.epam.task1.entity.EntityArray;
import java.util.List;

public interface EntityArrayCreator {
    EntityArray createEntityArray(EntityArray array);
    EntityArray createEntityArray(int[] array);
    EntityArray createEntityArray();
    List<EntityArray> createEntityArrays(List<int[]> array);
}
