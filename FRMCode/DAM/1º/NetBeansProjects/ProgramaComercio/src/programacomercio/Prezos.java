package programacomercio;

public class Prezos {
    int prez;
    String rprez;
    
    public Prezos(String p,int f){
    this.prez=f;
    this.rprez=p;
    }

    public float getPrez() {
        return prez;
    }

    public String getRprez() {
        return rprez;
    }
    
}
