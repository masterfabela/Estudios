
package exemplotrychatch;

public class Exemplotrychatch {

    public static void main(String[] args) {
        /*Captura c1=new Captura();
        c1.dividircaptura()*/
        /*Varioscatch vc1=new Varioscatch();
        vc1.dividirVC();*/
        /*Con_Finally cf1=new Con_Finally();
        cf1.dividirCF();*/
        /*
        PropagarExcepcion pe1=new PropagarExcepcion();
        try{
        pe1.dividirPE();
        }catch(ArithmeticException ex){//Aqui se recive a excepcion
            System.out.println(ex.getMessage());
        }*/
        DividirExcepcionsPropias dep1=new DividirExcepcionsPropias();
        try{
        dep1.dividirEP();
        }
        catch(ExcepcionsPropias ep1){
            System.out.println(ep1.getMessage());
        }
        
        System.out.println("Remata o programa.");
    }
    
}
