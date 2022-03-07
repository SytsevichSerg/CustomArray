
package com.epam.task1.parser.impl;

import com.epam.task1.entity.EntityArray;
import com.epam.task1.exception.EntityArrayException;
import com.epam.task1.validator.SourceRowValidator;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.epam.task1.parser.EntityStringParser;

public class EntityStringParserImpl implements EntityStringParser{  //использовать паттерны матчеры для разбиения

    
    private static final Logger LOG = LogManager.getLogger();
    
    public enum SingletonCustomSeparator {//nested class
        INSTANCE;
        private String separator = ";";
        private SingletonCustomSeparator(){
            Properties p = new Properties();
            try{
                p.load(new FileReader("separator.properties"));
                separator = p.getProperty("validSeparators", ";");
            }
            catch(IOException e){
                LOG.error("IOException in initSeparators method");
            }
        }
   
        public String getSeparator() {
            return separator;
        }
    }
    
    @Override
    public int[] parse(String row) {
        //Log
        stringFilter(row);// просеиваем
        StringTokenizer tokenizer = new StringTokenizer(row, SingletonCustomSeparator.INSTANCE.getSeparator());
        List<Integer> intermediateResult = new ArrayList<>();
       
        while (tokenizer.hasMoreElements()) {
            String token = tokenizer.nextToken().trim();
            if(token.isEmpty())
                continue;
            
            Integer number = Integer.parseInt(token);
            intermediateResult.add(number);
        }
         int[] arrayElements = new int[intermediateResult.size()];
         for(int i = 0; i<intermediateResult.size(); i++)
             arrayElements[i]=intermediateResult.get(i);
        
         LOG.debug("Method parse returns" + Arrays.toString(arrayElements));
         return arrayElements;
    }

    @Override
    public List<Integer> parseAll(List<String> lines) throws EntityArrayException {
        List<String> validLines = stringFilter(lines);//here can be exception
        List<Integer> all = new ArrayList<>();
        int[] currentArray;
        for (String line : validLines) {
            currentArray = parse(line);
            for(int i : currentArray)
                all.add(i);
        }
        
        return all;
    }
    
    private boolean stringFilter(String row) {
        SourceRowValidator validator = SourceRowValidator.getInstance();
        if (!validator.iSRowValid(row)) { // коллим валидатор
            LOG.error ("Row < " + row + " > is not correct");
            return false;
        }
        return true;
    }
    
    private List<String> stringFilter(List<String> rows) throws EntityArrayException {
        if (rows == null) {
            LOG.error("List of row is null");
            throw new EntityArrayException("List of row is null");
        }
        return rows.stream().filter(this::stringFilter).collect(Collectors.toList());
    }
}
