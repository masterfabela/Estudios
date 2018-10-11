/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg5conectores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Femio
 */
public class Derbi {
    public void conectar(){
    try{
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:3306/?user=root;create=true");
        if(conn!=null){
            System.out.println("Conexion Correcta co driver Derbi.");
        }
    }catch(SQLException sqle1){
            System.out.println("Erro: "+sqle1.getMessage());
            }
    catch(ClassNotFoundException cnfe1){
        System.out.println("Erro: +"+cnfe1.getMessage());
    }
        }
}

