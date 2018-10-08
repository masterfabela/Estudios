/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio3;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author femio
 */
public class Conector {
    //alter session set nls_date_format = 'dd.mm.yyyy hh24:mi:ss';
    Connection conect;
    Scanner sc = new Scanner(System.in);
    int opcion2=0;
    Statement orde;
    public void conectar(){
        try{
            conect=DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root");
            System.out.println("Conexión correcta.");
        }catch(SQLException sqle1){
            System.out.println("Erro:"+sqle1.getMessage());
        }
    }
    public void pechar(){
        try{
            conect.close();
            System.out.println("Desconexión correcta.");
        }catch(SQLException sqle1){
            System.out.println("Erro:"+sqle1.getMessage());
        }
    }
    public void altas(){
        
        while(opcion2!=5){
            System.out.println("========ALTAS========\n"
                + "1-Profesores\n"
                + "2-Alumnos\n"
                + "3-Notas\n"
                + "4-Taboa PAAN\n"
                + "5-Sair");
            opcion2=sc.nextInt();
            switch(opcion2){
                case 1:
                    System.out.println("Introduza o dni:");
                    String dni=sc.next();
                    System.out.println("Introduza o nome:");
                    String nome=sc.next();
                    System.out.println("Introduza a titulación:");
                    String tit=sc.next();
                    try{
                        orde=conect.createStatement();
                        orde.execute("insert into profesores values('"+dni+"','"+nome+"','"+tit+"');");
                        System.out.println("Inseiruse a "+nome+" correctamente.");
                    }catch(SQLException sqle1){
                        System.out.println("Erro:"+sqle1.getMessage());
                    }
                    ;
                break;
                case 2:System.out.println("Introduza o Id:");
                    int id=sc.nextInt();
                    System.out.println("Introduza o codigo:");
                    String codigo=sc.next();
                    System.out.println("Introduza o nome:");
                    nome= sc.next();
                    try{
                        orde=conect.createStatement();
                        orde.execute("insert into alumnos values('"+id+"','"+codigo+"','"+nome+"');");
                        System.out.println("Inseiruse a "+nome+" correctamente.");
                    }catch(SQLException sqle1){
                        System.out.println("Erro:"+sqle1.getMessage());
                    }
                    ;
                break;
                case 3:
                    //Problemas co date.
                    System.out.println("Introduza o Id da asignatura:");
                    String idas=sc.next();
                    System.out.println("Introduza o Id do alumno:");
                    int idal=Integer.parseInt(sc.next());
                    System.out.println("Introduza a data:");
                    Date data=Date.valueOf(sc.next());
                    System.out.println("Introduza a nota:");
                    int nota= sc.nextInt();
                    try{
                        orde=conect.createStatement();
                        orde.execute("insert into notas(Idas,Idal,fecha,nota) values('"+idas+"','"+idal+"','"+data+"','"+nota+"');");
                        System.out.println("Inseiruse a nota correctamente.");
                    }catch(SQLException sqle1){
                        System.out.println("Erro:"+sqle1.getMessage());
                    }
                    ;
                break;
                case 4:
                    System.out.println("Introduza o Id da asignatura:");
                    idas=sc.next();
                    System.out.println("Introduza o Id do alumno:");
                    idal=sc.nextInt();
                    System.out.println("Introduza o dni:");
                    dni=sc.next();
                    try{
                        orde=conect.createStatement();
                        orde.execute("insert into profesoresalumnosasignaturas(dni,Idas,Idal) values ('"+dni+"','"+idas+"','"+idal+"')");
                        System.out.println("Inseiruse a relacion correctamente.");
                    }catch(SQLException sqle1){
                        System.out.println("Erro:"+sqle1.getMessage());
                    }
                    ;
                break;
            }
        }
    }
    public void baixas(){
        while(opcion2!=3){
        System.out.println("=======BAIXAS========\n"
                + "1-Profesores\n"
                + "2-Alumnos\n"
                + "3-Sair");
        opcion2=sc.nextInt();
        switch(opcion2){
            case 1:
                System.out.println("Introduza o Dni do profesor a dar de baixa:");
                    String dni=sc.next();
                    try{
                    orde=conect.createStatement();
                    orde.execute("delete from profesores where dni='"+dni+"'");
                    orde.execute("delete from profesoresalumnosasignaturas where dni='"+dni+"'");
                    }catch(SQLException sqle1){
                        System.out.println("Erro: "+sqle1.getMessage());
                    }
                ;
            break;
            case 2:
                System.out.println("Introduza o identificador do alumno a dar de baixa:");
                    String idal =sc.next();
                    try{
                    orde=conect.createStatement();
                    orde.execute("delete from alumnos where Idal='"+idal+"'");
                    orde.execute("delete from notas where Idal='"+idal+"'");
                    orde.execute("delete from profesoresalumnosasignaturas where Idal='"+idal+"'");
                    }catch(SQLException sqle1){
                        System.out.println("Erro: "+sqle1.getMessage());
                    }
                ;
            break;
        }
        }
    }
    public void modificacions(){
        System.out.println("Introduce o identificador do alumno.");
        String idal=sc.next();
        System.out.println("Introduza a nova nota.");
        int nota=sc.nextInt();
        try{
        orde=conect.createStatement();
        orde.execute("update from alumnos set nota='"+nota+"' where Idal='"+idal+"'");
        }catch(SQLException sqle1){
            System.out.println("Erro:"+sqle1.getMessage());
        }
    }
    public void consultas(){
        while(opcion2!=5){
                System.out.println("======CONSULTAS======\n"
                + "1-Profesores/Asignaturas\n"
                + "2-Alumnos/Notas/Asignaturas\n"
                + "3-Asignatira/profesor\n"
                + "4-Taboa PAAN\n"
                + "5-Sair");
        }
    }
    
