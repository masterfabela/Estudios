/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import org.hibernate.Session;
import pojos.Ciclo;
import pojos.Instituto;
import pojos.Taller;
import xunta.NewHibernateUtil;

/**
 *
 * @author Femio
 */
public class Listados {
    Scanner sc=new Scanner(System.in);
    public void listarCiclos1(){
        Session s = NewHibernateUtil.getSession();
        System.out.println("Introduza o codigo do taller");
        String codigo=sc.next();
        System.out.println("Introduza a data de inicio");
        String dataI=sc.next();
        System.out.println("Introduza a data de fin");
        String data=sc.next();
        List<Taller> talleres = s.createCriteria(Taller.class, codigo).list();
        if (talleres.isEmpty()) {
            System.out.println("Non existe ese taller.");
        } else {
            Taller t = talleres.get(0);
            Set<Ciclo>ciclos=t.getCiclos();
        }
        s.close();
    }
    public void listarCiclos2(){
        Session s = NewHibernateUtil.getSession();
        System.out.println("Introduza o codigo do Instituto");
        String codigo=sc.next();
        List<Instituto> instis = s.createCriteria(Instituto.class, codigo).list();
        if (instis.isEmpty()) {
            System.out.println("Non existe ese instituto.");
        } else {
            Instituto i = instis.get(0);
            Set<Ciclo>ciclos=i.getCiclos();
            if(ciclos.isEmpty()){
                System.out.println("Este instituto non posue ciclos.");
            }else{
                System.out.println("Este Instituto posue os seguintes ciclos:");
                for(Ciclo x:ciclos){
                    System.out.println(x.getNome());
                }
            }
        }
        s.close();
    }
    public void listarInstitutos(){
        Session s = NewHibernateUtil.getSession();
        System.out.println("Introduza o codigo do Ciclo");
        String codigo=sc.next();
        List<Ciclo> ciclos = s.createCriteria(Ciclo.class, codigo).list();
        if (ciclos.isEmpty()) {
            System.out.println("Non existe ese ciclo.");
        } else {
            Ciclo c = ciclos.get(0);
            Set<Instituto>instis=c.getInstitutos();
            if(instis.isEmpty()){
                System.out.println("Este ciclo non posue institutos.");
            }else{
                System.out.println("Este Ciclo posue os seguintes institutos:");
                for(Instituto x:instis){
                    System.out.println("Istituto codigo:"+x.getCodigo());
                }
            }
        }
        s.close();
    }
}
