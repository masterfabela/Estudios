/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxectosql;

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
    JTextField nome,idade,codigo;
    JLabel n,i,c;
    JTable taboa;
    JButton cons,borr,act,add;
    DefaultTableModel modelo=new DefaultTableModel();
    Conector c1;

    public Venta(Conector cs){
        Conector c1=cs;
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
        
        Vector v1=new Vector();
        modelo.addColumn("Nome");
        modelo.addColumn("Idade");
        modelo.addColumn("Codigo");
        taboa.setModel(modelo);
        System.out.println(taboa.getColumnName(0));
        p2.add(taboa);

        
        
        

        modelo.addRow(v1);
        taboa.setModel(modelo);
        
        p3=new JPanel(new FlowLayout());
        cons=new JButton("Consulta");
        cons.addActionListener(this);
        borr=new JButton("Borrado");
        borr.addActionListener(this);
        act=new JButton("Actualizar");
        act.addActionListener(this);
        add=new JButton("Engadir");
        add.addActionListener(this);
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

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object e=ae.getSource();
        if(e==borr){
        
        }
        if(e==cons){
            c1.conectar();
            ArrayList<Programador> l=c1.consultar("select * from EquipoProg;");
            Vector v1=new Vector();
            for(Programador l1:l){
                v1.add(new Programador(l1.nome,l1.idade,l1.codigo));
                modelo.addRow(v1);
                v1.clear();
        }
        taboa.setModel(modelo);
        }
        if(e==add){
        
        }
        if(e==act){
        
        }
    }
    
}
