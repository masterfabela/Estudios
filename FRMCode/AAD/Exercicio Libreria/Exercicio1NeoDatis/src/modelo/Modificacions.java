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
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

/**
 *
 * @author femio23
 */
public class Modificacions {
    public void modificarDireccion(){
        ODB odb=ODBFactory.openClient("localhost", 8000, "libreria");
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce o codigo do autor deste libro:");
        String codigobusqueda=sc.next();
        IQuery query2=new CriteriaQuery(Autor.class,Where.equal("dni",codigobusqueda));
        Objects<Autor> lista=odb.getObjects(query2);
        if(lista.isEmpty()){
            System.out.println("Non existen autores con ese codigo.");
            odb.close();
        }else{
            Autor a1= lista.getFirst();
            System.out.println("Introduce a nova direccion:");
            String direccionNova=sc.next();
            a1.setDireccion(direccionNova);
            odb.store(a1);
            odb.commit();
            odb.close();
        }
    }
    public void modificarPrezo(){
        ODB odb=ODBFactory.openClient("localhost", 8000, "libreria");
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce o codigo do libro a modificar:");
        String codLibro= sc.next();
        IQuery query2=new CriteriaQuery(Libro.class,Where.equal("codigo",codLibro));
        Objects<Libro> lista=odb.getObjects(query2);
        if(lista.isEmpty()){
            System.out.println("Non existen libros con ese codigo.");
            odb.close();
        }else{
            Libro l1=lista.getFirst();
            System.out.println("Introduza o novo prezo.");
            float prezo=sc.nextFloat();
            l1.setPrecio(prezo);
            odb.store(l1);
            odb.commit();
            odb.close();
        }
    }
}
