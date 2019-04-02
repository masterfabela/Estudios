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
        e.setDepartamento(new Departamento("6","Programacion","Pontevedra"));
        guardarModificar(e);
        System.out.println("Definir vehiculo? y/n");
        String opcion = sc.next();
        switch(opcion){
            case "y":;
            break;
            default:;
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
        System.out.println("Introduce o DNI:");
        String dni = sc.next();
        List<Empregado> empregado = s.createCriteria(Empregado.class, dni).list();
        if (empregado.isEmpty()) {
            System.out.println("Non existe ese empregado.");
        } else {
            v.setEmpregado(empregado.get(0));
            v.setDni(empregado.get(0).getDni());
            guardarModificar(v);
        }
        
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
    public void definirVehiculo(){
        
    }
    public void definirDepartamento(){
        
    }
    public void definirEmpregado(){}
}