    public void crearBD(){
        try{
            Statement s = conect.createStatement();
            s.execute("create database if not exists BDInstituto;");
            s.execute("use BDInstituto;");
            s.execute("create table if not exists profesores ( "
                    + "dni varchar(11) not null,"
                    + "nome varchar(30) not null ,"
                    + "titulacion varchar(30) not null, "
                    + "primary key(dni));");
            s.execute("create table if not exists alumnos ("
                    + "Idal int(11) auto_increment not null,"
                    + "codal varchar(4), "
                    + "nome varchar(30) ,"
                    + "primary key(Idal), "
                    + "unique (codal));");
            s.execute("create table if not exists asignaturas( "
                    + "Idas int(5) auto_increment not null,"
                    + "codas varchar(4),"
                    + "nome varchar(30) ,"
                    + "aciclo varchar(30),"
                    + "primary key (Idas),"
                    + "unique (codas));");
            s.execute(
                    "create table if not exists profesoresalumnosasignaturas ("
                    +"dni varchar(11) not null, "
                    +"Idas int (5) not null, "
                    +"Idal int(11) not null, "
                    +"foreign key (dni) references profesores(dni) on delete cascade on update cascade, "
                    +"foreign key (Idas) references asignaturas(Idas) on delete cascade on update cascade, "
                    +"foreign key (Idal) references alumnos(Idal) on delete cascade on update cascade, "
                    +"primary key (Idas,Idal))"); 
            s.execute("create table if not exists notas ("
                    + "Idas int(5) ,"
                    + "Idal int(11) ,"
                    //Problemas co formateo do date.
                    + "fecha date not null,"
                    + "nota float(3),"
                    + "primary key (Idas,Idal,fecha),"
                    + "foreign key (Idas) references asignaturas (Idas) on delete cascade on update cascade, "
                    + "foreign key (Idal) references alumnos (Idal) on delete cascade on update cascade);");    
            System.out.println("Finalizado.");
        }catch(SQLException sqle1){
            System.out.println("Erro: "+sqle1.getMessage());
        }
    }
}
