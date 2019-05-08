/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author femio23
 */
public class Creador {
    public static void creaTaboas(){
        Connection c=null;
        try{
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root");
            System.out.println("Conexion realizada satisfactoriamente.");
        }catch(SQLException sqle1){
            System.out.println("Erro na conexión: "+sqle1.getMessage());
        }try{
            Statement creacion = c.createStatement();
            //creacion.execute("drop database if exists EmpresaCoches;");
            creacion.execute("create database if not exists EmpresaCoches;");
            creacion.execute("use EmpresaCoches;");
            creacion.execute("create table if not exists Proveedor("
                    + "codigo int(4) auto_increment not null,"
                    + "nome varchar(20),"
                    + "primary key(codigo)"
                    + ");");
            creacion.execute("create table if not exists Coche("
                    + "matricula varchar(7) not null,"
                    + "marca varchar(20),"
                    + "modelo varchar(20),"
                    + "tipo varchar(20),"
                    + "precioCompra decimal,"
                    + "precioVenta decimal,"
                    + "codigoProveedor int(4),"
                    + "primary key(matricula),"
                    + "foreign key(codigoProveedor) references Proveedor(codigo) on update cascade on delete cascade"
                    + ");");
            System.out.println("Taboas creadas correctamente.");
            
        }catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        }
    }
}
