
package com.epam.task1_2.repository;

import com.epam.task1.entity.EntityArray;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

/**
 *
 * Singleton
 */
public class SingletonEntityArrayRepository {
   
    private final List<EntityArray> arrays = new CopyOnWriteArrayList<>();
    private static ReentrantLock lock = new ReentrantLock();
    
    private SingletonEntityArrayRepository(){ }
    private static class SingeltonHolder {//bill pugh
            private final static SingletonEntityArrayRepository INSTANCE = new SingletonEntityArrayRepository();
    }
    public static SingletonEntityArrayRepository getInstance() {
        return SingeltonHolder.INSTANCE;
    }
    
    public List<EntityArray> getArrays(){// блинов ругался на простую выдачу (небезопасную) массива массивов 
       return Collections.unmodifiableList(this.arrays);
    }
    
    public boolean add(EntityArray array){
        return arrays.add(array);
    }
    
    public boolean addAll(Collection<? extends EntityArray> cl){
        return arrays.addAll(cl);
    }
    
    public boolean remove(EntityArray array){
        return arrays.remove(array);
    }
    
    public boolean removeAll(Collection<?> cl){
        return arrays.removeAll(cl);
    }
    
    public EntityArray get (int index){
        return arrays.get(index);
    }
    
    public EntityArray set( int index, EntityArray array) {
        return arrays.set(index, array);
    }
    
    public List<EntityArray> query(Specification specification){
     
        List<EntityArray> list = new ArrayList<>();
        
        for(EntityArray array : arrays){
            if(specification.specify(array)){
                list.add(array);
            }
        }
        return list;
    }
    
    public List<EntityArray> queryStream(Specification specification){
        List<EntityArray> list = arrays.stream().filter(specification::specify).collect(Collectors.toList());
        return list;
    }
    
    public List<EntityArray> sort(Comparator<? super EntityArray> comparator){
        return arrays.stream().sorted(comparator).collect(Collectors.toList()); // на исходный контейнер сортировка не действует. создаем копию
    } 
}
