/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemploarraisbasicos;

/**
 *
 * @author femio23
 */
public class Temperatura {
    public void ordenar (float[]temp){
    int i,j;
    float aux;
    for(i=0;i<temp.length-1;i++){
        for(j=i+1;j<temp.length;j++){
            if(temp[i]>temp[j]){
                aux=temp[i];
                temp[i]=temp[j];
                temp[j]=aux;
            }
        }
    }
    }
}
