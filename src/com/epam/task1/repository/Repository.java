
package com.epam.task1.repository;

import com.epam.task1.entity.EntityArray;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;


public interface Repository {
    public List<EntityArray> getArrays();
    
    public boolean add(EntityArray array);
    
    public boolean addAll(Collection<? extends EntityArray> cl);
    
    public boolean remove(EntityArray array);
    
    public boolean removeAll(Collection<?> cl);
    
    public EntityArray get (int index);
        
    public EntityArray set( int index, EntityArray array);
        
    public void forEach(Consumer<? super EntityArray> action);
    
    public List<EntityArray> query(Specification specification);
        
    public List<EntityArray> queryStream(Specification specification);
    
    public List<EntityArray> sort(Comparator<? super EntityArray> comparator); // на исходный контейнер сортировка не действует. создаем копию
    
}
