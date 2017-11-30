
package boletin11;

public class Boletin11 {

    public static void main(String[] args) {
        Persoa p1=new Persoa("Ana","Cosme",25,1);
        p1.concentrarse();
        p1.viaxar();
        Xogador x1=new Xogador(2,25,7,"Pepe","Torres","Dianteiro");
        x1.concentrarse();
        x1.viaxar();
        Adestrador a1=new Adestrador(3,31,"Maika","Rovira","A1");
        a1.concentrarse();
        a1.viaxar();
        Masaxista m1=new Masaxista("Fran","Romay",22,4,0,"Tecnico de Teleco");
        m1.concentrarse();
        m1.viaxar();
        System.out.println(m1.getApelido());
    }
    
}
