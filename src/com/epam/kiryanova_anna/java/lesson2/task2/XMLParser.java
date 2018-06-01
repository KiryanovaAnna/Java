package com.epam.kiryanova_anna.java.lesson2.task2;

import com.epam.kiryanova_anna.java.lesson2.task2.airplane.XMLAirplane;
import javafx.util.Pair;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class XMLParser {
    public XMLAirplane parseAirplane(Document xml) throws IOException {
        if (!xml.getDocumentElement().getNodeName().equals("Plane"))
            throw new IOException("Root document is not Plane.");

        NodeList tmp = xml.getElementsByTagName("Name");
        if (tmp.getLength() == 0)
            throw new IOException("No name found in xml.");
        String name = tmp.item(0).getTextContent();

        tmp = xml.getElementsByTagName("Type");
        if (tmp.getLength() == 0)
            throw new IOException("No type found in xml.");
        String type = tmp.item(0).getTextContent();

        tmp = xml.getElementsByTagName("Route");
        if (tmp.getLength() == 0)
            throw new IOException("No route found in xml.");
        String[] route = tmp.item(0).getTextContent().split(",");
        if (route.length != 2)
            throw new IOException("Wrong route format");

        Map<String, String> parameters = new HashMap<>();

        tmp = xml.getElementsByTagName("Parameter");
        for (int i = 0; i < tmp.getLength(); i++) {
            Node parameterNode = tmp.item(i);
            if (parameterNode.getNodeType() != Node.ELEMENT_NODE)
                continue;

            String[] kv = parameterNode.getTextContent().split(",");
            parameters.put(kv[0], kv[1]);
        }

        return new XMLAirplane(name, type, parameters, new Pair<>(route[0], route[1]));
    }

    public XMLAirline parseAirline(Document xml) throws IOException, ParserConfigurationException {
        if (!xml.getDocumentElement().getNodeName().equals("Airline"))
            throw new IOException("Root document is not Airline.");

        XMLAirline airline = new XMLAirline();
        NodeList planes = xml.getElementsByTagName("Plane");
        for (int i = 0; i < planes.getLength(); i++) {
            Node plane = planes.item(i);

            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document planeXML = builder.newDocument();

            Node imported = planeXML.importNode(plane, true);
            planeXML.appendChild(imported);

            airline.addPlane(parseAirplane(planeXML));
        }

        return airline;
    }

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        XMLParser parser = new XMLParser();
        Document airlineXML = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File("airline.xml"));

        XMLAirline airline = parser.parseAirline(airlineXML);
        System.out.println(airline);
    }
}
