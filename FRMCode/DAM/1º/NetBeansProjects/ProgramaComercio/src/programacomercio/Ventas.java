package programacomercio;

public class Ventas {
    
    String nv;
    String rprod;
    int cant;    

    public String getNv() {
        return nv;
    }

    public String getRprod() {
        return rprod;
    }

    public float getCant() {
        return cant;
    }

    public Ventas(String f, String g, int l){
        this.nv=f;
        this.rprod=g;
        this.cant=l;
        
    }
}
