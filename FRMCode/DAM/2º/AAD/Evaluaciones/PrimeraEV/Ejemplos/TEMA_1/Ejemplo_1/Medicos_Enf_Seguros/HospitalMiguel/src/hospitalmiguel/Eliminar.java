
package hospitalmiguel;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.*;


// @author Miguel

public class Eliminar {
       
    
    public static void eliminar (BufferedReader leer) throws IOException {
        

        byte op=1;
        
        try{
            Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost:3307/HOSPITALMIGUEL?user=root&password=usbw");
            Statement sentencia=conexion.createStatement();

            while(op!=0)
            {
                op=Menu.menuEliminar(leer);
                switch (op){
                    case 1:
                        eliminarMedico(sentencia, leer);
                        break;
                    case 2:
                        eliminarEnfermo(sentencia, leer);
                        break;
                    case 3:
                        eliminarSeguro(sentencia, leer);
                        break;
                }

            }

            conexion.close();
        
        }catch (SQLException e) {
            
            System.out.println(e.getMessage());
        }
    }
    
    public static void eliminarSeguro (Statement sentencia, BufferedReader leer) throws IOException {
        
        int codigo;
        
        Consultas.verSeguros(sentencia, leer);
        System.out.println("Introducir código del seguro a eliminar:");
        codigo=Integer.parseInt(leer.readLine());

        if (Menu.menuConfirmar(leer)==1)
        {
            try{
               if(sentencia.executeUpdate("DELETE FROM SEGUROS WHERE (codigo='"+codigo+"')")>0)
                   System.out.println("\n-- Seguro eliminado -- \n");
               else
                   System.out.println("\n No se ha encontrado al Seguro \n");
               
               
            }catch (SQLException e) {

                System.out.println("\n-- Este seguro tiene pacientes asignados, no se puede eliminar -- \n");
            }
        }
        else
            System.out.println("\n-- Seguro NO eliminado -- \n");
        
    }  
        
    public static void eliminarMedico (Statement sentencia, BufferedReader leer) throws IOException {
        
        int codigo;
        
        Consultas.verMedicos(sentencia, leer);
        System.out.println("Introducir codigo del médico a eliminar:");
        codigo=Integer.parseInt(leer.readLine());

        if (Menu.menuConfirmar(leer)==1)
        {
            try{
               if(sentencia.executeUpdate("DELETE FROM MEDICOS WHERE (codigo='"+codigo+"')")>0)
                   System.out.println("\n-- Médico eliminado -- \n");
               else
                   System.out.println("\n No se ha encontrado al Médico\n");
               
               
            }catch (SQLException e) {

                System.out.println(e.getMessage());
            }
        }
        else
            System.out.println("\n-- Médico NO eliminado --\n");
        
    }
           
    public static void eliminarEnfermo (Statement sentencia, BufferedReader leer) throws IOException {
        
        int nuss;
        
        Consultas.verEnfermos(sentencia, leer);
        System.out.println("Introducir NUSS del enfermo a eliminar:");
        nuss=Integer.parseInt(leer.readLine());

        if (Menu.menuConfirmar(leer)==1)
        {
            try{
               if(sentencia.executeUpdate("DELETE FROM ENFERMOS WHERE (nuss='"+nuss+"')")>0)
                   System.out.println("\n-- Enfermo eliminado -- \n");
               else
                   System.out.println("\n No se ha encontrado al Enfermo\n");
               
               
            }catch (SQLException e) {

                System.out.println(e.getMessage());
            }
        }
        else
            System.out.println("\n-- Enfermo NO eliminado -- \n");
        
    }
    
}
