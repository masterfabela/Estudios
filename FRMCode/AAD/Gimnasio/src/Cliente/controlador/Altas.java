/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente.controlador;

import java.util.Scanner;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import Cliente.modelo.*;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

/**
 *
 * @author Femio
 */
public class Altas {
    Scanner sc=new Scanner(System.in);
    public void altaXimnasio(){
        ODB odb =ODBFactory.openClient("localhost", 8000, "ximnaisos");
        System.out.println("Introduza o cif do ximnasio:");
        String cif=sc.next();
        IQuery query = new CriteriaQuery(Ximnasio.class,Where.equal("cif",cif));
        Objects <Ximnasio> consulta = odb.getObjects(query);
        if(consulta.isEmpty()){
            System.out.println("Introduza o nome do ximnasio:");
            String nome= sc.next();
            ArrayList<Actividade> actividades=new ArrayList<Actividade>();
            ArrayList<Cliente> clientes=new ArrayList<Cliente>();
            Ximnasio x1=new Ximnasio(cif,nome,actividades,clientes);
            odb.store(x1);
            odb.close();
            
            
        }else{
            System.out.println("Este ximnasio xa existe.");
        }
    }
    public void altaSocio(){
        ODB odb = ODBFactory.openClient("localhost", 8000, "ximnasios");
        System.out.println("Introduza o Codigo do Socio.");
        String codigo= sc.next();
        ICriterion criterio=Where.equal("codigo", codigo);
        IQuery query=new CriteriaQuery(Socio.class,criterio);
        Objects<Socio> consulta=odb.getObjects(query);
        if(consulta.isEmpty()){
            System.out.println("Introduza o seu nome.");
            String nome=sc.next();
            ArrayList<Uso> usos=new ArrayList();
            Socio s1=new Socio(codigo,nome,usos);
            odb.store(s1);
            odb.close();
        }else{
            System.out.println("Xa existe un cliente con ese código.");
            odb.close();
        }
    }
    public void altaActividades(){
        ODB odb = ODBFactory.openClient("localhost", 8000, "ximnasios");
        System.out.println("Introduza o nome da actividade:");
        String nome=sc.next();
        ICriterion criterio=Where.equal("nome",nome);
        IQuery query =new CriteriaQuery(Actividade.class,criterio);
        Objects<Actividade> consulta = odb.getObjects(query);
        float cuota=0;
        float desconto=0;
        if(consulta.isEmpty()){
            System.out.println("Introduza o seu tipo(L-G-A):");
            String tipo=sc.next();
            
            switch(tipo){
                case "L":
                    cuota=0;
                    desconto=0;
                    break;
                case "G":
                    cuota=2;
                    desconto=20;
                    break;
                case "A":
                    cuota=4;
                    desconto=30;
                    break;
            }
            
            System.out.println("Introduza o desconto:");
            Actividade a1= new Actividade(nome,tipo,cuota,desconto);
            odb.store(a1);
            odb.close();
        }else{
            System.out.println("Esa actividade xa existe.");
        }
    }
    public void altaUsos(){
        ODB odb = ODBFactory.openClient("localhost", 8000, "ximnasios");
        System.out.println("Introduze a data(YYYY-MM-DD):");
        String d = sc.next();
        Date data = Date.valueOf(d);
        System.out.println("Introduza a hora de inicio(hh:mm:ss):");
        String hi= sc.next();
        Time horaI= Time.valueOf(hi);
        System.out.println("Introduza o nome do uso:");
        String nome = sc.next();
        ICriterion criterio = new And().add(Where.equal("data",data)).add(Where.equal("hinicio",horaI)).add(Where.equal("nome",nome));
        IQuery query =new CriteriaQuery(Uso.class,criterio);
        Objects<Uso> consulta = odb.getObjects(query);
        if(consulta.isEmpty()){
            System.out.println("Introduza a hora de fin(hh:mm:ss):");
            Time horaF=Time.valueOf(sc.next());
            System.out.println("Introduza o importe:");
            float importe=sc.nextFloat();
            Uso u1=new Uso(data,horaI,horaF,nome,importe);
            odb.store(u1);
            odb.close();
        }else{
            System.out.println("Ese uso xa existe.");
        }
    }
}
