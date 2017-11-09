package exemplobucles;

import java.util.Scanner;

public class BucleDoWhile {
    Scanner sc=new Scanner(System.in);

    int suma=0;
    int produto=1;
    public String calcdw(){
        System.out.println("Iniciando bucle do...while");
        int i=0;
        do{
            System.out.println("Introduce un numero");
            int num = sc.nextInt();
            suma= suma + num;
            produto=produto*num;
            i++;
        }while(i<7);
        return("A suma total é "+suma+" e o producto total é "+produto+".");
}
}
