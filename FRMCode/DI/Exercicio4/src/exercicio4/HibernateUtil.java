/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio4;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

/**
 *
 * @author a18franciscorm
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    static Configuration cfg=new Configuration().configure();
    static {
        try{
            sessionFactory = cfg.buildSessionFactory();
            
        }catch(Throwable ex){
            System.err.println("A creacion da SesionFactory fallou: "+ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
