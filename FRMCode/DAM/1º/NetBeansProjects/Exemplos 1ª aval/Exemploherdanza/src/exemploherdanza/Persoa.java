package exemploherdanza;

public class Persoa {
String nome;
String apelido;
int idade;

public Persoa(String n, String a, int i){
nome=n;
apelido=a;
idade=i;
}
public String getn(){
return nome;
}
public String geta(){
return apelido;
}
public int geti(){
return idade;
}

    @Override
    public String toString() {
        return "Persoa{" + "nome=" + nome + ", apelido=" + apelido + ", idade=" + idade + '}';
    }
}
