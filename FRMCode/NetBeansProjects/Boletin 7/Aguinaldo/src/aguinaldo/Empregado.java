
package aguinaldo;

public class Empregado {
String nome;
int numf;
float habs;
public Empregado(String n, int nf,float ha){
nome=n;
numf=nf;
habs=ha;
}
public String getn(){
return nome;
}
public int getf(){
return numf;
}
public float getha(){
return habs;
}

}
