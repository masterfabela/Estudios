/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persoas;

/**
 *
 * @author femio23
 */
public class Alumno {
    private String Nome;
    private int nota;

    public Alumno(String Nome, int nota) {
        this.Nome = Nome;
        this.nota = nota;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Nome= " + Nome + ", nota= " + nota;
    }
    
}
