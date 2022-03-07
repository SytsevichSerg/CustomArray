
package com.epam.task1.repository.impl;

import com.epam.task1.entity.EntityArray;
import com.epam.task1.repository.Repository;
import com.epam.task1.repository.Specification;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 *
 * Singleton
 */
public class ArraysRepository implements Repository{
   
    private final List<EntityArray> ENTITY_ARRAYS;
    
    private ArraysRepository(){ 
        ENTITY_ARRAYS = new ArrayList<>();
    }
    
    private static class SingeltonHolder {//bill pugh
            private final static ArraysRepository INSTANCE = new ArraysRepository();
    }
    public static ArraysRepository getInstance() {
        return SingeltonHolder.INSTANCE;
    }
    
    @Override
    public List<EntityArray> getArrays(){
       return ENTITY_ARRAYS;
    }
    
    @Override
    public boolean add(EntityArray array){
        return ENTITY_ARRAYS.add(array);
    }
    
    @Override
    public boolean addAll(Collection<? extends EntityArray> cl){
        return ENTITY_ARRAYS.addAll(cl);
    }
    
    @Override
    public boolean remove(EntityArray array){
        return ENTITY_ARRAYS.remove(array);
    }
    
    @Override
    public boolean removeAll(Collection<?> cl){
        return ENTITY_ARRAYS.removeAll(cl);
    }
    
    @Override
    public EntityArray get (int index){
        return ENTITY_ARRAYS.get(index);
    }
    
    @Override
    public EntityArray set( int index, EntityArray array) {
        return ENTITY_ARRAYS.set(index, array);
    }
    
    @Override
    public void forEach(Consumer<? super EntityArray> action) {
        ENTITY_ARRAYS.forEach(action);
    }
    
    @Override
    public List<EntityArray> query(Specification specification){
     
        List<EntityArray> list = new ArrayList<>();
        
        for(EntityArray array : ENTITY_ARRAYS){
            if(specification.specify(array)){
                list.add(array);
            }
        }
        return list;
    }
    
    @Override
    public List<EntityArray> queryStream(Specification specification){
        List<EntityArray> list = ENTITY_ARRAYS.stream().filter(specification::specify).collect(Collectors.toList());
        return list;
    }
    
    @Override
    public List<EntityArray> sort(Comparator<? super EntityArray> comparator){
        return ENTITY_ARRAYS.stream().sorted(comparator).collect(Collectors.toList()); // на исходный контейнер сортировка не действует. создаем копию
    } 
}
