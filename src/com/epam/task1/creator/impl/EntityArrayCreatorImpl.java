
package com.epam.task1.creator.impl;

import com.epam.task1.creator.EntityArrayCreator;
import com.epam.task1.entity.EntityArray;
import java.util.ArrayList;
import java.util.List;


public class EntityArrayCreatorImpl implements EntityArrayCreator{

    @Override
    public EntityArray createEntityArray(int[] array) {
        return array != null ? new EntityArray(array) : new EntityArray();
    }

    @Override
    public EntityArray createEntityArray() {
         return new EntityArray();
    }

    @Override
    public List<EntityArray> createEntityArrays(List<int[]> array) {
       List<EntityArray> enArray = new ArrayList<>();
        if (array == null) {
            return enArray;
        }
        EntityArray currentArray;
        for (int[] elements : array) {
            currentArray = createEntityArray(elements);
            enArray.add(currentArray);
        }
        return enArray;
    }
    
}
