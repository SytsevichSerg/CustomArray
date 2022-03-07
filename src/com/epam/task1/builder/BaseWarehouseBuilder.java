
package com.epam.task1.builder;

import com.epam.task1.entity.EntityArray;
import com.epam.task1.entity.Warehouse;
import java.util.List;


public abstract class BaseWarehouseBuilder {
    protected Warehouse warehouse;
    protected BaseWarehouseBuilder (Warehouse warehouse){
        this.warehouse = warehouse;
    }
    public abstract Warehouse buildWarehouse(List<EntityArray> arrays);
}
