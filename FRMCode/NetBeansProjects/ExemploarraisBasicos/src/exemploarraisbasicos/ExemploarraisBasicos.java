package exemploarraisbasicos;

import java.util.Arrays;
import libarray.MetodosArray;
public class ExemploarraisBasicos {

    public static void main(String[] args) {
        Temperatura t1=new Temperatura();
        float []temp ;
        temp=new float[5];
        temp[0]=7;
        temp[1]=4;
        temp[2]=1;
        temp[3]=3;
        temp[4]=10;
        for(int i=0;i<temp.length;i++){
        System.out.println(temp[i]);}
        System.out.println("");
        //Arrays.sort(temp);
        t1.ordenar(temp);
        
        for(int i=0;i<temp.length;i++){
        System.out.println(temp[i]);}
        System.out.println("");
        MetodosArray.reverseorder(temp);
        for(int i=0;i<temp.length;i++){
        System.out.println(temp[i]);}
        
    }
    
}
