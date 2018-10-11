/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin23;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author femio23
 */
public class VentanaB implements ActionListener{
    JFrame marco;
    JPanel panel;
    JButton boton1,boton2;
    public VentanaB(){
        boton1=new JButton("Programación");
        boton1.addActionListener(this);
        boton2=new JButton("Bases");
        boton2.addActionListener(this);
        panel=new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(boton1);
        panel.add(boton2);
        marco=new JFrame("DAM 1");
        marco.add(panel);
        marco.setSize(200,200);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object boton=e.getSource();
        if(boton==boton1){
            marco.setTitle("Programación");
        }
        if(boton==boton2){
            marco.setTitle("Bases");
        }
        
    }
    
}
