/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.femiasa.toolbar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.net.URLEncoder;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.awt.HtmlBrowser;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "File",
        id = "org.femiasa.toolbar.SomeAction"
)
@ActionRegistration(
        iconBase = "org/femiasa/toolbar/github.png",
        displayName = "#CTL_SomeAction"
)
@ActionReference(path = "Toolbars/File", position = 0)
@Messages("CTL_SomeAction=GH")
public final class SomeAction implements ActionListener {
    Panel p1=new Panel();
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
        String searchText = URLEncoder.encode(p1.entrada.getText(), "UTF-8");
        HtmlBrowser.URLDisplayer.getDefault().showURL
           (new URL("http://www.google.com/search?hl=en&q="+searchText+"&btnG=Google+Search"));
    } catch (Exception eee){
        return;//nothing much to do
    }
    }
}
