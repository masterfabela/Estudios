package boletin17_3;

public class Boletin17_3 {

    public static void main(String[] args) {
        int n=5;
        int[]lnotas=new int[n];
        String[]lnomes=new String[n];
        Metodos m1=new Metodos();
        lnotas=m1.creadorn(lnotas);
        lnomes=m1.creadorp(lnomes);
        for(int i=0;i<lnotas.length;i++){
            System.out.println("Alumno: "+lnomes[i]+" - Nota: "+lnotas[i]);
        }
        //m1.cualificador(lnotas,lnomes);
        //m1.buscador(lnotas,lnomes);
        lnotas=m1.ordec(lnotas,lnomes);
        for(int i=0;i<lnotas.length;i++){
            System.out.println("Alumno: "+lnomes[i]+" - Nota: "+lnotas[i]);
        }
    }
    
}
