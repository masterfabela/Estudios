package com.example.a18franciscorm.proxecto;

/**
 * Created by a18franciscorm on 21/02/2019.
 */

public class Alimento {
    int codigo;
    String nome,tipo,azucares_simples,grasas_saturadas,sodio;

    public Alimento(int codigo, String nome, String tipo, String azucares_simples, String grasas_saturadas, String sodio) {
        this.codigo = codigo;
        this.nome = nome;
        this.tipo = tipo;
        this.azucares_simples = azucares_simples;
        this.grasas_saturadas = grasas_saturadas;
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

    public String getAzucares_simples() {
        return azucares_simples;
    }

    public void setAzucares_simples(String azucares_simples) {
        this.azucares_simples = azucares_simples;
    }

    public String getGrasas_saturadas() {
        return grasas_saturadas;
    }

    public void setGrasas_saturadas(String grasas_saturadas) {
        this.grasas_saturadas = grasas_saturadas;
    }

    public String getSodio() {
        return sodio;
    }

    public void setSodio(String sodio) {
        this.sodio = sodio;
    }
}
