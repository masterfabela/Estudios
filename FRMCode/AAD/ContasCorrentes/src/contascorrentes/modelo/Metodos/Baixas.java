/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contascorrentes.modelo.Metodos;

import contascorrentes.modelo.Pojos.ContaPrazo;
import java.util.Scanner;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

/**
 *
 * @author a18franciscorm
 */
public class Baixas {
    public void baixaCPrazo(){
        ODB odb=ODBFactory.openClient("localhost", 8000, "contabilidade");
        Scanner sc= new Scanner(System.in);
        System.out.println("Introduce os datos referentes á conta:\n Numero:");
        String numero=sc.next();
        ICriterion criterio =Where.equal("numero",numero );
        IQuery query=new CriteriaQuery(ContaPrazo.class,criterio);
        Objects<ContaPrazo> conta=odb.getObjects(query);
        if(conta.isEmpty()){
            System.out.println("Non existe tal conta.");
        }else{
            ContaPrazo c1=conta.getFirst();
            odb.delete(c1);
            odb.commit();
            odb.close();
        }
    }
}
