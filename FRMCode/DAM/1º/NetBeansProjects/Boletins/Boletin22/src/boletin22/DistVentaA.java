/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin22;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author femio23
 */
public class DistVentaA {
    JFrame marco;
    JLabel info,user,nome,id,grupo,directorio,shell,pass,pass2;
    JTextField tuser,tnome,tid,tdirectorio;
    JComboBox cgrupo,cdirectorio;
    JPasswordField tpass,tpass2;
    ArrayList agrupo=new ArrayList();
    ArrayList adir=new ArrayList();
    
    public DistVentaA(){
    info=new JLabel("Create a new user");
    user=new JLabel("User Name:");
    nome=new JLabel("Full Name:");
    id=new JLabel("User ID:");
    grupo=new JLabel("Group:");
    directorio=new JLabel("Home Directory:");
    shell=new JLabel("Login Shell:");
    pass=new JLabel("Password:");
    pass2=new JLabel("Confirm:");
    tuser=new JTextField("mary",15);
    tnome=new JTextField("User Mary",15);
    tid=new JTextField("[Automatic]",15);
    tid.setEditable(false);
    
    tdirectorio=new JTextField("[Automatic]",15);
    tdirectorio.setEditable(false);
    tpass=new JPasswordField("1234567890",15);
    tpass2=new JPasswordField("1234567890",15);
    cgrupo=new JComboBox();
    cgrupo.addItem("Staff");
    cgrupo.addItem("Users");
    cdirectorio=new JComboBox();
    cdirectorio.addItem("/bin/ksh");
    cdirectorio.addItem("/home/media");
    
    JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9,fin;
    p1=new JPanel();
    p1.setLayout(new FlowLayout());
    p1.add(info);
    p2=new JPanel();
    p2.setLayout(new FlowLayout());
    p2.add(user);
    p2.add(tuser);
    p3=new JPanel();
    p3.setLayout(new FlowLayout());
    p3.add(nome);
    p3.add(tnome);
    p4=new JPanel();
    p4.setLayout(new FlowLayout());
    p4.add(id);
    p4.add(tid);
    p5=new JPanel();
    p5.setLayout(new FlowLayout());
    p5.add(grupo);
    p5.add(cgrupo);
    p6=new JPanel();
    p6.setLayout(new FlowLayout());
    p6.add(directorio);
    p6.add(tdirectorio);
    p7=new JPanel();
    p7.setLayout(new FlowLayout());
    p7.add(shell);
    p7.add(cdirectorio);
    p8=new JPanel();
    p8.setLayout(new FlowLayout());
    p8.add(pass);
    p8.add(tpass);
    p9=new JPanel();
    p9.setLayout(new FlowLayout());
    p9.add(pass2);
    p9.add(tpass2);
    fin=new JPanel();
    fin.setLayout(new BoxLayout(fin,BoxLayout.Y_AXIS));
    fin.add(p1);
    fin.add(p2);
    fin.add(p3);
    fin.add(p4);
    fin.add(p5);
    fin.add(p6);
    fin.add(p7);
    fin.add(p8);
    fin.add(p9);
    marco=new JFrame("New User");
    marco.add(fin);
    marco.pack();
    marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    marco.setVisible(true);
    }
}
