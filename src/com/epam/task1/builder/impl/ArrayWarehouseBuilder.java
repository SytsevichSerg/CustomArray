
package com.epam.task1.builder.impl;

import com.epam.task1.builder.BaseWarehouseBuilder;
import com.epam.task1.entity.EntityArray;
import com.epam.task1.entity.EntityArrayParameters;
import com.epam.task1.entity.Warehouse;
import com.epam.task1.exception.EntityArrayException;
import com.epam.task1.service.ArrayProcessService;
import com.epam.task1.service.impl.ArrayProcessServiceImpl;
import java.util.List;
import java.util.UUID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ArrayWarehouseBuilder extends BaseWarehouseBuilder{
    private static final Logger LOG = LogManager.getLogger();
    
    public ArrayWarehouseBuilder(){
        super(Warehouse.getInstance());
    }
    
    @Override
    public Warehouse buildWarehouse(List<EntityArray> arrays) {
        
        ArrayProcessService service = new ArrayProcessServiceImpl();
        for (EntityArray array : arrays) {
            try {
                int min = service.findMinStream(array);
                int max = service.findMax(array);
                double sum = service.calcSummStream(array);
                double average = service.calcAverage(array);
                
                EntityArrayParameters params = new EntityArrayParameters(max, min, sum, average);
                UUID id = array.getId();
                warehouse.put(id, params);
            } catch (EntityArrayException exception) {
                LOG.error("Params of array:" + array + "not added.", exception);
            }
        }
        LOG.info("Warehouse built." + warehouse);
        return warehouse;
    }
    
}
