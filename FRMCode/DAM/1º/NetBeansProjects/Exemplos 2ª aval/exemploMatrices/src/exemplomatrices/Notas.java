package exemplomatrices;

public class Notas {
    int[][]notas=new int[4][3];
     int[]m1=new int[3];
    
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
    public void mediamodulo(){
    for(int f=0;f<3;f++){
        int m=0;
        for(int c=0;c<4;c++){
            m+=notas[c][f];
        }

        m1[f]=m/4;
        }

    }
    public void amosarnm(){
        System.out.println("\n   Medias modulos.");
        System.out.println("PROG||BD||COD");
        System.out.println(" "+m1[0]+"  ||"+m1[1]+" ||"+m1[2]);
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
