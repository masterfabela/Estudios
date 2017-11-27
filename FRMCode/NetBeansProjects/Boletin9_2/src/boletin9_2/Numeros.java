
package boletin9_2;

public class Numeros {
    long vs,vp=1;
    public Numeros(){}
    public void calcular(){
    for(int i=10;i<91;i++){
        vs=vs+i;
        vp=vp*i;
    
    }
        System.out.println("O valor total de suma é "+vs+", e o valor total do producto "+vp+".");
        //VP devolve 0 porque sobrepasa a capacidade do tipo Long.
    }
}
