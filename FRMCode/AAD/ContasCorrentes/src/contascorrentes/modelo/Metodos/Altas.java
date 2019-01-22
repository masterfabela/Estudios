/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contascorrentes.modelo.Metodos;

import contascorrentes.modelo.Pojos.Cliente;
import contascorrentes.modelo.Pojos.Conta;
import contascorrentes.modelo.Pojos.ContaCorrente;
import contascorrentes.modelo.Pojos.ContaPrazo;
import contascorrentes.modelo.Pojos.Movemento;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
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
public class Altas {
    public void altaCliente(){
        ODB odb=ODBFactory.openClient("localhost", 8000, "libreria");
        Scanner sc= new Scanner(System.in);
        System.out.println("Introduce os datos do cliente:\n DNI:");
        String dni=sc.next();
        ICriterion criterio =Where.equal("dni",dni );
        IQuery query=new CriteriaQuery(Cliente.class,criterio);
        Objects<Cliente> cliente=odb.getObjects(query);
        if(cliente.isEmpty()){
            System.out.println("Nome Completo:");
            String nome=sc.next();
            System.out.println("Direccion:");
            String direccion=sc.next();
            Set <Conta>contas=null;
            Cliente a1=new Cliente(dni,nome,direccion,contas);
            if(!contas.isEmpty()){
                a1.setContas(contas);
            }
            odb.store(a1);
            odb.close();
        }else{
            System.out.println("Este cliente xa existe, non se pode levar a cabo a alta.");
        }
    }
    public Cliente altaCliente(String dni){
        ODB odb=ODBFactory.openClient("localhost", 8000, "contabilidade");
        Scanner sc= new Scanner(System.in);
        ICriterion criterio =Where.equal("dni",dni );
        IQuery query=new CriteriaQuery(Cliente.class,criterio);
        Objects<Cliente> cliente=odb.getObjects(query);
        if(cliente.isEmpty()){
            System.out.println("Nome Completo:");
            String nome=sc.next();
            System.out.println("Direccion:");
            String direccion=sc.next();
            Set <Conta>contas=null;
            Cliente a1=new Cliente(dni,nome,direccion,contas);
            odb.store(a1);
            odb.close();
            return a1;
        }else{
            System.out.println("Este cliente xa existe, non se pode levar a cabo a alta.");
            return null;
        }
        
    }
    public void altaCCorrente(){
        ODB odb=ODBFactory.openClient("localhost", 8000, "contabilidade");
        Scanner sc= new Scanner(System.in);
        System.out.println("Introduce os datos da Conta:\n Numero:");
        String numero=sc.next();
        ICriterion criterio =Where.equal("numero",numero );
        IQuery query=new CriteriaQuery(ContaCorrente.class,criterio);
        Objects<ContaCorrente> conta=odb.getObjects(query);
        if(conta.isEmpty()){
            System.out.println("Sucursal:");
            String sucursal=sc.next();
            System.out.println("Saldo actual:");
            double saldo=sc.nextDouble();
            Set<Cliente>clientes=null;
            System.out.println("Vai introducir Clientes(Existentes ou non):\nDNI:");
            String dni=sc.next();
            ICriterion criterio2 =Where.equal("dni",dni );
            IQuery query2=new CriteriaQuery(Cliente.class,criterio2);
            Objects<Cliente> cliente=odb.getObjects(query);
            Cliente a1;
            if(cliente.isEmpty()){
                a1=altaCliente(dni);
                clientes.add(a1);
            }else{
                clientes.add(cliente.getFirst());
                a1=cliente.getFirst();
            }
            Set<Movemento>movementos=null;
            ContaCorrente c1=new ContaCorrente(movementos,numero,sucursal,saldo,clientes);
            odb.store(c1);
            Set<Conta>listaConta=a1.getContas();
            listaConta.add(c1);
            odb.store(a1);
            odb.close();
        }else{
            System.out.println("Xa existe unha conta con este numero, non se pode levar a cabo a alta.");
        }
    }
    public void altaCPrazo(){
        ODB odb=ODBFactory.openClient("localhost", 8000, "contabilidade");
        Scanner sc= new Scanner(System.in);
        System.out.println("Introduce os datos da Conta:\n Numero:");
        String numero=sc.next();
        ICriterion criterio =Where.equal("numero",numero );
        IQuery query=new CriteriaQuery(ContaPrazo.class,criterio);
        Objects<ContaPrazo> conta=odb.getObjects(query);
        if(conta.isEmpty()){
            System.out.println("Sucursal:");
            String sucursal=sc.next();
            System.out.println("Interese:");
            float interese=sc.nextFloat();
            System.out.println("Saldo actual:");
            double saldo=sc.nextDouble();
            System.out.println("Data de vencemento:");
            String data=sc.next();
            LocalDate dataV=LocalDate.parse(data);
            System.out.println("Vai introducir Clientes(Existentes ou non):\nDNI:");
            String dni=sc.next();
            ICriterion criterio2 =Where.equal("dni",dni );
            IQuery query2=new CriteriaQuery(Cliente.class,criterio2);
            Objects<Cliente> cliente=odb.getObjects(query);
            Set<Cliente>clientes=null;
            Cliente a1;
            if(!cliente.isEmpty()){
                clientes.add(cliente.getFirst());
                a1=cliente.getFirst();
            }else{
                a1=altaCliente(dni);
                clientes.add(a1);
            }
            ContaPrazo c1=new ContaPrazo(interese,dataV,numero,sucursal,saldo,clientes);
            odb.store(c1);
            Set<Conta>listaConta=a1.getContas();
            listaConta.add(c1);
            odb.store(a1);
            odb.close();
        }else{
            System.out.println("Xa existe unha conta con este numero, non se pode levar a cabo a alta.");
        }
    }
    public void altaMovemento(){
        ODB odb=ODBFactory.openClient("localhost", 8000, "contabilidade");
        Scanner sc= new Scanner(System.in);
        System.out.println("Introduce os datos referentes a o movemento:\n Numero de conta:");
        String numero=sc.next();
        ICriterion criterio =Where.equal("numero",numero );
        IQuery query=new CriteriaQuery(ContaCorrente.class,criterio);
        Objects<ContaCorrente> conta=odb.getObjects(query);
        if(conta.isEmpty()){
            System.out.println("Esa conta non existe.");
        }else{
            System.out.println("Data da operacion(aaaa:mm:dd):");
            String data=sc.next();
            Date dataOp=Date.valueOf(data);
            System.out.println("Hora da operacion(hh:mm:ss):");
            String hora=sc.next();
            Time horaOP=Time.valueOf(hora);
            System.out.println("Cantidade:");
            double cantidade=sc.nextFloat();
            double saldoA=conta.getFirst().getSaldoActual();
            Movemento c1=new Movemento(numero,dataOp,horaOP,cantidade,saldoA);
            odb.store(c1);
            odb.commit();
            odb.close();
        }
    }
}
