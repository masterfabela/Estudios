/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente.controlador;

import Cliente.modelo.Cliente;
import Cliente.modelo.Socio;
import Cliente.modelo.Usuario;
import java.util.Scanner;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

/**
 *
 * @author Femio
 */
public class Consultas {
    Scanner sc= new Scanner(System.in);
    public void consultarXimnasios(){}
    public void consultarCliente(){
        ODB odb=ODBFactory.openClient("localhost", 8000, "ximnasios");
        System.out.println("Introduce o dni do cliente:");
        String dni=sc.next();
        IQuery query1= new CriteriaQuery(Usuario.class,Where.equal("codigo",dni));
        IQuery query2= new CriteriaQuery(Socio.class,Where.equal("codigo",dni));
        Objects<Cliente> consulta=odb.getObjects(query1);
        Objects<Cliente> consulta2=odb.getObjects(query2);
        if(consulta.isEmpty() && consulta2.isEmpty()){
            System.out.println("Non existen clientes con ese dni.");
        }else{
            if(consulta.isEmpty()){
                 System.out.println("Socio: "+consulta2.getFirst().getClass().getSimpleName());
            }else{
                System.out.println("Usuario: "+consulta.getFirst().getNome());
            }
        }
    }
}
