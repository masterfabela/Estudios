
package boletin9_3;

public class Rectangulos {
    float base,altura;
    public Rectangulos(float b,float a){
    base=b;
    altura=a;
    }
    public void calcarea(){
    float area=base*altura;
        System.out.println("A area é de "+area+" unidades cadradas.");
    }
}
