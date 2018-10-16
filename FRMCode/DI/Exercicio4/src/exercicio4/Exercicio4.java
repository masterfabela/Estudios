/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio4;
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
        Session sesion;
        sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tr=sesion.beginTransaction();
        
    }
    
}
