
package com.epam.task1.observer;

import com.epam.task1.event.ArrayEvent;

public interface Observer {
    public void update(ArrayEvent arrayEvent);
}
