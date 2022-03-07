
package com.epam.task1.reader;

import com.epam.task1.exception.EntityArrayException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TxtFileReader {

    
    private static final Logger LOG = LogManager.getLogger();
    
    private List<String> lines;
    
    
    public List<String> getFileContents(String fileName) throws EntityArrayException{
        try{
            initialFileProoving(fileName);
            lines =  Files.readAllLines(Paths.get(fileName));
        }
        catch(IOException e){
            LOG.error("IOException in getFileContents method");
            throw new EntityArrayException("IOException in getFileContents method");
        }
        return lines;
    }
    
    private void initialFileProoving(String fileName) throws EntityArrayException {
        LOG.debug("checkFileName");
        if (fileName == null || fileName.isEmpty()) {
            LOG.error("fileName is null or empty string");
            throw new EntityArrayException("Filename is not correct");
        }
        if (Files.notExists(Paths.get(fileName))) {
            LOG.error("Fle not exists");
            throw new EntityArrayException("File <" + fileName + "> not exists");
        }
        if (!Files.isReadable(Paths.get(fileName))) {
            LOG.error("File can`t be read");
            throw new EntityArrayException("File <" + fileName + ">' can`t be read");
        }
    }
}
