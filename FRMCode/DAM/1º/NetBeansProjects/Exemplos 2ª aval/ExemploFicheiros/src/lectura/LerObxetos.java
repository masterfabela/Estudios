/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lectura;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import persoas.Alumno;

/**
 *
 * @author femio23
 */
public class LerObxetos {
    Scanner sc;
    Alumno a1;
    public void leerobxetos(){
        String lectura;
        String[] lista=new String[2];
            try {
                sc=new Scanner(new File("alumnos.txt"));
                while(sc.hasNext()){
                    lectura=sc.nextLine();
                    lista=lectura.split(",");
                    a1=new Alumno(lista[0],Integer.parseInt(lista[1]));
                    System.out.println(a1.toString());
                }                
                sc.close();

            } catch (FileNotFoundException ex) {
                System.out.println("Erro 1"+ex.getMessage());

            }
            finally{
                sc.close();
            }
        }
        public ArrayList<Alumno> suspenso(){
            ArrayList<Alumno> suspensos=new ArrayList();
            String lectura;
        String[] lista=new String[2];
            try {
                sc=new Scanner(new File("alumnos.txt"));
                while(sc.hasNext()){
                    lectura=sc.nextLine();
                    lista=lectura.split(",");
                    a1=new Alumno(lista[0],Integer.parseInt(lista[1]));
                    System.out.println(a1.toString());
                    if(Integer.parseInt(lista[1])<5){
                        suspensos.add(a1);
                    }
                }                
                sc.close();

            } catch (FileNotFoundException ex) {
                System.out.println("Erro 1"+ex.getMessage());

            }
            finally{
                sc.close();
            }
            return suspensos;
        }
    }

