/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.task1_2.observer;

import com.epam.task1_2.observer.Observer;

/**
 *
 *  Нотификатор
 */
public interface Observable {
    void notifyObservers();
    void attach(Observer ob);
    void detach(Observer ob);
}
