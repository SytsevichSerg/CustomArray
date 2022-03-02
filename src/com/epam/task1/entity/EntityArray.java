
package com.epam.task1.entity;
import com.epam.task1_2.event.ArrayEvent;
import com.epam.task1_2.observer.Observable;
import com.epam.task1_2.observer.Observer;
import com.epam.task1_2.util.IdGenerator;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class EntityArray implements Serializable, Observable{
    
    private int[] array;
    
    private UUID idArray; // 
    private String nameArray;
    private List<Observer> observers  = new ArrayList<>();
    
       
    public EntityArray(){
        array = new int[0];
    }
    
    public EntityArray(int... array) {
        this.array = array != null ? array.clone() : null;
    }
    
    public EntityArray(List<Integer> list){
        array = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
            array[i] = list.get(i);
    }
    
    public int[] getArray(){
        return array !=null ? array.clone() : null;
    }
    
    public void setArray(int[] array){
        this.array = array.clone();
        notifyObservers();
    }
    
    public UUID getId(){
        return idArray;
    }
    
    public void setId(){
        idArray = IdGenerator.assignId();
    }
    
    public void addElement(int element){

        int[] tempArray = new int[array.length+1];
        System.arraycopy(array, 0, tempArray, 0, array.length);
        tempArray[array.length]=element;
        array = tempArray;
        notifyObservers();
    }
    
    
    @Override
    public String toString(){
        return Arrays.toString(array);
   }
   
   @Override
   public boolean equals(Object obj){
       if(obj == this)
        return true;
       
       return false;
   }
   
   @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    @Override
    public void notifyObservers() {
         ArrayEvent event = new ArrayEvent(this);
         /*
         for(Observer observer: observers){
             observer.update(event);
         }
         */
         observers.forEach(o-> o.update(event));
    }

    @Override
    public void attach(Observer ob) {
        observers.add(ob);
    }

    @Override
    public void detach(Observer ob) {
        observers.remove(ob);
    }
   
}
