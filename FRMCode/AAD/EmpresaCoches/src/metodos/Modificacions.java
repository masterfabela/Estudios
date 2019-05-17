/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import empresacoches.NewHibernateUtil;
import java.util.Scanner;
import java.util.Set;
import org.hibernate.Session;
import pojos.*;

/**
 *
 * @author femio23
 */
public class Modificacions {

    Scanner sc = new Scanner(System.in);

    public void asignarProveedor() {
        Session s = NewHibernateUtil.getSession();
        System.out.println("Introduza a matricula.");
        String matricula = sc.next();
        Coche c = (Coche) s.get(Coche.class, matricula);
        if (c == null) {
            System.out.println("O coche con matricula " + matricula + " non existe.");
            System.out.println("Cancelase a acción.");
        } else {
            System.out.println("Introduce o codigo do Proveedor");
            String codigo = sc.next();
            Proveedor p = (Proveedor) s.get(Proveedor.class, codigo);
            if (p == null) {
                System.out.println("Non existe proveedor con codigo " + codigo + ".");
                System.out.println("Cancelase a acción.");
            } else {
                c.setCodigoProveedor(p);
                Set<Coche> co = p.getCoches();
                co.add(c);
                p.setCoches(co);
                Edicion.guardarModificar(s, c);
                Edicion.guardarModificar(s, p);
                System.out.println("Coche " + c.getMatricula() + " e proveedor " + p.getNome() + " modificados.");
            }
        }
        s.close();
    }

    public void asignarCocheExpo() {
        Session s = NewHibernateUtil.getSession();
        System.out.println("Introduza o codigo da Exposicion.");
        String codigo = sc.next();
        Exposicion e = (Exposicion) s.get(Exposicion.class, codigo);
        if (e == null) {
            System.out.println("A exposicion de codigo " + codigo + " non existe.");
            System.out.println("Cancelase a acción.");
        } else {
            System.out.println("Introduce a matricula do coche a engadir.");
            String matricula = sc.next();
            Coche c = (Coche) s.get(Coche.class, matricula);
            if (c == null) {
                System.out.println("Non existe coche con matricula " + matricula + ".");
                System.out.println("Cancelase a acción.");
            } else {
                c.setCodigoExposicion(e);
                Set<Coche> co = e.getCoches();
                co.add(c);
                e.setCoches(co);
                Edicion.guardarModificar(s, c);
                Edicion.guardarModificar(s, e);
                System.out.println("Coche " + c.getMatricula() + " e exposicion " + e.getNome() + " modificados.");
            }
        }
        s.close();
    }
    public void venderCoche(){
        Session s = NewHibernateUtil.getSession();
        System.out.println("Introduza o dni do cliente.");
        String dni = sc.next();
        Cliente cl= (Cliente) s.get(Cliente.class, dni);
        if (cl == null) {
            System.out.println("O cliente de dni " + dni + " non existe.");
            System.out.println("Cancelase a acción.");
        } else {
            System.out.println("Introduce a matricula do coche a vender.");
            String matricula = sc.next();
            Coche c = (Coche) s.get(Coche.class, matricula);
            if (c == null) {
                System.out.println("Non existe coche con matricula " + matricula + ".");
                System.out.println("Cancelase a acción.");
            } else {
                System.out.println("Introduza o precio de venta:");
                float pv=sc.nextFloat();
                c.setCodigoCliente(cl);
                c.setPrecioVenta(pv);
                Set<Coche> co = cl.getCoches();
                co.add(c);
                cl.setCoches(co);
                Edicion.guardarModificar(s, c);
                Edicion.guardarModificar(s, cl);
                System.out.println("Coche " + c.getMatricula() + " e cliente " + cl.getNome() + " modificados.");
            }
        }
        s.close();
    }
}
