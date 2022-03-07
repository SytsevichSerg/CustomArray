package com.epam.task1.observer;

import com.epam.task1.observer.Observer;

/**
 *
 *  Нотификатор
 */
public interface Observable {
    void notifyObservers();
    void attach(Observer ob);
    void detach(Observer ob);
}
