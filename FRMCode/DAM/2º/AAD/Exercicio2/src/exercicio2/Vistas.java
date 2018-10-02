/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio2;

/**
 *
 * @author a18franciscorm
 */
public class Vistas {
    public void main_menu(){
        System.out.println(
            "|----MENU----|"
            +"1-Insercion.\n"
            + "2-Borrado.\n"
            + "3-Consultas.\n"
            + "4-Modificacions.\n"
            + "5-Fin."
            +"|-------------|");
    }
    public void insert_menu(){
        System.out.println(
                "|-INSERCIÓNS-|"
                        + "1-Departamento.\n"
                        + "2-Empregado.");
    }
    public void erese_menu(){
        System.out.println(
                "|--BORRADO--|"
                        + "1-Departamento.\n"
                        + "2-Empregado.");
    }
    public void query_menu(){
        System.out.println(
                "|--CONSULTAS--|"
                        + "1-Departamento.\n"
                        + "2-Empregado.");
    }
    public void update_menu(){
        System.out.println(
                "|MODIFICACIONS|"
                        + "1-Departamento.\n"
                        + "2-Empregado.");
    }
}
