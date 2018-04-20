/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.femiasa.toolbar;

import java.awt.FlowLayout;
import java.net.URL;
import java.net.URLEncoder;
import javax.swing.*;
import org.openide.awt.HtmlBrowser.URLDisplayer;

/**
 *
 * @author femio23
 */
public class Panel {
    JPanel panel;
    JLabel etiqueta;
    JTextField entrada;
    public Panel(){
    etiqueta=new JLabel("Busca:");
    entrada=new JTextField(25);
    panel=new JPanel();
    panel.setLayout(new FlowLayout());
    panel.add(etiqueta);
    panel.add(entrada);
    panel.setVisible(true);
    
    
    }
    
}
