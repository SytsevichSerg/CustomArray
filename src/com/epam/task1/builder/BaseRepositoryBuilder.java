
package com.epam.task1.builder;

import com.epam.task1.repository.impl.ArraysRepository;


public abstract class BaseRepositoryBuilder {
        
    protected ArraysRepository repository;
    public abstract ArraysRepository buildRepository(String fileName);
}
