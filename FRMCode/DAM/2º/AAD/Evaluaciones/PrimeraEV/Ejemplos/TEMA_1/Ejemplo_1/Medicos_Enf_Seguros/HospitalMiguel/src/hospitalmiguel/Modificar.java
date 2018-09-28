
package hospitalmiguel;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.*;


// @author Miguel

public class Modificar {
    
        
    public static void modificar (BufferedReader leer) throws IOException {
        
        int nuss,seguro,op,op2;
        ResultSet consulta;
        
        try{
            Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost:3307/HOSPITALMIGUEL?user=root&password=usbw");
            Statement sentencia=conexion.createStatement();
            
            Consultas.verEnfermos(sentencia, leer);
            System.out.println("Introducir NUSS del paciente a modificar: (0 para Finalizar)");
            nuss=Integer.parseInt(leer.readLine());
            
            while (nuss!=0){

                try{
                
                    consulta=sentencia.executeQuery("SELECT nuss FROM ENFERMOS where nuss='"+nuss+"';");

                    if(consulta.next()){

                        System.out.println("¿Qué desea modificar?"
                                            + "\n1.Médicos asignados"
                                            + "\n2.Compañia aseguradora"
                                            + "\n0.Finalizar");
                        op=Integer.parseInt(leer.readLine());
                        switch(op) {
                            case 1:
                                System.out.println("¿Desea añadir un médico o eliminarlo?"
                                        + "\n1.Añadir"
                                        + "\n2.Eliminar"
                                        + "\n0.Cancelar");
                                op2=Integer.parseInt(leer.readLine());
                                switch (op2){
                                    case 1:
                                        Asociar.asociarMedico(nuss, sentencia, leer);
                                        break;
                                    case 2:
                                        Asociar.quitarMedico(nuss, sentencia, leer);
                                        break;
                                }
                                break;
                            case 2:
                                Consultas.verSeguros(sentencia, leer);
                                System.out.println("Introducir código del seguro:");
                                seguro=Integer.parseInt(leer.readLine());
                                sentencia.executeUpdate("UPDATE ENFERMOS SET seguro='"+seguro+"' WHERE nuss="+nuss+"");
                                break;
                        }
                    }else
                        System.out.println("\nNUSS no encontrado\n");
                    
                    }catch (SQLException e) {
            
                        System.out.println("\n Seguro incorrecto \n");
                    }
                
                Consultas.verEnfermos(sentencia, leer);
                System.out.println("Introducir NUSS del paciente a modificar: (0 para Finalizar)");
                nuss=Integer.parseInt(leer.readLine());
            }
        }catch (SQLException e) {
            
            System.out.println(e.getMessage());
        }
        
        
    }

}
