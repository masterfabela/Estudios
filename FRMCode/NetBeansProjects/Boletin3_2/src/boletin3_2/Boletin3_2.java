package boletin3_2;
import java.utils.Scanner;
public class Boletin3_2 {

    public static void main(String[] args) {
        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
                System.out.println("Vai a lanzar un novo satelite,introduza os seguintes datos:");
                System.out.println("Meridiano:");
                double m=sc.nextDouble();
                System.out.println("Paralelo:");
                double p=sc.nextDouble();
                System.out.println("Distacia:");
                double d=sc.nextDouble();
                Satelite meteosat=new Satelite(m,p,d);
                meteosat.verPosicion();    }
    }
    
}
