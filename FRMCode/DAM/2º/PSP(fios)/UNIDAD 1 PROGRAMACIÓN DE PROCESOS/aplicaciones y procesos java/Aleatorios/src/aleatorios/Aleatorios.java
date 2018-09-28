    
package aleatorios;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
// probamos crear un proceso hijo, comunicarnos con él E/S y finalizar su ejecución
public class Aleatorios {

    
    public static void main(String[] args) {
       String line;
       if (args.length <= 0) {
                       System.err.println("Se necesita un programa a ejecutar");
                       System.exit(-1);
                        }
       //args es  aleatoriosHijo.exe
      try{
		Process hijo = new ProcessBuilder(args).start();
                BufferedReader br = new BufferedReader(new
                            InputStreamReader(hijo.getInputStream()));
                //br es un stream de entrada conectado  (mediante una pipe) a la salida estándar del proceso hijo
                // el proceso aleatorios (padre) leerá en él la información que el proceso hijo le deja.
                // en este caso un nuevo número aleatorio
                PrintStream ps = new PrintStream(hijo.getOutputStream());
                // ps es un stream de salida conectado (mediante una pipe) a la entrada estandar del hijo.
                //  el p.padre envía cadenas al hijo ( aquí solicitando un número aleatorio más)
                BufferedReader in = new BufferedReader(new
                                   InputStreamReader(System.in));
                
                while ((in.readLine()).compareTo("fin") != 0 ) {
                    ps.println(" "); //No es necesario escribir nada en concreto, da igual  que cadena 
                    // de hecho la cadena tecleada por usuario no la recojemos.
                    ps.flush(); // Asegura que los datos se han enviado
                    
                    if ((line = br.readLine()) != null) {
                                    System.out.println(line);
                           }
                }//fin while
                //usuario teclea "fin", padre finaliza el proceso hijo
                System.out.println("Finalizando");
                hijo.destroy();
                //el proceso padre finaliza  la ejecución del proceso hijo, al leer "fin"
                
      }catch (IOException e) {
        System.out.println("Error ocurrió durante la ejecución.Descripción del error:" + e.getMessage());
        }         
    }
}
