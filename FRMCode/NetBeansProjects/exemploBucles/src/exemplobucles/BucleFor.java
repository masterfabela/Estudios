package exemplobucles;
import java.util.Scanner;
public class BucleFor {
   Scanner sc=new Scanner(System.in);
    int suma=0;
    int produto=1; 
    public String calcf(){
        System.out.println("Iniciando bucle for");
    for(int i=0;i<7;i++){
            System.out.println("Introduce un numero");
            int num = sc.nextInt();
            suma= suma + num;
            produto=produto*num;
    }
        return("A suma total é "+suma+" e o producto total é "+produto+".");
}
}
