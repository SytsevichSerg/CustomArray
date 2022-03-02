
package com.epam.task1.reader;

import com.epam.task1.exception.EntityArrayException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomFileReader {
    final String SOURCEFILE = "C:\\Java\\EduProjects\\Epam\\Task1\\Src\\datasource.txt";
    private static final Logger ARRLOG = LogManager.getLogger();
    
    private List<String> lines;
    
    
    public List<String> getFileContents() throws EntityArrayException{
        try{
            initialFileProoving(SOURCEFILE);
            lines =  Files.readAllLines(Paths.get(SOURCEFILE));
        }
        catch(IOException e){
            ARRLOG.error("IOException in getFileContents method");
            throw new EntityArrayException("IOException in getFileContents method");
        }
        return lines;
    }
    
    private void initialFileProoving(String fileName) throws EntityArrayException {
        //LOGGER.debug("checkFileName");
        if (fileName == null || fileName.isEmpty()) {
            //LOGGER.error("fileName is null or empty string");
            throw new EntityArrayException("Filename is not correct");
        }
        if (Files.notExists(Paths.get(fileName))) {
            //LOGGER.error("Fle not exists");
            throw new EntityArrayException("File <" + fileName + "> not exists");
        }
        if (!Files.isReadable(Paths.get(fileName))) {
            //LOGGER.error("File can`t be read");
            throw new EntityArrayException("File <" + fileName + ">' can`t be read");
        }
    }
}
