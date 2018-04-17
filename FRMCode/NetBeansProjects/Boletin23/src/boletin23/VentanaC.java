/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin23;

import static boletin23.VentanaA.panel;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


/**
 *
 * @author femio23
 */
public class VentanaC implements ActionListener{
    JFrame marco;
    JPanel panel;
    JButton boton1,boton2;
    JLabel saudo;
    public VentanaC(){
        boton1=new JButton("Saudo");
        boton1.addActionListener(this);
        boton2=new JButton("Despedida");
        boton2.addActionListener(this);
        saudo=new JLabel();
        saudo.setVisible(false);
        panel=new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.add(boton1);
        panel.add(boton2);
        panel.add(saudo);
        marco=new JFrame("Accions");
        marco.add(panel);
        marco.setSize(200,200);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object boton=e.getSource();
        if(boton==boton1){
            saudo.setText("Un saudo a todos.");
        }
        if(boton==boton2){
            saudo.setText("Adeus");
        }
        saudo.setVisible(true);
        
    }
}
