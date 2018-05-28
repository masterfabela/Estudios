package programacomercio;
import com.fran.metodos.Entradaspred;

public class ProgramaComercio {

    public static void main(String[] args) {
        Ventas[]v1={new Ventas("1","rf1",7),new Ventas("2","rf2",9),new Ventas("3","rf3",4)};
        Productos[]p1={new Productos("rf1","Uvas","rp1"),new Productos("rf2","Coles","rp2"),new Productos("rf3","Fresas","rp3")};
        Prezos[]pr1={new Prezos("rp1",2),new Prezos("rp2",5),new Prezos("rp3",4)};
        Metodos m1=new Metodos();
        m1.impfact(v1, p1, pr1);
        
        String memo=Entradaspred.pedirString("Introduce numero de venta");
        m1.searchelem(v1, p1, pr1, memo);
        
    }
    
}
