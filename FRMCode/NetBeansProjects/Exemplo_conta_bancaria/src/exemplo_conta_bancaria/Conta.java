
package exemplo_conta_bancaria;

public class Conta {
    String nome;
    String numConta;
    double saldo;
public Conta(){

}
public Conta(String n,String nc, double s){
nome=n;
numConta=nc;
saldo=s;
}
public String getconta(){
    return numConta;
}
public String setconta(String nc){
numConta=nc;
return numConta;
}
public String getnome(){
    return nome;
}
public String setnome(String n){
    nome=n;
    return nome;
    }
public double retirar (double cant){
saldo =saldo-cant;
System.out.println("Acaba de retirar "+cant+" euros da sua conta, o que lle deixa un total de "+
saldo+" euros totais.");
return saldo;
}
public double ingresar (double cant){
    saldo =saldo+cant;
    System.out.println("Acaba de ingresar "+cant+" euros da sua conta, o que lle deixa un total de "+
    saldo+" euros totais.");
    return saldo;
    }
}
