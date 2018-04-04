package exemploclaseabstacta;

public class Rectangulo extends Poligono{

    public Rectangulo(float base, float altura) {
        super(base, altura);
    }
    
    @Override
    public void diarea(){
        System.out.println("O área é:"+getBase()*getAltura());
    }
}
