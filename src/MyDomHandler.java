import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;

public class MyDomHandler {

    static void readXml(String path) {
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();//построитель документа

            Document document = documentBuilder.parse(path);//создается дерево DOM документа из файла

            BufferedWriter writer = new BufferedWriter(new FileWriter("TestDOMSave"));


            Node root = document.getDocumentElement();//корневой элемент
            System.out.println(root);
            NodeList lines = root.getChildNodes();
            System.out.println("Reading by DOM parser");
            for (int i = 0; i < lines.getLength(); i++) {
                Node sonnet = lines.item(i);//вход внутрь тега

                if (sonnet.getNodeType() != Node.TEXT_NODE) {
                    NodeList sonnetChildNodes = sonnet.getChildNodes();
                    for (int j = 0; j < sonnetChildNodes.getLength(); j++) {
                        Node authorAndLine = sonnetChildNodes.item(j);

                        if (authorAndLine.getNodeType() != Node.TEXT_NODE) {
                            System.out.println(authorAndLine.getNodeName() + ":" + authorAndLine.getChildNodes().item(0).getTextContent());
                            writer.write(authorAndLine.getNodeName() + ":" + authorAndLine.getChildNodes().item(0).getTextContent() + "\n");
                        }
                    }
                }
            }
            writer.close();
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace(System.out);
        } catch (SAXException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
