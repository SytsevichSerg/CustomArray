
package com.epam.task1.repository.specification.impl;

import com.epam.task1.entity.EntityArray;
import com.epam.task1.exception.EntityArrayException;
import com.epam.task1.repository.Specification;
import com.epam.task1.service.ArrayProcessService;
import com.epam.task1.service.impl.ArrayProcessServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MinEqualsSpecification implements Specification{
    private static final Logger LOG = LogManager.getLogger();
    private final int min;
    
    public MinEqualsSpecification (int min){
        this.min = min;
    }

    @Override
    public boolean specify(EntityArray array) {
       boolean result = false;
        ArrayProcessService service = new ArrayProcessServiceImpl();
        try{
            int min = service.findMinStream(array);
            result = (this.min == min);
        }catch (EntityArrayException e) {
            LOG.warn("Something is wrong with min", e);
        }
        return result;
    }
    
}
