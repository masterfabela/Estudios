package exemplobucles;
import java.util.Scanner;
public class ExemploBucles {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Elixa a estructura repetitiva que vai a usar:"+
                "\n1=While.\n2=Do...while.\n3=For.");
        int mem=sc.nextInt();
        switch(mem){
            case 1:
                bucleWhile bw=new bucleWhile();
                System.out.println(bw.calcw());
                break;
            case 2:
                BucleDoWhile bdw=new BucleDoWhile();
                System.out.println(bdw.calcdw());
                break;
            case 3:
                BucleFor bf=new BucleFor();
                System.out.println(bf.calcf());
                break;
                
        }
        
        
        
        }
        
    }
    

