
package com.epam.task1.main;

import com.epam.task1.builder.BaseRepositoryBuilder;
import com.epam.task1.builder.BaseWarehouseBuilder;
import com.epam.task1.builder.impl.ArrayWarehouseBuilder;
import com.epam.task1.builder.impl.FileSystemRepositoryBuilder;
import com.epam.task1.entity.EntityArray;
import com.epam.task1.entity.Warehouse;
import com.epam.task1.exception.EntityArrayException;
import com.epam.task1.observer.Observer;
import com.epam.task1.observer.impl.ArrayObserver;
import com.epam.task1.repository.impl.ArraysRepository;
import com.epam.task1.service.ArrayReplaceService;
import com.epam.task1.service.impl.ArrayReplaceServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main {
    private static final Logger LOG = LogManager.getLogger();
    
    public static void main(String[] args)  {
      final String sourceFile = "./src/com/epam/task1/src/datasource.txt";
      
       BaseRepositoryBuilder repoBuilder = new FileSystemRepositoryBuilder();
       ArraysRepository repository =  repoBuilder.buildRepository(sourceFile);
       
       Observer observer = new ArrayObserver();
       repository.forEach((o)->o.attach(observer));
       
       BaseWarehouseBuilder whBuilder = new ArrayWarehouseBuilder();
       Warehouse warehause = whBuilder.buildWarehouse(repository.getArrays());
       EntityArray array = repository.get(0);
       ArrayReplaceService service = new ArrayReplaceServiceImpl();
       try{
           service.replaceAllValuesBelowThis(array, 1, 99);
       } catch (EntityArrayException exception){
           LOG.error("Exception by replace values", exception);
       }
       
    }
    
}
