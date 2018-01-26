package extra.array.pkg1;

import javax.swing.JOptionPane;

/*crear un programa que lea a altura de 20 persoas, que calcule a altura media 
e cantas persoas teñen altura superior á media, e a porcentaxe de persoas con 
altura inferior a media e ordear por altura de maior a menor.*/
public class Metodos {

    public Metodos() {
    }
    
    
    public Persoa[] creador(Persoa[]array){
        String nome;
        float alt;
        for(int i=0;i<array.length;i++){
            nome=JOptionPane.showInputDialog("Introduza o nome da "+(i+1)+"ª persoa:");
            alt=(float)(Math.random()+1);
            Persoa p1=new Persoa(alt,nome);
        array[i]=p1;
        }
    return array;
    }
   public float mediador(Persoa[]array){
        float ac=0;
    for(Persoa p0 :array){
            ac=ac+p0.altura;
        }
        System.out.println("A altura media deste grupo é de "+(ac/array.length)+" metros.");
        return ac/array.length;
    }
    public int cuantificador(Persoa[]array,float m){
    int n=0;
    for(Persoa p0 :array){
    if(p0.altura>m)
        n++;
    }
    if(n==0)
            System.out.println("Ninguen deste grupo supera a media.");
    else
            System.out.println(n+" persoas superan a media.");
    return n;
    }
    public void cuantinf(Persoa[]array,float m){
    float n=0;
    for(Persoa p0 :array){
    if(p0.altura<m)
        n++;
    }
    n=(n*100)/array.length;
    System.out.println("A porcentaxe de persoas con altura\ninferior á media é do"+n+"%.");
    }
}
