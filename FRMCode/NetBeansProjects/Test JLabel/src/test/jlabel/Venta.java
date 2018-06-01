/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jlabel;

import java.net.URL;
import javax.swing.*;

/**
 *
 * @author femio23
 */
public class Venta {
    JFrame marco;
    JPanel p1;
    JButton b1;
    JLabel l1;
    public Venta (){
    b1=new JButton("Barco");
    b1.setOpaque(true);
    b1.setAlignmentX(200);
    b1.setAlignmentY(200);
    l1=new JLabel("hola");
    l1.setAlignmentX(200);
    l1.setAlignmentY(200);
    l1.setIcon(new ImageIcon("submarino.jpg"));
    l1.add(b1);
    
    p1=new JPanel();
    
    p1.add(l1);
    marco=new JFrame();
    marco.add(p1);
    marco.setSize(400,450);
    marco.setVisible(true);
    marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
