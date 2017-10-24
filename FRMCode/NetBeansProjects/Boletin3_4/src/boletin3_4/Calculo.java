package boletin3_4;
public class Calculo {
    private int po;
    private int pa;
    public Calculo(){ 
    }
  public void engadirPolbo(int x ){
  po=x;
  }
  public void engadirPatacas( int x){//Engade x kg de patacas
  pa=x;
  }          
  public void amosarPolbo(){//Amosa por pantalla os kg de polbo que ten no almacen
      System.out.println("Temos un total de "+po+" kg de polbo no almacen");
  }
  public void amosarPatacas(){
   System.out.println("Temos un total de "+pa+"kg de patatas no almacen");
  }
public int clientesposibles (){
   int resul,n1,n2;
   n1=po/2;
   n2=pa;
   if (n1<n2){
       resul=3*n1;
      }else{
       resul=3*n2;
   }
   return resul;
}
}
