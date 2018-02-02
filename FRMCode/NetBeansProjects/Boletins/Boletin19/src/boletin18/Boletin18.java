package boletin18;

import javax.swing.JOptionPane;

public class Boletin18 {

    public static void main(String[] args) {
        Buzon m1=new Buzon();
        Correo c1=new Correo("Benvido ó seu servizo de correo.",true);
        Correo c2=new Correo("Acordate de darlle ás galiñas.",true);
        m1.c.add(c1);
        m1.engade(c2);
        System.out.println(m1.amosaPrimerNoLeido());
        if(m1.porLer()==false){
            System.out.println("Quedan correos por ler");
        }else{
            System.out.println("Todo lido");
        }
        System.out.println(m1.amosa(Integer.parseInt(JOptionPane.showInputDialog("Que correo (por orde de chegada) desexa ver?"))));
        m1.scramble();
        m1.engade(new Correo("Estaría vostede interesado en invertir en criptomoedas?",false));
        m1.scramble();
        m1.elimina(2);
        m1.scramble();
        
    }
    
}
