
package exemplobucles;

import java.util.Scanner;

public class bucleWhile {
    Scanner sc=new Scanner(System.in);

    int suma=0;
    int produto=1;
    public String calcw(){
        System.out.println("Iniciando bucle while");
        int i=0;
        while(i<7){
        System.out.println("Introduce un numero");
            int num = sc.nextInt();
            suma= suma + num;
            produto=produto*num;
            i++;
            }
            return("A suma total é "+suma+" e o producto total é "+produto+".");
    }
}

