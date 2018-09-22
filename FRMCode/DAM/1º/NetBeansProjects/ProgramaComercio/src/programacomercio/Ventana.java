/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacomercio;

import java.awt.FlowLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author femio23
 */
public class Ventana {
    JFrame marco;
    JPanel p1,p2,p3,p4;
    JTable tprezos,tproductos,tventas;
    DefaultTableModel modelo1=new DefaultTableModel();
    DefaultTableModel modelo2=new DefaultTableModel();
    DefaultTableModel modelo3=new DefaultTableModel();
    Metodos m1=new Metodos();
    public Ventana(){
        m1.conectar();
        m1.cargadatos();
    p1=new JPanel(new FlowLayout());
        tventas=new JTable();
        modelo1.addColumn("nº venta");
        modelo1.addColumn("rº prod");
        modelo1.addColumn("cantidade");
        tventas.setModel(modelo1);
        p1.add(tventas);
        
    p2=new JPanel(new FlowLayout());
        tproductos=new JTable();
        modelo2.addColumn("rº prod");
        modelo2.addColumn("nome");
        modelo2.addColumn("rº prezo");
        tproductos.setModel(modelo2);
        p2.add(tproductos);
        
    p3=new JPanel(new FlowLayout());
        tprezos=new JTable();
        modelo3.addColumn("prezo");
        modelo3.addColumn("rº prezo");
        tprezos.setModel(modelo3);
        p3.add(tprezos);
        
        for(Ventas v1:m1.ven){
            modelo1.addRow(new Object[]{v1.rprod,v1.nv,v1.cant});
        }
        tventas.setModel(modelo1);
        for(Productos v2:m1.pro){
            modelo2.addRow(new Object[]{v2.rprod,v2.nome,v2.rprez});
        }
        tproductos.setModel(modelo2);
        for(Prezos v3:m1.pre){
            modelo3.addRow(new Object[]{v3.prez,v3.rprez});
        }
        tprezos.setModel(modelo3);
        
        p4=new JPanel();
        p4.setLayout(new BoxLayout(p4,BoxLayout.Y_AXIS));
        p4.add(p1);
        p4.add(p2);
        p4.add(p3);
        marco=new JFrame();
        marco.setVisible(true);
        marco.setSize(300, 300);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.add(p4);
        m1.pechar();
    }
}
