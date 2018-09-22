/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin23;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author femio23
 */
public class VentanaD implements ActionListener{
    JFrame marco,marco2;
    JPanel panel;
    JButton boton1;
    JLabel saudo;
    public VentanaD(){
        boton1=new JButton("Saudo");
        boton1.addActionListener(this);
        saudo=new JLabel();
        saudo.setVisible(false);
        panel=new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.add(boton1);
        panel.add(saudo);
        marco=new JFrame("Accions");
        marco2=new JFrame("Reaccions");
        marco2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco2.setVisible(false);
        marco.add(panel);
        marco.setSize(200,200);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object boton=e.getSource();
        if(boton==boton1){
            marco2.setVisible(true);
        }
    }
}
