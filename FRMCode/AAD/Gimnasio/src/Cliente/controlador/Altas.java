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
import java.util.ArrayList;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
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
            System.out.println("Usos");
            ArrayList<Uso> usos=new ArrayList();
            Socio s1=new Socio(codigo,nome,usos);
            odb.store(s1);
            odb.close();
        }else{
            System.out.println("Xa existe un cliente con ese código.");
            odb.close();
        }
    }
}
