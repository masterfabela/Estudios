/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import org.neodatis.odb.*;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

/**
 *
 * @author femio23
 */
public class Altas {
    public void addAutor(){
        ODB odb=ODBFactory.openClient("localhost", 8000, "libreria");
        Scanner sc= new Scanner(System.in);
        System.out.println("Introduce os datos do autor:\n DNI:");
        String dni=sc.next();
        System.out.println("Nome Completo:");
        String nome=sc.next();
        System.out.println("Direccion:");
        String direccion=sc.next();
        System.out.println("Idade:");
        int idade=sc.nextInt();
        System.out.println("Nacionalidade:");
        String nacionalidade=sc.next();
        ArrayList <Libro>libro=new ArrayList();
        Autor a1=new Autor(dni,nome,direccion,nacionalidade,idade,libro);
        libro=engadidoInternoLibro(a1);
        if(!libro.isEmpty()){
            a1.setLibros(libro);
        }
        odb.store(a1);
        odb.commit();
        odb.close();
    }
    public Libro AddLibro(){
        ODB odb=ODBFactory.openClient("localhost", 8000, "libreria");
        Scanner sc= new Scanner(System.in);
        IQuery query=new CriteriaQuery(Autor.class);
        Objects <Autor> lista=odb.getObjects(query);
        if(lista.isEmpty()){
            System.out.println("Non existen autores, polo que non e posible inserir libros.");
            odb.close();
            return null;
        }else{
            System.out.println("Introduza os datos do libro:\nCodigo");
            String codigo=sc.next();
            System.out.println("Titulo");
            String titulo=sc.next();
            System.out.println("Categoria");
            String categoria= sc.next();
            System.out.println("Prezo");
            float prezo=sc.nextFloat();
            System.out.println("Data de publicación(YYYY-MM-DD)");
            String fechaS=sc.next();
            LocalDate fecha=LocalDate.parse(fechaS);
            Libro l1=new Libro(codigo,titulo,categoria,prezo,fecha);
            System.out.println("Introduce o codigo do autor deste libro:");
            String codigobusqueda=sc.next();
            ICriterion criterio =Where.equal("dni", codigobusqueda);
            IQuery query2=new CriteriaQuery(Autor.class,criterio);
            Objects<Autor> autor=odb.getObjects(query2);
            if(autor.isEmpty()){
                System.out.println("Non existen autores con ese codigo.");
                odb.close();
                return null;
            }else{
                Autor a1=autor.getFirst();
                ArrayList<Libro> libros=new ArrayList();
                libros.add(l1);
                a1.setLibros(libros);
                odb.store(l1);
                odb.commit();
                odb.close();
                return l1;
            }
        }
    }
    public ArrayList<Libro> engadidoInternoLibro(Autor a1){
        Scanner sc=new Scanner(System.in);
        ArrayList<Libro> x=new ArrayList();
        String opcion="X";
        while(!opcion.equalsIgnoreCase("Y")&&!opcion.equalsIgnoreCase("N")){
            System.out.println("Desexa engadir libros agora a este autor?(Y/N)");
            opcion = sc.next();
            switch(opcion){
                case "Y":x.add(AddLibro());
                break;
                case "N":x.clear();
                break;
                default:System.out.println("Erro de entrada(Y/N).");
                break;
                
            }
        }
        return x;
    }
    
}
