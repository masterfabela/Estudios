
package exemploswitch;
import java.util.Scanner;
public class Exemploswitch {

    public static void main(String[] args) {
        System.out.println("***Menu principal:***\n Elixa un dia da semana.\n1:Luns.\n2:Martes.\n3:Mercores.\n4:Xoves."+
                "\n5:Venres.\n6:Sabado\n7:Domingo.");
        Scanner sc=new Scanner(System.in);
        String op=sc.nextLine();
        metodos m=new metodos();
        m.comparar(op);
    }
    
}
