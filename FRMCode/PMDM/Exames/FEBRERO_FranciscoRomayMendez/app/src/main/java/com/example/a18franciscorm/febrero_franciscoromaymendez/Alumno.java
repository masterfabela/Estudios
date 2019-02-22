package com.example.a18franciscorm.febrero_franciscoromaymendez;

import android.widget.ArrayAdapter;

/**
 * Created by a18franciscorm on 14/02/2019.
 */

public class Alumno {
    String nome,Curso,ciclo;

    public Alumno(String nome, String curso, String ciclo) {
        this.nome = nome;
        Curso = curso;
        this.ciclo = ciclo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return Curso;
    }

    public void setCurso(String curso) {
        Curso = curso;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }
}
