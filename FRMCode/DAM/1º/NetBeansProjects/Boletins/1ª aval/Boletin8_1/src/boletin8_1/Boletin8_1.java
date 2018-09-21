package boletin8_1;
import java.util.Scanner;

public class Boletin8_1 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
      /*//Primeiro exercicio
        for(int i=0;i<5;i++){
           System.out.println("Isto é un bucle");
       }*/
      
      
      /*//Segundo exercicio
      int j=0;
      do{
      int n=sc.nextInt();
          System.out.println("O mumero é o "+n);
      j++;
      }while (j<5) ;*/
      
      
      /*//Terceiro exercicio
      int n;
      do{
      n=sc.nextInt();
          System.out.println("O mumero é o "+n);
      }while (n!=0) ;*/
      
      
      /*//Cuarto Exercicio
      int n,i=0;
      do{
      n=sc.nextInt();
      System.out.println("O mumero é o "+n);
      i++;
      }while(n>0&&i<4);*/
      
      
      /*//Quinto Exercicio
      int n,i=0,m=0;
      do{
      n=sc.nextInt();
      m=m+n;
      System.out.println("O mumero é o "+n+", e a suma, "+m);
      i++;
      }while(n>0&&i<4);*/
      
      
      /*//Sexto Exercicio
        double b;
        System.out.println("Introduza a o lado do cadrado do que se calculará a area:");
        double l=sc.nextFloat();
        b=Math.pow(l,2);
        System.out.println("O area é "+b);*/
        
      
         /*//Séptimo Exercicio
        double b;
        System.out.println("Introduza a o lado do cadrado do que se calculará a area:");
        double l=sc.nextFloat();
        do{
            System.out.println("Erro, o numero debe ser positivo.\nTenteo de novo.");
            l=sc.nextFloat();
        }while(l<0);
        b=Math.pow(l,2);
        System.out.println("O area é "+b);*/
      
        
        /*//Oitavo Exercicio
        double l=1;
        while(l!=0){
        double b;
        System.out.println("Introduza a o lado do cadrado do que se calculará a area:");
        l=sc.nextFloat();
        while(l<0){
            System.out.println("Erro, o numero debe ser positivo.\nTenteo de novo.");
            l=sc.nextFloat();
        }
        b=Math.pow(l,2);
        System.out.println("O area é "+b);}*/
      
      
      /*//Noveno Exercicio
      int s=0;
      while(s<100){
      int n=sc.nextInt();
      s=s+n;
          System.out.println("Suma "+s);
      }*/
      
      /*//Decimo Exercicio
      int m=0;
      for(int i=0;i<6;i++){
          System.out.println("Nota do "+(i+1)+"º modulo");
          int n=sc.nextInt();
          m=m+n;
      } System.out.println("A nota media é "+(m/6));*/
      
      
      /*//Undecimo Exercicio
      int m=0;
      for(int j=0;j<3;j++){
          System.out.println((j+1)+"º Alumno.");
          m=0;
      for(int i=0;i<6;i++){
          System.out.println("Nota do "+(i+1)+"º modulo");
          int n=sc.nextInt();
          m=m+n;
      } System.out.println("A nota media do "+(j+1)+"º alumno é "+(m/6));}*/
      
      
      /*//Duodecimo Exercicio
      String seguir="si";
      int m=0,j=0;
      
      while(seguir =="si"){
          System.out.println((j+1)+"º Alumno.");
          m=0;
      for(int i=0;i<6;i++){
          System.out.println("Nota do "+(i+1)+"º modulo");
          int n=sc.nextInt();
          m=m+n;
      } 
      System.out.println("A nota media do "+(j+1)+"º alumno é "+(m/6));
      j++;
          System.out.println(j);
          System.out.println("Desexa seguir?");
          seguir=sc.next();
      }*/
      
      
    }
    
    
}
