/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import empresacoches.NewHibernateUtil;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import pojos.*;

/**
 *
 * @author Femio
 */
public class Consultas {

    Scanner sc = new Scanner(System.in);

    /**
     * Método de consulta de comprador dun coche.
     */
    public void consultarComprador() {
        Session s = NewHibernateUtil.getSession();
        System.out.println("Introduza a matricula do coche a consultar:");
        String matricula = sc.next();
        Coche c = (Coche) s.get(Coche.class, matricula);
        if (c == null) {
            System.out.println("Non existe ningun coche con matricula " + matricula + ".");
        } else {
            if (c.getCodigoCliente() == null) {
                System.out.println("O coche de matricula " + c.getMatricula() + " non está vendido.");
            } else {
                System.out.println("O coche de matricula " + c.getMatricula() + " posúeo " + c.getCodigoCliente().getNome() + " " + c.getCodigoCliente().getApelidos() + ".");
            }
        }
        s.close();

    }

    /**
     * Método de consulta de stock de coches.
     */
    public void consultarStock() {
        Session s = NewHibernateUtil.getSession();
        List<Coche> coches = s.createCriteria(Coche.class).list();
        int i = 0;
        for (Coche c : coches) {
            i++;
            System.out.println(i + "." + c.getMarca() + " ," + c.getModelo() + " ," + c.getMatricula() + " ," + c.getTipo());
        }
        s.close();

    }
}
