package exercicio4;


import Obx.*;
import java.util.ArrayList;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author a18franciscorm
 */
public class Metodos {
    Scanner sc=new Scanner(System.in);
    public ArrayList conectar(){
        SessionFactory sf= HibernateUtil.getSessionFactory();
        Session sesion =HibernateUtil.getSession();
        sf.openSession();
        Transaction tr=sesion.beginTransaction();
        ArrayList dataSesion=null;
        dataSesion.add(sf);
        dataSesion.add(sesion);
        return dataSesion;
    }
    public void desconectar(Session sesion, SessionFactory sf){
        sesion.close();
        sf.close();
    }
    public Autores pedirAutores(){
        System.out.println("Introduza o DNI:");
        int dni=sc.nextInt();
        System.out.println("Introduza o nome completo:");
        String nome=sc.next();
        System.out.println("Introduza a nacionalidade:");
        String nacionalidade=sc.next();
        Autores a1=new Autores(dni,nome,nacionalidade);
        return a1;
    }
    public int menuPrincipal(){
        int opcion;
        System.out.println("----Menu principal:----\n"
                + "1-Conexion.\n"
                + "2-Insercion.\n"
                + "3-Borrado.\n"
                + "4-Modificación.\n"
                + "5-Consultas.\n"
                + "6-Fin");
        opcion=sc.nextInt();
        if(opcion>=1 && opcion<=6)
            return opcion;
        else
            System.out.println("Insertado un valor non válido.");
            return 0;
    }
    public int menuInsercion(){
        int opcion;
        String textoMenu="--Menu de insercions:--\n"
                + "1-Insertar autores.\n"
                + "2-Insertar libros.\n"
                + "3-Insertar teléfonos.\n"
                + "4-Volver.\n";
        System.out.println(textoMenu);
            opcion=sc.nextInt();
        if(opcion>4 || opcion<1){
            System.out.println("Insertado un valor non válido.");
            System.out.println(textoMenu);
            opcion=sc.nextInt();
        } 
            return opcion;
    }
    public int menuBorrado(){
        int opcion;
        String textoMenu="---Menu de borrado:---\n"
                + "1-Borrar autores.\n"
                + "2-Borrar libros.\n"
                + "3-Borrar teléfonos.\n"
                + "4-Volver.\n";
        System.out.println(textoMenu);
            opcion=sc.nextInt();
        if(opcion>4 || opcion<1){
            System.out.println("Insertado un valor non válido.");
            System.out.println(textoMenu);
            opcion=sc.nextInt();
        } 
            return opcion;
    }
    public int menuModificacion(){
        int opcion;
        String textoMenu="--Menu de modificacións:--\n"
                + "1-Modificar prezos de libros.\n"
                + "2-Modificar telefono de autores.\n"
                + "3-Volver.\n";
        System.out.println(textoMenu);
            opcion=sc.nextInt();
        if(opcion>3 || opcion<1){
            System.out.println("Insertado un valor non válido.");
            System.out.println(textoMenu);
            opcion=sc.nextInt();
        } 
            return opcion;
    }
    public int menuConsulta(){
        int opcion;
        String textoMenu="--Menu de consultas:--\n"
                + "1-Libros->Autores->Telefonos.\n"
                + "2-Autor->Libros.\n"
                + "3-Todos os libros.\n"
                + "4-Todos os autores->Libros.\n"
                + "5-Volver";
        System.out.println(textoMenu);
            opcion=sc.nextInt();
        if(opcion>5 || opcion<1){
            System.out.println("Insertado un valor non válido.");
            System.out.println(textoMenu);
            opcion=sc.nextInt();
        } 
            return opcion;
    }
    public void switchInsert(ArrayList sesion){
        switch(menuInsercion()){
            case 1:;
            break;
            case 2:;
            break;
            case 3:;
            break;
            default:;
            break;
        }
    }
    public void switchDelete(){
        int opcion=menuBorrado();
    }
    public void switchUpdate(){
        int opcion=menuModificacion();
    }
    public void switchQuery(){
        int opcion=menuConsulta();
    }
    public int[] loopMenuPrincipal(int intentos){
        int[] saidaOpcionIntentos = null;
        if(intentos>0){
            System.out.println("Insertado un valor non valido");
            intentos++;
        }
        intentos++;
        saidaOpcionIntentos[0]=menuPrincipal();
        saidaOpcionIntentos[1]=intentos;
        return saidaOpcionIntentos;               
    }
}
