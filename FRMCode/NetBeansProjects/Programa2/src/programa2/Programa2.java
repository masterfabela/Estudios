package programa2;

public class Programa2 {

    public static void main(String[] args) {
       //proba de incrementos-decrementos
       int num1=5,resultado;
       resultado=num1++;//post-incremento
       System.out.println("Resultado="+resultado+", e num="+num1 );
       resultado=++num1;//pre-incremento
       System.out.println("pero resultado="+resultado+", e num="+num1 );
       //proba de simplificación
       resultado+=3;
       System.out.println(resultado);
       int modulo=resultado%3;//proba modulo
       System.out.println("resto="+modulo);
       int cociente=resultado/num1;
       System.out.println("cociente="+cociente);
       
    }
    
}
