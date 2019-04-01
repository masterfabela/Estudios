/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicioexist;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XPathQueryService;

/**
 *
 * @author Femio
 */
public class ExercicioExist {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));

        String driver = "org.exist.xmldb.DatabaseImpl";
        Collection col = null;
        String URI = "xmldb:exist://localhost:8080/exist/xmlrpc/db/Ximnasios";
        String usu = "admin";
        String usuPwd = "Femiofran23";
        String accion = null;
        String documento = "<Cuotas_AC>";
        Resource r = null;

        try {
            Class cl = Class.forName(driver);
            Database database = (Database) cl.newInstance();
            DatabaseManager.registerDatabase(database);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | XMLDBException ex) {
            System.out.println(ex);
        }
        try {
            col = (Collection) DatabaseManager.getCollection(URI, usu, usuPwd);

            if (col == null) {
                System.out.println("Coleccion INEXISTENTE");
            } else {
                accion = "for $soc in /Socios/socio\n"
                        + "return <datos>\n"
                        + "    <cod>{data($soc/@codigo)}</cod>\n"
                        + "    <nombresocio>{data($soc/nombre)}</nombresocio>\n"
                        + "    { for $us in /USO_GIMNASIO/fila_uso\n"
                        + "    let $ac:= /Actividades/actividad[@codigo=$us/CODACTIV]\n"
                        + "    let $ho:= number($us/HORAFINAL/text())- number($us/HORAINICIO/text())\n"
                        + "    let $ad:= number($ac/cuota_adicional/text())* $ho\n"
                        + "    where $us/CODSOCIO =$soc/@codigo\n"
                        + "    return <usos>\n"
                        + "        { $us/CODACTIV}\n"
                        + "        <nombre>{data($ac/nombre)}</nombre>\n"
                        + "        <tipo>{data($ac/@tipo)}</tipo>\n"
                        + "        <horas>{$ho}</horas>\n"
                        + "        <cuota>{$ad}</cuota>\n"
                        + "        </usos>}\n"
                        + "    </datos>";

                try {
                    XPathQueryService serv = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                    ResourceSet resultado = serv.query(accion);
                    ResourceIterator i;
                    i = resultado.getIterator();

                    if (!i.hasMoreResources()) {
                        System.out.println("la consulta esta vacia");
                    }
                    while (i.hasMoreResources()) {
                        r = i.nextResource();
                        documento += (String) r.getContent();
                    }
                    documento += "</Cuotas_AC>";

                    File fic = new File("Intermedio.xml");
                    PrintStream ps = new PrintStream(fic);
                    ps.print(documento);
                    ps.close();

                    r = col.createResource("Intermedio.xml", "XMLResource");
                    r.setContent(fic);
                    col.storeResource(r);

                    accion = " for $soc in /Socios/socio\n"
                            + "let $adtot:= sum(/cuotas_adicionales/datos[cod=$soc/@codigo]/usos/cuota_adicional)\n"
                            + "let $ctot:= number($soc/cuota/text()+$adtot\n)"
                            + "return <datos>\n"
                            + "    <cod>{data($soc/@codigo)}</cod>\n"
                            + "    {$soc/nombre}\n"
                            + "    <cuota_fija>{data($soc/cuota)}</cuota_fija>\n"
                            + "    <suma>{$adtot}</suma>\n"
                            + "    <total>{$ctot}</total>\n"
                            + "</datos>";

                    resultado = serv.query(accion);

                    i = resultado.getIterator();

                    if (!i.hasMoreResources()) {
                        System.out.println("la consulta esta vacia");
                    }
                    while (i.hasMoreResources()) {
                        r = i.nextResource();
                        System.out.println((String) r.getContent());
                    }
                } catch (XMLDBException e) {
                    System.out.println(e);
                } catch (FileNotFoundException ex) {
                    System.out.println(ex);
                }

            }
        } catch (XMLDBException ex) {
            System.out.println(ex);
        }

    }
}
