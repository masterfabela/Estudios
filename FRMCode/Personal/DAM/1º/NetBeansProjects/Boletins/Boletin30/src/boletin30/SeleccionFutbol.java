/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin30;

/**
 *
 * @author femio23
 */
public abstract class SeleccionFutbol implements IntegranteSeleccionFutbol{
    int id,idade;
    String nome, apelidos;

    public SeleccionFutbol(int id, int idade, String nome, String apelidos) {
        this.id = id;
        this.idade = idade;
        this.nome = nome;
        this.apelidos = apelidos;
    }
    
}
