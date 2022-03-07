
package com.epam.task1.observer.impl;

import com.epam.task1.entity.Warehouse;
import com.epam.task1.entity.EntityArray;
import com.epam.task1.entity.EntityArrayParameters;
import com.epam.task1.exception.EntityArrayException;
import com.epam.task1.service.ArrayProcessService;
import com.epam.task1.service.impl.ArrayProcessServiceImpl;
import com.epam.task1.event.ArrayEvent;
import com.epam.task1.observer.Observer;
import java.util.UUID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayObserver implements Observer{
    private static final Logger LOG = LogManager.getLogger();
    
    @Override
    public void update(ArrayEvent arrayEvent) {
        EntityArray array = (EntityArray)arrayEvent.getSource();
        Warehouse warehouse =  Warehouse.getInstance();
        UUID id = array.getId();
        EntityArrayParameters parameters = warehouse.get(id);
        ArrayProcessService service = new ArrayProcessServiceImpl();
        try {
            double sum = service.calcSumm(array);
            parameters.setSum(sum);
            
            double average = service.calcAverage(array);
            parameters.setAverage(average);
            
            int min = service.findMin(array);
            parameters.setMin(min);
            
            int max = service.findMax(array);
            parameters.setMax(max);
            
        } catch(EntityArrayException e) {
            LOG.error("Exception in update method", e);
        }
    }
}
