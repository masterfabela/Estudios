/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin23;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author femio23
 */
public class VentanaA implements ActionListener{
    static JFrame marco;
    static JPanel panel;
    static JButton boton;
    static JLabel etiqueta;
    public VentanaA(){
        etiqueta=new JLabel("Premeches o botón.");
        etiqueta.setVisible(false);
        boton=new JButton("Preme");
        boton.addActionListener(this);
        panel=new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.add(boton);
        panel.add(etiqueta);
        marco=new JFrame("Test de accions:");
        marco.setSize(200,200);
        marco.add(panel);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        etiqueta.setVisible(true);
    }
    
}
