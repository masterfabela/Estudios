package exemplo_atrib_obx;

public class Conta {
    private Persoa titular;//non ten valores por non estar o obxeto creado.
    private double saldo;
    public Conta(){
        titular=new Persoa();//Isto é equivalente a: "int v; v=0;", xa que esta é a evaluacon.
    
    }
    public Conta (String nome,String dni,double saldo){
        titular=new Persoa();
    titular.setnome(nome);
    titular.setdni(dni);
    this.saldo = saldo;
    }
    public Conta(Persoa ti, double s){
    titular=ti;
    this.saldo=s;
    }
    public void setnome(String n){
    titular.setnome(n);
    }
    public void setdni(String d){
    titular.setdni(d);
    }
    public void setsaldo(double s){
    saldo=s;
    }
    public String getnome(){
    return titular.getnome();
    }
    public String getdni(){
    return titular.getdni();
    }
    public double getsaldo(){
    return saldo;
    }
    public void setTitular(String n,String d,double s){
        titular.setnome(n);
        titular.setdni(d);
        saldo=s;
    }
    public Persoa getTitular(){
    return titular;
    }
    @Override
    public String toString(){
    return("O titular é "+titular+".\nE o saldo dispoñible é de "+//Por herdanza, recoñoce o toString de persoa, por defecto
            saldo+" euros.");
    }
}
