package aleatorios2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
public class Aleatorios2 {
    public static void main(String[] args) {
        //variable que guarda el string que introduce el usuario por teclado, cualquier
        // cadena distinta de fin
        String entrada;
        try{
            Process procesohijo = new ProcessBuilder("aleatorioshijo.exe").start();
            BufferedReader flujoentrada1 = new BufferedReader(new InputStreamReader(procesohijo.getInputStream()));
            PrintStream flujosalida1 = new PrintStream(procesohijo.getOutputStream());
            BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
            //este proceso (padre) mientras obtenga en su entrada estándar una cadena 
            // distinta de fin, arranca un proceso hijo( aleatorioshijo) para obtener un número
            // que será numero de cadenas 
            // que procesará y enviará a otro proceso hijo mayusculashijo
            //CUANDO LEA DESDE TECLADO "fin" FINALIZA EJECUCIÓN DE aleatorioshijo
            do{
                System.out.println("Inserta un String (para terminar fin): ");
                entrada = lee.readLine();
                if(!entrada.equals("fin")){
                  flujosalida1.println("dame  un       número");//petición de trabajo a aleatorioshijo
                  flujosalida1.flush();
                  String salida = flujoentrada1.readLine();//obtengo número de aleatorioshijo
                
                    
                        int veces=Integer.parseInt(salida);
                        // arranco proceso mayusculashijo (instancia de mayusculashijo.exe).
                        //atención dentro ciclo do.. while
                        Process procesohijo2 = new ProcessBuilder("mayusculashijo.exe").start();
                        BufferedReader flujoentrada2 = new BufferedReader(new InputStreamReader(procesohijo2.getInputStream()));
                        PrintStream flujosalida2 = new PrintStream(procesohijo2.getOutputStream());
                        System.out.println ("Número de cadenas a procesar:"+veces);
                        for(int i=0;i<veces;i++){                            
                            String entrada2 = lee.readLine();//leo desde teclado  una cadena
                            flujosalida2.println(entrada2);// se la envío al proceso hijo mayusculashijo
                            flujosalida2.flush();
                            System.out.println(flujoentrada2.readLine()); 
                                //recibo resultado de mayusculashijo y lo visualizo (cadena en mayusculas)
                        }//fin for, tantas cadenas procesadas como valor número aleatorio obtenido
                          // por proceso hijo aleatorioshijo 
                        procesohijo2.destroy(); // arranco y finalizo mayusculashijo cada vez
                    
                }
            }while(!entrada.equals("fin"));
            procesohijo.destroy();
            System.out.println("Fin proceso");
        }
        catch (IOException e){
            System.out.println("Error ocurrió durante la ejecución " + "Descripción del error: " + e.getMessage());
        }
    } 
}
