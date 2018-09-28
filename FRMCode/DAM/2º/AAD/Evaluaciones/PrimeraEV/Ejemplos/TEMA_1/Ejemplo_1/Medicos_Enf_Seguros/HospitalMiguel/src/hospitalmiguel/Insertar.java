
package hospitalmiguel;
import java.io.*;
import java.sql.*;


// @author Miguel

public class Insertar {
    
    
    public static void insertar (BufferedReader leer) throws IOException {
        
        byte op=1;
        
        try{
            Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost:3307/HOSPITALMIGUEL?user=root&password=usbw");
            Statement sentencia=conexion.createStatement();

            while(op!=0)
            {
                op=Menu.menuAltas(leer);
                switch (op){
                    case 1:
                        insertarMedico(sentencia, leer);
                        break;
                    case 2:
                        insertarEnfermo(sentencia, leer);
                        break;
                    case 3:
                        insertarSeguro(sentencia, leer);
                        break;
                }
            }

            conexion.close();
        
        }catch (SQLException e) {
            
            System.out.println(e.getMessage());
        }
        
    }
     
    public static void insertarSeguro (Statement sentencia, BufferedReader leer) throws IOException {
        
        String nombre,prestaciones;
        int codigo;
        ResultSet consulta;
                
        System.out.println("Código del seguro:");
        codigo=Integer.parseInt(leer.readLine());
        
        try {
            consulta=sentencia.executeQuery("SELECT codigo FROM SEGUROS where codigo='"+codigo+"';");
            
            if(!consulta.next()){
        
                System.out.println("Nombre del seguro:");
                nombre=leer.readLine();
                System.out.println("Prestaciones del seguro:");
                prestaciones=leer.readLine();


                sentencia.executeUpdate("INSERT INTO SEGUROS (codigo,nombre,prestaciones) "
                                      + "VALUES ('"+codigo+"','"+nombre+"','"+prestaciones+"')");
                System.out.println("Seguro Registrado");
            }else
                System.out.println("\nCódigo duplicado\n");

        }catch (SQLException e) {

            System.out.println(e.getMessage());
            System.out.println("\nSeguro NO Registrado\n");
        }
        
    }
    
    public static void insertarMedico (Statement sentencia, BufferedReader leer) throws IOException {
        
        String nombre,especialidad,clinica;
        int codigo;
        byte op;
        ResultSet consulta;
        
        System.out.println("Código del Médico:");
        codigo=Integer.parseInt(leer.readLine());
        
        try{
            consulta=sentencia.executeQuery("SELECT codigo FROM MEDICOS where codigo='"+codigo+"';");

            if(!consulta.next()){

                System.out.println("Nombre del Médico:");
                nombre=leer.readLine();
                System.out.println("Especialidad del Médico:");
                especialidad=leer.readLine();
                System.out.println("Clínica del Médico:");
                clinica=leer.readLine();


                sentencia.executeUpdate("INSERT INTO MEDICOS (codigo,nombre,especialidad,clinica) "
                                      + "VALUES ('"+codigo+"','"+nombre+"','"+especialidad+"','"+clinica+"')");

                System.out.println("Médico Registrado");

                System.out.println("¿Desea asociar algún Paciente a este Médico?"
                        + "\n1.SI"
                        + "\n2.NO");
                op=Byte.parseByte(leer.readLine());

                if (op==1)
                    Asociar.asociarEnfermo(codigo, sentencia, leer);
            }else
                System.out.println("\nCódigo duplicado\n");
            

        }catch (SQLException e) {

            System.out.println(e.getMessage());
            System.out.println("\nMédico NO Registrado\n");
        }
        
    }
    
    public static void insertarEnfermo (Statement sentencia, BufferedReader leer) throws IOException {
        
        String nombre,patologia;
        int nuss,seguro;
        byte op;
        ResultSet consulta;
        
        
        System.out.println("NUSS del Enfermo:");
        nuss=Integer.parseInt(leer.readLine());
        
        try{
            consulta=sentencia.executeQuery("SELECT nuss FROM ENFERMOS where nuss='"+nuss+"';");

            if(!consulta.next()){
        
        
                System.out.println("Nombre del Enfermo:");
                nombre=leer.readLine();
                System.out.println("Patología del Enfermo:");
                patologia=leer.readLine();
                Consultas.verSeguros(sentencia, leer);
                System.out.println("Código del Seguro:");
                seguro=Integer.parseInt(leer.readLine());
        
        
                sentencia.executeUpdate("INSERT INTO ENFERMOS (nuss,nombre,patologia,seguro) "
                                      + "VALUES ('"+nuss+"','"+nombre+"','"+patologia+"','"+seguro+"')");

                System.out.println("\nEnfermo Registrado\n");

                System.out.println("¿Desea asociar algún Médico a este Paciente?"
                        + "\n1.SI"
                        + "\n2.NO");
                op=Byte.parseByte(leer.readLine());

                if (op==1)
                    Asociar.asociarMedico(nuss, sentencia, leer);
            }else
                System.out.println("\nNUSS Duplicado\n");
            
        }catch (SQLException e) {
            System.out.println("\nSeguro incorrecto");
            System.out.println("\nEnfermo NO Registrado\n");
        }
    }
    
}
