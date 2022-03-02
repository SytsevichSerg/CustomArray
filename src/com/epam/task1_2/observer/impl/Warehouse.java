/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.task1_2.observer.impl;

import com.epam.task1.entity.EntityArrayParameters;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class Warehouse{

    private final Map<UUID,EntityArrayParameters> params = new HashMap<>();
    
    private final static Warehouse INSTANCE = new Warehouse();
    private Warehouse(){} //
    public static Warehouse getInstance() {
        return INSTANCE;
    }
    
    public EntityArrayParameters get(UUID id){
        return params.get(id);
    }
    
    
    // fill map..
    
    //1 parameter
    //all parameters 
}
