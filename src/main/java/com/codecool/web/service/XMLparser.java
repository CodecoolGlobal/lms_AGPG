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
    private static Document createDocument(String path) {
        xmlFile = new File(path);
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
    private static void save(Document document, String path) {
        TransformerFactory factory = TransformerFactory.newInstance();

        Document documentClean = removeEmptyNodes(document);
        DOMSource domSource = new DOMSource(documentClean);
        StreamResult streamResult = new StreamResult(new File(path));
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

    //Update
    public static void update(String path, String oldName, String newName, String newPassword, Boolean newPosition) {
        Document document = createDocument(path);

        NodeList nList = document.getElementsByTagName("user");
        for (int i = 0; i < nList.getLength(); i++) {
            Element consumable = (Element) nList.item(i);
            Element name = (Element) consumable.getElementsByTagName("fullname").item(0);
            String currentName = name.getTextContent();
            if (currentName.equals(oldName)) {

                consumable.getElementsByTagName("fullname").item(0).setTextContent(newName);
                consumable.getElementsByTagName("psw").item(0).setTextContent(newPassword);
                consumable.getElementsByTagName("position").item(0).setTextContent(String.valueOf(newPosition));
            }
        }
        save(document, path);
    }

    //Read Xml & return with it's items
    public static User[] read(String path) {
        Document document = createDocument(path);
        NodeList nList = document.getElementsByTagName("user");
        User[] users = new User[nList.getLength()];

        for (int i = 0; i < nList.getLength(); i++) {
            String fullname = document.getElementsByTagName("fullname").item(i).getTextContent();
            String email = document.getElementsByTagName("email").item(i).getTextContent();
            String psw = document.getElementsByTagName("psw").item(i).getTextContent();
            String position = document.getElementsByTagName("position").item(i).getTextContent();

            User new_user = new User(1, fullname, email, psw, Boolean.valueOf(position));
            users[i] = new_user;
        }
        return users;
    }

    //Write to Xml
    public static void write(User user, String path) {
        Document document = createDocument(path);

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

        save(document,path);
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
