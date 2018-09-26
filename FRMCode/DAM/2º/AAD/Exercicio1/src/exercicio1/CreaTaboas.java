/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author a18franciscorm
 */
public class CreaTaboas {
    public void estructurar(Connection conexion){
        try{
            PreparedStatement ps=conexion.prepareStatement("CREATE DATABASE IF NOT EXISTS libreria;");
            ps.execute();
            ps=conexion.prepareStatement("USE libreria;");
            ps.execute();
            ps=conexion.prepareStatement("CREATE TABLE IF NOT EXISTS autores ( "+
                    "IdAutor INT(11) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, "+
                    "nombre VARCHAR(30) NOT NULL, "+
                    "nacionalidad VARCHAR(30) NOT NULL, "+
                    "PRIMARY KEY(IdAutor));");
            ps.execute();
            System.out.println("1");
            ps=conexion.prepareStatement("CREATE TABLE IF NOT EXISTS libros ( "+
                    "IdLibro INT(11) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, "+
                    "titulo VARCHAR(30) NOT NULL, "+
                    "precio FLOAT NOT NULL, "+
                    "PRIMARY KEY(IdLibro));");
            ps.execute();
            ps=conexion.prepareStatement("CREATE TABLE IF NOT EXISTS librosautores ( "+
                    "autor INT(11) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, "+
                    "libro INT(11) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, "+
                    "PRIMARE KEY(autor,libro), "+
                    "INDEX fk_autor(autor), "+
                    "INDEX fk_libro(libro), "+
                    "CONTRAINT fk_autor "+
                    "FOREING KEY (autor)"+
                    "   REFERENCES autores(IdAutor)"+
                    "       ON DELETE CASCADE "+
                    "       ON UPDATE CASCADE, "+
                    "CONTRAINT fk_libro "+
                    "FOREING KEY (libro)"+
                    "   REFERENCES autores(IdLibro)"+
                    "       ON DELETE CASCADE "+
                    "       ON UPDATE CASCADE, "+
                    ");"
                    );
//                    System.out.println("Creada a estructura da BD.");
        }catch(SQLException sqle1){
            System.out.println("Error:"+sqle1.getMessage());
        }
    }
}
