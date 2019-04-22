/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresas;

import Pojos.*;
import java.util.List;
import java.util.Scanner;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Femio
 */
public class Modificar {
    Scanner sc=new Scanner(System.in);
    public void modificarPrezo(){
        Session s=NewHibernateUtil.getSession();
        System.out.println("Introduza o codigo do produto a cambiar:");
        String cif=sc.next();
            List<Produto> produtos = s.createCriteria(Produto.class, cif).list();
        if (produtos.isEmpty()) {
            System.out.println("Non existe ese produto.");
        } else {
            Produto f=produtos.get(0);
            System.out.println("Introduza o novo prezo");
            float prezo=sc.nextFloat();
            f.setPrezo(prezo);
            guardarModificar(s,f);
            System.out.println(f.getCodigo()+" foi modificado.");
        }
        s.close();
    }
    public void modificarSoldo(){
        Session s=NewHibernateUtil.getSession();
        System.out.println("Introduza o dni do empregado fixo a cambiar:");
        String cif=sc.next();
        List<Fixo> fixos = s.createCriteria(Fixo.class, cif).list();
        if (fixos.isEmpty()) {
            System.out.println("Non existe ese empregado.");
        } else {
            Fixo f=fixos.get(0);
            System.out.println("Introduza o novo soldo.");
            int prezo=sc.nextInt();
            f.setSalario(prezo);
            guardarModificar(s,f);
            System.out.println(f.getNome()+" foi modificado.");
        }
        s.close();
    }
    
    public void modificarImporte(){
        Session s=NewHibernateUtil.getSession();
        System.out.println("Introduza o dni do empregado temporal a cambiar:");
        String cif=sc.next();
        List<Temporal> fixos = s.createCriteria(Temporal.class, cif).list();
        if (fixos.isEmpty()) {
            System.out.println("Non existe ese empregado.");
        } else {
            Temporal f=fixos.get(0);
            System.out.println("Introduza o importe.");
            int prezo=sc.nextInt();
            f.setImporte(prezo);
            guardarModificar(s,f);
            System.out.println(f.getNome()+" foi modificado.");
        }
        s.close();
    }
    
    public void modificarRetencion(){
        Session s=NewHibernateUtil.getSession();
        System.out.println("Introduza o dni do empregado a cambiar:");
        String cif=sc.next();
        List<Empregado> fixos = s.createCriteria(Empregado.class, cif).list();
        if (fixos.isEmpty()) {
            System.out.println("Non existe ese empregado.");
        } else {
            Empregado f=fixos.get(0);
            System.out.println("Introduza a nova retencion.");
            float prezo=sc.nextFloat();
            f.setRetencion(prezo);
            guardarModificar(s,f);
            System.out.println(f.getNome()+" foi modificado.");
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
