package boletin11;

public class Persoa {
    private int id, idade;
    private String nome, apelido;
    public Persoa(String n, String a, int i, int di){
nome=n;
apelido=a;
idade=i;
id=di;
}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
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