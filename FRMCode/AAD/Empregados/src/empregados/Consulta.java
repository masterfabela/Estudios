/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empregados;

import Pojos.Departamento;
import Pojos.Empregado;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import org.hibernate.Session;

/**
 *
 * @author femio23
 */
public class Consulta {

    Scanner sc = new Scanner(System.in);

    public void empregado() throws ClassNotFoundException, SQLException {
        Session s = Empregados.iniciosesionFactory();
        System.out.println("Introduce o DNI:");
        String dni = sc.next();
        List<Empregado> empregado = s.createCriteria(Empregado.class, dni).list();
        if (empregado.isEmpty()) {
            System.out.println("Non existe ese empregado.");
        } else {
            for (Empregado e : empregado) {
                System.out.println("Departamento: " + e.getDepartamento().getNomeDep() + " Localidade: " + e.getDepartamento().getLocalidade() + ".");
            }
        }
    }

    public void departamento() throws ClassNotFoundException, SQLException {
        Session s = Empregados.iniciosesionFactory();
        System.out.println("Introduce o nome do Departamento:");
        String nome = sc.next();
        List<Departamento> departamento = s.createCriteria(Departamento.class, nome).list();
        if (departamento.isEmpty()) {
            System.out.println("Non existe ese Departamento.");
        } else {
            for (Departamento d : departamento) {
                Set<Empregado> x = d.getEmpregados();
                for (Empregado e : x) {
                    System.out.println(e.getNome() + ", " + e.getDni() + ", " + e.getOficio() + ", " + e.getSalario() + ", "
                            + "" + e.getComision() + ", " + e.getDataAlta() + ", " + e.getVehiculo().getMatricula());
                }
            }
        }
    }

}
