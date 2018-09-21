package boletin17_2;

public class Boletin17_2 {

    public static void main(String[] args) {
        int[]lnotas=new int[30];
        Metodos m1=new Metodos();
        lnotas=m1.creador(lnotas);
        for(int i=0;i<lnotas.length;i++){
            System.out.println(lnotas[i]);
        }
        m1.cualificador(lnotas);
        m1.mediador(lnotas);
        m1.mathonra(lnotas);
        
    }
    
}
