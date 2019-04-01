/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciciodom;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 *
 * @author Femio
 */
public class ExercicioDOM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            //Creación e escritura.
            Document doc=DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element raiz = doc.createElement("listalibros");
            Element nodo1 = doc.createElement("libro");
            Element nodo2 = doc.createElement("autor");
            Element nodo3 = doc.createElement("titulo");
            Element nodo4 = doc.createElement("apellido1");
            Element nodo5 = doc.createElement("apellido2");
            Element nodo6 = doc.createElement("nombre");
            doc.appendChild(raiz);
            raiz.appendChild(nodo1);
            nodo1.appendChild(nodo2);
            nodo1.appendChild(nodo3);
            nodo2.appendChild(nodo4);
            nodo2.appendChild(nodo5);
            nodo2.appendChild(nodo6);
            nodo4.setTextContent("López");
            nodo5.setTextContent("Pérez");
            nodo6.setTextContent("Juan");
            nodo3.setTextContent("Programación");
            TransformerFactory transfact = TransformerFactory.newInstance();
            transfact.setAttribute("indent-number", 3);
            Transformer trans =transfact.newTransformer();
            trans.setOutputProperty(OutputKeys.INDENT, "yes");
            trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            StringWriter sw= new StringWriter();
            StreamResult sr = new StreamResult(sw);
            DOMSource ds = new DOMSource(doc);
            trans.transform(ds, sr);
            PrintWriter escritor=new PrintWriter(new FileWriter("libros.xml"));
            escritor.println(sw.toString());
            escritor.close();
        }catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }catch(TransformerConfigurationException te){
            System.out.println(te.getMessage());
        }catch(TransformerException te){
            System.out.println(te.getMessage());
        }catch(ParserConfigurationException pce1){
            System.out.println(pce1.getMessage());
        }
        //Lectura
        try{
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File("libros.xml"));
            doc.getDocumentElement().normalize();
            Element raiz = (Element)doc.getDocumentElement().getChildNodes();
            Element libro1=(Element)doc.getDocumentElement().getElementsByTagName("libro").item(0);
            Element isbn=doc.createElement("isbn");
            Element precio = doc.createElement("precio");
            System.out.println(raiz.getNodeName());
            libro1.appendChild(isbn);
            libro1.appendChild(precio);
            raiz.appendChild(libro1);
            TransformerFactory transfact = TransformerFactory.newInstance();
            transfact.setAttribute("indent-number", 3);
            Transformer trans =transfact.newTransformer();
            trans.setOutputProperty(OutputKeys.INDENT, "yes");
            trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            StringWriter sw= new StringWriter();
            StreamResult sr = new StreamResult(sw);
            DOMSource ds = new DOMSource(doc);
            trans.transform(ds, sr);
            PrintWriter escritor=new PrintWriter(new FileWriter("libros.xml"));
            escritor.println(sw.toString());
            escritor.close();
            
        }catch( ParserConfigurationException pce){
            System.out.println(pce.getMessage());
        }catch( SAXException se){
            System.out.println(se.getMessage());
        }catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }catch(TransformerException te){
            System.out.println(te.getMessage());
        }
        try{
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File("libros.xml"));
            doc.getDocumentElement().normalize();
            Element raiz = (Element)doc.getDocumentElement().getChildNodes();
            Element libro1=doc.createElement("libro");
            Element isbn=doc.createElement("isbn");
            Element autor=doc.createElement("autor");
            Element nombre=doc.createElement("isbnombren");
            nombre.setTextContent("Cristina");
            Element ap1=doc.createElement("apellido1");
            ap1.setTextContent("Lopez");
            Element ap2=doc.createElement("apellido2");
            ap2.setTextContent("Lopez");
            Element precio = doc.createElement("precio");
            Element titulo = doc.createElement("titulo");
            titulo.setTextContent("Bases de datos.");
            libro1.appendChild(autor);
            autor.appendChild(ap2);
            autor.appendChild(ap1);
            autor.appendChild(nombre);
            libro1.appendChild(isbn);
            libro1.appendChild(precio);
            libro1.appendChild(titulo);
            raiz.appendChild(libro1);
            TransformerFactory transfact = TransformerFactory.newInstance();
            transfact.setAttribute("indent-number", 3);
            Transformer trans =transfact.newTransformer();
            trans.setOutputProperty(OutputKeys.INDENT, "yes");
            trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            StringWriter sw= new StringWriter();
            StreamResult sr = new StreamResult(sw);
            DOMSource ds = new DOMSource(doc);
            trans.transform(ds, sr);
            PrintWriter escritor=new PrintWriter(new FileWriter("libros.xml"));
            escritor.println(sw.toString());
            escritor.close();
            
        }catch( ParserConfigurationException pce){
            System.out.println(pce.getMessage());
        }catch( SAXException se){
            System.out.println(se.getMessage());
        }catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }catch(TransformerException te){
            System.out.println(te.getMessage());
        }
        try{
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File("libros.xml"));
            doc.getDocumentElement().normalize();
            Element raiz = (Element)doc.getDocumentElement().getChildNodes();
            for(int i=0;i<raiz.getElementsByTagName("titulo").getLength();i++){
                System.out.println(raiz.getElementsByTagName("titulo").item(i).getTextContent());
            }
            
        }catch( ParserConfigurationException pce){
            System.out.println(pce.getMessage());
        }catch( SAXException se){
            System.out.println(se.getMessage());
        }catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }
        try{
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File("libros.xml"));
            doc.getDocumentElement().normalize();
            Element raiz = (Element)doc.getDocumentElement().getChildNodes();
            for(int i=0;i<raiz.getElementsByTagName("titulo").getLength();i++){
                if(raiz.getElementsByTagName("titulo").item(i).getTextContent().equalsIgnoreCase("Programación"))
                System.out.println(raiz.getElementsByTagName("titulo").item(i).getTextContent());
            }
            
        }catch( ParserConfigurationException pce){
            System.out.println(pce.getMessage());
        }catch( SAXException se){
            System.out.println(se.getMessage());
        }catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }
    
}
