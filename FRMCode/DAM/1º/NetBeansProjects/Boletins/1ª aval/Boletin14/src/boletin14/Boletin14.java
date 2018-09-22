
package boletin14;

public class Boletin14 {

    public static void main(String[] args) {
        System.out.println("****Sistema iniciado****");
        Garaxe g1=new Garaxe();
        System.out.println("Bos dias");
        try{
        g1.probsitio();
        Coches c1=new Coches(g1.m,g1.t);
        c1.preciar();
        g1.saida(c1);
        }catch(SobrecochesException sce1){
            System.out.println(sce1.getMessage());
            System.out.println("Sentimolo, probe mais tarde, que teña un bo dia.");
        }
        
    }
    
}
