/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Femio
 */
public class MetodosSQL {
    public void creador(){
        Connection conexion = null;
        Statement orden=null;
        try{
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root");
            System.out.println("Conexion para a creacion realizada correctamente.");
        }catch(SQLException sqle){
            System.out.println("Error na conexion co server"+sqle.getMessage());
        }
        try{
            orden = conexion.createStatement();
            orden.execute("create database if not exists Xestionacoches;");
            orden.execute("use Xestionacoches;");
            orden.execute("create table if not exists EmpresasCoches("
                    + "cif varchar(9) not null, "
                    + "NombreEmpresa varchar(20) not null, "
                    + "Telf varchar(9) not null, "
                    + "primary key (cif)"
                    + ");");
            orden.execute("create table if not exists Coches ("
                    + "codigo varchar(4) not null, "
                    + "marca varchar(20) not null, "
                    + "modelo varchar(20) not null, "
                    + "cif varchar(9) not null, "
                    + "primary key (codigo), "
                    + "foreign key (cif) references EmpresasCoches(cif) on delete cascade on update cascade"
                    + ");");
            orden.execute("create table if not exists CochesVenta ("
                    + "codigo varchar(4) not null, "
                    + "precioVenta float not null, "
                    + "primary key (codigo), "
                    + "foreign key (codigo) references Coches(codigo)"
                    + ");");
            orden.execute("create table if not exists CochesAlquiler ("
                    + "codigo varchar(4) not null, "
                    + "precioDia float not null, "
                    + "estado enum('L','R') not null, "
                    + "primary key(codigo), "
                    + "foreign key (codigo) references Coches(codigo) on delete cascade on update cascade"
                    + ");");
            orden.execute("create table if not exists Usos ("
                    + "FechaAlquiler date not null, "
                    + "codigo varchar(4) not null, "
                    + "FechaEntrega date not null, "
                    + "importe float not null, "
                    + "primary key (FechaAlquiler,codigo), "
                    + "foreign key (codigo) references CochesAlquiler(codigo) on delete cascade on update cascade"
                    + ");");
        }catch(SQLException sqle){
            System.out.println("Error na creacion das taboas"+sqle.getMessage());
        }
    }
    
    
}
