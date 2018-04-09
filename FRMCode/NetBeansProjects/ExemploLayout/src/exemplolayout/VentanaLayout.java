/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplolayout;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author femio23
 */
public class VentanaLayout {
    JFrame marco;
    JPanel panel;
    JButton boton1,boton2,boton3,boton4,boton5;
    public VentanaLayout(){
        marco = new JFrame(" FlowLayout ");
        panel = new JPanel();
        boton1 = new JButton("Boton1");
        boton2 = new JButton("Boton2");
        boton3 =  new JButton("Boton3");
        boton4 = new JButton("Boton4");
        boton5 = new JButton("Boton5");
        
    }
    
    public void distribuirLayout(){
        
        
        //aplicamos o layout:
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        //Adicion de compoñentes:
        panel.add(boton1);
        panel.add(boton2);
        panel.add(boton3);
        panel.add(boton4);
        panel.add(boton5);
        
        marco.add(panel);
        
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
    }
    
    public void disBoxLayout(){
        
        panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));
        panel.add(boton1);
        panel.add(boton2);
        panel.add(boton3);
        panel.add(boton4);
        panel.add(boton5);
        
        marco.add(panel);
        //axustamos o marco os compoñentes
        marco.pack();
        
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
    }
    public void disBorderLayout(){
        
        panel.setLayout(new BorderLayout());
        panel.add(boton1,BorderLayout.NORTH);
        panel.add(boton2,BorderLayout.SOUTH);
        panel.add(boton3,BorderLayout.EAST);
        panel.add(boton4,BorderLayout.WEST);
        panel.add(boton5,BorderLayout.CENTER);
        
        marco.add(panel);
        //axustamos o marco os compoñentes
        marco.pack();
        
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
    }
}
