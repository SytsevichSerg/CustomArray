/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.task1.entity;

import com.epam.task1.entity.EntityArrayParameters;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class Warehouse{

    private final Map<UUID,EntityArrayParameters> params = new HashMap<>(); // оправдал ли final для карты отображений
    
    private static Warehouse instance;
    private Warehouse(){} // когда надо инициализировать мар в конструкторе
    public static Warehouse getInstance() {
        if(instance == null){
            instance = new Warehouse();
        }
        return instance;
    }
    
    public EntityArrayParameters get(UUID id){
        return params.get(id).clone();
    }
    
    public void put(UUID id, EntityArrayParameters param){
        params.put(id, param);
    } 
    
    public boolean containsId(UUID id){
        return params.containsKey(id);
    }
    
    public Map<UUID,EntityArrayParameters> getParams(){
        Map<UUID,EntityArrayParameters> clone = new HashMap<>();
        for( UUID id: params.keySet() ){
            clone.put(id, params.get(id));
        }
        return clone;
    }
    
    public void clear() {
        params.clear();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || (obj.getClass() != this.getClass())) {
            return false;
        }
        Warehouse warehouse = (Warehouse) obj;
        return this.params.equals(warehouse.params);
    }

    @Override
    public int hashCode() {
        return params.hashCode();
    }
    
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(this.getClass().getSimpleName());
        stringBuilder.append('{').append("params=").append('}');
        return stringBuilder.toString();
    }
}
