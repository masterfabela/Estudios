package exemploclaseabstacta;

public abstract class Poligono {
    private float base,altura;

    public Poligono(float base, float altura) {
        this.base = base;
        this.altura = altura;
    }
    

    public float getBase() {
        return base;
    }

    public float getAltura() {
        return altura;
    }
    public abstract void diarea();
}
