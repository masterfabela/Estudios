/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin27;

import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 *
 * @author femio23
 */
public class Venta implements ActionListener{
    JFrame marco;
    JPanel vista,vista2,pestado,pboton,ptotal;
    JTextArea visual;
    JButton on;
    JButton off;
    JButton z,u,d,t,c,ci,s,se,o,n;
    JButton div,mul,sum,res,dec,resul;
    public Venta(){
        visual=new JTextArea(1,9);
        visual.setText("a");
        vista=new JPanel();
        vista.setLayout(new FlowLayout(FlowLayout.CENTER));
        vista.add(visual);
        vista.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        
        
        
        on=new JButton("AC");
        on.setBackground(Color.red);
        on.addActionListener(this);
        off=new JButton("OFF");
        off.setBackground(Color.blue);
        off.addActionListener(this);
        
        pestado=new JPanel();
        pestado.setLayout(new FlowLayout(FlowLayout.CENTER));
        pestado.add(on);
        pestado.add(off);
        
        z=new JButton("0");
        z.addActionListener(this);
        u=new JButton("1");
        u.addActionListener(this);
        d=new JButton("2");
        d.addActionListener(this);
        t=new JButton("3");
        t.addActionListener(this);
        c=new JButton("4");
        c.addActionListener(this);
        ci=new JButton("5");
        ci.addActionListener(this);
        s=new JButton("6");
        s.addActionListener(this);
        se=new JButton("7");
        se.addActionListener(this);
        o=new JButton("8");
        o.addActionListener(this);
        n=new JButton("9");
        n.addActionListener(this);
        div=new JButton("/");
        div.addActionListener(this);
        mul=new JButton("*");
        mul.addActionListener(this);
        res=new JButton("-");
        res.addActionListener(this);
        sum=new JButton("+");
        sum.addActionListener(this);
        dec=new JButton(".");
        dec.addActionListener(this);
        resul=new JButton("=");
        resul.addActionListener(this);
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
        vista2=new JPanel();
        vista2.setLayout(new BoxLayout(vista2,BoxLayout.Y_AXIS));
        vista2.add(pestado);
        vista2.add(pboton);
        vista2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        
        ptotal=new JPanel();
        ptotal.setLayout(new BoxLayout(ptotal,BoxLayout.Y_AXIS));
        ptotal.add(vista);
        ptotal.add(vista2);
        
        marco=new JFrame();
        marco.add(ptotal);
        marco.setSize(260,400);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
        
        
        
    }    

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o=e.getSource();
        if(o==on){
        visual.setBackground(Color.WHITE);
        visual.setText("_");
        }
        if(o==off){
        visual.setText("");
        visual.setBackground(Color.GRAY);
        }
    }
}
