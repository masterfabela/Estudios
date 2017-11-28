package boletin11;

public class Xogador extends Persoa{
    int dorsal;
    String demarcacion;
    public Xogador(int di, int i,int d,String n,String a, String de){
        super(n,a,i,di);
        dorsal=d;
        demarcacion=de;
    }
    public void xogarPartido(){}
    public void adestrar(){}
    
    
    @Override
    public String toString(){
    return "Datos da persoa indicada:\nNome:"+nome+"\nApelidos:"+apelido+"\nId:"+id+"\nIdade:"+idade+"\nDorsal:"+dorsal+"\nDemarcacion:"+demarcacion;
    }
}
