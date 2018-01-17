/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemploarraisobxetos;

/**
 *
 * @author femio23
 */
public class Persoa {
    String nome, dni;

    public Persoa() {
    }

    public Persoa(String nome, String dni) {
        this.nome = nome;
        this.dni = dni;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return"nome=" + nome + ", dni=" + dni;
    }
    
}
