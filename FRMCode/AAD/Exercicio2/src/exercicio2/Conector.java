/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author a18franciscorm
 */
public class Conector {
    static Connection conect;
    Scanner sc=new Scanner(System.in);
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
    public void estructurar(){
        try{
            PreparedStatement ps=conect.prepareStatement("CREATE DATABASE IF NOT EXISTS empresa;");
            ps.execute();
            ps=conect.prepareStatement("USE empresa;");
            ps.execute();
            ps=conect.prepareStatement("CREATE TABLE IF NOT EXISTS departamentos ( "+
                    "nu_dept VARCHAR(2) NOT NULL, "+
                    "dnome VARCHAR(30) NOT NULL, "+
                    "localidade VARCHAR(30) NOT NULL, "+
                    "PRIMARY KEY(nu_dept));");
            ps.execute();
            ps=conect.prepareStatement("CREATE TABLE IF NOT EXISTS empregados ( "+
                    "dni INT(9) UNSIGNED ZEROFILL NOT NULL, "+
                    "nome VARCHAR(10) NOT NULL, "+
                    "estudios VARCHAR(10) NOT NULL, "+
                    "dir VARCHAR(10) NOT NULL, "+
                    "dataalta DATE NOT NULL, "+
                    "salario INT NOT NULL, "+
                    "comision INT NOT NULL, "+
                    "nu_dept VARCHAR(2) NOT NULL, "+
                    "PRIMARY KEY(dni),"+
                    "INDEX fk_nu_dept(nu_dept),"+
                    "CONSTRAINT fk_nu_dept "+
                    "FOREIGN KEY (nu_dept)"+
                    "   REFERENCES departamentos(nu_dept)"+
                    "       ON DELETE CASCADE "+
                    "       ON UPDATE CASCADE "+
                    "); ");
            ps.execute();
            System.out.println("Creada a estructura da BD.");
        }catch(SQLException sqle1){
            System.out.println("Error:"+sqle1.getMessage());
        }
    }
    public void main_menu(){
        System.out.println(
            "|----MENU----|\n"
            + "1-Insercion.\n"
            + "2-Borrado.\n"
            + "3-Consultas.\n"
            + "4-Modificacions.\n"
            + "5-Fin."
            +"|-------------|");
    }
    public void insert_menu(){
        
        byte seleccion=0;
        while(seleccion==0){
            System.out.println(
                "|-INSERCIÓNS-|\n"
                + "1-Departamento.\n"
                + "2-Empregado."
                + "3-Sair.");
            System.out.println("Elixa:");
            seleccion=sc.nextByte();
            try{
            Statement orde=conect.createStatement();
            switch(seleccion){
                case 1:
                    System.out.println("Introduza o numero do departamento a engadir:");
                    String ndep=sc.next();
                    System.out.println("Introduza o nome do departamento a engadir:");
                    String nome=sc.next();
                    System.out.println("Introduza a localidade do departamento a engadir:");
                    String loc=sc.next();
                    orde.execute("insert into departamentos values('"+ndep+"','"+nome+"','"+loc+"');");
                break;
                case 2:
                    System.out.println("Introduza o numero do empregado a engadir:");
                    String dni=sc.next();
                    System.out.println("Introduza o nome do empregado a engadir:");
                    nome=sc.next();
                    System.out.println("Introduza os estudos do empregado a engadir:");
                    String estudos=sc.next();
                    System.out.println("Introduza a direccion do empregado a engadir:");
                    String direccion=sc.next();
                    System.out.println("Introduza a data de alta do emrpegado a engadir:");
                    Date dataA =Date.valueOf(sc.next());
                    System.out.println("Introduza o salario do emrpegado a engadir:");
                    int salario =sc.nextInt();
                    System.out.println("Introduza a comision do emrpegado a engadir:");
                    int comision =sc.nextInt();
                    System.out.println("Introduza o departamento do empregado a engadir:");
                    ndep =sc.next();
                    orde.execute("insert into empregados values('"+dni+"','"+nome+"','"+estudos+"','"+direccion+"','"+dataA+"','"+salario+"','"+comision+"','"+ndep+"');");;
                break;
                case 3:
                    System.out.println("Saindo");;
                break;
                default:System.out.println("Saindo");;
                break;
            }}catch(SQLException sqle1){
                System.out.println("Erro: "+sqle1.getMessage());
            }
            
        }
        
    }
    public void erese_menu(){
        System.out.println(
                "|--BORRADO--|"
                        + "1-Departamento.\n"
                        + "2-Empregado.");
    }
    public void query_menu(){
        System.out.println(
                "|--CONSULTAS--|"
                        + "1-Departamento.\n"
                        + "2-Empregado.");
    }
    public void update_menu(){
        System.out.println(
                "|MODIFICACIONS|"
                        + "1-Departamento.\n"
                        + "2-Empregado.");
    }
}
