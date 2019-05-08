/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author femio23
 */
public class Edicion {
    public static void guardarModificar(Session sesion,Object objeto) {
        try {
            sesion.beginTransaction();
            sesion.saveOrUpdate(objeto);
            sesion.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }
}
