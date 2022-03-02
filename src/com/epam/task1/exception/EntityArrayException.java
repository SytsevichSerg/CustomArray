
package com.epam.task1.exception;


public class EntityArrayException extends Exception{
    
    public EntityArrayException(){
        super();
    }
    
    public EntityArrayException(String msg){
        super(msg);
    }
    
    public EntityArrayException(Exception e){
        super(e);
    }
    
    public EntityArrayException(String msg, Exception e){
        super(msg,e);
    }

}
