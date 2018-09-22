
package exemplo_conta_bancaria;

public class Conta {
    String nome;
    String numConta;
    double saldo;
public Conta(){

}
public Conta(String n,String nc, double s){
this.nome=n;
this.numConta=nc;
this.saldo=s;
//"this" evita que haxa conflictos, se as variables se chaman igual.
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
public double getsaldo(){
    return saldo;
}
public double setsaldo(double s){
    saldo=s;
    return saldo;
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
@Override
public String toString(){
    return("Nome = "+nome+".\nNumero de conta = "+numConta+". \nSaldo = "+saldo+".");//Este metodo e interesante.
}
public void anulacion(){
    nome ="null";
    numConta="null";
    saldo=0;
    
}
}
