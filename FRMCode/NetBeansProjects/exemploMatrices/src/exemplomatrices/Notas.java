package exemplomatrices;
import libarray.MetodosArray;
/**
 *
 * @author femio23
 */
public class Notas {
    int[][]notas=new int[4][3];
    
    public void crearTaboa(){
    for(int f=0;f<notas.length;f++){
        for(int c=0;c<notas[f].length;c++){
        notas[f][c]=MetodosArray.lerint();
        }
    }
    }
    public void amosar(){
    for(int f=0;f<notas.length;f++){
        for(int c=0;c<notas[f].length;c++){
            System.out.print(notas[f][c]+" ");
        }
        System.out.println("");
    }
    }
    public void amosar2(int[]array){
        System.out.println("");
    for(int f=0;f<array.length;f++){
        System.out.println(notas[f]);
    }
    }
    public void medialumno(){
        int media=0;
    for(int f=0;f<notas.length;f++){
        System.out.println("");
        for(int c=0;c<notas[f].length;c++){
            System.out.print(notas[f][c]+" ");
            media=media+notas[f][c];
        }
        System.out.print("<-- AVG="+(media/notas[f].length));
        media=0;
    }
    }
    public int[] medialumno2(){
        int[]m1=new int[notas.length];
    int media=0;
    for(int f=0;f<notas.length;f++){
        for(int c=0;c<notas[f].length;c++){
            media=media+notas[f][c];
            m1[f]=(media/notas[f].length);
        }
    m1[f]=(media/notas[f].length);   
        }
    return m1;
    }
    public int[] mediamodulo(){
        int[]m1=new int[notas.length];
    int media=0;
    for(int c=0;c<notas.length;c++){
        for(int f=0;f<notas[c].length;f++){
            media=media+notas[f][c];
            m1[c]=(media/notas[c].length);
        }
    m1[c]=(media/notas[c].length);   
        }
    return m1;
    }
}
