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
}
