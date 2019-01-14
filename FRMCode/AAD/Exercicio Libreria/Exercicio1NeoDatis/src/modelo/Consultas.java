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
public class Consultas {
    public void verLibro(){
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
            System.out.println(l1.toString());
            odb.close();
        }
    }
    public void verItalianos(){
        ODB odb=ODBFactory.openClient("localhost", 8000, "libreria");
        IQuery query2=new CriteriaQuery(Autor.class,Where.equal("nacionalidad","italiana"));
        Objects<Autor> lista=odb.getObjects(query2);
        if(lista.isEmpty()){
            System.out.println("Non existen autores italianos.");
            odb.close();
        }else{
            for(Autor l1:lista){
                System.out.println(l1.toString());
            }
            odb.close();
        }}
    public void librosPublicadosIntervalo(){}
    public void librosEspañois60(){
         ODB odb=ODBFactory.openClient("localhost", 8000, "libreria");
        IQuery query2=new CriteriaQuery(Autor.class,Where.equal("nacionalidad","española");
        Objects<Autor> lista=odb.getObjects(query2);
        if(lista.isEmpty()){
            System.out.println("Non existen autores españois.");
            odb.close();
        }else{
            for(Autor l1:lista){
                System.out.println(l1.getNombre()+", de "+" años:");
                if(l1.getLibros().isEmpty())
                    System.out.println("Non ten libros publicados.");
                else{
                    for(Libro l2:l1.getLibros()){
                        l2.getTitulo();
                    }
                }
            }
            odb.close();
        }
    }
    public void cantidadNacional(){}
    public void titulosAutor(){
        ODB odb=ODBFactory.openClient("localhost", 8000, "libreria");
        Scanner sc= new Scanner(System.in);
        System.out.println("Introduce o nome do autor:");
        String nome = sc.next();
        IQuery query2=new CriteriaQuery(Autor.class,Where.equal("nombre",nome));
        Objects<Autor> lista=odb.getObjects(query2);
        if(lista.isEmpty()){
            System.out.println("Non existe tal autor.");
            odb.close();
        }else{
            Autor a1= lista.getFirst();
            System.out.println("Os seus libros son:\n");
            for(Libro l1:a1.libros){
                System.out.println(l1.getTitulo()+", "+l1.getPrecio()+"€\n");
            }
            odb.close();
        }
    }
}
