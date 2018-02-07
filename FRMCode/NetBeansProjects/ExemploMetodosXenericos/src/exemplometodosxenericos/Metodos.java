
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
//   public static <T> void eliminar1(ArrayList<T>lista,){
//       for(<T> l1:lista){
//       
//       }
//   }
}
