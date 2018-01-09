package boletin9_4;
public class Tablas {
    public Tablas(){}
    public void calcular(int n){
    System.out.println("A taboa do "+n+" é:");
    for(int i=0;i<11;i++){
        System.out.println("-"+n+"x"+i+"="+(n*i)+".");
    }
    }
}
