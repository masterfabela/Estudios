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
    Conector c1 = new Conector();

    public Venta(){
//        Conector c1=cs;
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
        modelo.addColumn("nombre");
        modelo.addColumn("idade");
        modelo.addColumn("codigo");
        p2.add(taboa);
        
        
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
            c1.conectar();
            if(idade.getText().equals("")&& codigo.getText().equals("")){
            c1.borrar("delete from EquipoProg where nome='"+nome.getText()+"';");
            }
            if(nome.getText().equals("")&& codigo.getText().equals("")){
                c1.borrar("delete from EquipoProg where idade='"+idade.getText()+"';");
            }
            if(idade.getText().equals("")&& nome.getText().equals("")){
                c1.borrar("delete from EquipoProg where codigo='"+codigo.getText()+"';");
            }
        
        
            c1.pechar();
        }
        if(e==cons){
            c1.conectar();
            modelo.setRowCount(0);
            taboa.setModel(modelo);
            ArrayList<Programador> l=new ArrayList();
            if(idade.getText().equals("")&& codigo.getText().equals("")&& nome.getText().equals("")){
                 l=c1.consultar("select * from EquipoProg;");
            }else{
            if(idade.getText().equals("")&& codigo.getText().equals("")){
                l=c1.consultar("select * from EquipoProg where nome='"+nome.getText()+"';");
            }
            if(nome.getText().equals("")&& codigo.getText().equals("")){
                l=c1.consultar("select * from EquipoProg where idade="+idade.getText()+";");
            }
            if(idade.getText().equals("")&& nome.getText().equals("")){
                l=c1.consultar("select * from EquipoProg where codigo='"+codigo.getText()+"';");
            }
            }
            
            for(Programador l1:l){
                modelo.addRow(new Object[]{l1.nome,l1.idade,l1.codigo});
            }
        taboa.setModel(modelo);
        c1.pechar();
        }
        if(e==add){
            c1.conectar();
            c1.insertar(nome.getText(),Integer.parseInt(idade.getText()),codigo.getText());
            c1.pechar();
        }
        if(e==act){
            c1.conectar();
            if(idade.getText().equals("")&& codigo.getText().equals("")){
                String var=JOptionPane.showInputDialog("Introduza o novo nome:");
                c1.actualizar("update EquipoProg set nome='"+var+"' where nome='"+nome.getText()+"';");
            }
            if(nome.getText().equals("")&& codigo.getText().equals("")){
                String var=JOptionPane.showInputDialog("Introduza a nova idade:");
                System.out.println("update EquipoProg set idade="+Integer.parseInt(var)+" where idade="+idade.getText()+";");

                c1.actualizar("update EquipoProg set idade="+Integer.parseInt(var)+" where idade="+idade.getText()+";");
            }
            if(idade.getText().equals("")&& nome.getText().equals("")){
                String var=JOptionPane.showInputDialog("Introduza o novo codigo:");
                c1.actualizar("update EquipoProg set codigo='"+var+"' where codigo='"+codigo.getText()+"';");
            }
            c1.pechar();
        }
    }
    
}
