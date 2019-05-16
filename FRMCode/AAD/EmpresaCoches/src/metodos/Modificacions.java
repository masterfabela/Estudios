/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import empresacoches.NewHibernateUtil;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import org.hibernate.LockOptions;
import org.hibernate.Session;
import pojos.*;

/**
 *
 * @author femio23
 */
public class Modificacions {
    
        Scanner sc = new Scanner(System.in);
    public void asignarProveedor(){
        Session s=NewHibernateUtil.getSession();
        System.out.println("Introduza a matricula.");
        String matricula = sc.next();
        Coche c=(Coche)s.get(Coche.class,matricula);
        if (c==null) {
            System.out.println("O coche con matricula " + matricula + " non existe.");
            System.out.println("Cancelase a acción.");
        } else {
            System.out.println("Introduce o codigo do Proveedor");
            String codigo=sc.next();
            Proveedor p=(Proveedor)s.get(Proveedor.class,codigo);
            if(p==null){
                System.out.println("Non existe proveedor con codigo "+codigo+".");
                System.out.println("Cancelase a acción.");
            }else{
                c.setCodigoProveedor(p);
                Set<Coche>co=p.getCoches();
                co.add(c);
                p.setCoches(co);
                Edicion.guardarModificar(s,c);
                Edicion.guardarModificar(s,p);
                System.out.println("Coche "+c.getMatricula()+" e proveedor "+p.getNome()+" modificados.");
            }
        }
        s.close();
    }
    
    public void asignarCoche(){
        Session s=NewHibernateUtil.getSession();
        System.out.println("Introduza o codigo.");
        String codigo = sc.next();
        Proveedor p=(Proveedor)s.get(Proveedor.class,codigo);
        if (p==null) {
            System.out.println("O proveedor de codigo " + codigo + " non existe.");
            System.out.println("Cancelase a acción.");
        } else {
            System.out.println("Introduce o codigo do Proveedor");
            String matricula=sc.next();
            Coche c=(Coche)s.get(Coche.class,matricula);
            if(c==null){
                System.out.println("Non existe coche con matricula "+matricula+".");
                System.out.println("Cancelase a acción.");
            }else{
                c.setCodigoProveedor(p);
                Set<Coche>co=p.getCoches();
                co.add(c);
                p.setCoches(co);
                Edicion.guardarModificar(s,c);
                Edicion.guardarModificar(s,p);
                System.out.println("Coche "+c.getMatricula()+" e proveedor "+p.getNome()+" modificados.");
            }
        }
        s.close();
    }
}
