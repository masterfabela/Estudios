/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresas;

import Pojos.*;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;

/**
 *
 * @author Femio
 */
public class Baixas {
    Scanner sc=new Scanner(System.in);
    public void baixaFixo(){
        Session s=NewHibernateUtil.getSession();
        System.out.println("Introduza o dni do empregado:");
        String cif=sc.next();
            List<Fixo> fixos = s.createCriteria(Fixo.class, cif).list();
        if (fixos.isEmpty()) {
            System.out.println("Non existe ese empregado fixo.");
        } else {
            Fixo f=fixos.get(0);
            System.out.println(f.getNome()+" foi eliminado.");
            s.delete(f);
        }
        s.close();
    }
     public void baixaTemporal(){
        Session s=NewHibernateUtil.getSession();
        System.out.println("Introduza o dni do empregado:");
        String cif=sc.next();
            List<Temporal> temporais = s.createCriteria(Temporal.class, cif).list();
        if (temporais.isEmpty()) {
            System.out.println("Non existe ese empregado fixo.");
        } else {
            Temporal f=temporais.get(0);
            System.out.println(f.getNome()+" foi eliminado.");
            s.delete(f);
        }
        s.close();
    }
}
