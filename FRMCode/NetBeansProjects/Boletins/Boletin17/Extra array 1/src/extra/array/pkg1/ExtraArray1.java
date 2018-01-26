package extra.array.pkg1;

import java.util.Arrays;

/*crear un programa que lea a altura de 20 persoas, que calcule a altura media 
e cantas persoas teñen altura superior á media, e a porcentaxe de persoas con 
altura inferior a media e ordear por altura de maior a menor.*/
public class ExtraArray1 {

    public static void main(String[] args) {
        Metodos m1=new Metodos();
        int n=3;
        Persoa[]persoas=new Persoa[n];
        persoas=m1.creador(persoas);
        float media=m1.mediador(persoas);
        int m=m1.cuantificador(persoas, media);
        m1.cuantinf(persoas, media);
        for (Persoa p0 : persoas) {
            System.out.println(p0.nome+" mide "+p0.altura+" metros.");
        }
        //Falta ordenar, ollo cos nomes.
        Arrays.sort(persoas);
    }
    
}
