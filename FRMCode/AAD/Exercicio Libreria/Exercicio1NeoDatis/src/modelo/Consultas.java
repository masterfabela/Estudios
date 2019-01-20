/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;
import java.util.Scanner;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.Objects;
import org.neodatis.odb.Values;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

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
        }
    }
    public void librosPublicadosIntervalo(){
        //Metodo non finalizado.
        LocalDate fecha1=null,fecha2=null;
        ODB odb=ODBFactory.openClient("localhost", 8000, "libreria");
        Scanner sc=new Scanner(System.in);
        System.out.println("");
        ICriterion criterio= new And().add(Where.equal("nacionalidad","ESP")).add(Where.gt("fechaPublicacion",fecha1)).add(Where.ge("fechaPublicacion",fecha2));
        CriteriaQuery query = new CriteriaQuery(Autor.class,criterio);
        Objects<Autor> lista=odb.getObjects(query);
        if(lista.isEmpty()){
            System.out.println("Non existen autores españois e maiores de 60.");
            odb.close();
        }else{
            for(Autor l1:lista){
                System.out.println(l1.getNombre()+", de "+l1.getEdad()+" años:");
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
    public void librosEspañois60(){
        ODB odb=ODBFactory.openClient("localhost", 8000, "libreria");
        ICriterion criterio= new And().add(Where.equal("nacionalidad","ESP")).add(Where.gt("edad",18));
        CriteriaQuery query = new CriteriaQuery(Autor.class,criterio);
        Objects<Autor> lista=odb.getObjects(query);
        if(lista.isEmpty()){
            System.out.println("Non existen autores españois e maiores de 60.");
            odb.close();
        }else{
            for(Autor l1:lista){
                System.out.println(l1.getNombre()+", de "+l1.getEdad()+" años:");
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
    public void cantidadNacional(){
        ODB odb=ODBFactory.openClient("localhost", 8000, "libreria");
        Values listaNacions= odb.getValues(new ValuesCriteriaQuery(Autor.class).field("nacionalidad").count("dni").groupBy("nacionalidad"));
        while(listaNacions.hasNext()){
            ObjectValues ov=(ObjectValues)listaNacions.next();
            System.out.println("Pais: "+ov.getByAlias("nacionalidad")+", autores: "+ov.getByIndex(1));
        }
    }
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
