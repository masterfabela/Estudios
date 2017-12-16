package boletin11;

public class Adestrador extends Persoa{
    private String idFederacion;
    public Adestrador(int di, int i,String n,String a,String idf){
    super(n,a,i,di);
    idFederacion=idf;
    }

    public String getIdFederacion() {
        return idFederacion;
    }

    public void setIdFederacion(String idFederacion) {
        this.idFederacion = idFederacion;
    }
    
    public void dirixirPartido(){}
    public void dirixirAdestramento(){}
    
    public String toString(Adestrador m){
    return "Datos da persoa indicada:\nNome:"+m.getNome()+"\nApelidos:"+m.getApelido()+"\nId:"+getId()+"\nIdade:"+getIdade()+"\nId da federacion"+m.getIdFederacion();
    }
}
