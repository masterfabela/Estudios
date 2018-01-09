package exemplopaquetes;
import com.fran.taller.Taller;
import com.fran.venta.Ventas;

public class ExemploPaquetes {

    public static void main(String[] args) {
        Coches coche1=new Coches("1234");
        Coches coche2=new Coches("1111");
        Ventas coh1=new Ventas(coche1,1200,"citröen");
        Taller coh2=new Taller(coche2,500f);
        System.out.println(coh1.toString());
        System.out.println(coh2.toString());
        coh2.desconto(coche1, coche2);
        System.out.println(coh1.toString());
        System.out.println(coh2.toString());
    }
    
}
