/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import pojos.Ciclo;
import pojos.Taller;
import xunta.NewHibernateUtil;

/**
 *
 * @author Femio
 */
public class Baixas {

    Scanner sc = new Scanner(System.in);

    public void baixaCiclo() {
        Session s = NewHibernateUtil.getSession();
        System.out.println("Introduza o codigo do ciclo:");
        String codigo = sc.next();
        List<Ciclo> ciclos = s.createCriteria(Ciclo.class, codigo).list();
        if (ciclos.isEmpty()) {
            System.out.println("Non existe ese ciclo.");
        } else {
            Ciclo c = ciclos.get(0);
            System.out.println(c.getNome() + " foi eliminado.");
            s.delete(c);
        }
        s.close();
    }

    public void baixaTaller() {
        Session s = NewHibernateUtil.getSession();
        System.out.println("Introduza o codigo do Taller:");
        String codigo = sc.next();
        List<Taller> talleres = s.createCriteria(Taller.class, codigo).list();
        if (talleres.isEmpty()) {
            System.out.println("Non existe ese taller.");
        } else {
            Taller t = talleres.get(0);
            System.out.println(t.getNome() + " foi eliminado.");
            s.delete(t);
        }
        s.close();
    }
}
