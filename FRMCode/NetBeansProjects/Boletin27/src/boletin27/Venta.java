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
    JTextField visual;
    JButton on;
    JButton off;
    JButton z,u,d,t,c,ci,s,se,oi,n;
    JButton div,mul,sum,res,dec,resul;
    String mem1,mem2;
    String signo=null;
    boolean cambio,p;
    public Venta(){
        cambio=false;
        p=true;
        visual=new JTextField(9);
        visual.setText("");
        visual.setBackground(Color.GRAY);
        visual.setFont(new Font("Arial",Font.BOLD,25));
        visual.setHorizontalAlignment(JTextField.RIGHT);
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
        oi=new JButton("8");
        oi.addActionListener(this);
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
        pboton.add(oi);
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
    
    public void operar(String operador1,String operador2, String signo){
        float resultado=0;
        String show=null;
        switch(signo){
        case"/":resultado=Float.parseFloat(operador1)/Float.parseFloat(operador2);
            show=String.valueOf(resultado);
            visual.setText(String.valueOf(resultado));
            if(operador1=="0"||operador2=="0"){
                visual.setText("Math Error");
                show="Math Error";
            }
            break;
        case"*":resultado=Float.parseFloat(operador1)*Float.parseFloat(operador2);
            show=String.valueOf(resultado);
            visual.setText(String.valueOf(resultado));
            break;
        case"+":resultado=Float.parseFloat(operador1)+Float.parseFloat(operador2);
            show=String.valueOf(resultado);
            break;
        case"-":resultado=Float.parseFloat(operador1)-Float.parseFloat(operador2);
//            if(Float.parseFloat(operador1)<Float.parseFloat(operador2)){
            show=String.valueOf(resultado);
            visual.setText(String.valueOf(resultado));
//            show="-"+show;
//            }else{
            show=String.valueOf(resultado);
//            }
            break;
        }
        
    }
    public String concatenar(String s,String f){
         String se;
        if(f==null){
        se=s;
        }else{
       se=f+s;
        }
        return se;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object o=e.getSource();
        if(o==on){
        visual.setBackground(Color.WHITE);
        visual.setText("");
        cambio=false;
            System.out.println(mem1+" "+mem2+" "+signo);
        
        mem1=null;
        mem2=null;
        }
        if(o==off){
        visual.setText("");
        visual.setBackground(Color.GRAY);
        }
        if(o==div){
        cambio=!cambio;
        signo="/";
        }
        if(o==mul){
        cambio=!cambio;
        signo="*";
        }
        if(o==sum){
        cambio=!cambio;
        signo="+";
        }
        if(o==res){
        cambio=!cambio;
        signo="-";
        }
        if(o==resul){
            operar(mem1,mem2,signo);
            
        }
        if(o==z){
            if(cambio==false){
                mem1=concatenar("0",mem1);
                visual.setText(mem1);
            }
            else{
                mem2=concatenar("0",mem2);
                visual.setText(mem2);
            }
        }
        if(o==u){
            if(cambio==false){
                mem1=concatenar("1",mem1);
                visual.setText(mem1);
            }
            else{
                mem2=concatenar("1",mem2);
                visual.setText(mem2);
            }
        }
        if(o==d){
            if(cambio==false){
                mem1=concatenar("2",mem1);
                visual.setText(mem1);
            }
            else{
                mem2=concatenar("2",mem2);
                visual.setText(mem2);
            }
        }
        if(o==t){
            if(cambio==false){
                mem1=concatenar("3",mem1);
                visual.setText(mem1);
            }
            else{
                mem2=concatenar("3",mem2);
                visual.setText(mem2);
            }
        }
        if(o==c){
            if(cambio==false){
                 mem1=concatenar("4",mem1);
                 visual.setText(mem1);
            }
            else{
                mem2=concatenar("4",mem2);
                visual.setText(mem2);
            }
        }
        if(o==ci){
            if(cambio==false){
                mem1=concatenar("5",mem1);
               visual.setText(mem1);
            }
            else{
                mem2=concatenar("5",mem2);
                visual.setText(mem2);
            }
        }
        if(o==s){
            if(cambio==false){
                mem1=concatenar("6",mem1);
                visual.setText(mem1);
            }
            else{
                mem2=concatenar("6",mem2);
                visual.setText(mem2);
            }
        }
        if(o==se){
            if(cambio==false){
                mem1=concatenar("7",mem1);
                visual.setText(mem1);
            }
            else{
                mem2=concatenar("7",mem2);
                visual.setText(mem2);
            }
        }
        if(o==oi){
            if(cambio==false){
                mem1=concatenar("8",mem1);
                visual.setText(mem1);
            }
            else{
                mem2=concatenar("8",mem2);
                visual.setText(mem2);
            }
        }
        if(o==n){
            if(cambio==false){
                mem1=concatenar("9",mem1);
                visual.setText(mem1);
            }
            else{
                mem2=concatenar("9",mem2);
                visual.setText(mem2);
            }
        }
        if(o==dec){
        if(cambio==false){
                mem1=concatenar(".",mem1);
                visual.setText(mem1);
            }
            else{
                mem2=concatenar(".",mem2);
                visual.setText(mem2);
            }
        }
    }
}
