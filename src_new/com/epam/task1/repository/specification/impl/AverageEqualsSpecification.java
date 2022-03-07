package com.epam.task1.repository.specification.impl;

import com.epam.task1.entity.EntityArray;
import com.epam.task1.exception.EntityArrayException;
import com.epam.task1.repository.Specification;
import com.epam.task1.service.ArrayProcessService;
import com.epam.task1.service.impl.ArrayProcessServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AverageEqualsSpecification implements Specification{
    private static final Logger LOG = LogManager.getLogger();
    private final double average;
            
    public AverageEqualsSpecification(double average){
        this.average = average;
    }
            
    @Override
    public boolean specify(EntityArray array) {
        boolean result = false;
        ArrayProcessService service = new ArrayProcessServiceImpl();
        try{
            double average = service.calcAverageStream(array);
            result = (this.average==average);
        }catch (EntityArrayException e) {
            LOG.warn("Something is wrong with average", e);
        }
        return result;
    }
    
}
