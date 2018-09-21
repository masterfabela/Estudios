/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplopolimorfismo;

/**
 *
 * @author femio23
 */
public class Persoa {
    String nome;
    int idade;

    public Persoa() {
    }

    public Persoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Persoa{" + "nome=" + nome + ", idade=" + idade + '}';
    }
    
    public void saudo(){
        System.out.println("Saudo dende persoa");
    }
}
