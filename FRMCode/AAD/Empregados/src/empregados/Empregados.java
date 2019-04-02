/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empregados;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author femio23
 */
public class Empregados {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Creador c=new Creador();
        Vista v=new Vista();
        Insercion i=new Insercion();
        Borrando b=new Borrando();
        Modificado m=new Modificado();
        Consulta co=new Consulta();
        c.creaTaboas();
        Session sesion =NewHibernateUtil.getSession();
        System.out.println("Sesion iniciada correctamente");
        byte opcion=0;
        while(opcion!=11){
            v.menuPrincipal();
            opcion=sc.nextByte();
            try{
            switch(opcion){
                case 1:i.creaEmpregado();
                break;
                case 2:i.creaDepartamento();
                break;
                case 3:i.creaVehiculo();
                break;
                case 4:b.borraEmpregado();
                break;
                case 5:b.borraDepartamento();
                break;
                case 6:m.vehiculo();
                break;
                case 7:co.departamento();
                break;
                case 8:co.empregado();
                break;
                case 9:m.empregado();
                break;
                case 10:m.departamento();
                break;
                default:
                    if(opcion==11)
                        System.out.println("Adeus");
                    else
                        System.out.println("\n\nErro de entrada(1-11)\n\n\n");
                break;
            }}catch(ClassNotFoundException | SQLException | IOException e){
                e.getMessage();
            }
        }
        sesion.close();
    }
    public static Session iniciosesionFactory() throws ClassNotFoundException, SQLException {
        SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        if (session != null) {
            System.out.println("Sesión creada con éxito");
        } else {
            System.out.println("Fallo en el inicio de sesión");
        }
        return session;
    }
    
}
