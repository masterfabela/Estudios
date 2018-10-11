/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.femiasa.crearepoGH;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;
import org.kohsuke.github.GHCreateRepositoryBuilder;
import org.kohsuke.github.GitHub;

@ActionID(
        category = "File",
        id = "org.femiasa.crearepoGH.SomeAction"
)
@ActionRegistration(
        iconBase = "org/femiasa/crearepoGH/github.png",
        displayName = "#CTL_SomeAction"
)
@ActionReference(path = "Toolbars/File", position = 0)
@Messages("CTL_SomeAction=GitHub Repository creator")
public final class SomeAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
    GitHub gh1 ;
    Scanner sc=null;
    File fich=null;
    String user="0";
    String pass="0";
        try{
            fich=new File("user.txt");
            sc=new Scanner(fich);
            user=sc.nextLine();
            pass=sc.nextLine();
            //creamos un ficheiro para as credenciais de usuario e cargamolas no programa.
            gh1=GitHub.connectUsingPassword(user, pass);
            //conectamonos a git coas credenciais.
            novorep("Testeando",gh1);
            //creamos o repositorio.
            
        }catch(FileNotFoundException fnfe1){
            System.out.println("error:"+fnfe1.getMessage());
        }catch(IOException ioe1){
            System.out.println("error:"+ioe1.getMessage());
            user="0";
            pass="0";
        }
        sc.close();
    }
    /**
     * Método de creación de repositorios novos.
     * @param repoNombre Variable que garda o nome do repositorio a crear.
     * @param gh1 Obxeto de tipo GitHub que trae o usuario xa iniciado.
     * @throws IOException 
     */
    public static void novorep(String repoNombre,GitHub gh1) throws IOException {
        GHCreateRepositoryBuilder repo = gh1.createRepository(repoNombre);
        repo.autoInit(true)
            .create();
        System.out.println("Listo");
    }
}

