package com.example.a18franciscorm.proxecto;

/**
 * Created by a18franciscorm on 21/02/2019.
 */

public class Alimento {
    int codigo;
    String nome, tipo, azucares, grasas, sodio;

    public Alimento(int codigo, String nome, String tipo, String azucares, String grasas, String sodio) {
        this.codigo = codigo;
        this.nome = nome;
        this.tipo = tipo;
        this.azucares = azucares;
        this.grasas = grasas;
        this.sodio = sodio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getAzucares() {
        return azucares;
    }

    public void setAzucares(String azucares) {
        this.azucares = azucares;
    }

    public String getGrasas() {
        return grasas;
    }

    public void setGrasas(String grasas) {
        this.grasas = grasas;
    }

    public String getSodio() {
        return sodio;
    }

    public void setSodio(String sodio) {
        this.sodio = sodio;
    }
}