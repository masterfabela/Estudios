package programa3;

public class Programa3 {

    public static void main(String[] args) {
        //conversión de tipos 
        int enteiro=3;
        float decimal=2.5f;//forzamos o paso de double a float
        decimal=enteiro;//conversión directa por compativilidade.
        System.out.println(decimal);
        //enteiro=decimal; Erro debido a incompativilidade de conversión directa.
        decimal=2.5f;
        enteiro=(int)decimal;
        System.out.println(enteiro);
        
    }
    
}
