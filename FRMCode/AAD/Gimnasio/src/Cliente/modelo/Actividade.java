/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.modelo;

/**
 *
 * @author a18franciscorm
 */
public class Actividade {
    private String nome;
    private float cuota,desconto;

    public Actividade() {
    }

    public Actividade(String nome, float cuota, float desconto) {
        this.nome = nome;
        this.cuota = cuota;
        this.desconto = desconto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getCuota() {
        return cuota;
    }

    public void setCuota(float cuota) {
        this.cuota = cuota;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }
    
}
