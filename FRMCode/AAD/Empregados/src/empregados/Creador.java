/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empregados;

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
            //creacion.execute("drop database if exists Empregados;");
            creacion.execute("create database if not exists Empregados;");
            creacion.execute("use Empregados;");
            creacion.execute("create table if not exists Departamento("
                    + "nDep varchar(2),"
                    + "nomeDep varchar(20),"
                    + "localidade varchar(20),"
                    + "primary key(nDep)"
                    + ");");
            creacion.execute("create table if not exists Empregado("
                    + "nome varchar(20) not null,"
                    + "oficio varchar(20),"
                    + "dni varchar(10),"
                    + "dataAlta date,"
                    + "salario int,"
                    + "comision int,"
                    + "nDep varchar(2),"
                    + "primary key(dni),"
                    + "index fk_nDep(nDep),"
                    + "constraint fk_nDep "
                    + "foreign key(nDep) references Departamento(nDep) on delete cascade on update cascade"
                    + ");");
            creacion.execute("create table if not exists Vehiculo("
                    + "dni varchar(10),"
                    + "matricula varchar(7),"
                    + "marca varchar(20),"
                    + "modelo varchar(20),"
                    + "dataCompra date,"
                    + "primary key (dni),"
                    + "unique index (matricula),"
                    + "index fk_dni(dni),"
                    + "constraint fk_dni "
                    + "foreign key(dni) references Empregado(dni) on delete cascade on update cascade"
                    + ");");
            
        }catch(SQLException sql1){
            System.out.println(sql1.getMessage());
        }
        
    }
}
