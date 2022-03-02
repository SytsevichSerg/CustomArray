
package customarray;
import com.epam.task1.entity.EntityArray;
import com.epam.task1_2.repository.SingletonEntityArrayRepository;
import com.epam.task1.exception.EntityArrayException;
import java.util.List;
import com.epam.task1.parser.impl.EntityStringParserImpl;
import com.epam.task1.reader.CustomFileReader;


public class CustomArray {

  
    public static void main(String[] args) throws EntityArrayException {

      
       CustomFileReader scf = new CustomFileReader();
       List<String> lines = scf.getFileContents();
       EntityStringParserImpl spi = new EntityStringParserImpl();
       
       List<Integer> lst = spi.parseAll(lines);
       EntityArray array1 = new EntityArray(lst);
       
       //EntityArray array1 = new EntityArray(lst.toArray());
       SingletonEntityArrayRepository rep = SingletonEntityArrayRepository.getInstance();
       
    }
}
