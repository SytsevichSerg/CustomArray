
package com.epam.task1_2.event;

import com.epam.task1.entity.EntityArray;
import java.util.EventObject;

public class ArrayEvent extends EventObject {

    public ArrayEvent(EntityArray array) {
        super(array);
    }
   @Override
    public EntityArray getSource(){
        return (EntityArray)super.getSource();
    }
    
}
