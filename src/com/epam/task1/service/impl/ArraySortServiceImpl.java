
package com.epam.task1.service.impl;

import com.epam.task1.entity.EntityArray;
import com.epam.task1.service.ArraySortService;
import java.util.Arrays;
import java.util.stream.IntStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ArraySortServiceImpl implements ArraySortService{

    private static final Logger ARRLOG = LogManager.getLogger(ArrayProcessServiceImpl.class.getName());
    
    @Override
    public void bubbleSort(EntityArray array) {
        ARRLOG.info("insertionSort  ...");
        
        int[] arrayHelper = array.getArray();
        boolean isSorted = false;
        int buf;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < arrayHelper.length - 1; i++) {
                if (arrayHelper[i] > arrayHelper[i + 1]) {
                    isSorted = false;
                    buf = arrayHelper[i];
                    arrayHelper[i] = arrayHelper[i + 1];
                    arrayHelper[i + 1] = buf;
                }
            }
        }

        array.setArray(arrayHelper);
    }

    @Override
    public void insertionSort(EntityArray array)  {
        ARRLOG.info("insertionSort  ...");
        
        int[] arrayHelper = array.getArray();
        for (int left = 0; left < arrayHelper.length; left++) {
            // Вытаскиваем значение элемента
            int value = arrayHelper[left];
            // Перемещаемся по элементам, которые перед вытащенным элементом
            int i = left - 1;
            for (; i >= 0; i--) {
                    // Если вытащили значение меньшее — передвигаем больший элемент дальше
                    if (value < arrayHelper[i]) {
                            arrayHelper[i + 1] = arrayHelper[i];
                    } else {
                            // Если вытащенный элемент больше — останавливаемся
                            break;
                    }
            }
            // В освободившееся место вставляем вытащенное значение
            arrayHelper[i + 1] = value;
        }
        array.setArray(arrayHelper);
    }

    @Override
    public void shakeSort(EntityArray array) {
        
    }

    @Override
    public void streamSort(EntityArray array) {
        ARRLOG.info("Stream: sort array ...");
        
        int[] arrayHelper = array.getArray();
        IntStream intStream = Arrays.stream(arrayHelper);
        int[] newArray = intStream.sorted().toArray();
        array.setArray(newArray);
    }
    
}
