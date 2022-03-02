
package com.epam.task1.service;

import com.epam.task1.entity.EntityArray;

public interface ArraySortService {
    
    void bubbleSort(EntityArray array);

    void insertionSort(EntityArray array);

    void shakeSort(EntityArray array);

    void streamSort(EntityArray array);
}