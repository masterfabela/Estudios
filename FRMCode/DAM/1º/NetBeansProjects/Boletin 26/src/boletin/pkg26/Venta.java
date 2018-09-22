/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin.pkg26;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author femio23
 */
public class Venta implements ActionListener{
    JFrame marco;
    JPanel p1,p2,p3,p4;
    JLabel e1,e2;
    JButton b1;
    JTextField f1,f2;
    JComboBox c1;
    JTable t1;
    Vector v1=new Vector();
    Vector datos= new Vector();
    DefaultTableModel modelo = new DefaultTableModel();

    public Venta() {
        e1=new JLabel("Nome:");
        f1=new JTextField();
        f1.setColumns(10);
        c1=new JComboBox(v1);
        v1.add("DAM1");
        v1.add("ASIR");
        p1=new JPanel();
        p1.add(e1);
        p1.add(f1);
        p1.add(c1);
        
        e2=new JLabel("Apelido:");
        b1=new JButton("Agregar á taboa:");
        b1.addActionListener(this);
        f2=new JTextField();
        f2.setColumns(10);
        p2=new JPanel();
        p2.add(e2);
        p2.add(f2);
        p2.add(b1);
        
        t1=new JTable();
        
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Curso");
        t1.setModel(modelo);

        t1.setVisible(true);
        Vector cab=new Vector();
        cab.add("Nome");
        cab.add("Apelidos");
        cab.add("Ciclo");
        modelo.addRow(cab);
        t1.setModel(modelo);
        p3=new JPanel();
        p3.add(t1);
        
        p4=new JPanel();
        p4.setLayout(new BoxLayout(p4,BoxLayout.Y_AXIS));
        p4.add(p1);
        p4.add(p2);
        p4.add(p3);
        
        marco=new JFrame();
        marco.add(p4);
        marco.setSize(400, 200);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        datos.add(f1.getText());
        datos.add(f2.getText());
        datos.add(c1.getSelectedItem());
        modelo.addRow(datos);
        
        t1.setModel(modelo);
        datos.clear();
    }
    
    
    
}
