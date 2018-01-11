package exemploclaseabstacta;

public class Triangulo extends Poligono {

    public Triangulo(float base, float altura) {
        super(base, altura);
    }
    
    @Override
    public void diarea(){
        System.out.println("El área es:"+(getBase()*getAltura())/2);
    }
}
