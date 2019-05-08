/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import pojos.Ciclo;
import pojos.Instituto;
import pojos.Taller;
import pojos.Uso;
import xunta.NewHibernateUtil;

/**
 *
 * @author Femio
 */
public class Adicions {
    Scanner sc=new Scanner(System.in);
    public void adicionCiclo(){
        Session s = NewHibernateUtil.getSession();
        System.out.println("Introduza o codigo do Istituto:");
        String codigo = sc.next();
        List<Instituto> institutos = s.createCriteria(Instituto.class, codigo).list();
        if (institutos.isEmpty()) {
            System.out.println("Non existe ese Instituto.");
        } else {
            Instituto i=institutos.get(0);
            System.out.println("Introduza o codigo do ciclo:");
            String codigoc = sc.next();
            List<Ciclo> ciclos = s.createCriteria(Ciclo.class, codigoc).list();
            if (ciclos.isEmpty()) {
                System.out.println("Non existe ese ciclo.");
            } else {
                Ciclo c = ciclos.get(0);
                Set<Ciclo>ci=new HashSet<Ciclo>();
                ci.add(c);
                i.setCiclos(ci);
                System.out.println("O ciclo "+c.getNome() + " foi engadido a o insituto "+i.getCodigo()+".");
                guardarModificar(s,i);
            }
        }
        s.close();
    }
    public void adicionTaller(){
        Session s = NewHibernateUtil.getSession();
        System.out.println("Introduza o codigo do ciclo:");
        String codigoc = sc.next();
        List<Ciclo> ciclos = s.createCriteria(Ciclo.class, codigoc).list();
        if (ciclos.isEmpty()) {
            System.out.println("Non existe ese ciclo.");
        } else {
            Ciclo c = ciclos.get(0);
            System.out.println("Introduza o codigo do Taller:");
            String codigot = sc.next();
            List<Taller> talleres = s.createCriteria(Taller.class, codigot).list();
            if (ciclos.isEmpty()) {
                System.out.println("Non existe ese taller.");
            } else {
                Taller t=talleres.get(0);
                Set<Taller>ta=new HashSet<Taller>();
                ta.add(t);
                c.setTalleres(ta);
                System.out.println("O taller "+t.getNome() + " foi engadido ó ciclo "+c.getNome()+".");
                guardarModificar(s,c);
            }
        }
        s.close();
    }
    public void adicionUso(){
        Session s = NewHibernateUtil.getSession();
        Taller t=new Taller();
        System.out.println("Introduza o codigo do ciclo:");
        String codigoc = sc.next();
        List<Ciclo> ciclos = s.createCriteria(Ciclo.class, codigoc).list();
        if (ciclos.isEmpty()) {
            System.out.println("Non existe ese ciclo.");
        } else {
            Ciclo c = ciclos.get(0);
            System.out.println("Introduza o codigo do Taller:");
            String codigot = sc.next();
            List<Taller> talleres = s.createCriteria(Taller.class, codigot).list();
            if (ciclos.isEmpty()) {
                System.out.println("Non existe ese taller.");
            } else {
                t=talleres.get(0);}
            Uso u=new Uso(Date.valueOf(LocalDate.now()),Time.valueOf(LocalTime.now()),c,t);
            Set<Uso>us=new HashSet<Uso>();
            us.add(u);
            c.setUsos(us);
            guardarModificar(s,c);
        }
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
