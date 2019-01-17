/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Scanner;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

/**
 *
 * @author femio23
 */
public class Baixas {
    public void eliminar(){
        ODB odb=ODBFactory.openClient("localhost", 8000, "libreria");
        Scanner sc= new Scanner(System.in);
        System.out.println("Introduce ocodigo do libro:");
        String codigo = sc.next();
        IQuery query2=new CriteriaQuery(Libro.class,Where.equal("codigo",codigo));
        Objects<Libro> lista=odb.getObjects(query2);
        if(lista.isEmpty()){
            System.out.println("Non existen libros con ese codigo.");
            odb.close();
        }else{
            Libro l1= lista.getFirst();
            odb.delete(l1);
            odb.commit();
            odb.close();
        }
    }
}
