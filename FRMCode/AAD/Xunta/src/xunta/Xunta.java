/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xunta;

import java.util.Scanner;
import metodos.Adicions;
import metodos.Altas;
import metodos.Baixas;
import metodos.Listados;
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
        Altas a=new Altas();
        Adicions ad=new Adicions();
        Baixas b=new Baixas();
        Listados l=new Listados();
        c.creaTaboas();
        byte opcion=0;
        while(opcion!=12){
            Vista.menuPrincipal();
            opcion=sc.nextByte();
            switch(opcion){
                case 1:a.altaInstituto();
                break;
                case 2:a.altaCiclo();
                break;
                case 3:a.altaTaller();
                break;
                case 4:ad.adicionCiclo();
                break;
                case 5:ad.adicionTaller();
                break;
                case 6:ad.adicionUso();
                break;
                case 7:b.baixaCiclo();
                break;
                case 8:b.baixaTaller();
                break;
                case 9:l.listarCiclos1();
                break;
                case 10:l.listarCiclos2();
                break;
                case 11:l.listarInstitutos();
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
