package boletin9_1;

public class Numeros {
    int p,n,cero;
    
    public Numeros(){}
    public void calcular(int num){
        if(num>0){
        p=p+1;
        }else{
            if(num==0){
            cero=cero+1;
            }else{
            n=n+1;
            }
        }
    }
    @Override
    public String toString(){
    return "A serie posue:\n"+p+" numeros positivos.\n"+cero+" ceros.\n"+n+" numeros negativos.";
    }
}
