/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.femiasa.botonpop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "File",
        id = "org.femiasa.botonpop.Accionadorboton"
)
@ActionRegistration(
        iconBase = "org/femiasa/botonpop/firefox-logo-300x310.png",
        displayName = "#CTL_Accionadorboton"
)
@ActionReference(path = "Toolbars/File", position = 0)
@Messages("CTL_Accionadorboton=Haz click")
public final class Accionadorboton implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showConfirmDialog(null,"Holaaaaa");
    }
}
