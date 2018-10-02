/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author a18franciscorm
 */
public class Conector {
    Connection conect;
    
    public void conectar(){
        try{
        conect=DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root");
        if(conect!=null){
            System.out.println("Base conectada correctamente.");
        }
        }catch(SQLException sqle1){
                System.out.println("Error:"+sqle1.getMessage());    
    }
    }
    public void pechar(){
    try {
            conect.close();
            System.out.println("Base desconectada satisfactoriamente.");
        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void engadirLibro(Scanner sc){
        String titulo,idlibro;
        float prezo;
        System.out.println("Vai a engadir un libro, introduza os datos que se lle piden a continuacion:");
        System.out.println("Titulo:");
        titulo=sc.next();
        System.out.println("Nº de identificación:");
        idlibro=sc.next();
        System.out.println("Prezo:");
        prezo=sc.nextFloat();
        try{
        PreparedStatement ps=conect.prepareStatement("INSERT INTO libros (IdLibro,titulo,precio) VALUES (?,?,?)");
        ps.setString(1,idlibro);
        ps.setString(2,titulo);
        ps.setFloat(3,prezo);
        ps.execute();
            System.out.println(titulo+" engadido correctamente.");
        }catch(SQLException sqle1){
            System.out.println(sqle1.getMessage());
        }
        
    }
    
    public void engadirAutor(Scanner sc){
        
    System.out.println("Vai a engadir un autor, introduza os datos que se lle piden a continuacion:");
        System.out.println("Identificación do autor:");
        String idautor=sc.next();
        System.out.println("Nome:");
        String nome=sc.next();
        System.out.println("Nacionalidade:");
        String nacionalidade=sc.next();
        try{
        PreparedStatement ps=conect.prepareStatement("INSERT INTO autores (IdAutor,nombre,nacionalidad) VALUES (?,?,?)");
        ps.setString(1,idautor);
        ps.setString(2,nome);
        ps.setString(3,nacionalidade);
        ps.execute();
        System.out.println(nome+" engadido correctamente.");
        }catch(SQLException sqle1){
            System.out.println(sqle1.getMessage());
        }
    }
    public void ereseAutor(Scanner sc){
    System.out.println("Vai a eliminar un autor, introduza o codigo identificativo:");
        String idautor=sc.next();
        try{
        PreparedStatement ps=conect.prepareStatement("delete from autores where IdAutor = "+idautor);
        ps.execute();
        System.out.println(idautor+" eliminado correctamente.");
        }catch(SQLException sqle1){
            System.out.println(sqle1.getMessage());
        }
    }
    public void ereseLibro(Scanner sc){
    System.out.println("Vai a eliminar un libro, introduza o codigo identificativo:");
        String idlibro=sc.next();
        try{
        PreparedStatement ps=conect.prepareStatement("delete from libros where IdLibro = "+idlibro);
        ps.execute();
        System.out.println(idlibro+" eliminado correctamente.");
        }catch(SQLException sqle1){
            System.out.println(sqle1.getMessage());
        }}
    public void modificar(Scanner sc){
        System.out.println("Vai a modificar o prezo dun libro, introduza o codigo identificativo e logo o novo prezo:");
        String idlibro=sc.next();
        Float prezo=sc.nextFloat();
        try{
        PreparedStatement ps=conect.prepareStatement("update libros set precio = "+prezo+" where IdLibro = "+idlibro);
        ps.execute();
        System.out.println(idlibro+" modificado correctamente.");
        }catch(SQLException sqle1){
            System.out.println(sqle1.getMessage());
        }
    }
    public void consultar(Scanner sc, int n){
//        ResultSet resul;
//        switch(n){
//                     case 1:System.out.println("Introduza o título.");
//                     int titulo=sc.nextInt();
//                             try{
//        PreparedStatement ps=conect.prepareStatement("select nombre from autores where IdAutor in ( select IdAutor from librosautores where IdLibro in(select IdLibro from libros where titulo =\"+titulo+\"));");
//PreparedStatement ps=conect.prepareStatement("select nombre from autores where IdAutor =(select autor from librosautores where libro =\"+titulo+\")");
//        resul=ps.executeQuery();
//        System.out.println(resul.get);
//        
//
//        }catch(SQLException sqle1){
//            System.out.println(sqle1.getMessage());
//        }
//                     break;
//                     case 2:c1.ereseAutor(sc);
//                     break;
//                     default:System.out.println("Engada un valor válido:");
//                     break;
//    }
    }
        
}
