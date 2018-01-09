
package boletin15;

import javax.swing.JOptionPane;

public class Boletin15 {

    public static void main(String[] args) {
        String s="Si";
        int ba,bp;
         while(s.equals("Si")) {
        JOptionPane.showMessageDialog(null,"Buenos dias, bienvenido al sistema de calculo de notas.");
        try{
        bp=Integer.parseInt(JOptionPane.showInputDialog("Introduzca el numero de boletines totales que\ndeberian haber entregado los alumnos:"));
        ba=Integer.parseInt(JOptionPane.showInputDialog("Introduzca el numero de boletines totales\n que ha entregado el alumno:"));
         if(bp<0||ba<0){
        throw new Errorexception();
        }
        }catch(Errorexception ex1){
            JOptionPane.showMessageDialog(null,ex1.getMessage());
        }finally{
            do{
        bp=Integer.parseInt(JOptionPane.showInputDialog("Introduzca el numero de boletines totales que\ndeberian haber entregado los alumnos:"));
        ba=Integer.parseInt(JOptionPane.showInputDialog("Introduzca el numero de boletines totales\n que ha entregado el alumno:"));
            }while(bp<0&&ba<0);
        }
        Boletin b1=new Boletin();
        Ppractica pp1=new Ppractica();
        Pteorica pt1=new Pteorica();
        double m1=b1.cboletin(ba, bp);
        double m2=pp1.cpractica();
        double m3=pt1.cpteorica();
       s=JOptionPane.showInputDialog("********Notas********"+
                                 "\nProbas Teoricas: "+String.format("%.2f",m3)+
                                 "\nProba Práctica: "+String.format("%.2f",m2)+
                                 "\nBoletins: "+String.format("%.2f",m1)+
                                 "\nNota Total: "+String.format("%.2f",m1+m2+m3)+
                                 "\n¿Desea calcular mas notas?");
       }
         JOptionPane.showMessageDialog(null,"Pase un buen dia");

       }
       }
        
    
    

