/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

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
            //creacion.execute("drop database if exists Empresas;");
            creacion.execute("create database if not exists Empresas;");
            creacion.execute("use Empresas;");
            creacion.execute("create table if not exists Empresa("
                    + "cif varchar(9) not null,"
                    + "nome varchar(20),"
                    + "direccion varchar(20),"
                    + "telefono varchar(9),"
                    + "primary key(cif)"
                    + ");");
            creacion.execute("create table if not exists Produto("
                    + "codigo varchar(4),"
                    + "stockActual integer,"
                    + "stockMinimo integer,"
                    + "prezo decimal,"
                    + "cif varchar(9),"
                    + "primary key(codigo),"
                    + "foreign key(cif) references Empresa(cif) on delete cascade on update cascade"
                    + ");");
            creacion.execute("create table if not exists Empregado("
                    + "dni varchar(9) not null,"
                    + "nome varchar(20),"
                    + "telefono varchar(9),"
                    + "retencion decimal,"
                    + "cif varchar(9),"
                    + "primary key(dni),"
                    + "foreign key(cif) references Empresa(cif) on delete cascade on update cascade"
                    + ");");
            creacion.execute("create table if not exists Fixo("
                    + "dni varchar(9) not null,"
                    + "salario integer,"
                    + "trienios integer,"
                    + "primary key(dni),"
                    + "foreign key(dni) references Empregado(dni) on delete cascade on update cascade"
                    + ");");
            creacion.execute("create table if not exists Temproal("
                    + "dni varchar(9) not null,"
                    + "dataInicio date,"
                    + "dataFin date,"
                    + "importe decimal,"
                    + "primary key(dni),"
                    + "foreign key(dni) references Empregado(dni) on delete cascade on update cascade"
                    + ");");
            creacion.execute("create table if not exists Venta("
                    + "data date not null,"
                    + "hora time not null,"
                    + "codigo varchar(4) not null,"
                    + "temporal varchar(9) not null,"
                    + "cantidade integer,"
                    + "importe decimal,"
                    + "primary key(codigo,temporal,data,hora),"
                    + "foreign key(codigo) references Produto(codigo) on delete cascade on update cascade,"
                    + "foreign key(temporal) references Empregado(dni) on delete cascade on update cascade"
                    + ");");
            
        }catch(SQLException sql1){
            System.out.println(sql1.getMessage());
        }
        
    }
}
