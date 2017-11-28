package boletin11;

public class Adestrador extends Persoa{
    String idFederacion;
    public Adestrador(int di, int i,String n,String a,String de){
    super(n,a,i,di);
    idFederacion=de;
    }
    public void dirixirPartido(){}
    public void dirixirAdestramento(){}
    
    
    @Override
    public String toString(){
    return "Datos da persoa indicada:\nNome:"+nome+"\nApelidos:"+apelido+"\nId:"+id+"\nIdade:"+idade+"\nId da federacion"+idFederacion;
    }
}
