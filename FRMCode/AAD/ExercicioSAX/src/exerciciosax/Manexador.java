/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciciosax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Femio
 */
public class Manexador  extends DefaultHandler{

    @Override
    public void startDocument() throws SAXException {
        System.out.println("\nPrincipio del documento...");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("\nFin del documento...");
    }

    @Override
    public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {
        System.out.println("\nProcesando etiqueta...");
        if (uri.length() > 0) {
            System.out.println("\tNamespace uri: " + uri);
        }
        System.out.println("\tNombre: " + localName);
        System.out.println("\tNombre con prefijo: " + name);
        if (attributes.getLength() > 0) {
            System.out.println("\tProcesando " + attributes.getLength() + " atributos...");
            for (int i = 0; i < attributes.getLength(); i++) {
                System.out.println("\t\t" + attributes.getQName(i) + ": " + attributes.getValue(i));
            }
        }
        String valorId = attributes.getValue("id");
        if (valorId != null) {
            System.out.println("\tId: " + valorId);
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        boolean hayText = false;
        for (int i = start; i < start + length; i++) {
            if (("" + ch[i]).matches("[A-z0-9]")) {
                hayText = true;
            }
        }
        if (hayText) {
            System.out.println("\nProcesando texto dentro de una etiqueta... ");
            System.out.println("\tTexto: " + String.valueOf(ch, start, length));
        }
    }

    @Override
    public void endElement(String uri, String localName, String name)
            throws SAXException {
        System.out.println("\nFin de etiqueta...");
        if (uri.length() > 0) {
            System.out.println("\tNamespace uri: " + uri);
        }
        System.out.println("\tNombre: " + localName);
        System.out.println("\tNombre con prefijo: " + name);
    }
}
