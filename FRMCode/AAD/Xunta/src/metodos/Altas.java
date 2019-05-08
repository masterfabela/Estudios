/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import java.util.Scanner;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import pojos.Ciclo;
import pojos.Instituto;
import pojos.Taller;
import xunta.NewHibernateUtil;

/**
 *
 * @author Femio
 */
public class Altas {
    Scanner sc=new Scanner(System.in);
    public void altaInstituto(){
        Session s=NewHibernateUtil.getSession();
        System.out.println("Introduza o novo codigo.");
        String codigo=sc.next();
        System.out.println("Introduza o seu telefono.");
        String telefono=sc.next();
        Instituto i=new Instituto(codigo,telefono);
        guardarModificar(s,i);
        s.close();
    }
    public void altaCiclo(){
        Session s=NewHibernateUtil.getSession();
        System.out.println("Introduza o novo codigo.");
        String codigo=sc.next();
        System.out.println("Introduza o seu nome.");
        String nome=sc.next();
        Ciclo c=new Ciclo(codigo,nome);
        guardarModificar(s,c);
        s.close();
    }
    public void altaTaller(){
        Session s=NewHibernateUtil.getSession();
        System.out.println("Introduza o novo codigo.");
        String codigo=sc.next();
        System.out.println("Introduza o seu nome.");
        String telefono=sc.next();
        Taller i=new Taller(codigo,telefono);
        guardarModificar(s,i);
        s.close();
    }
    public static void guardarModificar(Session sesion,Object objeto) {
        try {
            sesion.beginTransaction();
            sesion.saveOrUpdate(objeto);
            sesion.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }
}
