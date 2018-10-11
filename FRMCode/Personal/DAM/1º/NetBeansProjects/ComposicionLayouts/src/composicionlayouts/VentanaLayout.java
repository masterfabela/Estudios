/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package composicionlayouts;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author femio23
 */
public class VentanaLayout {
    JFrame marco;
    JPanel paneluser;
    JPanel panelpass;
    JPanel panelbutton;
    JPanel fin;
    JButton boton1;
    JButton boton2;
    JButton boton3;
    JLabel labeluser;
    JLabel labelpass;
    JTextField fielduser;
    JTextField fieldpass;
    
    
    public VentanaLayout(){
        marco = new JFrame();
        paneluser=new JPanel();
        panelpass=new JPanel();
        panelbutton=new JPanel();
        fin =new JPanel();
        
        boton1=new JButton("Boton1");
        boton2=new JButton("Boton2");
        boton3=new JButton("Boton2");
        
        labeluser=new JLabel("Usuario");
        labelpass=new JLabel("Contraseña");
        
        fielduser=new JTextField("   User   ");
        fieldpass=new JTextField("   Pass   ");
    }
    public void dist(){
        paneluser.setLayout(new FlowLayout());
        paneluser.add(labeluser);
        paneluser.add(fielduser);
        panelpass.setLayout(new FlowLayout());
        panelpass.add(labelpass);
        panelpass.add(fieldpass);
        panelbutton.setLayout(new FlowLayout());
        panelbutton.add(boton1);
        panelbutton.add(boton2);
        panelbutton.add(boton3);
        fin.setLayout(new BoxLayout(fin,BoxLayout.Y_AXIS));
        fin.add(paneluser);
        fin.add(panelpass);
        fin.add(panelbutton);
        
        marco.add(fin);
        
        marco.pack();
        
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
    }
}
