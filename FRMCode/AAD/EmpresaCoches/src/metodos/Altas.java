/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import empresacoches.NewHibernateUtil;
import java.util.List;
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
    public void altaCoches() {
        Session s = NewHibernateUtil.getSession();
        System.out.println("Introduza a matricula.");
        String matricula = sc.next();
        Coche c = (Coche)s.get(Coche.class, matricula);
        if (c!=null) {
            System.out.println("O coche con matricula " + matricula + " xa existe.");
        } else {
            System.out.println("Introduza a marca.");
            String marca = sc.next();
            System.out.println("Introduza a modelo.");
            String modelo = sc.next();
            System.out.println("Introduza a tipo:Turismo=t,Industrial=i,Todo-terreno=tt).");
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
            System.out.println("Introduza o prezo de compra.");
            float pCompra = sc.nextFloat();
            System.out.println("Introduza o prezo de venta.");
            float pVenta = sc.nextFloat();
            c = new Coche(matricula, marca, modelo, tipo, pCompra, pVenta);
            Edicion.guardarModificar(s, c);

        }
        s.close();
    }

    public void altaProveedores() {
        Session s = NewHibernateUtil.getSession();
        System.out.println("Introduza o codigo do proveedor.");
        String codigo = sc.next();
        System.out.println("Introduza o nome.");
        String nome = sc.next();
        Proveedor p = new Proveedor(codigo, nome);
        Edicion.guardarModificar(s, p);
        s.close();
    }
    public void altaReparacion() {
        Session s = NewHibernateUtil.getSession();
        System.out.println("Introduza o codigo.");
        String codigo = sc.next();
        Reparacion r = (Reparacion)s.get(Coche.class, codigo);
        if (r!=null) {
            System.out.println("A reparacion con codigo "+codigo+" xa existe.");
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
            String matricula=sc.next();
            Coche c=(Coche)s.get(Coche.class,matricula);
            if(c==null){
                System.out.println("Non existe un coche con matricula: "+matricula+".");
                System.out.println("Cancelase a acción.");
            }else{
                r=new Reparacion(codigo,tipo,ob);
                r.setCodigoCoche(c);
                Set<Reparacion>re=c.getReparacions();
                re.add(r);
                Edicion.guardarModificar(s,c);
                Edicion.guardarModificar(s,r);
                System.out.println("Coche "+c.getMatricula()+" e reparacion "+r.getCodigo()+" relacionados.");
            }
        }
        s.close();
    }
}
