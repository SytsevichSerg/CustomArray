/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.task1.builder.impl;

import com.epam.task1.builder.BaseRepositoryBuilder;
import com.epam.task1.creator.EntityArrayCreator;
import com.epam.task1.creator.impl.EntityArrayCreatorImpl;
import com.epam.task1.entity.EntityArray;
import com.epam.task1.exception.EntityArrayException;
import com.epam.task1.parser.impl.EntityStringParserImpl;
import com.epam.task1.reader.TxtFileReader;
import com.epam.task1.repository.impl.ArraysRepository;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FileSystemRepositoryBuilder extends BaseRepositoryBuilder{
    
    private static final Logger LOG = LogManager.getLogger();
    public FileSystemRepositoryBuilder(){
        repository = ArraysRepository.getInstance();
    }
    
    @Override
    public ArraysRepository buildRepository(String fileName) {
        try{
            TxtFileReader reader = new TxtFileReader();
            List<String> lines = reader.getFileContents(fileName);
            EntityStringParserImpl parser = new EntityStringParserImpl();

            List<Integer> lst = parser.parseAll(lines);
            EntityArray array = new EntityArray(lst);
            repository.add(array);
        } catch (EntityArrayException exception){
           LOG.error("Repository build exception", exception);
       }
       return repository;
    }
    
}
