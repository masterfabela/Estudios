/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciciosax;

import java.io.FileInputStream;
import java.io.IOException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author Femio
 */
public class ExercicioSAX {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            XMLReader lector;
            lector = XMLReaderFactory.createXMLReader();
            lector.setContentHandler(new Manexador());
            lector.parse(new InputSource(new FileInputStream("test.xml")));
        }catch(IOException ie){
            System.out.println(ie.getMessage());
        }catch(SAXException se){
            System.out.println(se.getMessage());
        }
    }
    
}
