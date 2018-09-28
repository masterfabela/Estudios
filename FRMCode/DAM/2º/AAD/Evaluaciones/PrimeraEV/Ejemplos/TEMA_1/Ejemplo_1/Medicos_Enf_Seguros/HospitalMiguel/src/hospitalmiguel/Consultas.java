
package hospitalmiguel;
import java.io.*;
import java.sql.*;


// @author Miguel

public class Consultas {
    
    
    public static void consulta (BufferedReader leer) throws IOException {
        
        byte op=1;
        
        try{
            Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost:3307/HOSPITALMIGUEL?user=root&password=usbw");
            Statement sentencia=conexion.createStatement();


            while(op!=0)
            {
                op=Menu.menuConsultas(leer);
                switch (op){
                    case 1:
                        verMedicos(sentencia, leer);
                        break;
                    case 2:
                        verEnfermos(sentencia, leer);
                        break;
                    case 3:
                        verSeguros(sentencia, leer);
                        break;
                    case 4:
                        consultarMedico(conexion, sentencia, leer);
                        break;
                    case 5:
                        consultarEnfermo(conexion, sentencia, leer);
                        break;
                }
            }

            conexion.close();
        
        }catch (SQLException e) {
            
            System.out.println(e.getMessage());
        }

    }

    public static void consultarMedico (Connection conexion, Statement sentencia, BufferedReader leer) throws IOException {
        
        String nombre;
        byte b=0;
        
        Consultas.verMedicos(sentencia, leer);
        System.out.println("Nombre del médico a buscar:");
        nombre=leer.readLine();
        
        try{

            ResultSet consulta=sentencia.executeQuery("SELECT nombre, codigo FROM MEDICOS WHERE nombre='"+nombre+"';");
            
            while (consulta.next()){
                b=1;
                System.out.println("Lista de pacientes del Doctor "+consulta.getString(2)+" - "+consulta.getString(1)+":");
                System.out.println("----------------------------------------------------------------");
                System.out.println("| NUSS     |          NOMBRE          |   PATOLOGÍA   | SEGURO |");
                
                Statement sentencia2=conexion.createStatement();
                ResultSet consulta2=sentencia2.executeQuery("SELECT enfermo FROM MEDICOS_ENFERMOS WHERE medico='"+consulta.getString(2)+"';");
                
                while (consulta2.next()){
                    
                    Statement sentencia3=conexion.createStatement();
                    ResultSet consulta3=sentencia3.executeQuery("SELECT nuss,nombre,patologia,seguro FROM ENFERMOS WHERE nuss='"+consulta2.getString(1)+"';");
                    
                    while(consulta3.next()){
                        
                        System.out.printf("|  %5s   |  %22s  | %10s    | %5s  |%n",consulta3.getString(1),consulta3.getString(2),consulta3.getString(3),consulta3.getString(4));
                    
                    }
                    consulta3.close();
                }
                consulta2.close();
                System.out.println("----------------------------------------------------------------\n");
            }

            if (b==0)
                System.out.println("\n -- Médico no encontrado -- \n");
            
            consulta.close();
         
            
        }catch (SQLException e) {
            
            System.out.println(e.getMessage());
        }
        
    }
    
    public static void consultarEnfermo (Connection conexion, Statement sentencia, BufferedReader leer) throws IOException {
        
        int nuss;
        
        Consultas.verEnfermos(sentencia, leer);
        System.out.println("NUSS del Paciente a buscar:");
        nuss=Integer.parseInt(leer.readLine());
        
        try{
            ResultSet consulta=sentencia.executeQuery("SELECT nombre, seguro FROM ENFERMOS WHERE nuss='"+nuss+"';");
            
            if(consulta.next()){
                System.out.println("\n Datos del Seguro -- Paciente "+nuss+" - "+consulta.getString(1)+":");

                consulta=sentencia.executeQuery("SELECT codigo, nombre, prestaciones FROM SEGUROS WHERE codigo='"+consulta.getString(2)+"';");
                consulta.first();
                
                System.out.println("--------------------------------------");
                System.out.println("| CODIGO |   NOMBRE   | PRESTACIONES |");
                System.out.printf("| %5s  |%10s  | %10s   |%n",consulta.getString(1),consulta.getString(2),consulta.getString(3));
                System.out.println("--------------------------------------");

            }
            else
                System.out.println("Paciente no encontrado");
            consulta.close();
         
            
        }catch (SQLException e) {
            
            System.out.println(e.getMessage());
        }
        
    }
    
    public static void verSeguros (Statement sentencia, BufferedReader leer) throws IOException {
        
        

        try{
            ResultSet consulta=sentencia.executeQuery("SELECT * FROM SEGUROS;");
            
            System.out.println("--------------------------------------");
            System.out.println("| CODIGO |   NOMBRE   | PRESTACIONES |");

            while(consulta.next()){
                
                System.out.printf("| %5s  |%10s  | %10s   |%n",consulta.getString(1),consulta.getString(2),consulta.getString(3));
            }
            
            System.out.println("--------------------------------------");                   
            consulta.close();
            
         
        }catch (SQLException e) {
            
            System.out.println(e.getMessage());
        }
        
    }
    
    public static void verMedicos (Statement sentencia, BufferedReader leer) throws IOException {
        
        

        try{
            ResultSet consulta=sentencia.executeQuery("SELECT * FROM MEDICOS;");
            
            System.out.println("-------------------------------------------------------------");
            System.out.println("|  CODIGO  |       NOMBRE       |  ESPECIALIDAD  |  CLINICA   |");

            while(consulta.next()){
                
                System.out.printf("|  %5s   | %18s | %12s   | %10s |%n",consulta.getString(1),consulta.getString(2),consulta.getString(3),consulta.getString(4));
            }
            
            System.out.println("-------------------------------------------------------------");                   
            consulta.close();
            
         
        }catch (SQLException e) {
            
            System.out.println(e.getMessage());
        }
        
    }
    
    public static void verEnfermos (Statement sentencia, BufferedReader leer) throws IOException {
        

        
        try{
            ResultSet consulta=sentencia.executeQuery("SELECT * FROM ENFERMOS;");
            
            System.out.println("----------------------------------------------------------------");
            System.out.println("| NUSS     |          NOMBRE          |   PATOLOGÍA   | SEGURO |");
            
            while(consulta.next()){
                
                System.out.printf("|  %5s   |  %22s  | %10s    | %5s  |%n",consulta.getString(1),consulta.getString(2),consulta.getString(3),consulta.getString(4));
            }
            System.out.println("----------------------------------------------------------------");
            consulta.close();
         
            
        }catch (SQLException e) {
            
            System.out.println(e.getMessage());
        }
        
    }
    
    public static void verMedicosAsociados (int nuss, Statement sentencia, BufferedReader leer) throws IOException {
        
        ResultSet consulta;
        
        try{

        consulta=sentencia.executeQuery("SELECT * FROM MEDICOS WHERE codigo IN (SELECT medico FROM MEDICOS_ENFERMOS WHERE enfermo='"+nuss+"');");
        System.out.println("-------------------------------------------------------------");
        System.out.println("|  CODIGO  |       NOMBRE       | ESPECIALIDAD |  CLINICA   |");
        while(consulta.next()){

            System.out.printf("|  %5s   | %18s | %10s   | %10s |%n",consulta.getString(1),consulta.getString(2),consulta.getString(3),consulta.getString(4));
        }

        System.out.println("-------------------------------------------------------------");                   
        consulta.close();
         
            
        }catch (SQLException e) {
            
            System.out.println(e.getMessage());
        }
        
    }

}
