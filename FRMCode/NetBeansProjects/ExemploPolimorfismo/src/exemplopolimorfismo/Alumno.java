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
public class Alumno extends Persoa{
    int nota;

    public Alumno() {
    }

    public Alumno(int nota, String nome, int idade) {
        super(nome, idade);
        this.nota = nota;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Alumno{" + "nota=" + nota + '}';
    }
    
    @Override
    public void saudo(){
        System.out.println("Saudo dende Alumno.");
    }
}
