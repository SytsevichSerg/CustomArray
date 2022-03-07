package com.epam.task1.repository.specification.impl;

import com.epam.task1.entity.EntityArray;
import com.epam.task1.exception.EntityArrayException;
import com.epam.task1.repository.Specification;
import com.epam.task1.service.ArrayProcessService;
import com.epam.task1.service.impl.ArrayProcessServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SumAboveSpecification implements Specification{
    
    private static final Logger LOG = LogManager.getLogger();
    private final double sum;
            
    public SumAboveSpecification(double sum){
        this.sum = sum;
    }
    @Override
    public boolean specify(EntityArray array) {
    boolean result = false;
        ArrayProcessService service = new ArrayProcessServiceImpl();
        try{
            double sum = service.calcSummStream(array);
            result = (this.sum > sum);
        }catch (EntityArrayException e) {
            LOG.warn("Something is wrong with sum", e);
        }
        return result;    
    }
    
}
