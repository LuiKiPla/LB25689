import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import com.Product.Box;
import com.Product.Boxes;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import static junit.framework.TestCase.assertEquals;

public class XmlReaderTest {

    @Test
    public void test() throws JAXBException, FileNotFoundException {
        Box box = new Box("Электроника", 3.0, List.of("Телефон", "Ноутбук"));

        JAXBContext context = JAXBContext.newInstance(Boxes.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Boxes boxes = (Boxes) unmarshaller.unmarshal(new FileReader("src/main/java/com/Product/Boxes.xml"));


        assertEquals(box, boxes.getBoxes().get(1));
    }
}
