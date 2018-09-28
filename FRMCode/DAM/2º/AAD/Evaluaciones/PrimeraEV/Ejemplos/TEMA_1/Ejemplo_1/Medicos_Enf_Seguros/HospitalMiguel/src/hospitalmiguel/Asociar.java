
package hospitalmiguel;
import java.io.*;
import java.sql.*;

// @author Miguel

public class Asociar {
    
    
    public static void asociar (BufferedReader leer) throws IOException {
        
        byte op=1;
        int codMedico,nuss;
        ResultSet consulta;
        
        try{
            Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost:3307/HOSPITALMIGUEL?user=root&password=usbw");
            Statement sentencia=conexion.createStatement();

            while(op!=0)
            {
                op=Menu.menuAsociar(leer);
                switch (op){
                    case 1:
                        Consultas.verMedicos(sentencia, leer);
                        System.out.println("Introducir Código del Médico al que desea asignar pacientes:");
                        codMedico=Integer.parseInt(leer.readLine());
                        consulta=sentencia.executeQuery("SELECT codigo FROM MEDICOS where codigo='"+codMedico+"';");
                        if(consulta.next())
                            asociarEnfermo(codMedico, sentencia, leer);
                        else
                            System.out.println("\n Código incorrecto \n");
                        break;
                    case 2:
                        Consultas.verEnfermos(sentencia, leer);
                        System.out.println("Introducir NUSS del enfermo al que desea asignar Médico:");
                        nuss=Integer.parseInt(leer.readLine());
                        consulta=sentencia.executeQuery("SELECT nuss FROM ENFERMOS where nuss='"+nuss+"';");
                        if(consulta.next())
                            asociarMedico(nuss, sentencia, leer);
                        else
                            System.out.println("\n NUSS incorrecto \n");
                        break;
                }

            }

            conexion.close();
        
        }catch (SQLException e) {
            
            System.out.println(e.getMessage());
        }
        
    }
    
    public static void asociarEnfermo (int codMedico, Statement sentencia, BufferedReader leer) throws IOException {
        
        
        int nuss;
        
        Consultas.verEnfermos(sentencia, leer);
        System.out.println("Introducir NUSS del Enfermo a asociar: (0 para Finalizar)");
        nuss=Integer.parseInt(leer.readLine());
        
        while(nuss!=0)
        {
            try{

                sentencia.executeUpdate("INSERT INTO MEDICOS_ENFERMOS (medico,enfermo) "
                                      + "VALUES ('"+codMedico+"','"+nuss+"')");

                System.out.println("\n Paciente Asociado \n");

            }catch (SQLException e){

                System.out.println("\n Paciente duplicado o no encontrado \n");
            }
            
            Consultas.verEnfermos(sentencia, leer);
            System.out.println("Introducir NUSS del Enfermo a asociar: (0 para Finalizar)");
            nuss=Integer.parseInt(leer.readLine());
        }
        
    }        
    
    public static void asociarMedico (int nuss, Statement sentencia, BufferedReader leer) throws IOException {
        
        
        int codMedico=1;

        Consultas.verMedicos(sentencia, leer);
        System.out.println("Introducir código del médico a asociar: (0 para Finalizar)");
        codMedico=Integer.parseInt(leer.readLine());
        
        while(codMedico!=0)
        {

            try{

                sentencia.executeUpdate("INSERT INTO MEDICOS_ENFERMOS (medico,enfermo) "
                                      + "VALUES ('"+codMedico+"','"+nuss+"')");

                System.out.println("\n Médico Asociado \n");

            }catch (SQLException e){

                System.out.println(" \n -- Médico Duplicado o no encontrado -- \n");
            }
            
            Consultas.verMedicos(sentencia, leer);
            System.out.println("Introducir código del médico a asociar: (0 para Finalizar)");
            codMedico=Integer.parseInt(leer.readLine());
            
            
        }
        
        
    }
    
    public static void quitarMedico (int nuss, Statement sentencia, BufferedReader leer) throws IOException {
          
        int codMedico;

        try{

            Consultas.verMedicosAsociados(nuss, sentencia, leer);
            System.out.println("Introducir código del médico a desvincular: (0 para Finalizar)");
            codMedico=Integer.parseInt(leer.readLine());

            while(codMedico!=0){

                if(sentencia.executeUpdate("DELETE FROM MEDICOS_ENFERMOS WHERE medico='"+codMedico+"' AND enfermo='"+nuss+"';")>0)
                    System.out.println(" \n -- Médico Eliminado -- \n");
                else
                    System.out.println(" \n -- Médico No encontrado -- \n");

                Consultas.verMedicosAsociados(nuss, sentencia, leer);
                System.out.println("Introducir código del médico a desvincular: (0 para Finalizar)");
                codMedico=Integer.parseInt(leer.readLine());
            }
        
        }catch (SQLException e){

                System.out.println(e.getMessage());
            }
        
        
    }
    
}
