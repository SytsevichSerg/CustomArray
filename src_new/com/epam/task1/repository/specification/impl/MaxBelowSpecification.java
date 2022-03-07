
package com.epam.task1.repository.specification.impl;

import com.epam.task1.entity.EntityArray;
import com.epam.task1.exception.EntityArrayException;
import com.epam.task1.repository.Specification;
import com.epam.task1.service.ArrayProcessService;
import com.epam.task1.service.impl.ArrayProcessServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MaxBelowSpecification implements Specification{
    private static final Logger LOG = LogManager.getLogger();
    private final int max;
    
    public MaxBelowSpecification(int max){
        this.max = max;
    }

    @Override
    public boolean specify(EntityArray array) {
     boolean result = false;
        ArrayProcessService service = new ArrayProcessServiceImpl();
        try{
            int max = service.findMaxStream(array);
            result = (this.max < max);
        }catch (EntityArrayException e) {
            LOG.warn("Something is wrong with max", e);
        }
        return result;
    }
}
