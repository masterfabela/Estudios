/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresas;

import Pojos.*;
import static empresas.Modificar.guardarModificar;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import org.hibernate.Session;

/**
 *
 * @author Femio
 */
public class Consultas {
    Scanner sc=new Scanner(System.in);
    public void consultarEmpregados(){
        Session s=NewHibernateUtil.getSession();
        System.out.println("Introduza o codigo da empresa:");
        String cif=sc.next();
            List<Empresa> empresas = s.createCriteria(Empresa.class, cif).list();
        if (empresas.isEmpty()) {
            System.out.println("Non existe esa empresa.");
        } else {
            Empresa f=empresas.get(0);
            Set<Empregado>empregados=new HashSet<Empregado>();
            empregados=f.getEmpregados();
            if(empregados.isEmpty()){
                System.out.println("Esta empresa non posue empregados.");
            }else{
                for(Empregado x:empregados){
                    System.out.println(x.getCif().toString()+"-"+x.getNome().toString()+":"+x.getClass().getName().toString());
                }
            }
            
        }
        s.close();
    }
    public void consultarProdutos(){
        Session s=NewHibernateUtil.getSession();
        System.out.println("Introduza o codigo da empresa:");
        String cif=sc.next();
            List<Empresa> empresas = s.createCriteria(Empresa.class, cif).list();
        if (empresas.isEmpty()) {
            System.out.println("Non existe esa empresa.");
        } else {
            Empresa f=empresas.get(0);
            Set<Produto>empregados=new HashSet<Produto>();
            empregados=f.getProdutos();
            if(empregados.isEmpty()){
                System.out.println("Esta empresa non posue produtos.");
            }else{
                for(Produto x:empregados){
                    System.out.println(x.getCodigo());
                }
            }
            
        }
        s.close();
    }
    public void consultarTemporal(){
        Session s=NewHibernateUtil.getSession();
        System.out.println("Introduza o dni do empregado fixo:");
        String cif=sc.next();
        Temporal temporal=null;
        temporal = (Temporal)s.createCriteria(Temporal.class, cif).uniqueResult();
        if (temporal==null) {
            System.out.println("Non existe ese empregado.");
        } else {
            Set<Venta>ventas=temporal.getVentas();
            if(ventas.isEmpty()){
                System.out.println("Este empregado non ten ventas.");
            }else{
                long cantidade=0;
            for(Venta x:ventas){
                cantidade+=x.getImporte();
            }
            if(cantidade>100000){
                System.out.println("Soldo total:"+(temporal.getSoldo()+100));
            }else{
                System.out.println("Soldo total:"+(temporal.getSoldo()));
            }
            }
        }
        s.close();
    }
}
