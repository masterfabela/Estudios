/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Obx;

import java.io.Serializable;
import java.util.Set;

/**
 *
 * @author a18franciscorm
 */
public class Autores implements Serializable {
    private int dniautor;
    private String nome;
    private String nacionalidade;
    private Telefonos telefonos;
    private Set<Libros> libros;

    public Autores() {
    }

    public Telefonos getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(Telefonos telefonos) {
        this.telefonos = telefonos;
    }

    public Autores( int dniautor, String nome, String nacionalidade) {
        this.dniautor = dniautor;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
    }

    public Set<Libros> getLibros() {
        return libros;
    }

    public void setLibros(Set<Libros> libros) {
        this.libros = libros;
    }

    public int getDniautor() {
        return dniautor;
    }

    public void setDniautor(int dniautor) {
        this.dniautor = dniautor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    
}
