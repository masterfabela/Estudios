package programacomercio;

public class Productos {
    String rprod,nome,rprez;
    public Productos(String rp,String n,String pr){
        this.rprod=rp;
        this.nome=n;
        this.rprez=pr;
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
