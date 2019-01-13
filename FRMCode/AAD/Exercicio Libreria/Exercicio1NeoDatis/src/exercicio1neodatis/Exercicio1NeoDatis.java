/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio1neodatis;
import org.neodatis.odb.*;
import org.neodatis.odb.core.oid.OIDFactory;

/**
 *
 * @author femio23
 */
public class Exercicio1NeoDatis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ODB odb=ODBFactory.open("neodatis.test");
        OID oid=OIDFactory.buildObjectOID(3);
        Jugadores jug=(Jugadores) odb.getObjectFromId(oid);
        System.out.println(jug.getNombre()+"*"+jug.getDeporte());
        odb.close();
    }
    
}

