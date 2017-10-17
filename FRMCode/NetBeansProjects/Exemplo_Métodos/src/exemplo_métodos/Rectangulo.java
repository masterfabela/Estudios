package exemplo_métodos;

public class Rectangulo {
    private float base,altura;
    //constructores
    public Rectangulo(){
    
}
    public Rectangulo(float ba,float alt){
        base=ba;
        altura=alt;
    }
//metodos de acceso, sets e gets

public void setBase(float b){
base=b;
}
public float getBase (){
return base;
}
public void setAltura(float a){
altura=a;
}
public float getAltura (){
return altura;
}

public void amosar(){
    System.out.println("A base é de "+getBase+"uds.\n "
            + "e a altura é de "+getAltura+"uds.");
} 
}