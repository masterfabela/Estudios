/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio4;
import Obx.Libros;
import org.hibernate.*;

/**
 *
 * @author a18franciscorm
 */
public class Exercicio4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        MetodosSQL msql=new MetodosSQL();
        msql.creaTaboas();
        SessionFactory sf= HibernateUtil.getSessionFactory();
        
        Session sesion =HibernateUtil.getSession();
        sf.openSession();
        Transaction tr=sesion.beginTransaction();
        
        
        
        Libros l1 = new Libros(4563,"Lolita",29.3f);
        sesion.save(l1);
        tr.commit();
        sesion.close();
        
    }
    
}
