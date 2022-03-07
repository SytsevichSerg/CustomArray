
package com.epam.task1.service.impl;

import com.epam.task1.entity.EntityArray;
import com.epam.task1.exception.EntityArrayException;
import com.epam.task1.service.ArrayReplaceService;
import java.util.Arrays;
import java.util.stream.IntStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayReplaceServiceImpl implements ArrayReplaceService{
    private static final Logger LOG = LogManager.getLogger();

    @Override
    public void replaceAllValues(EntityArray entityArray, int value, int replacement) throws EntityArrayException {
        LOG.info("Replace all values in the array");
        if (entityArray == null || entityArray.getArray() == null) {
            LOG.error("EntityArray or its internal array is null");
            throw new EntityArrayException("EntityArray or its internal array is null");
        }
        int[] array = entityArray.getArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                array[i] = replacement;
            }
        }
        entityArray.setArray(array);
        LOG.info("ArrayId:"+ entityArray.getId()+ " | all values equal " + value + " replaced to " + replacement);
    }

    @Override
    public void replaceAllValuesAboveThis(EntityArray entityArray, int value, int replacement) throws EntityArrayException {
        LOG.info("Replace all values in the array above the value");
        if (entityArray == null || entityArray.getArray() == null) {
            LOG.error("EntityArray or its internal array is null");
            throw new EntityArrayException("EntityArray or its internal array is null");
        }
        int[] array = entityArray.getArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] > value) {
                array[i] = replacement;
            }
        }
        entityArray.setArray(array);
        LOG.info("ArrayId:"+ entityArray.getId()+ " | all values above this " + value + " replaced to " + replacement);
    }

    @Override
    public void replaceAllValuesBelowThis(EntityArray entityArray, int value, int replacement) throws EntityArrayException {
        LOG.info("Replace all values in the array below the value");
        if (entityArray == null || entityArray.getArray() == null) {
            LOG.error("EntityArray or its internal array is null");
            throw new EntityArrayException("EntityArray or its internal array is null");
        }
        int[] array = entityArray.getArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] < value) {
                array[i] = replacement;
            }
        }
        entityArray.setArray(array);
        LOG.info("ArrayId:"+ entityArray.getId()+ " | all values below this " + value + " replaced to " + replacement);
    }

    @Override
    public void replaceAllNegativeValues(EntityArray entityArray, int replacement) throws EntityArrayException {
        LOG.info("Replace all negative values in the array");
        if (entityArray == null || entityArray.getArray() == null) {
            LOG.error("EntityArray or its internal array is null");
            throw new EntityArrayException("EntityArray or its internal array is null");
        }
        int[] array = entityArray.getArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                array[i] = replacement;
            }
        }
        entityArray.setArray(array);
        LOG.info("ArrayId:"+ entityArray.getId()+ " | all negative values replaced to " + replacement);
    }

    @Override
    public void replaceAllValuesStream(EntityArray entityArray, int value, int replacement) throws EntityArrayException {
        LOG.info("Replace all values in the array usung stream");
        if (entityArray == null || entityArray.getArray() == null || entityArray.getArray().length==0) {
            LOG.error("EntityArray or its internal array is null or empty");
            throw new EntityArrayException("EntityArray or its internal array is null or empty");
        }
  
        IntStream stream = Arrays.stream(entityArray.getArray());
        int[] newValues = stream.map((m) -> (m == value) ? replacement : m).toArray();
        entityArray.setArray(newValues);
        LOG.info("ArrayId:"+ entityArray.getId()+ " | all values equal " + value + " replaced to " + replacement);
    }

    @Override
    public void replaceAllValuesAboveThisStream(EntityArray entityArray, int value, int replacement) throws EntityArrayException {
        LOG.info("Replace all values in the array above the value usung stream");
        if (entityArray == null || entityArray.getArray() == null || entityArray.getArray().length==0) {
            LOG.error("EntityArray or its internal array is null or empty");
            throw new EntityArrayException("EntityArray or its internal array is null or empty");
        }
  
        IntStream stream = Arrays.stream(entityArray.getArray());
        int[] newValues = stream.map((m) -> (m > value) ? replacement : m).toArray();
        entityArray.setArray(newValues);
        LOG.info("ArrayId:"+ entityArray.getId()+ " | all values above " + value + " replaced to " + replacement);
    }

    @Override
    public void replaceAllValuesBelowThisStream(EntityArray entityArray, int value, int replacement) throws EntityArrayException {
        LOG.info("Replace all values in the array below the value usung stream");
        if (entityArray == null || entityArray.getArray() == null || entityArray.getArray().length==0) {
            LOG.error("EntityArray or its internal array is null or empty");
            throw new EntityArrayException("EntityArray or its internal array is null or empty");
        }
  
        IntStream stream = Arrays.stream(entityArray.getArray());
        int[] newValues = stream.map((m) -> (m < value) ? replacement : m).toArray();
        entityArray.setArray(newValues);
        LOG.info("ArrayId:"+ entityArray.getId()+ " | all values below " + value + " replaced to " + replacement);
    }

    @Override
    public void replaceAllNegativeValuesStream(EntityArray entityArray, int replacement) throws EntityArrayException {
        LOG.info("Replace all negative values in the array usung stream");
        if (entityArray == null || entityArray.getArray() == null || entityArray.getArray().length==0) {
            LOG.error("EntityArray or its internal array is null or empty");
            throw new EntityArrayException("EntityArray or its internal array is null or empty");
        }
  
        IntStream stream = Arrays.stream(entityArray.getArray());
        int[] newValues = stream.map((m) -> (m < 0) ? replacement : m).toArray();
        entityArray.setArray(newValues);
        LOG.info("ArrayId:"+ entityArray.getId()+ " | all negative values replaced to " + replacement);
    }
    
}
