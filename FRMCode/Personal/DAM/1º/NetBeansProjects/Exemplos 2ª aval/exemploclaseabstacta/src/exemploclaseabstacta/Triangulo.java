package exemploclaseabstacta;

public class Triangulo extends Poligono {

    public Triangulo(float base, float altura) {
        super(base, altura);
    }
    
    @Override
    public void diarea(){
        System.out.println("El área es:"+(getBase()*getAltura())/2);//podo acceder, co propio metodo, con this, con super, ou co propio obxeto
    }                                                               //e dicir: getBase(),t.getBase(),this.getBase() ou super.getBase();
}
