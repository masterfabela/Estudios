package exercicio4;


import Obx.*;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;

public class Metodos {
    Scanner sc=new Scanner(System.in);
    MetodosSQL msql1= new MetodosSQL();
    public Session conectar(){
        msql1.creaTaboas();
        Session sesion =HibernateUtil.getSession();
        return sesion;
    }
    public void desconectar(Session sesion){
        sesion.close();
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
    public Autores buscAutores(int dni, Session sesion){
        sesion.clear();
        Autores a1=(Autores)sesion.get(Autores.class, dni);
        return a1;
    }
    public Libros buscLibro(String titulo, Session sesion){
        sesion.beginTransaction().begin();
        Libros l1=(Libros)sesion.get(Telefonos.class, titulo);
        return l1;
    }
    
    public Libros pedirLibros(Session sesion){
        System.out.println("Introduza o dni do autor");
        int id=sc.nextInt();
        System.out.println("Introduza o titulo:");
        String titulo=sc.next();
        System.out.println("Introduza o prezo:");
        Float prezo=sc.nextFloat();
        Libros l1=new Libros(titulo,prezo,buscAutores(id,sesion));
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
    public void switchInsert(Session sesion){
        switch(menuInsercion()){
            case 1:sesion.save(pedirAutores());
                sesion.beginTransaction().commit();;
            break;
            case 2:
                Libros l1=pedirLibros(sesion);
                sesion.save(l1);
                sesion.beginTransaction().commit();;
            break;
            case 3:sesion.save(pedirTelefonos());
                sesion.beginTransaction().commit();;
            break;
        }
    }
    public void switchDelete(Session sesion){
        switch(menuBorrado()){
            case 1:System.out.println("Introduce o seu dni:");
            int dni=sc.nextInt();
            Autores a1=buscAutores(dni,sesion);
            sesion.delete(a1);
            sesion.beginTransaction().commit();
            break;
            case 2:;
            break;
            case 3:;
            break;
        }
    }
    public void switchUpdate(Session sesion){
        switch(menuModificacion()){
            case 1:System.out.println("Introduce o seu dni:");
            int dni=sc.nextInt();
            Autores a1=buscAutores(dni,sesion);
            a1.setNacionalidade("Marroki");
            sesion.update(a1);
            sesion.beginTransaction().commit();
            break;
            case 2:;
            break;
            case 3:;
            break;
        }
    }
    public void switchQuery(Session sesion){
        switch(menuConsulta()){
            case 1:System.out.println("Introduce o seu dni:");
            String nome=sc.next();
            List<Autores> lista = sesion.createCriteria(Autores.class).list();
            for(Autores l:lista){
                if(l.getNome().equalsIgnoreCase(nome)){
                    System.out.println(l.getNacionalidade());
                }else{
                    System.out.println("Nada");}
            }
            sesion.beginTransaction().commit();
            break;
            case 2:;
            break;
            case 3:;
            break;
        }
    }
    }

