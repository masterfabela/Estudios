/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin31;

import java.util.ArrayList;

/**
 *
 * @author femio23
 */
public class Boletin31 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Supervisor s1=new Supervisor("Son o supervisor");
        Coche c1=new Coche("65423PO","Seat","Leon");
        Coche c2=new Coche("74581CO","Jaguar","XJT");
        Cliente cli1=new Cliente("Xexo");
        Cliente cli2=new Cliente ("Marisa");
        ArrayList lcli=new ArrayList();
        ArrayList lven=new ArrayList();
        lcli.add(cli1);
        lcli.add(cli2);
        
        Empregado sec=new Secretario("Pepe","Rodriguez Perez","77455","Rua Vilaboa,23","655888881",1000,s1,"65323256","23A");
        Empregado ven=new Vendedor("Xoaquin", "Melles", "7895", "Xil-Ganon", "6541100",300, s1,c1,"987456123","O Morrazo",lcli,0.05);
        lven.add(ven);
        Empregado xef=new XefedeZona("Luis","Gonzalez", "514789", "Santoña", "963852741", 1000, s1,"Central",sec, lven,c2);
        xef.imprimir();
        xef.incsalario(0);
        xef.imprimir();
        sec.imprimir();
        sec.incsalario(0);
        sec.imprimir();

    }
    
}
