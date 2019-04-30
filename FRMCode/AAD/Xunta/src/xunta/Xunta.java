/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xunta;

import java.util.Scanner;
import org.hibernate.Session;

/**
 *
 * @author femio23
 */
public class Xunta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Session sesion=NewHibernateUtil.getSession();
        Creador c=new Creador();
        c.creaTaboas();
        byte opcion=0;
        while(opcion!=12){
            Vista.menuPrincipal();
            opcion=sc.nextByte();
            switch(opcion){
                case 1:;
                break;
                case 2:;
                break;
                case 3:;
                break;
                case 4:;
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
        sesion.close();
    }
    
}
