package boletin5_3;
class Numero{
    int valor;
    public Numero(int n){
        valor=n;
    }
    public int getv(){
        return valor;
    }
    public void getsigno(){
    if(valor>0){
        System.out.println("+");
    }else{
    if(valor<0){
        System.out.println("-");
    }else{System.out.println("0");}
    }
}
}