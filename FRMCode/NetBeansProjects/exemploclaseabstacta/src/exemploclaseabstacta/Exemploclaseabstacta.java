package exemploclaseabstacta;

public class Exemploclaseabstacta {

    public static void main(String[] args) {
        //Poligono p1=new Poligono(4f,5f);  //Non se pode instanciar, é abstract.
        Rectangulo r1=new Rectangulo(4f,5f);
        Triangulo t1=new Triangulo(4f,5f);
        r1.diarea();
        t1.diarea();
    }
    
}
