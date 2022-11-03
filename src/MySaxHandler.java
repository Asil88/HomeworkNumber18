import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.ArrayList;



public class MySaxHandler extends DefaultHandler {
    boolean foundLastName = false;
    boolean foundFirstName = false;
    boolean foundNationality = false;
    boolean foundYearBirth = false;

    boolean foundYearDeath = false;

    boolean foundLine = false;

    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
/*
        System.out.println("---------------------------");
        System.out.println("Start Element :" + qName);*/

        if (qName.equals("lastName")) {
            foundLastName = true;
        }

        if (qName.equals("firstName")) {
            foundFirstName = true;
        }

        if (qName.equals("nationality")) {
            foundNationality = true;
        }

        if (qName.equalsIgnoreCase("yearOfBirth")) {
            foundYearBirth = true;
        }
        if (qName.equalsIgnoreCase("yearOfDeath")) {
            foundYearDeath = true;
        }
        if (qName.equalsIgnoreCase("line")) {
            foundLine = true;
        }

    }

    @Override
    public void characters(char ch[], int start, int length)
            throws SAXException {

        if (foundLastName) {
            System.out.println("Last Name : " + new String(ch, start, length));
            foundLastName = false;
        }

        if (foundFirstName) {
            System.out.println("First Name : " + new String(ch, start, length));
            foundFirstName = false;
        }

        if (foundNationality) {
            System.out.println("Nationality : " + new String(ch, start, length));
            foundNationality = false;
        }

        if (foundYearBirth) {
            System.out.println("Year of Birthday : " + new String(ch, start, length));
            foundYearBirth = false;
        }
        if (foundYearDeath) {
            System.out.println("Year of Death : " + new String(ch, start, length));
            foundYearDeath = false;
        }

        if (foundLine) {
            System.out.println("lines: " + new String(ch, start, length));
            foundLine = false;
        }

    }
    static void readXML(String path) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new MySaxHandler();

            File file = new File(path);
            System.out.println("Reading by SAX parser");
            saxParser.parse(file, handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   /* @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {

        System.out.println("End Element :" + qName);
    }*/

}