/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import empresacoches.NewHibernateUtil;
import java.util.Scanner;
import org.hibernate.Session;
import pojos.Coche;
import pojos.Proveedor;

/**
 *
 * @author femio23
 */
public class Altas {
    Scanner sc=new Scanner(System.in);
    public void altaCoches(){
        Session s=NewHibernateUtil.getSession();
        System.out.println("Introduza a matricula.");
        String matricula=sc.next();
        System.out.println("Introduza a marca.");
        String marca=sc.next();
        System.out.println("Introduza a modelo.");
        String modelo=sc.next();
        System.out.println("Introduza a tipo:Turismo=t,Industrial=i,Todo-terreno=tt).");
        String tipo=sc.next();
        switch(tipo){
            case "i":tipo="industrial";
            break;
            case "tt":tipo="todo-terreno";
            break;
            default:tipo="turismo";
            break;
        }
        System.out.println("Seleccionado: "+tipo+".");
        System.out.println("Introduza o prozo de compra.");
        float pCompra=sc.nextFloat();
        System.out.println("Introduza o prozo de venta.");
        float pVenta=sc.nextFloat();
        Coche c=new Coche(matricula,marca,modelo,tipo,pCompra,pVenta);
        Edicion.guardarModificar(s,c);
        s.close();
    }
    public void altaProveedores(){
        Session s=NewHibernateUtil.getSession();
        System.out.println("Introduza o codigo do proveedor.");
        String codigo=sc.next();
        System.out.println("Introduza o nome.");
        String nome=sc.next();
        Proveedor p=new Proveedor(codigo,nome);
        Edicion.guardarModificar(s,p);
        s.close();
    }
}
