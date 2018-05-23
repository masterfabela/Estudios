/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxectosql;

import java.awt.FlowLayout;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author femio23
 */
public class Venta {
    JFrame marco;
    JPanel p1,p2,p3,p4;
    JTextField nome,idade,codigo;
    JLabel n,i,c;
    JTable taboa;
    JButton cons,borr,act,add;
    public Venta(){
        p1=new JPanel(new FlowLayout());
        n=new JLabel("Nome:");
        i=new JLabel("Idade:");
        c=new JLabel("Codigo:");
        nome=new JTextField();
        nome.setColumns(10);
        idade=new JTextField();
        idade.setColumns(3);
        codigo=new JTextField();
        codigo.setColumns(3);
        p1.add(n);
        p1.add(nome);
        p1.add(i);
        p1.add(idade);
        p1.add(c);
        p1.add(codigo);
        
        p2=new JPanel(new FlowLayout());
        taboa=new JTable();
        DefaultTableModel modelo=new DefaultTableModel();
        modelo.addColumn("Nome");
        modelo.addColumn("Idade");
        modelo.addColumn("Codigo");

        Vector v1=new Vector();
        v1.add("a");
        v1.add("b");
        v1.add("c");
        modelo.setColumnIdentifiers(v1);
        taboa.setTableHeader();
        p2.add(taboa);

        
        
        

        modelo.addRow(v1);
        taboa.setModel(modelo);
        p2.add(taboa);
        
        p3=new JPanel(new FlowLayout());
        cons=new JButton("Consulta");
        borr=new JButton("Borrado");
        act=new JButton("Actualizar");
        add=new JButton("Engadir");
        p3.add(add);
        p3.add(cons);
        p3.add(act);
        p3.add(borr);
        
        p4=new JPanel();
        p4.setLayout(new BoxLayout(p4,BoxLayout.Y_AXIS));
        p4.add(p1);
        p4.add(p2);
        p4.add(p3);
        
        marco=new JFrame();
        marco.setSize(400,450);
        marco.add(p4);

        marco.setVisible(true);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
