
package com.epam.task1.service.impl;

import com.epam.task1.entity.EntityArray;
import com.epam.task1.exception.EntityArrayException;
import com.epam.task1.service.ArrayProcessService;
import com.epam.task1.observer.Observer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayProcessServiceImpl implements ArrayProcessService {

    private static final Logger LOG = LogManager.getLogger(ArrayProcessServiceImpl.class.getName());
    
    @Override
    public int findMax(EntityArray array) throws EntityArrayException {
        LOG.info("Get max from array  ...");
        int[] arrayHelper = array.getArray();
        if (arrayHelper.length  == 0) {
            
            LOG.error("Given array is empty");
            throw new EntityArrayException(" Given array is empty!");
        }
        
        int maxArr = arrayHelper[0];
        for (int i = 1; i < arrayHelper.length; i++) {
            if (arrayHelper[i] > maxArr) 
                maxArr = arrayHelper[i];
        }
        return maxArr;
    }

    @Override
    public int findMin(EntityArray array) throws EntityArrayException {
        LOG.info("Get min from array ...");
        
        int[] arrayHelper = array.getArray();
        if (arrayHelper.length == 0){ 
        
            LOG.error("Given array is empty");
            throw new EntityArrayException(" Given array is empty!");
        }
        
        int minArr = arrayHelper[0];
        for (int i = 1; i < arrayHelper.length; i++) {
            if (arrayHelper[i] < minArr) {
                minArr = arrayHelper[i];
            }
        }
        return minArr;
    }

    @Override
    public double calcSumm(EntityArray array) throws EntityArrayException {
        LOG.info("Calculate Sum  ...");
        
        int[] arrayHelper = array.getArray();
        if (arrayHelper.length == 0) {
            return 0;
        }
        double sum = arrayHelper[0];
        for (int i = 1; i < arrayHelper.length; i++) {
            if(sum<Double.MAX_VALUE)
                sum += arrayHelper[i];
            else {
                
                LOG.error("Sum is bigger as Double.MAX_VALUE");
                throw new EntityArrayException("Sum is bigger as Double.MAX_VALUE");
            }
        }
        return sum;
    }

    @Override
    public double calcAverage(EntityArray array) throws EntityArrayException {
        LOG.info("Calculate average ...");

        int[] arrayHelper = array.getArray();
        if (arrayHelper.length == 0) {
            
            LOG.error("Given array is empty");
            throw new EntityArrayException(" Given array is empty!");
        }
        return calcSumm(array) / arrayHelper.length;
    }

    @Override
    public int countPositive(EntityArray array) throws EntityArrayException {
        LOG.info("Count positive ...");
        
        int[] arrayHelper = array.getArray();
        int pos = 0;
         for (int i = 0; i < arrayHelper.length; i++) {
            
             if (arrayHelper[i] > 0) 
                pos++;
        }
        return pos;
    }

    @Override
    public int countNegative(EntityArray array) throws EntityArrayException {
        LOG.info("Count positive  ...");
        
        int[] arrayHelper = array.getArray();
        int neg = 0;
         for (int i = 0; i < arrayHelper.length; i++) {
            
             if (arrayHelper[i] < 0) 
                neg++;
        }
        return neg;
    }

    @Override
    public int findMaxStream(EntityArray array) throws EntityArrayException {
        LOG.info("Stream: get max from array  ...");
        
        int[] arrayHelper = array.getArray();
        IntStream intStream = Arrays.stream(arrayHelper);
        return intStream.max().getAsInt();
    }

    @Override
    public int findMinStream(EntityArray array) throws EntityArrayException {
        LOG.info("Stream: get min from array  ...");
        
        int[] arrayHelper = array.getArray();
        IntStream intStream = Arrays.stream(arrayHelper);
        return intStream.min().getAsInt();
    }

    @Override
    public double calcSummStream(EntityArray array) throws EntityArrayException {
        LOG.info("Stream: calculate sum  ...");
        // todo: doubleStream-> implement
        int[] arrayHelper = array.getArray();
        IntStream intStream = Arrays.stream(arrayHelper);
        return (double)intStream.sum();
    }

    @Override
    public double calcAverageStream(EntityArray array) throws EntityArrayException {
        LOG.info("Stream: calculate average  ...");
        
        int[] arrayHelper = array.getArray();
        IntStream intStream = Arrays.stream(arrayHelper);
        return intStream.average().getAsDouble();
    }

    @Override
    public int countPositiveStream(EntityArray array) throws EntityArrayException {
        LOG.info("Stream: count positive  ...");
        
        int[] arrayHelper = array.getArray();
        IntStream intStream = Arrays.stream(arrayHelper);
        return (int)intStream.filter((o) -> o > 0).count();
    }

    @Override
    public int countNegativeStream(EntityArray array) throws EntityArrayException {
        LOG.info("Stream: count negative  ...");
        
        int[] arrayHelper = array.getArray();
        IntStream intStream = Arrays.stream(arrayHelper);
        return (int)intStream.filter((o) -> o < 0).count();
    }
}
    
