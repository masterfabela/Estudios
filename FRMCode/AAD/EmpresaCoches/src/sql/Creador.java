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

    public static Connection conexion() {
        Connection c = null;
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root");
            System.out.println("Conexion realizada satisfactoriamente.");
        } catch (SQLException sqle1) {
            System.out.println("Erro na conexión: " + sqle1.getMessage());
        }
        creaTaboas(c);
        return c;
    }

    public static void creaTaboas(Connection c) {
        try {
            Statement creacion = c.createStatement();

            creacion.execute("create database if not exists EmpresaCoches;");
            creacion.execute("use EmpresaCoches;");
            creacion.execute("create table if not exists Proveedor("
                    + "codigo int(4) auto_increment not null,"
                    + "nome varchar(20),"
                    + "primary key(codigo)"
                    + ");");
            creacion.execute("create table if not exists Exposicion("
                    + "codigo int(4) not null,"
                    + "nome varchar(20),"
                    + "lugar varchar(20),"
                    + "primary key(codigo)"
                    + ");");
            creacion.execute("create table if not exists Cliente("
                    + "dni varchar(9) not null,"
                    + "nome varchar(20),"
                    + "apelidos varchar(40),"
                    + "direccion varchar(40),"
                    + "primary key(dni)"
                    + ");");
            creacion.execute("create table if not exists Coche("
                    + "matricula varchar(7) not null,"
                    + "marca varchar(20),"
                    + "modelo varchar(20),"
                    + "tipo varchar(20),"
                    + "precioCompra decimal,"
                    + "precioVenta decimal,"
                    + "codigoProveedor int(4),"
                    + "codigoReparacion int(4),"
                    + "codigoExposicion int(4),"
                    + "codigoCliente varchar(9),"
                    + "codigoReserva varchar(9),"
                    + "primary key(matricula),"
                    + "foreign key(codigoProveedor) references Proveedor(codigo) on update cascade on delete cascade,"
                    + "foreign key(codigoExposicion) references Exposicion(codigo) on update cascade on delete cascade,"
                    + "foreign key(codigoCliente) references Cliente(dni) on update cascade on delete cascade,"
                    + "foreign key(codigoReserva) references Cliente(dni) on update cascade on delete cascade"
                    + ");");
            creacion.execute("create table if not exists Reparacion("
                    + "codigo int(4) auto_increment not null,"
                    + "tipo varchar(20),"
                    + "descricion varchar(20),"
                    + "codigoCoche varchar(7),"
                    + "primary key(codigo),"
                    + "foreign key(codigoCoche) references Coche(matricula) on update cascade on delete cascade"
                    + ");");
            System.out.println("Taboas creadas correctamente.");

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
    }

    public static void purgaBase(Connection c) {
        try {
            Statement creacion = c.createStatement();
            creacion.execute("drop database if exists EmpresaCoches;");
            creaTaboas(c);
            creacion.execute("insert into Coche values(\"3436GTR\",\"Hunday\",\"Tucson\",\"turismo\",,,,,,,)");
            creacion.execute("insert into Proveedor values(1,\"Ibericar\")");
            creacion.execute("insert into Reparacion values(1,\"chapa\",\"repintado\",\"3436GTR\")");
            creacion.execute("insert into Exposicion values(1,\"ExpoLugo\",\"Lugo\")");
            System.out.println("Purga realizada correctamente");
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }

    }
}
