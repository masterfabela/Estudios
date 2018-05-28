package programacomercio;

public class Productos {
    String rprod,nome,rprez;
    public Productos(String pro,String n,String pre){
        this.rprod=pro;
        this.nome=n;
        this.rprez=pre;
    }

    public String getRprod() {
        return rprod;
    }

    public String getNome() {
        return nome;
    }

    public String getRprez() {
        return rprez;
    }
    
}
