/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo_dom;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 *
 * @author a18franciscorm
 */
public class Exemplo_DOM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Document doc=null;
        try{
            doc=DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        }catch(ParserConfigurationException pce1){
            pce1.printStackTrace();
        }
        Element root=doc.createElement("Raiz");
        Element nodo=doc.createElement("Nodo1");
        Text texto = doc.createTextNode("TextoNodo1");
        root.setAttribute("autor","F.D.Roosevelt");
        nodo.appendChild(texto);
        root.appendChild(nodo);
        doc.appendChild(root);
        StringWriter sw=null;
        try{
            TransformerFactory transFact = TransformerFactory.newInstance();
            transFact.setAttribute("indent-number", new Integer(3));
            Transformer trans = transFact.newTransformer();
            trans.setOutputProperty(OutputKeys.INDENT, "yes");
            trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION,"no");
            sw = new StringWriter();
            StreamResult sr = new StreamResult(sw);
            DOMSource ds = new DOMSource(doc);
            trans.transform(ds, sr);
        }catch(Exception e1){
            e1.printStackTrace();
        }
        try{
            PrintWriter pw =new PrintWriter(new FileWriter("test.xml"));
            pw.println(sw.toString());
            pw.close();
        }catch(IOException ioe1){
        ioe1.printStackTrace();}
    }
    
}
