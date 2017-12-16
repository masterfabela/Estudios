package boletin11;

public class Xogador extends Persoa{
    private int dorsal;
    private String demarcacion;
    public Xogador(int di, int i,int d,String n,String a, String de){
        super(n,a,i,di);
        dorsal=d;
        demarcacion=de;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getDemarcacion() {
        return demarcacion;
    }

    public void setDemarcacion(String demarcacion) {
        this.demarcacion = demarcacion;
    }
    
    public void xogarPartido(){}
    public void adestrar(){}
    
    public String toString(Xogador m){
    return "Datos da persoa indicada:\nNome:"+m.getNome()+"\nApelidos:"+m.getApelido()+"\nId:"+getId()+"\nIdade:"+getIdade()+"\nDorsal:"+m.getDorsal()+"\nDemarcacion:"+m.getDemarcacion();
    }
}
