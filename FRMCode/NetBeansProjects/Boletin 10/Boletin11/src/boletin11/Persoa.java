package boletin11;

public class Persoa {
    int id, idade;
    String nome, apelido;
    public Persoa(String n, String a, int i, int di){
nome=n;
apelido=a;
idade=i;
id=di;
}
    public void concentrarse(){
        System.out.println("Concentrase a selección");
    }
    public void viaxar(){
        System.out.println("Viaxa a selección");
    }
    @Override
    public String toString(){
    return "Datos da persoa indicada:\nNome:"+nome+"\nApelidos:"+apelido+"\nId:"+id+"\nIdade:"+idade;
    }
}