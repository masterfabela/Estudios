
package boletin4_4;

public class Almacen {
    int kpo,kpa;
   
   public void engadirPolbo(int x ){
   kpo=x;
   }
   public void engadirPatacas( int x){
   kpa=x;
   }
   public void amosarPolbo(){
       System.out.println(kpo);
   }
   public void amosarPatacas(){
   System.out.println(kpa);
   }
   public void calclientes(){
       int m1=kpo/2;
       if(m1>kpa){
           System.out.println("Cos productos do almacen, podemos atender a "+kpa*3+" persoas");
       }else{
       System.out.println("Cos productos do almacen, podemos atender a "+m1*3+" persoas");
       }
   }
}
