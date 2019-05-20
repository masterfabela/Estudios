/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import empresacoches.NewHibernateUtil;
import java.util.Scanner;
import java.util.Set;
import org.hibernate.Session;
import pojos.*;

/**
 *
 * @author femio23
 */
public class Altas {

    Scanner sc = new Scanner(System.in);

    /**
     * Método de alta para a clase Coche.
     */
    public void altaCoches() {
        Session s = NewHibernateUtil.getSession();
        System.out.println("Introduza a matricula.");
        String matricula = sc.next();
        Coche c = (Coche) s.get(Coche.class, matricula);
        if (c != null) {
            System.out.println("O coche con matricula " + matricula + " xa existe.");
        } else {
            System.out.println("Introduza a marca.");
            String marca = sc.next();
            System.out.println("Introduza a modelo.");
            String modelo = sc.next();
            System.out.println("Introduza a tipo:turismo=t,industrial=i,todo-terreno=tt).");
            String tipo = sc.next();
            switch (tipo) {
                case "i":
                    tipo = "industrial";
                    break;
                case "tt":
                    tipo = "todo-terreno";
                    break;
                default:
                    tipo = "turismo";
                    break;
            }
            System.out.println("Seleccionado: " + tipo + ".");
            c = new Coche(matricula, marca, modelo, tipo);
            Edicion.guardarModificar(s, c);

        }
        s.close();
    }

    /**
     * Método de alta para a clase Proveedor.
     */
    public void altaProveedores() {
        Session s = NewHibernateUtil.getSession();
        System.out.println("Introduza o codigo do proveedor.");
        String codigo = sc.next();
        Proveedor p = (Proveedor) s.get(Proveedor.class, codigo);
        if (p != null) {
            System.out.println("O proveedor con codigo " + codigo + " xa existe:" + p.getNome() + ".");
        } else {
            System.out.println("Introduza o nome.");
            String nome = sc.next();
            p = new Proveedor(codigo, nome);
            Edicion.guardarModificar(s, p);
        }
        s.close();
    }

    /**
     * Método de alta para a clase Reparación.
     */
    public void altaReparacion() {
        Session s = NewHibernateUtil.getSession();
        System.out.println("Introduza o codigo.");
        String codigo = sc.next();
        Reparacion r = (Reparacion) s.get(Reparacion.class, codigo);
        if (r != null) {
            System.out.println("A reparacion con codigo " + codigo + " xa existe.");
            System.out.println("Cancelase a operacion");
        } else {
            System.out.println("Introduza a tipo:\nchapa=c,mecanica=m,electronica=e).");
            String tipo = sc.next();
            switch (tipo) {
                case "c":
                    tipo = "chapa";
                    break;
                case "m":
                    tipo = "mecanica";
                    break;
                default:
                    tipo = "electronica";
                    break;
            }
            System.out.println("Seleccionado: " + tipo + ".");
            System.out.println("Introduza as observacions.");
            String ob = sc.next();
            System.out.println("Introduce a matricula do coche a reparar.");
            String matricula = sc.next();
            Coche c = (Coche) s.get(Coche.class, matricula);
            if (c == null) {
                System.out.println("Non existe un coche con matricula: " + matricula + ".");
                System.out.println("Cancelase a acción.");
            } else {
                r = new Reparacion(codigo, tipo, ob);
                r.setCodigoCoche(c);
                Set<Reparacion> re = c.getReparacions();
                re.add(r);
                Edicion.guardarModificar(s, c);
                Edicion.guardarModificar(s, r);
                System.out.println("Coche " + c.getMatricula() + " e reparacion " + r.getCodigo() + " relacionados.");
            }
        }
        s.close();
    }

    /**
     * Método de alta para a clase Exposición.
     */
    public void altaExposicion() {
        Session s = NewHibernateUtil.getSession();
        System.out.println("Introduza o codigo.");
        String codigo = sc.next();
        Exposicion e = (Exposicion) s.get(Exposicion.class, codigo);
        if (e != null) {
            System.out.println("A exposicion con codigo " + codigo + " xa existe.");
            System.out.println("Cancelase a operacion");
        } else {
            System.out.println("Introduza o nome.");
            String nome = sc.next();
            System.out.println("Introduza o lugar.");
            String lugar = sc.next();
            e = new Exposicion(codigo, nome, lugar);
            Edicion.guardarModificar(s, e);
        }
        System.out.println("Exposicion " + e.getNome() + " creada.");
        s.close();
    }

    /**
     * Método de alta para a clase Cliente.
     */
    public void altaCliente() {
        Session s = NewHibernateUtil.getSession();
        System.out.println("Introduza o dni.");
        String dni = sc.next();
        Cliente c = (Cliente) s.get(Cliente.class, dni);
        if (c != null) {
            System.out.println("O cliente de dni " + dni + " xa existe.");
            System.out.println("Cancelase a operacion");
        } else {
            System.out.println("Introduza o nome.");
            String nome = sc.next();
            System.out.println("Introduza os apelidos.");
            String apelidos = sc.next();
            System.out.println("Introduza a direccion.");
            String direccion = sc.next();
            c = new Cliente(dni, nome, apelidos, direccion);
            Edicion.guardarModificar(s, c);
        }
        System.out.println("Cliente " + c.getNome() + " engadido.");
        s.close();
    }

    /**
     * Método de alta para a clase Vendedor.
     */
    public void altaVendedor() {
        Session s = NewHibernateUtil.getSession();
        System.out.println("Introduza o dni.");
        String dni = sc.next();
        Vendedor v = (Vendedor) s.get(Vendedor.class, dni);
        if (v != null) {
            System.out.println("O vendedor de dni " + dni + " xa existe.");
            System.out.println("Cancelase a operacion");
        } else {
            System.out.println("Introduza o nome.");
            String nome = sc.next();
            System.out.println("Introduza os apelidos.");
            String apelidos = sc.next();
            System.out.println("Introduza o numero da SS.");
            String numeross = sc.next();
            System.out.println("Desexa dar de alta un vendedor asalariado ou comisionista?(a/c)");
            String tipo = sc.next();
            switch (tipo) {
                case "a":
                    System.out.println("Seleccionado: Asalariado.");
                    System.out.println("A canto ascende o seu soldo?");
                    float soldo = sc.nextFloat();
                    Asalariado a = new Asalariado(soldo, nome, apelidos, numeross, dni);
                    Edicion.guardarModificar(s, a);
                    break;
                default:
                    System.out.println("Seleccionado: Comisionista.");
                    System.out.println("A canto ascende a súa comision?");
                    float comision = sc.nextFloat();
                    Comision c = new Comision(comision, nome, apelidos, numeross, dni);
                    Edicion.guardarModificar(s, c);
                    break;
            }

            Vendedor vx = (Vendedor) s.get(Vendedor.class, dni);
            System.out.println("Vendedor " + vx.getNome() + " engadido.");
        }

        s.close();
    }
}
