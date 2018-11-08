/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio4;
import Obx.*;
import java.util.ArrayList;
import java.util.Scanner;
import org.hibernate.*;

/**
 *
 * @author a18franciscorm
 */
public class Exercicio4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        MetodosSQL msql=new MetodosSQL();
        Metodos m1= new Metodos();
        ArrayList dataSesion= null;
        Scanner sc=new Scanner(System.in);
        int opcion=0;
        int intentos=0;
        while(opcion!=6){
            switch(opcion){
                case 1:dataSesion=m1.conectar();
                break;
                case 2:m1.switchInsert(dataSesion);
                break;
                case 3:m1.switchDelete();
                break;
                case 4:m1.switchUpdate();
                break;
                case 5:m1.switchQuery();
                break;
                case 6:System.out.println("Saindo, Adeus");;
                break;
                default: 
                    ArrayList opcionIntentos = m1.loopMenuPrincipal(intentos);
                    opcion=(int)opcionIntentos.get(0);
                    intentos=(int)opcionIntentos.get(1);
                break;
            }
        }

                    
        /*
        MENÚ
        2- Inserción de nuevas filas.
            a. Inserción autor.
            b. Inserción libro(tiene que existir el autor).
            c. Insercción teléfono.
        3- Borrado de filas.
            a. Borrado libro(El autor sigue existiendo).
            b. Borrado autor(Desaparecen todos los libros).
            c. Borrado teléfono
        4-Modificaciones.
            - Introduciendo el código de un libro modifique su precio.
            -partiendo de un autor modificar el nº de tf.	
        6- Consultas.
            a. Introduciendo el título de un libro visualice sus datos  
                y el nombre el autor ó autores con su tf.
            b. Introduciendo el nombre de un autor visualice sus libros.
            c. Visualización de todos los Libros de la tabla.
            d.Visualización  de todos los autores con sus libros.
        7-Fin.

        */
    }
    
}
