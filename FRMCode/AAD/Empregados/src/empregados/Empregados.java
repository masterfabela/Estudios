/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empregados;

import org.hibernate.Session;

/**
 *
 * @author femio23
 */
public class Empregados {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Creador c=new Creador();
        c.creaTaboas();
        Session sesion =NewHibernateUtil.getSession();
        System.out.println("Sesion iniciada correctamente");
        sesion.close();
    }
    
}
