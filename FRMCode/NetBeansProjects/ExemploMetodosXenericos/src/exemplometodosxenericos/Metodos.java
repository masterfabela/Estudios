
package exemplometodosxenericos;

import java.util.*;

public class Metodos {
   public static <T> void amosar(ArrayList<T>lista){
       Iterator it=lista.iterator();
       while(it.hasNext())
       System.out.println(it.next());
   }
   public static <T> void eliminar(ArrayList<T>lista,int pos){
       lista.remove(pos);
   }
   public static <T> void eliminarsiten(ArrayList<T>lista,String s){
       Iterator it=lista.iterator();
       while(it.hasNext()){
           if(it.equals(s)){
               it.remove();
           }
       }
   }
}
