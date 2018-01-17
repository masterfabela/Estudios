package Arrays;

public class MetodosArray {
    public static void reverseorder(float[]array){
    int i,j;
    float aux;
    for(i=0;i<array.length-1;i++){
        for(j=i+1;j<array.length;j++){
            if(array[i]>array[j]){
                aux=array[i];
                array[i]=array[j];
                array[j]=aux;
                }
            }
        }
    }
}
