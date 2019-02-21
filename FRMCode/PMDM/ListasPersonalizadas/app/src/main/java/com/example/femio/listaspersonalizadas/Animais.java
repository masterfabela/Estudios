package com.example.femio.listaspersonalizadas;

/**
 * Created by Femio on 13/02/2019.
 */

public class Animais {
    private String nome;
    private int imaxe;

    public Animais(String nome, int imaxe) {
        this.nome = nome;
        this.imaxe = imaxe;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getImaxe() {
        return imaxe;
    }

    public void setImaxe(int imaxe) {
        this.imaxe = imaxe;
    }
}
