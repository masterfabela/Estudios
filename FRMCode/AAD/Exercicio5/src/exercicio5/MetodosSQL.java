/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio5;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author Femio
 */
public class MetodosSQL {
     Connection conexion=null;
    public void conectar(){
        try{
        conexion=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root");
            System.out.println("Conectado a o servidor correctamente");
        }catch(SQLException sql1){
            System.out.println("Erro na conexion inicial: "+sql1.getMessage());
        }
    }
    public void desconectar(){
        try{
            conexion.close();
        }catch(SQLException sql1){
            System.out.println("Erro na desconexion: "+sql1.getMessage());
        }
    }
    public void creador(){
        try{
        Statement state=conexion.createStatement();
        state.execute("create database if not exists BDInstitutos;");
        state.execute("use BDInstitutos;");
        state.execute("create table if not exists Ciclos("
                + "codCiclo int (4) not null, "
                + "nombreCiclo varchar (10), "
                + "primary key(codCiclo));");
        state.execute("create table if not exists Institutos("
                + "codInsti int (4) not null, "
                + "tf varchar (9), "
                + "primary key (codInsti)"
                + ");");
//        state.execute("create table if not exists Ciclos_Institutos("
//                + ");");
//        state.execute("create table if not exists Talleres("
//                + "codTaller int(4) not null,"
//                + "nombre varchar(10),"
//                + "codCiclo "
//                + ");");
//        state.execute("create table if not exists Usos();");
        }catch(SQLException sql1){
            System.out.println("Erro na Creacion da DB: "+sql1.getMessage());
        }
    }
   
}
