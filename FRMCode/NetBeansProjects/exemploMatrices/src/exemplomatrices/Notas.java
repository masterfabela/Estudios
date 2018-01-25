package exemplomatrices;
/**
 *
 * @author femio23
 */
public class Notas {
    int[][]notas=new int[4][3];
    
    public void crearTaboa(){
    for(int f=0;f<notas.length;f++){
        for(int c=0;c<notas[f].length;c++){
        notas[f][c]=(int)(1+Math.random()*10);
        }
    }
    }
    public void amosar(){
        System.out.println("    Prog||BD||COD");
    for(int f=0;f<notas.length;f++){
        esquerda(f);
        for(int c=0;c<notas[f].length;c++){
            
            System.out.print(" "+notas[f][c]+"   ");
        }
        System.out.println("");
    }
    }
    public void medialumno(){
        int media=0;
        System.out.println("");
        System.out.println("    Prog||BD||COD");
    for(int f=0;f<notas.length;f++){
        System.out.println("");
        esquerda(f);
        for(int c=0;c<notas[f].length;c++){
            System.out.print(" "+notas[f][c]+"   ");
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
    public void esquerda (int i){
        switch(i){
            case 0: 
                System.out.print("AA||");
                break;
            case 1:
                System.out.print("BB||");
                break;
            case 2:
                System.out.print("CC||");
                break;
            case 3:
                System.out.print("DD||");
                break;
            default:
                System.out.println("Error.");
        }
    
    }
}
