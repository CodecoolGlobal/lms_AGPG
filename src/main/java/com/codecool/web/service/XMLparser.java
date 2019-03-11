package com.codecool.web.service;

import com.codecool.web.model.User;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.File;

public class XMLparser {

    private static File xmlFile;

    // Creating Document type obj.
    private static Document createDocument() {
        xmlFile = new File("data.xml");
        Document document = null;
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            document = documentBuilder.parse(xmlFile);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e + "\nClosing application...");
            System.exit(-1);
        }
        return document;
    }


    // Write the document to the XMl
    private static void save(Document document) {
        TransformerFactory factory = TransformerFactory.newInstance();

        Document documentClean = removeEmptyNodes(document);
        DOMSource domSource = new DOMSource(documentClean);
        StreamResult streamResult = new StreamResult(new File("data.xml"));
        try {
            Transformer transformer = factory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformer.transform(domSource, streamResult);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e + "\nClosing application...");
            System.exit(-1);
        }
    }



//    //Read Xml & return with it's items
//    public static Consumable[] read(String category) {
//        Document document = createDocument(category);
//        String node = category.equals("food") ? "Food" : "Drink";
//        ConsumableType type = category.equals("food") ? ConsumableType.FOOD : ConsumableType.DRINK;
//        NodeList nList = document.getElementsByTagName(node);
//        Consumable[] consumables = new Consumable[nList.getLength()];
//
//        for (int i = 0; i < nList.getLength(); i++) {
//            String name = document.getElementsByTagName("name").item(i).getTextContent();
//            String bestBefore = document.getElementsByTagName("bestbefore").item(i).getTextContent();
//            int calories = Integer.valueOf(document.getElementsByTagName("calories").item(i).getTextContent());
//            if (node.equals("Food")) {
//                boolean isSpicy = Boolean.parseBoolean(document.getElementsByTagName("isspicy").item(i).getTextContent());
//                Food food = new Food(name, bestBefore, calories, type, isSpicy);
//                consumables[i] = food;
//            } else {
//                boolean isalcoholic = Boolean.parseBoolean(document.getElementsByTagName("isalcoholic").item(i).getTextContent());
//                boolean isFizzy = Boolean.parseBoolean(document.getElementsByTagName("isfizzy").item(i).getTextContent());
//                Drink drink = new Drink(name, bestBefore, calories, type, isalcoholic, isFizzy);
//                consumables[i] = drink;
//            }
//        }
//        return consumables;
//    }

    //Write to Xml
    public static void write(User user) {
        Document document = createDocument();

        Element root = document.getDocumentElement();

        Element attributes = document.createElement("user");

        root.appendChild(attributes);

        Element fullname = document.createElement("fullname");
        Element email = document.createElement("email");
        Element psw = document.createElement("psw");
        Element position = document.createElement("position");


        fullname.appendChild(document.createTextNode(user.getfName()));
        email.appendChild(document.createTextNode(user.getEmail()));
        psw.appendChild(document.createTextNode(user.getPw()));
        position.appendChild(document.createTextNode(String.valueOf(user.isMentor())));

        attributes.appendChild(fullname);
        attributes.appendChild(email);
        attributes.appendChild(psw);
        attributes.appendChild(position);

        save(document);
    }

    private static Document removeEmptyNodes(Document document) {
        XPath xp = XPathFactory.newInstance().newXPath();
        NodeList nl = null;
        try {
            nl = (NodeList) xp.evaluate("//text()[normalize-space(.)='']", document, XPathConstants.NODESET);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e + "\nClosing application...");
            System.exit(-1);
        }

        for (int i = 0; i < nl.getLength(); ++i) {
            Node node = nl.item(i);
            node.getParentNode().removeChild(node);
        }
        return document;
    }
}
