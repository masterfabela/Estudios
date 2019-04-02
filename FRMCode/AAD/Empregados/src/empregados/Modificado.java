/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empregados;

import Pojos.Departamento;
import Pojos.Empregado;
import Pojos.Vehiculo;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author femio23
 */
public class Modificado {
    
    Scanner sc = new Scanner(System.in);
    
    public void vehiculo() throws ClassNotFoundException, SQLException{
        Session s = Empregados.iniciosesionFactory();
        System.out.println("Introduce a matricula do Vehiculo:");
        String matricula = sc.next();
        Vehiculo a = (Vehiculo) s.get(Vehiculo.class, matricula);
        if (a == null) {
            System.out.println("Non existe ese Vehiculo.");
        } else {
            System.out.println("Introduza o marca:");
        a.setMarca(sc.next());
        System.out.println("Introduza o modelo:");
        a.setModelo(sc.next());
        System.out.println("Introduza a data:");
        String data = sc.next();
        Date dataAlta = Date.valueOf(data);
        a.setDataCompra(dataAlta);
        guardarModificar(a);
        s.close();
        System.out.println("Modificacion correcta.");
        }
    }
    public void departamento() throws ClassNotFoundException, SQLException{
        Session s = Empregados.iniciosesionFactory();
        System.out.println("Introduce o numero do Departamento:");
        String nDep = sc.next();
        Departamento a = (Departamento) s.get(Departamento.class, nDep);
        if (a == null) {
            System.out.println("Non existe ese Departamento.");
        } else {
            System.out.println("Introduza a localidade:");
            a.setLocalidade(sc.next());
            guardarModificar(a);
            s.close();
            System.out.println("Modificacion correcta.");
        }
    }
    public void empregado() throws ClassNotFoundException, SQLException{
        Session s = Empregados.iniciosesionFactory();
        System.out.println("Introduce o dni do Empregado:");
        String dni = sc.next();
        Empregado a = (Empregado) s.get(Empregado.class, dni);
        if (a == null) {
            System.out.println("Non existe ese Empregado.");
        } else {
            System.out.println("Introduza o salario:");
        a.setSalario(sc.nextInt());
        System.out.println("Introduza a comision:");
        a.setComision(sc.nextInt());
        guardarModificar(a);
        s.close();
        System.out.println("Modificacion correcta.");
        }
    }
     public static void guardarModificar(Object objeto) {
        try {
            Session sesion = NewHibernateUtil.getSession();
            sesion.beginTransaction();
            sesion.saveOrUpdate(objeto);
            sesion.getTransaction().commit();
            sesion.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }
}
