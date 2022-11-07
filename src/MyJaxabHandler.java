import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class MyJaxabHandler {
    public static void main(String[] args) throws JAXBException, IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("TestJaxbSave"));

        File file = new File("Example.xml");
        Sonnet sonnet = parseToObj(String.valueOf(file));
        System.out.println(sonnet);

    }




    public static Sonnet parseToObj(String filePath) throws JAXBException {
        Sonnet unmarshal = null;
        JAXBContext jaxbContext = JAXBContext.newInstance(Sonnet.class);
        Unmarshaller jaxbUmarshaller = jaxbContext.createUnmarshaller();
        unmarshal = (Sonnet) jaxbUmarshaller.unmarshal(new File(filePath));
        return unmarshal;
    }

    public static void toXmlFile(String filePath, Sonnet sonnet) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Sonnet.class);
        Marshaller jaxbUnmarshaller = jaxbContext.createMarshaller();
        jaxbUnmarshaller.marshal(sonnet, new File(filePath));
    }
}