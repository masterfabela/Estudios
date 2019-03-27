/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.bd;

import java.io.IOException;
import java.util.Scanner;
import modelo.Autor;
import modelo.Libro;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

/**
 *
 * @author a14damianld
 */
public class Modificar {
    
    public static void direccionAutor() {
        Scanner entradaTeclado = new Scanner(System.in);
        ODB odb = ODBFactory.openClient("localhost", 8000, "libreria");
        System.out.println("Introduzca o dni do autor");
        String dni = entradaTeclado.next();
        IQuery query = new CriteriaQuery(Autor.class, Where.equal("dni", dni));
        Objects<Autor>objects = odb.getObjects(query);
        if (objects.isEmpty()) {
            System.err.println("Non se atopou o dni " + dni);
        } else {
            Autor autorAModificar = (Autor)odb.getObjects(query).getFirst();
            System.out.println("Introduzca unha nova dirección");
            String novaDireccion = entradaTeclado.next();
            autorAModificar.setDireccion(novaDireccion);
            odb.store(autorAModificar);
        }
        odb.close();
    }
    
    public static void prezoLibro() {
        Scanner entradaTeclado = new Scanner(System.in);
        ODB odb = ODBFactory.openClient("localhost", 8000, "libreria");
        System.out.println("Introduzca o título do libro");
        String titulo = entradaTeclado.next();
        System.out.println("Introduzca o nome do autor");
        String nome = entradaTeclado.next();
        IQuery query = new CriteriaQuery(Libro.class, Where.equal("titulo", titulo));
        Objects<Libro>objects = odb.getObjects(query);
        if (objects.isEmpty()) {
            System.err.println("Non se atopou o libro " + titulo + " do autor " + nome);
        } else {
            Libro libroAModificar = (Libro)odb.getObjects(query).getFirst();
            System.out.println("Introduzca o novo prezo");
            Float prezo = entradaTeclado.nextFloat();
            libroAModificar.setPrecio(prezo);
            odb.store(libroAModificar);
        }
        odb.close();
    }
    
}
