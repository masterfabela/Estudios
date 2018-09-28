
package hospitalmiguel;
import java.sql.*;


// @author Miguel
 
public class CrearTablas {
    
    public static void CrearTablas () {
        
        try{
            
            Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost:3307/?user=root&password=usbw");
            Statement sentencia=conexion.createStatement();

            sentencia.execute("CREATE DATABASE IF NOT EXISTS HOSPITALMIGUEL;");
            sentencia.execute("USE HOSPITALMIGUEL;");


            sentencia.execute("CREATE TABLE IF NOT EXISTS SEGUROS"+ 
                              "(codigo INT NOT NULL, "+
                              "nombre VARCHAR(30) NOT NULL, "+
                              "prestaciones VARCHAR(30) NOT NULL, "+
                              "PRIMARY KEY (codigo)) "+
                              "ENGINE INNODB; ");


            sentencia.execute("CREATE TABLE IF NOT EXISTS ENFERMOS "+
                              "(nuss INT NOT NULL, "+
                              "nombre VARCHAR(30) NOT NULL, "+
                              "patologia VARCHAR(30) NOT NULL, "+
                              "seguro INT NOT NULL, "+
                              "PRIMARY KEY (nuss), "+
                              "CONSTRAINT fk1_seguro"+
                                 " FOREIGN KEY (seguro) references SEGUROS(codigo)"+
                                 " ON DELETE RESTRICT"+
                                 " ON UPDATE CASCADE)"+
                              "ENGINE INNODB;");

            sentencia.execute("CREATE TABLE IF NOT EXISTS MEDICOS "+
                              "(codigo INT NOT NULL, "+
                              "nombre VARCHAR(30) NOT NULL, "+
                              "especialidad VARCHAR(30) NOT NULL, "+
                              "clinica VARCHAR(30) NOT NULL, "+
                              "PRIMARY KEY (codigo)) "+
                              "ENGINE INNODB;");

            sentencia.execute("CREATE TABLE IF NOT EXISTS MEDICOS_ENFERMOS "+
                              "(medico INT NOT NULL, "+
                              "enfermo INT NOT NULL, "+
                              "PRIMARY KEY (medico,enfermo), "+
                              "CONSTRAINT fk2_medico"+
                                 " FOREIGN KEY (medico) references MEDICOS(codigo)"+
                                 " ON DELETE CASCADE "+
                                 " ON UPDATE CASCADE ,"+
                              "CONSTRAINT fk3_enfermo"+
                                 " FOREIGN KEY (enfermo) references ENFERMOS(nuss)"+
                                 " ON DELETE CASCADE"+
                                 " ON UPDATE CASCADE)"+
                              "ENGINE INNODB;");

            cargarEjemplos(sentencia);
            conexion.close();
            
            System.out.println("-- BASE DE DATOS LISTA --");

        }catch (SQLException e) {
            
            System.out.println(e.getMessage());
        }
    }
    
