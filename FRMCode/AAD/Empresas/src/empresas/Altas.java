/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresas;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import org.hibernate.Session;
import Pojos.*;
import java.sql.Date;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author femio23
 */
public class Altas {
    Scanner sc = new Scanner(System.in);
    public void altaEmpresa(){
        Session s=NewHibernateUtil.getSession();
        System.out.println("Introduza o nome da empresa:");
        String nome=sc.next();
        System.out.println("Introduza o cif:");
        String cif=sc.next();
        System.out.println("Indroduza a dirección:");
        String direccion=sc.next();
        System.out.println("Introduza o telefono:");
        String telefono=sc.next();
        Empresa e=new Empresa(cif,nome,direccion,telefono);
        guardarModificar(s,e);
        s.close();
    }
   
    public void altaFixo(){
        Session s=NewHibernateUtil.getSession();
        System.out.println("Introduza o nome do empregado:");
        String nome=sc.next();
        System.out.println("Introduza o dni:");
        String dni=sc.next();
        System.out.println("Introduza o telefono:");
        String telefono=sc.next();
        System.out.println("Indroduza a retención:");
        float retencion=sc.nextFloat();
        System.out.println("Indroduza o salario:");
        int salario=sc.nextInt();
        System.out.println("Indroduza os trienios:");
        int trienios=sc.nextInt();
        System.out.println("Indroduza o cif da empresa(Cif ou 0):");
        String cif=sc.next();
        if(cif.equalsIgnoreCase("0")){
            Fixo f=new Fixo(salario,trienios,dni,nome,telefono,null,retencion);
            guardarModificar(s,f);
        }else{
            List<Empresa> empresas = s.createCriteria(Empresa.class, cif).list();
        if (empresas.isEmpty()) {
            System.out.println("Non existe esa empresa.");
        } else {
            Fixo f=new Fixo(salario,trienios,dni,nome,telefono,cif,retencion);
            Empresa e=empresas.get(0);
            Set<Empregado>empregados=e.getEmpregados();
            empregados.add(f);
            e.setEmpregados(empregados);
            guardarModificar(s,f);
            guardarModificar(s,e);
        }
        }
        s.close();
    }
    
    public void altaTemporal(){
        Session s=NewHibernateUtil.getSession();
        System.out.println("Introduza o nome do empregado:");
        String nome=sc.next();
        System.out.println("Introduza o dni:");
        String dni=sc.next();
        System.out.println("Introduza o telefono:");
        String telefono=sc.next();
        System.out.println("Indroduza a retención:");
        float retencion=sc.nextFloat();
        System.out.println("Importe:");
        int importe=sc.nextInt();
        System.out.println("Inicio do contrato(YYYY-MM-DD):");
        Date inicio=Date.valueOf(sc.next());
        System.out.println("Fin de contrato(YYYY-MM-DD):");
        Date fin=Date.valueOf(sc.next());
        System.out.println("Indroduza o cif da empresa(Cif ou 0):");
        String cif=sc.next();
        if(cif.equalsIgnoreCase("0")){
            Temporal f=new Temporal(inicio,fin,importe,dni,nome,telefono,null,retencion);
            guardarModificar(s,f);
        }else{
            List<Empresa> empresas = s.createCriteria(Empresa.class, cif).list();
        if (empresas.isEmpty()) {
            System.out.println("Non existe esa empresa.");
        } else {
            Temporal f=new Temporal(inicio,fin,importe,dni,nome,telefono,cif,retencion);
            Empresa e=empresas.get(0);
            Set<Empregado>empregados=e.getEmpregados();
            empregados.add(f);
            e.setEmpregados(empregados);
            guardarModificar(s,f);
            guardarModificar(s,e);
        }
        }
        s.close();
    }
    public void altaProduto(){
        Session s=NewHibernateUtil.getSession();
        System.out.println("Introduza o codigo do produto:");
        String codigo=sc.next();
        System.out.println("Introduza o stock actual:");
        int stok=sc.nextInt();
        System.out.println("Indroduza o seu prezo:");
        float prezo=sc.nextFloat();
        Produto e=new Produto(codigo,stok,prezo);
        guardarModificar(s,e);
        s.close();
    }
    public void altaVenta(){
        Session s=NewHibernateUtil.getSession();
        System.out.println("Introduza o codigo do produto:");
        String codigo=sc.next();
        System.out.println("Introduza o stock actual:");
        int stok=sc.nextInt();
        System.out.println("Indroduza o seu prezo:");
        float prezo=sc.nextFloat();
        Produto e=new Produto(codigo,stok,prezo);
        guardarModificar(s,e);
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
