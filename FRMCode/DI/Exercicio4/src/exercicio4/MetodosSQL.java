/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio4;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author a18franciscorm
 */
public class MetodosSQL {
    public void creaTaboas(){
        Connection conect=null;
        try{
            conect=DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root");
            System.out.println("Base creada correctamente.");
        }catch(SQLException sqle1){
            System.out.println("Error na instancia da conexión: "+sqle1.getMessage());
        }
        try{
            Statement creacion=conect.createStatement();
            creacion.execute("create database if not exists Libreria;");
            creacion.execute("use Libreria;");
            creacion.execute("create table if not exists Libros ("
                    + "idlibro int(5) auto_increment not null,"
                    + "titulo varchar(30),"
                    + "prezo float(6),"
                    + "primary key(idlibro)"
                    + ");");
            creacion.execute("create table if not exists Autores("
                    + "dniautor int(8) not null,"
                    + "nombre varchar (60),"
                    + "nacionalidad varchar(30),"
                    + "primary key(dniautor)"
                    + ");");
            creacion.execute("create table if not exists Telefonos("
                    + "dni int(8) not null,"
                    + "ntel int(9),"
                    + "primary key(dni),"
                    + "foreign key(dni) references Autores(dniautor) on delete cascade on update cascade"
                    + ");");
            
            System.out.println("Taboas creadas correctamente.");
        }catch(SQLException sqle1){
            System.out.println("Error na creación das táboas: "+sqle1.getMessage());
        }
        
    }
}
