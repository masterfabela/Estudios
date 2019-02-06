/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente.modelo;

/**
 *
 * @author a18franciscorm
 */
public class Actividade {
    private String nome,tipo;
    private float cuota,desconto;

    public Actividade() {
    }

    public Actividade(String nome, String tipo, float cuota, float desconto) {
        this.nome = nome;
        this.tipo = tipo;
        this.cuota = cuota;
        this.desconto = desconto;
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
