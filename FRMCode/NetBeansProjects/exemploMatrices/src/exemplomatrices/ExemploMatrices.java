package exemplomatrices;

public class ExemploMatrices {

    public static void main(String[] args) {
        Notas n1=new Notas();
        int [] medias= new int[4]; 
        n1.crearTaboa();
        n1.amosar();
        n1.medialumno();
        medias=n1.medialumno2();
        n1.amosar2(medias);
        //medias=n1.mediamodulo();
        //5n1.amosar2(medias);
    }
    
}
