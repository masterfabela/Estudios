/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresas;

import BD.Creador;
import java.util.Scanner;
import org.hibernate.Session;


/**
 *
 * @author femio23
 */
public class Empresas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Session sesion=NewHibernateUtil.getSession();
        Creador.creaTaboas();
        Altas a=new Altas();
        byte opcion=0;
        while(opcion!=15){
            Vista.menuPrincipal();
            opcion=sc.nextByte();
            switch(opcion){
                case 1:a.altaEmpresa();
                break;
                case 2:a.altaFixo();
                break;
                case 3:a.altaTemporal();
                break;
                case 4:a.altaProduto();
                break;
                case 5:a.altaVenta();
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
                case 12:;
                break;
                case 13:;
                break;
                case 14:;
                break;
                default:
                    if(opcion==15){
                        System.out.println("Adeus");
                    }
                    else
                        System.out.println("\n\nErro de entrada(1-15)\n\n\n");
                break;
            }
    
        }
    }
}
