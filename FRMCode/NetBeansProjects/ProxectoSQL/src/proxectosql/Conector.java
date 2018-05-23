/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxectosql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author femio23
 */
public class Conector {
    String direccion="Base de datos/creador.sqlite3";
    Connection connect;
    public void conectar(){
        try{
        connect=DriverManager.getConnection("jdbc:sqlite:"+direccion);
        if(connect!=null){
            System.out.println("Base conectada.");
        }
        }catch(SQLException sqe1){
            System.out.println("Erro:"+sqe1.getMessage());
        }
    }
    public void pechar(){
    try {
            connect.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
public void consultar(String consulta){        
    ResultSet result = null;
        try {
            PreparedStatement st = connect.prepareStatement(consulta);
            result = st.executeQuery();
            while (result.next()) {
                System.out.print("Nome: ");
                System.out.println(result.getString("nome"));
 
                System.out.print("Idade: ");
                System.out.println(result.getInt("idade"));
 
                System.out.print("Codigo: ");
                System.out.println(result.getString("codigo"));
 
                System.out.println("=======================");
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    public void insertar(String nome,int idade,String codigo){
     try {
            PreparedStatement st = connect.prepareStatement("insert into EquipoProg (nome,idade,codigo) values (?,?,?)");
            st.setString(1,nome);
            st.setInt(2,idade);
            st.setString(3,codigo);
            st.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    public void actualizar(String consulta){
    try {
            PreparedStatement st = connect.prepareStatement(consulta);
            st.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    public void borrar(String consulta){
    try {
            PreparedStatement st = connect.prepareStatement(consulta);
            st.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
