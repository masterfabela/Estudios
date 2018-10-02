/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    public void estructurar(){
        try{
            PreparedStatement ps=conect.prepareStatement("CREATE DATABASE IF NOT EXISTS empresa;");
            ps.execute();
            ps=conect.prepareStatement("USE empresa;");
            ps.execute();
            ps=conect.prepareStatement("CREATE TABLE IF NOT EXISTS departamentos ( "+
                    "nu_dept VARCHAR(2) NOT NULL, "+
                    "dnome FLOAT NOT NULL, "+
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
}
