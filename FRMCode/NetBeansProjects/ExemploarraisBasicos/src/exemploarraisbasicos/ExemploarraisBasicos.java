package exemploarraisbasicos;

import java.util.Arrays;
import libarray.MetodosArray;
public class ExemploarraisBasicos {

    public static void main(String[] args) {
        float []temp ;
        temp=new float[4];
        temp[0]=7;
        temp[1]=4;
        temp[2]=1;
        temp[3]=3;
        for(int i=0;i<temp.length;i++){
        System.out.println(temp[i]);}
        Arrays.sort(temp);
        for(int i=0;i<temp.length;i++){
        System.out.println(temp[i]);}
        MetodosArray.reverseorder(temp);
        for(int i=0;i<temp.length;i++){
        System.out.println(temp[i]);}
        
    }
    
}
