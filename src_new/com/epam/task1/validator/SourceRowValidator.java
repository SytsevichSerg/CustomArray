
package com.epam.task1.validator;

//Singleton

import java.util.concurrent.locks.ReentrantLock;

public class SourceRowValidator {
    private static final String ROW_REGEX = "\\s*(-\\s*)?\\d+(\\s*;\\s*(-\\s*)?\\d+)*\\s*";
    
    
    private static ReentrantLock Lock = new ReentrantLock();
    private static SourceRowValidator instance = null;

    private SourceRowValidator(){
    }
    
    public static SourceRowValidator getInstance(){
        Lock.lock();
        try{
            if(instance ==null) {
                instance = new SourceRowValidator();
            }
        } finally {
            Lock.unlock();
        }
        return instance;
    }
    
    public boolean iSRowValid(String row){
        boolean bRet = false;
        if(row != null)
        {
            if(row.isEmpty()||row.matches(ROW_REGEX))
                bRet = true;
        }
        return bRet;
    }
}
