package com.mycompany.mavengit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;
import org.eclipse.jgit.api.AddCommand;
import org.eclipse.jgit.api.CommitCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.InitCommand;
import org.eclipse.jgit.api.PushCommand;
import org.eclipse.jgit.api.RemoteAddCommand;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.eclipse.jgit.transport.URIish;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
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
    static Repository repository;
    static String user,pass;
    public static void main(String[] args) throws IOException {
       //creacion do repo remoto
        try{
            fich=new File("user.txt");
            sc=new Scanner(fich);
            user=sc.nextLine();
            pass=sc.nextLine();
            gh1=GitHub.connectUsingPassword(user,pass);
            novorep("Primeiro repo Maven");
        }catch(FileNotFoundException fnfe1){
            System.out.println("error;"+fnfe1.getMessage());
        }
        sc.close();
        //clonado do repo secundario.
    try{
        Git.cloneRepository()
            .setURI("https://github.com/FranRM/Boletin21.git")
            .setDirectory(new File("nueva"))
            .call();
    }catch(GitAPIException ex1){
        System.out.println("Error:"+ex1.getMessage());
    }
   
    //creción do repo local
    FileRepositoryBuilder repositorear = new FileRepositoryBuilder();
    repository = repositorear.setGitDir(new File("C:\\Users\\Femio\\Documents\\NetBeansProjects\\CodigoMaquinaCOD\\ExerciciosMaven\\nueva\\.git"))
                    .readEnvironment()
                    .findGitDir()
                    .setMustExist(true)
                    .build();

    //add da carpeta
    try{
    Git git=new Git(repository);
                AddCommand add=git.add();
                add.addFilepattern("C:\\Users\\Femio\\Documents\\NetBeansProjects\\CodigoMaquinaCOD\\ExerciciosMaven\\nueva\\.git").call();
                git.close();
  //inicializado do repositorio
    InitCommand repositorio=new InitCommand();
        try{
            repositorio.setDirectory(new File("C:\\Users\\Femio\\Documents\\NetBeansProjects\\CodigoMaquinaCOD\\ExerciciosMaven\\nueva\\.git")).call();
        }catch(GitAPIException ex){
            System.out.println("Error:"+ex);
        }               
                
                CommitCommand commit=git.commit();
                commit.setMessage("Commit de pro").call();
                git.close();
            }catch(GitAPIException ex){
                System.out.println("Error:"+ex);
            }
    
        //pusheado
try{
            FileRepositoryBuilder repositoryBuilder=new FileRepositoryBuilder();
            repository=repositoryBuilder.setGitDir(new File("C:\\Users\\Femio\\Documents\\NetBeansProjects\\CodigoMaquinaCOD\\ExerciciosMaven\\nueva\\.git"))
                    .readEnvironment()
                    .findGitDir()
                    .setMustExist(true)
                    .build();
            
            Git git=new Git(repository);

            RemoteAddCommand remoteAddCommand=git.remoteAdd();
            remoteAddCommand.setName("origin");
            remoteAddCommand.setUri(new URIish("https://github.com/FranRM/Primeiro-repo-Maven"));
            remoteAddCommand.call();
            PushCommand pushCommand=git.push();
           
            pushCommand.setCredentialsProvider(new UsernamePasswordCredentialsProvider(user,pass));
            
            pushCommand.call();
            git.close();
        }catch(URISyntaxException ex){
            System.out.println("Error: "+ex);
        }catch(GitAPIException ex){
            System.out.println("Error: "+ex);
        }
        
    }
    public static void novorep(String repoNombre) throws IOException {
        GHCreateRepositoryBuilder repo = gh1.createRepository(repoNombre);
        repo.autoInit(true)
            .create();
        System.out.println("Listo");
    }
}