/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contolador;
import java.util.Scanner;
import vista.Vista;
import modelo.*;


/**
 *
 * @author femio23
 */
public class Exercicio1NeoDatis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Altas alta=new Altas();
        Modificacions mod= new Modificacions();
        byte opcion=0;
        Scanner sc=new Scanner(System.in);
        while(opcion!=12){
            Vista.mostrarMPrincipal();
            opcion=sc.nextByte();
            switch(opcion){
                case 1:alta.addAutor();
                break;
                case 2:alta.AddLibro();
                break;
                case 3:mod.modificarDireccion();
                break;
                case 4:mod.modificarPrezo();
                break;
                case 5:;
                break;
                case 6:;
                break;
                case 7:;
                break;
                case 8:;
                break;
                case 9:;
                break;
                case 10:;
                break;
                case 11:;
                break;
                default:
                    if(opcion==12)
                        System.out.println("Adeus");
                    else
                        System.out.println("\n\nErro de entrada(1-12)\n\n\n");
                break;
            }
        }
    }
}

