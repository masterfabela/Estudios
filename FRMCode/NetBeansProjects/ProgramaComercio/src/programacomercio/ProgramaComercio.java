package programacomercio;

public class ProgramaComercio {

    public static void main(String[] args) {
        //datos ventas
        String [] nv= {"2","1","3"};
        String [] rprod={"rf2","rf1","rf3"};
        float[] cant={1.5f,2f,3f}; 
        Ventas v1=new Ventas(nv,rprod,cant);
        
        //datos prezos
        float[]prez={2,3,8};
        String[]rprez={"rp2","rp1","rp3"};
        Prezos p1=new Prezos(rprez,prez);
        Metodos m1=new Metodos();
        String mem=m1.buscarnv(v1);
        
    }
    
}
