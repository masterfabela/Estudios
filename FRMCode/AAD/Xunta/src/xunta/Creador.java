/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xunta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author femio23
 */
public class Creador {
    Connection c=null;
    public void creaTaboas(){
        try{
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root");
            System.out.println("Conexion realizada satisfactoriamente.");
        }catch(SQLException sqle1){
            System.out.println("Erro na conexión: "+sqle1.getMessage());
        }try{
            Statement creacion = c.createStatement();
            //creacion.execute("drop database if exists Xunta;");
            creacion.execute("create database if not exists Xunta;");
            creacion.execute("use Xunta;");
            creacion.execute("create table if not exists Instituto("
                    + "codigo varchar(4) not null,"
                    + "telefono varchar(10),"
                    + "primary key(codigo)"
                    + ");");
            creacion.execute("create table if not exists Ciclo("
                    + "codigo varchar(4) not null,"
                    + "nome varchar(20),"
                    + "primary key(codigo)"
                    + ");");
            creacion.execute("create table if not exists Instituto_Ciclo("
                    + "codigoI varchar(4) not null,"
                    + "codigoC varchar(4) not null,"
                    + "primary key(codigoI,codigoC),"
                    + "foreign key(codigoI) references Instituto(codigo) on delete cascade on update cascade,"
                    + "foreign key(codigoC) references Ciclo(codigo) on delete cascade on update cascade"
                    + ");");
            creacion.execute("create table if not exists Taller("
                    + "codigo varchar(4) not null,"
                    + "nome varchar(20),"
                    + "codigoC varchar(4),"
                    + "primary key(codigo),"
                    + "foreign key(codigoC) references Ciclo(codigo) on update cascade on delete cascade"
                    + ");");
            creacion.execute("create table if not exists Uso("
                    + "codigoC varchar(4) not null,"
                    + "codigoT varchar(4) not null,"
                    + "data date,"
                    + "hora time,"
                    + "primary key(codigoC,codigoT,data,hora),"
                    + "foreign key(codigoC) references Ciclo(codigo) on update cascade on delete cascade,"
                    + "foreign key(codigoT) references Taller(codigo) on update cascade on delete cascade"
                    + ");");
        }catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        }}
}