    public static void cargarEjemplos (Statement sentencia) throws SQLException {
        
        
        sentencia.executeUpdate("INSERT INTO SEGUROS (codigo,nombre,prestaciones) VALUES ('111','Sanitas','todas')");
        sentencia.executeUpdate("INSERT INTO SEGUROS (codigo,nombre,prestaciones) VALUES ('222','Sanitas','Básico')");
        sentencia.executeUpdate("INSERT INTO SEGUROS (codigo,nombre,prestaciones) VALUES ('333','Adeslas','todas')");
        sentencia.executeUpdate("INSERT INTO SEGUROS (codigo,nombre,prestaciones) VALUES ('444','Mapfre','todas')");
        sentencia.executeUpdate("INSERT INTO MEDICOS (codigo,nombre,especialidad,clinica) VALUES ('101','Marcos Lopez','Dermatologo','Vigo')");
        sentencia.executeUpdate("INSERT INTO MEDICOS (codigo,nombre,especialidad,clinica) VALUES ('102','Juan Perez','Otorrino','Vigo')");
        sentencia.executeUpdate("INSERT INTO MEDICOS (codigo,nombre,especialidad,clinica) VALUES ('103','María Garrido','Endrocrino','Vigo')");
        sentencia.executeUpdate("INSERT INTO MEDICOS (codigo,nombre,especialidad,clinica) VALUES ('104','Lucas Torres','Dermatologo','Vigo')");
        sentencia.executeUpdate("INSERT INTO MEDICOS (codigo,nombre,especialidad,clinica) VALUES ('105','Lucas Torres','Cardiologo','Vigo')");
        sentencia.executeUpdate("INSERT INTO MEDICOS (codigo,nombre,especialidad,clinica) VALUES ('106','Ana Padilla','Neurólogo','Vigo')");
        sentencia.executeUpdate("INSERT INTO ENFERMOS (nuss,nombre,patologia,seguro) VALUES ('22','Pedro Martinez','Gripe','111')");
        sentencia.executeUpdate("INSERT INTO ENFERMOS (nuss,nombre,patologia,seguro) VALUES ('33','Sandra García','Fiebre','111')");
        sentencia.executeUpdate("INSERT INTO ENFERMOS (nuss,nombre,patologia,seguro) VALUES ('44','Andrés Soto','Meningitis','222')");
        sentencia.executeUpdate("INSERT INTO ENFERMOS (nuss,nombre,patologia,seguro) VALUES ('55','Marta Dominguez','Estres','333')");
        sentencia.executeUpdate("INSERT INTO ENFERMOS (nuss,nombre,patologia,seguro) VALUES ('66','Paco Lopez','Gripe','333')");
        sentencia.executeUpdate("INSERT INTO ENFERMOS (nuss,nombre,patologia,seguro) VALUES ('77','Sara Ortiz','Estres','333')");
        sentencia.executeUpdate("INSERT INTO ENFERMOS (nuss,nombre,patologia,seguro) VALUES ('88','Pedro Rojas','Gripe','444')");
        sentencia.executeUpdate("INSERT INTO ENFERMOS (nuss,nombre,patologia,seguro) VALUES ('99','Isabel Pedrido','Gripe','444')");
        sentencia.executeUpdate("INSERT INTO MEDICOS_ENFERMOS (medico,enfermo) VALUES ('101','22')");
        sentencia.executeUpdate("INSERT INTO MEDICOS_ENFERMOS (medico,enfermo) VALUES ('101','33')");
        sentencia.executeUpdate("INSERT INTO MEDICOS_ENFERMOS (medico,enfermo) VALUES ('102','22')");
        sentencia.executeUpdate("INSERT INTO MEDICOS_ENFERMOS (medico,enfermo) VALUES ('102','66')");
        sentencia.executeUpdate("INSERT INTO MEDICOS_ENFERMOS (medico,enfermo) VALUES ('102','77')");
        sentencia.executeUpdate("INSERT INTO MEDICOS_ENFERMOS (medico,enfermo) VALUES ('102','88')");
        sentencia.executeUpdate("INSERT INTO MEDICOS_ENFERMOS (medico,enfermo) VALUES ('103','99')");
        sentencia.executeUpdate("INSERT INTO MEDICOS_ENFERMOS (medico,enfermo) VALUES ('103','77')");
        sentencia.executeUpdate("INSERT INTO MEDICOS_ENFERMOS (medico,enfermo) VALUES ('104','77')");
        sentencia.executeUpdate("INSERT INTO MEDICOS_ENFERMOS (medico,enfermo) VALUES ('104','33')");
        sentencia.executeUpdate("INSERT INTO MEDICOS_ENFERMOS (medico,enfermo) VALUES ('105','44')");
        sentencia.executeUpdate("INSERT INTO MEDICOS_ENFERMOS (medico,enfermo) VALUES ('105','55')");
        sentencia.executeUpdate("INSERT INTO MEDICOS_ENFERMOS (medico,enfermo) VALUES ('105','66')");
        sentencia.executeUpdate("INSERT INTO MEDICOS_ENFERMOS (medico,enfermo) VALUES ('106','44')");

    }
    
}
