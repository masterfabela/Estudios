/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciciobeans;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Femio
 */
public class Metodos {
    Connection con;
    public void conectar(){
        try{
           con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root");
            System.out.println("Conexión estabrecida.");
        }catch(SQLException se){
            System.out.println("Erro na conexión: "+se.getMessage());
        }
    }
    public void desconectar(){
        try{
            con.close();
        }catch(SQLException se){
            System.out.println("Erro na desconexión: "+se.getMessage());
        }
    }
    public void creador(){
        try{
            Statement state = con.createStatement();
            state.execute("create database if not exists BDReservas;");
            state.execute("use BDReservas;");
            state.execute("create table if not exists Hoteles("
                    + "idHotel int(4) unsigned zerofill auto_increment not null,"
                    + "nombre varchar(40),"
                    + "tf varchar(9),"
                    + "primary key(idHotel)"
                    + ");");
            state.execute("create table if not exists Habitaciones("
                    + "idHabitacion int(4) unsigned zerofill auto_increment not null,"
                    + "tipo varchar(40),"
                    + "pvp real,"
                    + "ocupada bit,"
                    + "primary key (idHabitacion)"
                    + ");");
            state.execute("create table if not exists Clientes("
                    + "dni varchar(9) not null,"
                    + "nombre varchar(15),"
                    + "tf varchar(9),"
                    + "primary key(dni)"
                    + ");");
            state.execute("create table if not exists Reservas("
                    + "idHotel int(4) unsigned zerofill not null,"
                    + "idHabitacion int(4) unsigned zerofill not null,"
                    + "FechaEntrada date not null,"
                    + "FechaSalida date not null,"
                    + "idCliente varchar(9),"
                    + "primary key(FechaEntrada,idHabitacion),"
                    + "foreign key(idHotel) references Hoteles(idHotel) on delete cascade on update cascade,"
                    + "foreign key(idHabitacion) references Habitaciones(idHabitacion) on delete cascade on update cascade,"
                    + "foreign key(idCliente) references Clientes(dni) on delete cascade on update cascade"
                    + ");");
        }catch(SQLException se){
            System.out.println("Erro na creación da BBDD: "+se.getMessage());
        }
    }
}
