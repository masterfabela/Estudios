/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin27;

import java.awt.Color;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 *
 * @author femio23
 */
public class Venta {
    LineBorder m1,m2;
    JFrame marco;
    JPanel vista,pestado,pboton,ptotal;
    JTextArea visual;
    JButton on;
    JButton off;
    JButton z,u,d,t,c,ci,s,se,o,n;
    JButton div,mul,sum,res,dec,resul;
    public Venta(){
        m1=new LineBorder(Color.BLACK);
        visual=new JTextArea();
        visual.setText("0123456789");
        vista=new JPanel();
        vista.setLayout(new FlowLayout(FlowLayout.CENTER));
        //vista.add(m1);
        vista.add(visual);
        
        
        
        on=new JButton("AC");
        on.setBackground(Color.red);
        off=new JButton("OFF");
        off.setBackground(Color.blue);
        
        pestado=new JPanel();
        pestado.setLayout(new FlowLayout(FlowLayout.CENTER));
        pestado.add(on);
        pestado.add(off);
        
        z=new JButton("0");
        u=new JButton("1");
        d=new JButton("2");
        t=new JButton("3");
        c=new JButton("4");
        ci=new JButton("5");
        s=new JButton("6");
        se=new JButton("7");
        o=new JButton("8");
        n=new JButton("9");
        div=new JButton("/");
        mul=new JButton("*");
        res=new JButton("-");
        sum=new JButton("+");
        dec=new JButton(".");
        resul=new JButton("=");
        pboton=new JPanel();
        pboton.setLayout(new GridLayout(4,4,5,5));
        
        pboton.add(se);
        pboton.add(o);
        pboton.add(n);
        pboton.add(div);
        pboton.add(c);
        pboton.add(ci);
        pboton.add(s);
        pboton.add(mul);
        pboton.add(u);
        pboton.add(d);
        pboton.add(t);
        pboton.add(res);
        pboton.add(z);
        pboton.add(dec);
        pboton.add(resul);
        pboton.add(sum);
        pboton.setSize(250,300);
        
        ptotal=new JPanel();
        ptotal.setLayout(new BoxLayout(ptotal,BoxLayout.Y_AXIS));
        ptotal.add(vista);
        ptotal.add(pestado);
        ptotal.add(pboton);
        
        marco=new JFrame();
        marco.add(ptotal);
        marco.setSize(260,400);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
        
        
        
    }    
}
