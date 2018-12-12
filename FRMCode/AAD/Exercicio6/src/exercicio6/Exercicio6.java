/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio6;
import SQL.*;
import org.hibernate.Session;
import Obx.*;

/**
 *
 * @author Femio
 */
public class Exercicio6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MetodosSQL msql = new MetodosSQL();
        msql.creador();
        Session sesion=NewHibernateUtil.getSession();
        System.out.println("Conexion correcta.");
        //Coches c=new CochesVenta(25.3f,"0001","Lexus","GTR");
        sesion.beginTransaction();
        sesion.close();
        System.out.println("Fin");
        System.exit(0);
    }
    
}
