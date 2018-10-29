/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio4;
import Obx.*;
import java.util.Scanner;
import org.hibernate.*;

/**
 *
 * @author a18franciscorm
 */
public class Exercicio4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        MetodosSQL msql=new MetodosSQL();
        Metodos m1= new Metodos();
        msql.creaTaboas();
        SessionFactory sf= HibernateUtil.getSessionFactory();
        Session sesion =HibernateUtil.getSession();
        sf.openSession();
        Transaction tr=sesion.beginTransaction();
        Scanner sc=new Scanner(System.in);
        byte opcion=0;
        while(opcion!=6){
            
            switch(opcion){
                case 1:;
                break;
                default:opcion=m1.menuPrincipal();
                break;
            }
        }
        Libros l1 = new Libros(4563,"Lolita",29.3f);
        sesion.save(l1);
        Autores a1= new Autores(77416900,"Francisco Romay","Española");
        sesion.save(a1);
        Telefonos t1=new Telefonos(77416900,986744755);
        sesion.save(t1);
        tr.commit();
        sesion.close();
        sf.close();
        /*
        La relación entre Autores  y Libros  es de  uno a varios:un autor puede escribir
        varios libros y un libro  solo puede tener un autor, en los pojos pondremos la 
        relación bidireccional. La relación entre Autores yteléfonos es de uno a uno,
        un autor solo puede tener un tf.Y un tf solo puede pertenecer a un autor.
        
        Realizar un  programa en java, utilizando la herramienta O.R.M hibernate,
        que  cargue un driver JDBC y establezca la conexión con una BD MySQL  ,
        la  cual reside en la misma máquina cliente junto al driver ,la aplicación
        y el servidor USBW portable,  esta generará un menú que invoque a las 
        distintas clases con sus respectivos métodos, que se exponen a continuación:

        Creación  de la Base de Datos y tablas.
        Creación de pojos y mapeos.
        MENÚ
        2- Inserción de nuevas filas.
            a. Inserción autor.
            b. Inserción libro(tiene que existir el autor).
            c. Insercción teléfono.
        3- Borrado de filas.
            a. Borrado libro(El autor sigue existiendo).
            b. Borrado autor(Desaparecen todos los libros).
            c. Borrado teléfono
        4-Modificaciones.
            - Introduciendo el código de un libro modifique su precio.
            -partiendo de un autor modificar el nº de tf.	
        6- Consultas.
            a. Introduciendo el título de un libro visualice sus datos  
                y el nombre el autor ó autores con su tf.
            b. Introduciendo el nombre de un autor visualice sus libros.
            c. Visualización de todos los Libros de la tabla.
            d.Visualización  de todos los autores con sus libros.
        7-Fin.

        */
    }
    
}
