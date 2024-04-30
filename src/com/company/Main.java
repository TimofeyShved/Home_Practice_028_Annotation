package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        // анализируем класс на наличие аннотаций
        BookAnnolizator annolizator = new BookAnnolizator();
        annolizator.annolize(Book.class);

        System.out.println("------------------------------ PARSING ------------------------------");

        Books books = new Books();

        // получаем документ (распарсенный)
        Document doc = buildDocument("books.xml");


        // Получаем первый Node <books>
        Node booksNode = doc.getFirstChild();
        System.out.println("<" + booksNode.getNodeName() + ">");

        // Получаем дочерние Node <book>
        NodeList booksChileds = booksNode.getChildNodes();

        // вытаскиваем из дочернего Node, атрибут(автора) и содержимое(название книги)
        for (int i=0; i < booksChileds.getLength(); i++){

            if (booksChileds.item(i).getNodeType() == Node.ELEMENT_NODE){

                System.out.println("    <" + booksChileds.item(i).getNodeName() +
                        " author ='" + booksChileds.item(i).getAttributes().getNamedItem("author").getNodeValue() +
                        "'>");

                System.out.println("        " + booksChileds.item(i).getTextContent());

                Book book = new Book();
                book.setName(booksChileds.item(i).getTextContent());
                book.setAuthor(booksChileds.item(i).getAttributes().getNamedItem("author").getNodeValue());

                books.setBook(book);
            }
        }

        System.out.println("------------------------------ Finish ------------------------------");
        System.out.println(books.toString());

    }

    public static Document buildDocument(String path){
        File file = new File(path);
        DocumentBuilderFactory docBF = DocumentBuilderFactory.newInstance();
        Document doc = null;

        try {
            doc = docBF.newDocumentBuilder().parse(file);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        return doc;
    }
}
