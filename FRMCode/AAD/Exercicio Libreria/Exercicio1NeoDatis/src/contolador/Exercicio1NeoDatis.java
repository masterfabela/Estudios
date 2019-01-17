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
        Baixas baixa = new Baixas();
        Consultas cons = new Consultas();
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
                case 5:baixa.eliminar();
                break;
                case 6:cons.verItalianos();
                break;
                case 7:cons.librosPublicadosIntervalo();
                break;
                case 8:cons.librosEspañois60();
                break;
                case 9:cons.cantidadNacional();
                break;
                case 10:cons.titulosAutor();
                break;
                case 11:cons.verLibro();
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

