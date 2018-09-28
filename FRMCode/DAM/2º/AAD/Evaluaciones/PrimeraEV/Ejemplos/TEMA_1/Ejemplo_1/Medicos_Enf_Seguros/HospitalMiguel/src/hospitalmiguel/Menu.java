
package hospitalmiguel;
import java.io.BufferedReader;
import java.io.IOException;


// @author Miguel

public class Menu {
    
    public static byte menuInicio (BufferedReader leer) throws IOException {
        
        byte op;
        System.out.println("\nSeleccione opción:"
                + "\n1.Creación de Tablas y BD"
                + "\n2.Altas"
                + "\n3.Bajas"
                + "\n4.Modificar"
                + "\n5.Asociar"
                + "\n6.Consultas"
                + "\n0.Salir");
        
        op=Byte.parseByte(leer.readLine());
        
        return op;
        
    }
    
    public static byte menuAltas (BufferedReader leer) throws IOException {
        
        byte op;
        System.out.println("¿Qué desea dar de alta?"
                + "\n1.Médico"
                + "\n2.Enfermo"
                + "\n3.Seguro"
                + "\n0.Finalizar");
        
        op=Byte.parseByte(leer.readLine());
        
        return op;
    }
    
    public static byte menuEliminar (BufferedReader leer) throws IOException {
        
        byte op;
        System.out.println("¿Qué desea eliminar?"
                + "\n1.Médico"
                + "\n2.Enfermo"
                + "\n3.Seguro"
                + "\n0.Finalizar");
        
        op=Byte.parseByte(leer.readLine());
        
        return op;
    }
    
    public static byte menuModificar (BufferedReader leer) throws IOException {
        
        byte op;
        System.out.println("¿Qué desea modificar?"
                + "\n1.Médicos de un paciente"
                + "\n2.Enfermo"
                + "\n0.Finalizar");
        
        op=Byte.parseByte(leer.readLine());
        
        return op;
    }
    
    public static byte menuConsultas (BufferedReader leer) throws IOException {
        
        byte op;
        System.out.println("¿Qué desea consultar?"
                + "\n1.Listado de Médicos"
                + "\n2.Listado de Enfermos"
                + "\n3.Listado de Seguros"
                + "\n4.Pacientes de un Médico"
                + "\n5.Seguro de un Paciente"
                + "\n0.Finalizar");
        
        op=Byte.parseByte(leer.readLine());
        
        return op;
    }
    
    public static byte menuAsociar (BufferedReader leer) throws IOException {
        
        byte op;
        System.out.println("¿Qué desea Asociar?"
                + "\n1.Asociar Enfermos a un Médico"
                + "\n2.Asociar Médicos a un Enfermo"
                + "\n0.Finalizar");
        
        op=Byte.parseByte(leer.readLine());
        
        return op;
    }
    
    public static byte menuConfirmar (BufferedReader leer) throws IOException {
        
        byte op;
        System.out.println("¿Seguro que desea eliminar este registro?"
                + "\n1.SI"
                + "\n2.NO");
        
        op=Byte.parseByte(leer.readLine());
        
        return op;
    }

}
