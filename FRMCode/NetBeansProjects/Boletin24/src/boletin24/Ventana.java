/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin24;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Femio
 */
public class Ventana implements ActionListener{
    JFrame marco;
    JPanel panel;
    JButton b1,b2;
    JTextField caixa;
    Graphics g;
    public Ventana(){
    b1=new JButton("Debuxar");
    b1.addActionListener(this);
    b2=new JButton("Limpar");
    b2.addActionListener(this);
    caixa=new JTextField();
    caixa.setText("0");
    panel=new JPanel();
    panel.add(b1);
    panel.add(caixa);
    panel.add(b2);
    marco=new JFrame("Circulos");
    marco.setSize(400,400);
    marco.add(panel);
    marco.setVisible(true);
    marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object o=ae.getSource();
        if(o==b1){
            g=panel.getGraphics();
            for(int i=1; i<=Integer.parseInt(caixa.getText()); i++){
                int x1=(int) (Math.random()*100)+60;
                int y1=(int) (Math.random()*100)+80;
                g.setColor(Color.red);
                g.drawOval(x1, y1, 100, 100);
            }
        }else{
            
            g.clearRect(0, 50, 400,400);
        }
    }
}
