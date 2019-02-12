/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contascorrentes.modelo.Metodos;

import contascorrentes.modelo.Pojos.Cliente;
import contascorrentes.modelo.Pojos.ContaCorrente;
import contascorrentes.modelo.Pojos.ContaPrazo;
import contascorrentes.modelo.Pojos.Movemento;
import java.sql.Date;
import java.util.Scanner;
import java.util.Set;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

/**
 *
 * @author a18franciscorm
 */
public class Consultas {
    public void buscaC(){
        ODB odb=ODBFactory.openClient("localhost", 8000, "contabilidade");
        ICriterion criterio =Where.like("nome", "C");
        IQuery query=new CriteriaQuery(Cliente.class,criterio);
        Objects<Cliente> clientes=odb.getObjects(query);
        if(clientes.isEmpty()){
            System.out.println("Non existe cliente cuxo nome empece por C.");
        }else{
            for(Cliente c1:clientes){
                System.out.println(c1.getNome());
            }
        }
        odb.close();
    }
    public void clienteSaldo(){
        ODB odb=ODBFactory.openClient("localhost", 8000, "contabilidade");
        ICriterion criterio =Where.gt("saldoActual", 200000);
        IQuery query=new CriteriaQuery(ContaCorrente.class,criterio);
        Objects<ContaCorrente> contas=odb.getObjects(query);
        if(contas.isEmpty()){
            System.out.println("Non existen contas cuxo saldo sexa >200000.");
        }else{
            for(ContaCorrente c1:contas){
                Set clientes=c1.getClientes();
                if(clientes==null||clientes.isEmpty()){
                    System.out.println("A conta non ten cliente, pero existe.");
                }else{
                    while(clientes.iterator().hasNext())
                    clientes.iterator().next();
                }
            }
        }
        odb.close();
    }
    public void clienteNumerosVermellos(){
        Cliente cli=null;
        ODB odb=ODBFactory.openClient("localhost", 8000, "contabilidade");
        ICriterion criterio =Where.lt("saldoActual", 100);
        IQuery query=new CriteriaQuery(ContaCorrente.class,criterio);
        Objects<ContaCorrente> contas=odb.getObjects(query);
        if(contas.isEmpty()){
            System.out.println("Non existen contas correntes cuxo saldo sexa negativo.");
        }else{
            for(ContaCorrente c1:contas){
                Set clientes=c1.getClientes();
                if(clientes==null||clientes.isEmpty()){
                    System.out.println("A contaC non ten cliente, pero existe.");
                }else{
                    while(clientes.iterator().hasNext())
                    clientes.iterator().next();
                }
            }
        }
        IQuery query2=new CriteriaQuery(ContaPrazo.class,criterio);
        Objects<ContaPrazo> contas2=odb.getObjects(query2);
        if(contas2.isEmpty()){
            System.out.println("Non existen contas a prazo cuxo saldo sexa negativo.");
        }else{
            System.out.println(contas2.size());
            for(ContaPrazo c1:contas2){
                Set clientes=c1.getClientes();
                if(clientes==null||clientes.isEmpty()){
                    System.out.println("A contaP non ten cliente, pero existe.");
                }else{
                    while(clientes.iterator().hasNext())
                        cli=(Cliente)clientes.iterator().next();
                        System.out.println(cli.getNome());
                }
            }
        }
        odb.close();
    }
    public void mediaSaldo(){
        ODB odb=ODBFactory.openClient("localhost", 8000, "contabilidade");
        IQuery query=new CriteriaQuery(ContaPrazo.class);
        Objects<ContaPrazo> contas=odb.getObjects(query);
        if(contas.isEmpty()){
            System.out.println("Non existen contas a prazo.");
        }else{
            int cantidade=contas.size();
            double acumulado=0;
            for(ContaPrazo c1:contas){
                acumulado+=c1.getSaldoActual();
            }
            System.out.println("O saldo medio das contas a prazo é de "+(acumulado/cantidade)+"€.");
        }
        odb.close();
    }
    public void consultaMovementos(){
        ODB odb=ODBFactory.openClient("localhost", 8000, "contabilidade");
        System.out.println("Introduza o numero de conta:");
        Scanner sc=new Scanner(System.in);
        int numero=sc.nextInt();
        ICriterion criterio =new And().add(Where.gt("dataOperacion",Date.valueOf("1800-01-01"))).add(Where.equal("numeroConta",numero));
        IQuery query=new CriteriaQuery(Movemento.class,criterio);
        Objects<Movemento> movementos=odb.getObjects(query);
        if(movementos.isEmpty()){
            System.out.println("Non existe dita conta.");
        }else{
            for(Object m1:movementos){
                Movemento m=(Movemento)m1;
                System.out.println(m.toString());
            }
        }
        odb.close();
    }
}
