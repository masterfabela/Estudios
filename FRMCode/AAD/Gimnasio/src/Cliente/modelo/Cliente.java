/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente.modelo;
import java.util.ArrayList;

/**
 *
 * @author a18franciscorm
 */
public abstract class Cliente {
    private String codigo, nome;
    private ArrayList<Uso> usos;
    public abstract void importeUsos();

    public Cliente() {
    }

    public Cliente(String codigo, String nome, ArrayList<Uso> usos) {
        this.codigo = codigo;
        this.nome = nome;
        this.usos = usos;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Uso> getUsos() {
        return usos;
    }

    public void setUsos(ArrayList<Uso> usos) {
        this.usos = usos;
    }
    
}
