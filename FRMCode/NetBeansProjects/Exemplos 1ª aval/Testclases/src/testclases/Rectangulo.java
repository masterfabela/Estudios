package testclases;

public class Rectangulo {
    float base, altura;
    public float getbase(){
        return base;
    }
    public float getalt(){
        return altura;
    }
    public void setbase(float base){
        this.base=base;
    }
    public void setalt(float altura){
    this.altura=altura;
    }
    public Rectangulo(float ba, float alt){
    base=ba;
    altura=alt;
    }
    public Rectangulo(float ba){
    this(ba,4);
    }
    @Override
    public String toString(){
    return "Base:"+base+"\nAltura:"+altura;
    }
    public Rectangulo incrementar(){
    base++;
    altura+=2;
    return this;
    }
    public float calcarea(){
    float area=base*altura;
    return area;
    }
    public Rectangulo mudarbase(){
    base=15;
    return this;
    }
    
}
