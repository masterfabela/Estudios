/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavengit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import org.kohsuke.github.GHCreateRepositoryBuilder;
import org.kohsuke.github.GitHub;

/**
 *
 * @author femio23
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    static GitHub gh1;
    static Scanner sc=null;
    static File fich=null;
    public static void main(String[] args) throws IOException {
        System.out.println("HolaMundo");
        try{
            fich=new File("user.txt");
            sc=new Scanner(fich);
            
            gh1=GitHub.connectUsingPassword(sc.nextLine(),sc.nextLine());
            novorep("PrimeiroMaven");
            
        }catch(FileNotFoundException fnfe1){
            System.out.println("error;"+fnfe1.getMessage());
        }
        sc.close();
    }
    public static void novorep(String repoNombre) throws IOException {
        GHCreateRepositoryBuilder repo = gh1.createRepository(repoNombre);
        repo.autoInit(true)
            .create();
        System.out.println("Listo");
    }
    
}
