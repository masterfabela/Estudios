/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin3_1;
import java.util.Scanner;
public class Boletin3_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Coche car=new Coche();
        System.out.println("A velocidade actual do coche é de "+car.getVelocidade()+" Km/h.");
        System.out.println("Vai vostede a aceleralo coche, diga a velocidade que quere que alcance");
        int n= sc.nextInt();
        car.acelerar(n);
        System.out.println("A velocidade actual do coche é de "+car.getVelocidade()+" Km/h.");
        System.out.println("Vai vostede a frenalo coche, diga a velocidade que quere que alcance");
        n= sc.nextInt();
        car.frenar(n);
        System.out.println("A velocidade actual do coche é de "+car.getVelocidade()+" Km/h.");
    }
    
}
