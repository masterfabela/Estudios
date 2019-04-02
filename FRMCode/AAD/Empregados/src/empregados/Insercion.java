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
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author femio23
 */
public class Insercion {

    Scanner sc = new Scanner(System.in);

    public void creaEmpregado() throws ClassNotFoundException, SQLException {
        Session s = Empregados.iniciosesionFactory();
        System.out.println("Introduza o dni:");
        String dni = sc.next();
        System.out.println("Introduza o nome:");
        String nome = sc.next();
        System.out.println("Introduza o oficio:");
        String oficio = sc.next();
        System.out.println("Introduza o salario:");
        int salario = sc.nextInt();
        System.out.println("Introduza a comision:");
        int comision = sc.nextInt();
        System.out.println("Introduza a data:");
        String data = sc.next();
        Date dataAlta = Date.valueOf(data);
        Empregado e = new Empregado(nome, oficio, dni, salario, comision, dataAlta);
        System.out.println("Desexa engadir o departamento agora? s/n.");
        String opcion = sc.next();
        switch(opcion){
            case "y":definirDepartamento(s,e);
            break;
            default:System.out.println("Deacordo.");;
            break;
        }
        e.setDepartamento(new Departamento("6","Programacion","Pontevedra"));
        guardarModificar(e);
        System.out.println("Desexa engadir o vehiculo agora? s/n.");
        String opcion2 = sc.next();
        switch(opcion2){
            case "y":definirVehiculo(s,e);
            break;
            default:System.out.println("Deacordo.");;
            break;
        }
        s.close();
    }

    public void creaVehiculo() throws ClassNotFoundException, SQLException {
        Session s = Empregados.iniciosesionFactory();
        System.out.println("Introduza o matricula:");
        String matricula = sc.next();
        System.out.println("Introduza o marca:");
        String marca = sc.next();
        System.out.println("Introduza o modelo:");
        String modelo = sc.next();
        System.out.println("Introduza a data:");
        String data = sc.next();
        Date dataAlta = Date.valueOf(data);
        Vehiculo v = new Vehiculo(matricula, marca, modelo, dataAlta);
        definirEmpregado(s,v);
        s.close();
    }

    public void creaDepartamento() throws ClassNotFoundException, SQLException {
        Session s = Empregados.iniciosesionFactory();
        System.out.println("Introduza o numero de Departamento:");
        String nDep = sc.next();
        System.out.println("Introduza o nome:");
        String nome = sc.next();
        System.out.println("Introduza o localidade:");
        String localidade = sc.next();
        Departamento v = new Departamento(nDep, nome, localidade);
        System.out.println("Desexa engadir agora empregados?s/n.");
        String opcion=sc.next();
        switch(opcion){
            case"s":definirEmpregado(s,v);
            break;
            default:System.out.println("Deacordo.");;
            break;
        }
        definirEmpregado(s,v);
        guardarModificar(v);
        s.close();
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
    public void definirVehiculo(Session s,Empregado e){
        System.out.println("Introduce a matricula:");
        String matricula = sc.next();
        Object o=s.createQuery("from Vehiculo where matricula='"+matricula+"'").uniqueResult();
        Vehiculo departamento=(Vehiculo)o;
        if (departamento==null) {
            System.out.println("Non existe ese Departamento.");
        } else {
            e.setVehiculo(departamento);
            guardarModificar(e);
        }
    }
    public void definirDepartamento(Session s,Empregado e){
        System.out.println("Introduce o numero do departamento:");
        String dni = sc.next();
        Object o=s.createQuery("from Departamento where nDep='"+dni+"'").uniqueResult();
        Departamento departamento=(Departamento)o;
        if (departamento==null) {
            System.out.println("Non existe ese Departamento.");
        } else {
            e.setDepartamento(departamento);
            guardarModificar(e);
        }
    }
    
    public void definirEmpregado(Session s,Vehiculo v){
    System.out.println("Introduce o DNI:");
        String dni = sc.next();
       Object o=s.createQuery("from Empregado where dni='"+dni+"'").uniqueResult();
        Empregado empregado=(Empregado)o;
        if (empregado==null) {
            System.out.println("Non existe ese empregado.");
        } else {
            v.setEmpregado(empregado);
            v.setDni(empregado.getDni());
            guardarModificar(v);
        }}
    public void definirEmpregado(Session s,Departamento d){
    System.out.println("Introduce o DNI:");
        String dni = sc.next();
       Object o=s.createQuery("from Empregado where dni='"+dni+"'").uniqueResult();
        Empregado empregado=(Empregado)o;
        if (empregado==null) {
            System.out.println("Non existe ese empregado.");
        } else {
            Set<Empregado>empregados=d.getEmpregados();
            empregados.add(empregado);
            d.setEmpregados(empregados);
            guardarModificar(d);
        }}
}
