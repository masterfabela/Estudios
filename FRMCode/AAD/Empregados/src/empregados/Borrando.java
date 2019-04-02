/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empregados;

import Pojos.Departamento;
import Pojos.Empregado;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import org.hibernate.Session;

/**
 *
 * @author femio23
 */
public class Borrando {

    Scanner sc = new Scanner(System.in);

    public void borraEmpregado() throws IOException, SQLException, ClassNotFoundException {
        Session s = Empregados.iniciosesionFactory();
        System.out.println("Introduce o dni do Empregado:");
        String dni = sc.next();
        Empregado a = (Empregado) s.get(Empregado.class, dni);
        if (a == null) {
            System.out.println("Non existe ese Empregado.");
        } else {
            s.beginTransaction();
            s.delete(a);
            s.getTransaction().commit();
            s.close();
            System.out.println("Borrado correcto.");
        }
    }
    public void borraDepartamento() throws IOException, SQLException, ClassNotFoundException {
        Session s = Empregados.iniciosesionFactory();
        System.out.println("Introduce o numero do Departamento:");
        String nDep = sc.next();
        Departamento a = (Departamento) s.get(Departamento.class, nDep);
        if (a == null) {
            System.out.println("Non existe ese Empregado.");
        } else {
            s.beginTransaction();
            s.delete(a);
            s.getTransaction().commit();
            s.close();
            System.out.println("Borrado correcto.");
        }
    }
}
