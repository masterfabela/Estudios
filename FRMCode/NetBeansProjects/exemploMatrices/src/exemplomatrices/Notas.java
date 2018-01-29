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
        System.out.print("    Prog||BD||COD");
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
    public int[] mediamodulo(){
        int[]m1=new int[3];
    int media=0;
    for(int c=0;c<4;c++){
        for(int f=0;f<3;f++){
            //media=media+notas[c][f];
            System.out.println(notas[c][f]);
        }
    //m1[c]=media/4;
    //media=0;
        }
    return m1;
    }
    public void amosarnm(int[]n){
        System.out.println("\n   Medias modulos.");
        System.out.println("PROG||BD||COD");
        System.out.println(" "+n[0]+"  ||"+n[1]+" ||"+n[2]);
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
