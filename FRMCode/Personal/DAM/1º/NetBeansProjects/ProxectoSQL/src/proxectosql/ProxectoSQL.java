/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxectosql;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author femio23
 */
public class ProxectoSQL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conector con1=new Conector();
        Venta v1=new Venta();

    }
    public void borrado(Conector c1,JTextField nome,JTextField idade,JTextField codigo){
    
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
    public void actualizado(Conector c1,JTextField nome,JTextField idade,JTextField codigo){
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
    public void consultado(Conector c1,JTextField nome,JTextField idade,JTextField codigo,DefaultTableModel modelo, JTable taboa){
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
    public void engadido(Conector c1,JTextField nome,JTextField idade,JTextField codigo){
            c1.conectar();
            c1.insertar(nome.getText(),Integer.parseInt(idade.getText()),codigo.getText());
            c1.pechar();
    }
    
    
}
