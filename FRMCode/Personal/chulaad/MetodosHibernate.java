package Principales;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class NewHibernateUtil {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
           
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static Session getSession(){
        return sessionFactory.openSession();
    }
    
    public static void Renew(){
        Main.sesion.close();
        Main.sesion=sessionFactory.openSession();
    }
    
    public static void graba (Object obj){
        try{
        Main.sesion.beginTransaction();
        Main.sesion.saveOrUpdate(obj); 
        Main.sesion.getTransaction().commit();
        System.out.println("Se ha grabado "+obj.toString()+" a la base de datos.");
        }catch (HibernateException e) {System.out.println("-Error: no ha podido realizarse el grabado:\n"+e.getMessage());}
        }
    
    public static void borra (Object obj){
        try{
        Main.sesion.beginTransaction();
        Main.sesion.delete(obj);
        Main.sesion.getTransaction().commit();
        System.out.println("Se ha borrado "+obj.toString()+" de la base de datos.");
        }catch (HibernateException e) {System.out.println("-Error: no ha podido realizarse el borrado:\n"+e.getMessage());}
    }
    
    public static void update(Object obj){
        try{
        Main.sesion.beginTransaction();
        Main.sesion.update(obj);
        Main.sesion.getTransaction().commit();
        System.out.println("Se ha actualizado "+obj.toString()+" en la base de datos.");
        }catch (HibernateException e) {System.out.println("-Error: no ha podido realizarse la actualización:\n"+e.getMessage());}
    }
    
}