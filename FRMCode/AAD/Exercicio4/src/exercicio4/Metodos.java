package exercicio4;


import Obx.*;
import java.util.ArrayList;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Metodos {
    Scanner sc=new Scanner(System.in);
    MetodosSQL msql1= new MetodosSQL();
    public ArrayList conectar(){
        msql1.creaTaboas();
        SessionFactory sf= HibernateUtil.getSessionFactory();
        Session sesion =HibernateUtil.getSession();
        sf.openSession();
        Transaction tr=sesion.beginTransaction();
        ArrayList dataSesion=new ArrayList();
        dataSesion.add(sesion);
        dataSesion.add(tr);
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
    public Autores buscAutores(int dni, ArrayList al){
        Session sesion=(Session)al.get(0);
        Transaction tr=(Transaction)al.get(1);
        Autores a1=(Autores)sesion.get(Autores.class, dni);
        return a1;
    }
    public Libros pedirLibros(ArrayList al){
        System.out.println("Introduza o dni do autor");
        int id=sc.nextInt();
        System.out.println("Introduza o titulo:");
        String titulo=sc.next();
        System.out.println("Introduza o prezo:");
        Float prezo=sc.nextFloat();
        Libros l1=new Libros(titulo,prezo,buscAutores(id,al));
        return l1;
    }
    public Telefonos pedirTelefonos(){
        System.out.println("Introduza o DNI do usuario:");
        int dni=sc.nextInt();
        System.out.println("Introduza o teléfono:");
        int tlfn=sc.nextInt();
        Telefonos t1=new Telefonos(dni,tlfn);
        return t1;
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
            return 0 ;
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
    public void switchInsert(ArrayList al){
        Session sesion=(Session)al.get(0);
        Transaction tr=(Transaction)al.get(1);
        switch(menuInsercion()){
            case 1:sesion.save(pedirAutores());
                tr.commit();;
            break;
            case 2:
                Libros l1=pedirLibros(al);
                sesion.save(l1);
                tr.commit();;
            break;
            case 3:sesion.save(pedirTelefonos());
                tr.commit();;
            break;
        }
        
//                Libros l1 = new Libros(4563,"Lolita",29.3f);
//                    sesion.save(l1);
//                    Autores a1= new Autores(77416900,"Francisco Romay","Española");
//                    sesion.save(a1);
//                    Telefonos t1=new Telefonos(77416900,986744755);
//                    sesion.save(t1);
//                    tr.commit();
        
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
}
